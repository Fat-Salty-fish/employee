package com.sinoyd.demo.controller;

import com.sinoyd.demo.criteria.ExamineBaseCriteria;
import com.sinoyd.demo.entity.ExamineBase;
import com.sinoyd.demo.result.ResultBean;
import com.sinoyd.demo.service.ExamineService;
import com.sinoyd.frame.base.controller.BaseController;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.Collection;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-15 16:56
 */
@RestController
@RequestMapping("/api/bas/employeeManagement/examine")
public class ExamineController extends BaseController {
    @Autowired
    private ExamineService examineService;

    @GetMapping("")
    public Object examineBaseFindByPage(ExamineBaseCriteria examineBaseCriteria){
        PageBean pageBean = this.getPageBean();
        return ResultBean.success(examineService.examineBaseFindByPage(pageBean,examineBaseCriteria));
    }

    @GetMapping("/{id}")
    public Object examineBaseFindById(@PathVariable("id")Integer id){
        return ResultBean.success(examineService.examineBaseFindById(id));
    }

    @PostMapping("")
    public Object examineBaseCreate(ExamineBase examineBase){
        examineService.examineBaseCreate(examineBase);
        return ResultBean.success();
    }

    @DeleteMapping("")
    public Object examineBaseDelete(Collection<Integer> ids){
        return ResultBean.success(examineService.examineBaseDelete(ids));
    }

    @PutMapping("")
    public Object examineBaseUpdate(ExamineBase examineBase){
        examineService.examineBaseUpdate(examineBase);
        return ResultBean.success();
    }
}
