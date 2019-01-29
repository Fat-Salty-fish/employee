package com.sinoyd.demo.controller;

import com.sinoyd.demo.service.EmployeeService;
import com.sinoyd.frame.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-01-28 16:51
 */
@RestController
@RequestMapping("")
public class EmployeeController extends BaseController {
    @Autowired
    private EmployeeService employeeService;


}
