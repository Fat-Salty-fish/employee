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
 * @Description
 * @auther 李忠杰
 * @create 2019-02-19 9:09
 */
@RestController
@RequestMapping("/api/bas/employeeManagement/examine/detailInfo")
public class ExamineDetailInfoController extends BaseController {
    @Autowired
    private ExamineDetailService examineDetailService;

    @GetMapping("")
    public Object examineDetailFindByPage(ExamineDetailCriteria examineDetailCriteria) {
        PageBean pageBean = super.getPageBean();
        return ResultBean.success(examineDetailService.findExamineDetailInfoByPage(pageBean, examineDetailCriteria));
    }

    @GetMapping("/testProject")
    public Object examineDetailFindAnalysisProjectByPage(ExamineDetailCriteria examineDetailCriteria) {
        PageBean pageBean = super.getPageBean();
        return ResultBean.success(examineDetailService.findAnalysisProjectByPage(pageBean, examineDetailCriteria));
    }

    @GetMapping("/peopleRecord")
    public Object examineDetailFindPeopleRecordByPage(ExamineDetailCriteria examineDetailCriteria) {
        PageBean pageBean = super.getPageBean();
        return ResultBean.success(examineDetailService.findEmployeeRecordByPage(pageBean, examineDetailCriteria));
    }

    @PostMapping("")
    public Object examineDetailCreate(@RequestBody ExamineDetail examineDetail) {
        examineDetailService.create(examineDetail);
        return ResultBean.success();
    }

    @PostMapping("/testProject")
    public Object examineDetailCreateAnalysisProject(@RequestBody ExamineDetailParameter args) {
        examineDetailService.createAnalysisProject(args);
        return ResultBean.success();
    }

    @PostMapping("/peopleRecord")
    public Object examineDetailCreatePeopleRecord(@RequestBody ExamineDetailParameter args) {
        examineDetailService.createEmployeeRecord(args);
        return ResultBean.success();
    }

    @DeleteMapping("/testProject")
    public Object examineDetailDeleteAnalysisProject(@RequestBody ExamineDetailParameter args) {
        return ResultBean.success(examineDetailService.deleteAnalysisProject(args));
    }

    @DeleteMapping("/peopleRecord")
    public Object examineDetailDeletePeopleRecord(@RequestBody ExamineDetailParameter args) {
        return ResultBean.success(examineDetailService.deleteEmployeeRecord(args));
    }
}
