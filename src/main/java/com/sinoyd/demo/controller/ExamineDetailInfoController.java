package com.sinoyd.demo.controller;

import com.sinoyd.demo.criteria.ExamineDetailCriteria;
import com.sinoyd.demo.entity.ExamineDetail;
import com.sinoyd.demo.parameter.ExamineDetailParameter;
import com.sinoyd.demo.result.ResultBean;
import com.sinoyd.demo.service.ExamineDetailService;
import com.sinoyd.frame.base.controller.BaseController;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * @Description 考核详细信息controller 响应与考核详细信息有关的请求
 * @auther 李忠杰
 * @create 2019-02-19 9:09
 */
@RestController
@RequestMapping("/api/bas/employeeManagement/examine/detailInfo")
public class ExamineDetailInfoController extends BaseController {
    @Autowired
    private ExamineDetailService examineDetailService;

    /**
     * 考核详细信息分页查询
     *
     * @param examineDetailCriteria 查询条件为考核基础信息id和考核详细信息id
     * @return
     */
    @GetMapping("")
    public Object examineDetailFindByPage(ExamineDetailCriteria examineDetailCriteria) {
        PageBean pageBean = super.getPageBean();
        return ResultBean.success(examineDetailService.findExamineDetailInfoByPage(pageBean, examineDetailCriteria));
    }

    /**
     * 查询某个考核详细信息以及对应的分析项目
     *
     * @param examineDetailCriteria 查询条件为考核基础信息id和考核详细信息id
     * @return
     */
    @GetMapping("/testProject")
    public Object examineDetailFindAnalysisProjectByPage(ExamineDetailCriteria examineDetailCriteria) {
        PageBean pageBean = super.getPageBean();
        return ResultBean.success(examineDetailService.findAnalysisProjectByPage(pageBean, examineDetailCriteria));
    }

    /**
     * 查询某个考核详细信息以及对应的考核人员
     *
     * @param examineDetailCriteria 查询条件为考核基础信息id和考核详细信息id
     * @return
     */
    @GetMapping("/peopleRecord")
    public Object examineDetailFindPeopleRecordByPage(ExamineDetailCriteria examineDetailCriteria) {
        PageBean pageBean = super.getPageBean();
        return ResultBean.success(examineDetailService.findEmployeeRecordByPage(pageBean, examineDetailCriteria));
    }

    /**
     * 新增考核详细信息
     *
     * @param examineDetail 考核详细信息对象
     * @return
     */
    @PostMapping("")
    public Object examineDetailCreate(@RequestBody ExamineDetail examineDetail) {
        examineDetailService.create(examineDetail);
        return ResultBean.success();
    }

    /**
     * 新增考核详细信息对应的分析项目
     *
     * @param args 传入参数 包括考核基础信息id 考核详细信息id 分析项目id数组
     * @return
     */
    @PostMapping("/testProject")
    public Object examineDetailCreateAnalysisProject(@RequestBody ExamineDetailParameter args) {
        examineDetailService.createAnalysisProject(args);
        return ResultBean.success();
    }

    /**
     * 新增考核详细信息对应的考核人员
     *
     * @param args 传入参数 包括考核基础信息id 考核详细信息id 考核人员id数组
     * @return
     */
    @PostMapping("/peopleRecord")
    public Object examineDetailCreatePeopleRecord(@RequestBody ExamineDetailParameter args) {
        return ResultBean.success(examineDetailService.createEmployeeRecord(args));
    }

    /**
     * 删除考核详细信息对应的分析项目
     *
     * @param args 传入参数 包括考核基础信息id 考核详细信息id 要删除的分析项目id数组
     * @return
     */
    @DeleteMapping("/testProject")
    public Object examineDetailDeleteAnalysisProject(@RequestBody ExamineDetailParameter args) {
        return ResultBean.success(examineDetailService.deleteAnalysisProject(args));
    }

    /**
     * 删除考核详细信息对应的考核人员
     *
     * @param args 传入参数 包括考核基础信息id 考核详细信息id 要删除的考核人员id数组
     * @return
     */
    @DeleteMapping("/peopleRecord")
    public Object examineDetailDeletePeopleRecord(@RequestBody ExamineDetailParameter args) {
        return ResultBean.success(examineDetailService.deleteEmployeeRecord(args));
    }
}
