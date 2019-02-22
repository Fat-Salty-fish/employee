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
 * @Description 分析项目controller 响应与分析项目有关的操作
 * @auther 李忠杰
 * @create 2019-02-15 17:18
 */
@RestController
@RequestMapping("/api/bas/employeeManagement/testProject")
public class AnalysisProjectController extends BaseController {
    @Autowired
    private AnalysisProjectService analysisProjectService;

    /**
     * 对分析项目进行分页查询和模糊检索
     *
     * @param analysisProjectCriteria 检索条件为 分析项目名 以及分析项目的样品类型
     * @return
     */
    @GetMapping("")
    public Object findByPage(AnalysisProjectCriteria analysisProjectCriteria) {
        PageBean pageBean = this.getPageBean();
        return ResultBean.success(analysisProjectService.findByPage(pageBean, analysisProjectCriteria));
    }
}
