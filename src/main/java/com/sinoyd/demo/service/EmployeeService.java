package com.sinoyd.demo.service;

import com.sinoyd.demo.entity.Employee;
import com.sinoyd.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-01-28 16:51
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


}
