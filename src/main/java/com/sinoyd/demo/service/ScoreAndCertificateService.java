package com.sinoyd.demo.service;

import com.sinoyd.demo.criteria.ScoreAndCertificateCriteria;
import com.sinoyd.demo.entity.*;
import com.sinoyd.demo.parameter.CertificateParameter;
import com.sinoyd.demo.parameter.EmployeeScoreIdAndCertificateCode;
import com.sinoyd.demo.repository.*;
import com.sinoyd.frame.base.repository.CommonRepository;
import com.sinoyd.frame.base.util.PageBean;
import com.sinoyd.frame.base.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-20 15:24
 */
@Service
public class ScoreAndCertificateService {

    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private ExamineDetailEmployeeAndScoreInfoRepository examineDetailEmployeeAndScoreInfoRepository;
    @Autowired
    private CertificateRepository certificateRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ExamineBaseRepository examineBaseRepository;
    @Autowired
    private AnalysisProjectRepository analysisProjectRepository;
    @Autowired
    private ExamineDetailProjectRepository examineDetailProjectRepository;

    public Map findScoreByExamineBaseId(Integer examineBaseId) {
        List<ExamineDetailEmployeeAndScoreInfo> scoreList = examineDetailEmployeeAndScoreInfoRepository.findByExamineBaseId(examineBaseId)
                .stream()
                .filter(score -> !Integer.valueOf(1).equals(score.getExamineIsGetCertificate()))
                .collect(Collectors.toList());
        List<Employee> employees = employeeRepository.findByEmployeeIdIn(scoreList.stream().map(scoreInfo -> scoreInfo.getEmployeeId()).collect(Collectors.toList()));
        scoreList.forEach(scoreInfo ->
                scoreInfo.setEmployee(employees
                        .stream()
                        .filter(employee -> employee.getEmployeeId().equals(scoreInfo.getEmployeeId()))
                        .findAny()
                        .orElse(null)));
        return ServiceTools.setMapFormat("scoresToComment", scoreList);
    }

    @Transactional
    public void updateScoreInfo(ExamineDetailEmployeeAndScoreInfo scoreInfo) {
        if (scoreInfo.getExamineIsPassed() == null) {
            throw new IllegalArgumentException("未评价是否通过 评价失败");
        }
        scoreInfo.setExamineIsGetCertificate(0);
        examineDetailEmployeeAndScoreInfoRepository.save(scoreInfo);
    }

    public Map findCertificateByExamineBaseId(Integer examineBaseId) {
        List<ExamineDetailEmployeeAndScoreInfo> scoreList = examineDetailEmployeeAndScoreInfoRepository.findByExamineBaseId(examineBaseId)
                .stream()
                .filter(certificate -> Integer.valueOf(1).equals(certificate.getExamineIsPassed()))
                .filter(certificate -> Integer.valueOf(0).equals(certificate.getExamineIsGetCertificate()))
                .collect(Collectors.toList());
        List<Employee> employees = employeeRepository.findByEmployeeIdIn(scoreList.stream().map(scoreInfo -> scoreInfo.getEmployeeId()).collect(Collectors.toList()));
        scoreList.forEach(scoreInfo ->
                scoreInfo.setEmployee(employees.stream().filter(employee -> employee.getEmployeeId().equals(scoreInfo.getEmployeeId())).findAny().orElse(null)));
        return ServiceTools.setMapFormat("certificateToGive", scoreList);
    }

    @Transactional
    public void updateCertificateInfo(CertificateParameter args) {
        //检查空指针
        args.checkNull();
        //获取传入的参数
        Date startDate = args.getStartDate();
        Date endDate = args.getEndDate();

        //传入考核成绩得分列表Id以及对应的要添加的证书编号
        List<EmployeeScoreIdAndCertificateCode> idAndCodes = args.getData();

        //获取考核成绩得分列表数据
        List<ExamineDetailEmployeeAndScoreInfo> scoreInfos = examineDetailEmployeeAndScoreInfoRepository.findByExamineEmployeeIdIn(
                idAndCodes.stream()
                        .map(parameter -> parameter.getExamineEmployeeId())
                        .collect(Collectors.toList()))
                .stream()
                .filter(scoreInfo -> !Integer.valueOf(1).equals(scoreInfo.getExamineIsGetCertificate()))
                .collect(Collectors.toList());
        //获取考核基础信息
        Integer examineBaseId = scoreInfos.get(0).getExamineBaseId();
        Integer examineDetailId = scoreInfos.get(0).getExamineDetailId();

        //生成证书
        List<Certificate> certificates = new ArrayList<>();
        certificates = scoreInfos.stream()
                .map(scoreInfo -> {
                    Certificate certificate = new Certificate();
                    certificate.setExamineDetailId(examineDetailId);
                    certificate.setExamineBaseId(examineBaseId);
                    certificate.setEmployeeId(scoreInfo.getEmployeeId());
                    certificate.setExamineEmployeeId(scoreInfo.getExamineEmployeeId());
                    certificate.setCertificateDate(startDate);
                    certificate.setCertificateValidity(endDate);
                    certificate.setCertificateCode(idAndCodes.stream().filter(idAndCode -> certificate.getExamineEmployeeId().equals(idAndCode.getExamineEmployeeId())).map(idAndCode -> idAndCode.getCertificateCode()).findAny().orElse(null));
                    return certificate;
                })
                .collect(Collectors.toList());
        //保存证书
        certificateRepository.save(certificates);

        //保存已经发证的状态
        scoreInfos.forEach(scoreInfo -> scoreInfo.setExamineIsGetCertificate(1));
        examineDetailEmployeeAndScoreInfoRepository.save(scoreInfos);
    }

