package com.sinoyd.demo.controller;

import com.sinoyd.demo.criteria.EmployeeCriteria;
import com.sinoyd.demo.entity.Employee;
import com.sinoyd.demo.result.ResultBean;
import com.sinoyd.demo.service.EmployeeService;
import com.sinoyd.frame.base.controller.BaseController;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-01-28 16:51
 */
@RestController
@RequestMapping("/api/bas/employeeManagement/employee")
public class EmployeeController extends BaseController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public Object findByPage(EmployeeCriteria employeeCriteria) {
        PageBean pageBean = this.getPageBean();
        Map data = employeeService.findByPage(pageBean, employeeCriteria);
        return ResultBean.success(data);
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable("id") Integer id){
        Map data = employeeService.findById(id);
        return ResultBean.success(data);
    }

    @PostMapping("")
    public Object create(@RequestBody Employee employee){
        employeeService.save(employee);
        return ResultBean.success();
    }

    @PostMapping("/check")
    public Object checkEmployeeNumber(@RequestParam("employeeCode") String employeeCode){
        return ResultBean.success(employeeService.check(employeeCode));
    }

    @DeleteMapping("")
    public Object delete(@RequestBody Collection<Integer> ids){
        return ResultBean.success(employeeService.delete(ids));
    }

    @PutMapping("")
    public Object update(@RequestBody Employee employee){
        employeeService.update(employee);
        return ResultBean.success();
    }
}
