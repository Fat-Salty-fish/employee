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


/**
 * @Description 员工管理controller类 响应与员工有关的操作
 * @auther 李忠杰
 * @create 2019-01-28 16:51
 */
@RestController
@RequestMapping("/api/bas/employeeManagement/employee")
public class EmployeeController extends BaseController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 员工信息 分页搜索和模糊搜索
     *
     * @param employeeCriteria 查询条件为员工姓名以及员工编号
     * @return
     */
    @GetMapping("")
    public Object employeeFindByPage(EmployeeCriteria employeeCriteria) {
        PageBean pageBean = this.getPageBean();
        return ResultBean.success(employeeService.findByPage(pageBean, employeeCriteria));
    }

    /**
     * 员工信息 根据id进行搜索
     *
     * @param id 员工id
     * @return
     */
    @GetMapping("/{id}")
    public Object employeeFindById(@PathVariable("id") Integer id) {
        return ResultBean.success(employeeService.findById(id));
    }

    /**
     * 员工信息 新增一条员工信息
     *
     * @param employee
     * @return
     */
    @PostMapping("")
    public Object employeeCreate(@RequestBody Employee employee) {
        employeeService.save(employee);
        return ResultBean.success();
    }

    /**
     * 员工信息 验证员工编号是否已经重复 返回布尔值 fales为未重复 true为已重复
     *
     * @param employeeCode
     * @return
     */
    @PostMapping("/check")
    public Object employeeCheckEmployeeNumber(@RequestParam("employeeCode") String employeeCode) {
        return ResultBean.success(employeeService.check(employeeCode));
    }

    /**
     * 员工信息 删除多个员工信息
     *
     * @param ids
     * @return
     */
    @DeleteMapping("")
    public Object employeeDelete(@RequestBody Collection<Integer> ids) {
        return ResultBean.success(employeeService.delete(ids));
    }

    /**
     * 员工信息 更新员工信息
     *
     * @param employee
     * @return
     */
    @PutMapping("")
    public Object employeeUpdate(@RequestBody Employee employee) {
        employeeService.update(employee);
        return ResultBean.success();
    }
}
