package com.sinoyd.demo.service;

import com.sinoyd.demo.entity.Employee;
import com.sinoyd.demo.repository.EmployeeRepository;
import com.sinoyd.frame.base.repository.CommonRepository;
import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * @Description 员工信息操作Service层 用于对员工数据进行处理
 * @auther 李忠杰
 * @create 2019-01-28 16:51
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CommonRepository commonRepository;

    public Map findByPage(PageBean pageBean, BaseCriteria employeeCriteria) {
        pageBean.setEntityName("Employee a ");
        pageBean.setSelect("Select a ");
        commonRepository.findByPage(pageBean, employeeCriteria);
        List<Employee> employees = pageBean.getData();
        employees.forEach(Employee::intToArray);
        pageBean.setData(employees);
        return ServiceTools.setMapFormat(pageBean);
    }

    public Map findById(Integer id) {
        Employee employee = employeeRepository.findOne(id);
        employee.intToArray();
        return ServiceTools.setMapFormat("employee", employee);
    }

    public void save(Employee employee) {
        employee.arrayToInt();
        employeeRepository.save(employee);
    }

    public Map check(String employeeCode) {
        Boolean check = Optional.ofNullable(employeeRepository.findByEmployeeCode(employeeCode)).isPresent();
        return ServiceTools.setMapFormat("exist", check);
    }

    @Transactional
    public Map delete(Collection<Integer> ids) {
        Integer deleteNum = employeeRepository.deleteByEmployeeIdIn(ids);
        return ServiceTools.setMapFormat("deleteNumber", deleteNum);
    }

    @Transactional
    public void update(Employee employee) {
        if (employee.getEmployeeId() == null) {
            throw new NullPointerException("员工id为空!");
        }
        employee.arrayToInt();
        employeeRepository.save(employee);
    }
}
