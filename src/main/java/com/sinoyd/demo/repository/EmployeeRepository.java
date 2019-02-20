package com.sinoyd.demo.repository;

import com.sinoyd.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-01-28 16:50
 */
public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
    Integer deleteByEmployeeIdIn(Collection<Integer> ids);
    Employee findByEmployeeCode(String employeeCode);
    List<Employee> findByEmployeeIdIn(Collection<Integer> employeeIds);
}