    public Map<String,Object> findCertificateByPage(PageBean pageBean, ScoreAndCertificateCriteria criteria) {
        String examineName = criteria.getExamineName();

        List<ExamineBase> examineBases;

        //获取考核基础信息
        if (StringUtils.isNotNullAndEmpty(examineName)) {
            examineBases = examineBaseRepository.findByExamineNameLike("%" + examineName + "%");
            if(examineBases == null || examineBases.size() == 0){
                return null;
            }
            criteria.setExamineBaseIds(examineBases.stream().map(examineBase -> examineBase.getExamineBaseId()).collect(Collectors.toList()));
        }
        pageBean.setEntityName(" Certificate a ");
        pageBean.setSelect(" Select a ");

        commonRepository.findByPage(pageBean, criteria);

        List<Certificate> certificates = pageBean.getData();

        List<Employee> employeeToShow = employeeRepository.findByEmployeeIdIn(certificates.stream().map(certificate -> certificate.getEmployeeId()).distinct().collect(Collectors.toList()));
        List<ExamineBase> examineBaseToShow = examineBaseRepository.findByExamineBaseIdIn(certificates.stream().map(certificate -> certificate.getExamineBaseId()).collect(Collectors.toList()));

        List<Certificate> certificatesToShow = certificates.stream().map(certificate -> {
            certificate.setEmployee(employeeToShow.stream().filter(employee -> certificate.getEmployeeId().equals(employee.getEmployeeId())).findAny().orElse(null));
            certificate.setExamineBase(examineBaseToShow.stream().filter(examineBase -> certificate.getExamineBaseId().equals(examineBase.getExamineBaseId())).findAny().orElse(null));
            return certificate;
        }).collect(Collectors.toList());
        pageBean.setData(certificatesToShow);
        return ServiceTools.setMapFormat(pageBean);
    }

    public Map findAllCertificateByExamineBaseId(Integer examineBaseId) {
        List<Certificate> certificates = certificateRepository.findByExamineBaseId(examineBaseId);
        List<Integer> employeeIds = certificates.stream().map(certificate -> certificate.getEmployeeId()).collect(Collectors.toList());
        List<Integer> examineBaseIds = certificates.stream().map(certificate -> certificate.getExamineBaseId()).collect(Collectors.toList());

        List<Employee> employeeList = employeeRepository.findByEmployeeIdIn(employeeIds);
        List<ExamineBase> examineBaseList = examineBaseRepository.findByExamineBaseIdIn(examineBaseIds);

        List<Certificate> certificateToShow = certificates
                .stream()
                .map(certificate -> {
                    certificate.setEmployee(employeeList.stream().filter(employee -> certificate.getEmployeeId().equals(employee.getEmployeeId())).findAny().orElse(null));
                    certificate.setExamineBase(examineBaseList.stream().filter(examineBase -> certificate.getExamineBaseId().equals(examineBase.getExamineBaseId())).findAny().orElse(null));
                    return certificate;
                }).collect(Collectors.toList());
        return ServiceTools.setMapFormat("certificates", certificateToShow);
    }

    public Map findAbilityByExamineDetailId(Integer examineDetail) {
        List<Integer> analysisProjectIds = examineDetailProjectRepository.findByExamineDetailId(examineDetail).stream().map(Detail -> Detail.getAnalysisProjectId()).collect(Collectors.toList());
        List<AnalysisProject> analysisProjects = analysisProjectRepository.findByAnalysisProjectIdIn(analysisProjectIds);
        return ServiceTools.setMapFormat("testProjects", analysisProjects);
    }

    @Transactional
    public Map deleteCertificate(List<Integer> certificateIds) {
        List<Certificate> certificates = certificateRepository.findByCertificateIdIn(certificateIds);
        Integer deleteNum = (int) certificates.stream().filter(certificate -> Integer.valueOf(0).equals(certificate.getIsDeleted())).peek(certificate -> certificate.setIsDeleted(1)).count();
        certificateRepository.save(certificates);
        return ServiceTools.setMapFormat("deleteNum", deleteNum);
    }
}
