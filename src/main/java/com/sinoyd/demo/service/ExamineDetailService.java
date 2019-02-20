package com.sinoyd.demo.service;

import com.sinoyd.demo.criteria.ExamineDetailCriteria;
import com.sinoyd.demo.entity.*;
import com.sinoyd.demo.parameter.ExamineDetailParameter;
import com.sinoyd.demo.repository.*;
import com.sinoyd.frame.base.repository.CommonRepository;
import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    private AnalysisProjectRepository analysisProjectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ExamineDetailEmployeeAndScoreInfoRepository examineDetailEmployeeAndScoreInfoRepository;

    public Map findExamineDetailInfoByPage(PageBean pageBean, BaseCriteria examineDetailCriteria) {
        pageBean.setEntityName("ExamineDetail a ");
        pageBean.setSelect("Select a");
        commonRepository.findByPage(pageBean, examineDetailCriteria);
        List<ExamineDetail> examineDetails = pageBean.getData();
        List<Integer> examineDetailIds = examineDetails.stream().map(detail -> detail.getExamineDetailId()).collect(Collectors.toList());
        List<ExamineDetailProject> detailProjects = examineDetailProjectRepository.findByExamineDetailIdIn(examineDetailIds);
        List<ExamineDetailEmployeeAndScoreInfo> detailEmployees = examineDetailEmployeeAndScoreInfoRepository.findByExamineDetailIdIn(examineDetailIds);

        examineDetails.forEach(detail -> {
            detail.setTotalPeople((int) detailEmployees.stream().filter(detailEmployee -> detailEmployee.getExamineDetailId().equals(detail.getExamineDetailId())).count());
            detail.setTotalTestProject((int) detailProjects.stream().filter(detailProject -> detailProject.getExamineDetailId().equals(detail.getExamineDetailId())).count());
        });

//        pageBean.setData(examineDetails);

        return ServiceTools.setMapFormat(pageBean);
    }

    public Map findAnalysisProjectByPage(PageBean pageBean, ExamineDetailCriteria examineDetailCriteria) {
        if (examineDetailCriteria.getExamineDetailId() == null) {
            throw new NullPointerException("考核详细信息id为空 无法查询");
        }
        pageBean.setEntityName(" ExamineDetailProject a ");
        pageBean.setSelect(" Select a ");
        commonRepository.findByPage(pageBean, examineDetailCriteria);

        List<ExamineDetailProject> examineDetailProjects = pageBean.getData();
        List<Integer> analysisProjectIds = examineDetailProjects.stream().map(project -> project.getAnalysisProjectId()).distinct().collect(Collectors.toList());
        List<AnalysisProject> analysisProjects = analysisProjectRepository.findByAnalysisProjectIdIn(analysisProjectIds).stream().collect(Collectors.toList());

        examineDetailProjects.forEach(project ->
                project.setAnalysisProject(analysisProjects.stream().filter(analysisProject -> analysisProject.getAnalysisProjectId().equals(project.getAnalysisProjectId())).findAny().orElse(null)));
//        pageBean.setData(examineDetailProjects);
        return ServiceTools.setMapFormat(pageBean);
    }

    public Map findEmployeeRecordByPage(PageBean pageBean, ExamineDetailCriteria examineDetailCriteria) {
        if (examineDetailCriteria.getExamineDetailId() == null) {
            throw new NullPointerException("考核详细信息id为空 无法查询");
        }
        pageBean.setEntityName(" ExamineDetailEmployeeAndScoreInfo a ");
        pageBean.setSelect(" Select a ");
        commonRepository.findByPage(pageBean, examineDetailCriteria);

        List<ExamineDetailEmployeeAndScoreInfo> employeeRecords = pageBean.getData();
        List<Integer> employeeIds = employeeRecords.stream().map(employee -> employee.getEmployeeId()).distinct().collect(Collectors.toList());
        List<Employee> employees = employeeRepository.findByEmployeeIdIn(employeeIds);

        employeeRecords.forEach(record ->
                record.setEmployee(employees.stream().filter(employee -> record.getEmployeeId().equals(employee.getEmployeeId())).findAny().orElse(null)));
//        pageBean.setData(employeeRecords);
        return ServiceTools.setMapFormat(pageBean);
    }

    public void create(ExamineDetail examineDetail) {
        examineDetailRepository.save(examineDetail);
    }

    public void createAnalysisProject(ExamineDetailParameter args) {
        args.checkNull();
        Integer examineDetailId = args.getExamineDetailId();
        if (Integer.valueOf(1).equals(examineDetailRepository.findOne(examineDetailId).getIsScored())) {
            throw new IllegalArgumentException("此次考核已经给分 无法添加新的分析项目");
        }

        Integer examineBaseId = args.getExamineBaseId();

        List<Integer> existingAnalysisProjectIds = examineDetailProjectRepository.findByExamineDetailId(examineDetailId).stream().map(project -> project.getAnalysisProjectId()).collect(Collectors.toList());

        List<Integer> analysisProjectIds = args.getData().stream().filter(id->!existingAnalysisProjectIds.contains(id)).collect(Collectors.toList());

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

    public void createEmployeeRecord(ExamineDetailParameter args) {
        args.checkNull();
        Integer examineDetailId = args.getExamineDetailId();
        if (Integer.valueOf(1).equals(examineDetailRepository.findOne(examineDetailId).getIsScored())) {
            throw new IllegalArgumentException("此次考核已经给分 无法添加新的考核人员");
        }

        Integer examineBaseId = args.getExamineBaseId();

        List<Integer> existingEmployeeIds = examineDetailEmployeeAndScoreInfoRepository.findByExamineDetailId(examineDetailId).stream().map(employeeRecord->employeeRecord.getEmployeeId()).collect(Collectors.toList());

        List<Integer> employeeIds = args.getData().stream().filter(id->!existingEmployeeIds.contains(id)).collect(Collectors.toList());

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

    @Transactional
    public Map deleteAnalysisProject(ExamineDetailParameter args) {
        args.checkNull();

        Integer examineDetailId = args.getExamineDetailId();
        if (Integer.valueOf(1).equals(examineDetailRepository.findOne(examineDetailId).getIsScored())) {
            throw new IllegalArgumentException("此次考核已经给分 无法删除分析项目");
        }
        List<Integer> examineDetailProjectIds = args.getData();
        return ServiceTools.setMapFormat("deleteNum", examineDetailProjectRepository.deleteByExamineProjectIdIn(examineDetailProjectIds));
    }

    @Transactional
    public Map deleteEmployeeRecord(ExamineDetailParameter args) {
        args.checkNull();

        Integer examineDetailId = args.getExamineDetailId();
        if (Integer.valueOf(1).equals(examineDetailRepository.findOne(examineDetailId).getIsScored())) {
            throw new IllegalArgumentException("此次考核已经给分 无法删除考核人员");
        }
        List<Integer> examineDetailEmployeeRecordIds = args.getData();
        return ServiceTools.setMapFormat("deleteNum", examineDetailEmployeeAndScoreInfoRepository.deleteByExamineEmployeeIdIn(examineDetailEmployeeRecordIds));
    }
}
