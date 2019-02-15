package com.sinoyd.demo.controller;

import com.sinoyd.demo.service.ExamineService;
import com.sinoyd.frame.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
