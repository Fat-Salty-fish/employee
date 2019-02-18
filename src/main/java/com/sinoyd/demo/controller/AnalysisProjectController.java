package com.sinoyd.demo.controller;

import com.sinoyd.demo.criteria.AnalysisProjectCriteria;
import com.sinoyd.demo.result.ResultBean;
import com.sinoyd.demo.service.AnalysisProjectService;
import com.sinoyd.frame.base.controller.BaseController;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-15 17:18
 */
@RestController
@RequestMapping("/api/bas/employeeManagement/testProject")
public class AnalysisProjectController extends BaseController {
    @Autowired
    private AnalysisProjectService analysisProjectService;

    @GetMapping("")
    public Object findByPage(AnalysisProjectCriteria analysisProjectCriteria) {
        PageBean pageBean = this.getPageBean();
        return ResultBean.success(analysisProjectService.findByPage(pageBean, analysisProjectCriteria));
    }
}
