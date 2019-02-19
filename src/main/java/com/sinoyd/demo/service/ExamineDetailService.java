package com.sinoyd.demo.service;

import com.sinoyd.demo.entity.ExamineDetail;
import com.sinoyd.demo.entity.ExamineDetailEmployeeAndScoreInfo;
import com.sinoyd.demo.entity.ExamineDetailProject;
import com.sinoyd.demo.repository.ExamineDetailEmployeeAndScoreInfoRepository;
import com.sinoyd.demo.repository.ExamineDetailProjectRepository;
import com.sinoyd.demo.repository.ExamineDetailRepository;
import com.sinoyd.frame.base.repository.CommonRepository;
import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-19 9:11
 */
@Service
public class ExamineDetailService {
    @Autowired
    private CommonRepository commonRepository;

    @Autowired
    private ExamineDetailRepository examineDetailRepository;

    @Autowired
    private ExamineDetailProjectRepository examineDetailProjectRepository;

    @Autowired
    private ExamineDetailEmployeeAndScoreInfoRepository examineDetailEmployeeAndScoreInfoRepository;

    public void create(ExamineDetail examineDetail) {
        examineDetailRepository.save(examineDetail);
    }

    public void createAnalysisProject(Integer examineBaseId, Integer examineDetailId, List<Integer> analysisProjectIds) {
        List<ExamineDetailProject> projectList = analysisProjectIds.stream().
                map(temp -> {
                    ExamineDetailProject info = new ExamineDetailProject();
                    info.setExamineDetailId(examineDetailId);
                    info.setExamineBaseId(examineBaseId);
                    info.setAnalysisProjectId(temp);
                    return info;
                }).collect(Collectors.toList());
        examineDetailProjectRepository.save(projectList);
    }

    public void createEmployeeRecord(Integer examineBaseId, Integer examineDetailId, List<Integer> employeeIds) {
        List<ExamineDetailEmployeeAndScoreInfo> employeeInfos = employeeIds.stream()
                .map(temp -> {
                    ExamineDetailEmployeeAndScoreInfo info = new ExamineDetailEmployeeAndScoreInfo();
                    info.setExamineDetailId(examineDetailId);
                    info.setExamineBaseId(examineBaseId);
                    info.setEmployeeId(temp);
                    return info;
                }).collect(Collectors.toList());
        examineDetailEmployeeAndScoreInfoRepository.save(employeeInfos);
    }

    public Map findByPage(PageBean pageBean, BaseCriteria examineDetailCriteria){
        pageBean.setEntityName("ExamineDetail a ");
        pageBean.setSelect("Select a");
        commonRepository.findByPage(pageBean,examineDetailCriteria);
        List<ExamineDetail> examineDetails = pageBean.getData();
        List<Integer> examineDetailIds = examineDetails.stream().map(detail->detail.getExamineDetailId()).collect(Collectors.toList());
        List<ExamineDetailProject> detailProjects = examineDetailProjectRepository.findByExamineDetailIdIn(examineDetailIds);
        List<ExamineDetailEmployeeAndScoreInfo> detailEmployees = examineDetailEmployeeAndScoreInfoRepository.findByExamineDetailIdIn(examineDetailIds);

        examineDetails.forEach(detail->{
            detail.setTotalPeople((int)detailEmployees.stream().filter(detailEmployee->detailEmployee.getExamineDetailId().equals(detail.getExamineDetailId())).count());
            detail.setTotalTestProject((int)detailProjects.stream().filter(detailProject->detailProject.getExamineDetailId().equals(detail.getExamineDetailId())).count());
        });
        pageBean.setData(examineDetailIds);

        return ServiceTools.setMapFormat(pageBean);
    }
}
