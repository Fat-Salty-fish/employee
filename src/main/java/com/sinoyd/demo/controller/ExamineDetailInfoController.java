package com.sinoyd.demo.controller;

import com.sinoyd.demo.criteria.ExamineDetailCriteria;
import com.sinoyd.demo.entity.ExamineDetail;
import com.sinoyd.demo.result.ResultBean;
import com.sinoyd.demo.service.ExamineDetailService;
import com.sinoyd.frame.base.controller.BaseController;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("")
//    public Object examineDetailFindByPage(ExamineDetailCriteria examineDetailCriteria) {
//        PageBean pageBean = super.getPageBean();
//        return ResultBean.success(examineDetailService.findByPage(pageBean, examineDetailCriteria));
//    }

    @GetMapping("/{examineBaseId}/{examineDetailId}/testProject")
    public Object examineDetailFindTestProjectByPage(@PathVariable("examineDetailId") Integer examineDetailId) {
        return null;
    }

//    @PostMapping("")
//    public Object examineDetailCreate(@RequestBody ExamineDetail examineDetail) {
//        examineDetailService.create(examineDetail);
//        return ResultBean.success();
//    }

    @PostMapping("/testProject")
    public Object examineDetailCreateAnalysisProject(@PathVariable("examineBaseId") Integer examineBaseId,
                                                     @PathVariable("examineDetailId") Integer examineDetailId,
                                                     @RequestBody List<Integer> analysisProjectIds) {
        examineDetailService.createAnalysisProject(examineBaseId, examineDetailId, analysisProjectIds);
        return ResultBean.success();
    }

    @PostMapping("/{examineBaseId}/{examineDetailId}/peopleRecord")
    public Object examineDetailCreatePeopleRecord(@PathVariable("examineBaseId") Integer examineBaseId,
                                                  @PathVariable("examineDetailId") Integer examineDetailId,
                                                  @RequestBody List<Integer> employeeIds) {
        examineDetailService.createEmployeeRecord(examineBaseId, examineDetailId, employeeIds);
        return ResultBean.success();
    }


}
