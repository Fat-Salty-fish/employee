package com.sinoyd.demo.controller;

import com.sinoyd.demo.criteria.ScoreAndCertificateCriteria;
import com.sinoyd.demo.entity.ExamineDetailEmployeeAndScoreInfo;
import com.sinoyd.demo.parameter.CertificateParameter;
import com.sinoyd.demo.result.ResultBean;
import com.sinoyd.demo.service.ScoreAndCertificateService;
import com.sinoyd.frame.base.controller.BaseController;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * @Description 成绩分数上传以及发证controller 处理考核后分数的提交以及后续证书发放的请求
 * @auther 李忠杰
 * @create 2019-02-20 15:19
 */
@RestController
@RequestMapping("/api/bas/employeeManagement")
public class ScoreAndCertificateController extends BaseController {
    @Autowired
    private ScoreAndCertificateService scoreAndCertificateService;

    /**
     * 根据考核基础信息id获取对应的考核人员信息 用来提交分数
     * @param examineBaseId
     * @return
     */
    @GetMapping("/score/{examineBaseId}")
    public Object findScoreByExamineBaseId(@PathVariable("examineBaseId") Integer examineBaseId) {
        return ResultBean.success(scoreAndCertificateService.findScoreByExamineBaseId(examineBaseId));
    }

    /**
     * 提交考核人员成绩以及是否通过等信息
     * @param scoreInfo
     * @return
     */
    @PutMapping("/score")
    public Object updateScore(@RequestBody ExamineDetailEmployeeAndScoreInfo scoreInfo) {
        scoreAndCertificateService.updateScoreInfo(scoreInfo);
        return ResultBean.success();
    }

    /**
     * 根据考核基础信息id获取对应的考核人员信息 过滤掉未通过的员工 用来进行发证
     * @param examineBaseId
     * @return
     */
    @GetMapping("/certificate/{examineBaseId}")
    public Object findCertificateByExamineBaseId(@PathVariable("examineBaseId") Integer examineBaseId) {
        return ResultBean.success(scoreAndCertificateService.findCertificateByExamineBaseId(examineBaseId));
    }

    /**
     * 提交发证时间以及证书截止日期等信息 进行发证
     * @param args  传入参数 包括证书发放日期 证书截止日期 以及要发证的人员考核信息id
     * @return
     */
    @PutMapping("/certificate")
    public Object updateCertificate(@RequestBody CertificateParameter args) {
        scoreAndCertificateService.updateCertificateInfo(args);
        return ResultBean.success();
    }

    /**
     *  查询所有的已经发放的证书 分页搜索以及模糊搜索
     * @param criteria  搜索条件 员工id以及证书名称
     * @return
     */
    @GetMapping("/certificate")
    public Object findCertificateByPage(ScoreAndCertificateCriteria criteria) {
        PageBean pageBean = super.getPageBean();
        return ResultBean.success(scoreAndCertificateService.findCertificateByPage(pageBean, criteria));
    }

    /**
     * 根据考核基础信息获取对应的已经发放的证书
     * @param examineBaseId 考核基础信息id
     * @return
     */
    @GetMapping("/certificate/all/{examineBaseId}")
    public Object findAllCertificateByExamineBaseId(@PathVariable("examineBaseId") Integer examineBaseId) {
        return ResultBean.success(scoreAndCertificateService.findAllCertificateByExamineBaseId(examineBaseId));
    }

    /**
     * 根据考核详细id查询对应考核的能力检测表
     * @param examineDetailId 考核详细信息id
     * @return
     */
    @GetMapping("/certificate/ability/{examineDetailId}")
    public Object findAbilityByExamineDetailId(@PathVariable("examineDetailId") Integer examineDetailId) {
        return ResultBean.success(scoreAndCertificateService.findAbilityByExamineDetailId(examineDetailId));
    }

    /**
     * 根据证书id删除已经发放的证书 实现假删功能
     * @param certificateIds 证书id数组
     * @return
     */
    @DeleteMapping("/certificate")
    public Object deleteCertificate(@RequestBody List<Integer> certificateIds){
        return ResultBean.success(scoreAndCertificateService.deleteCertificate(certificateIds));
    }
}
