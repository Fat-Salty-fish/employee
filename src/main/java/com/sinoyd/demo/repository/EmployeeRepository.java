package com.sinoyd.demo.repository;

import com.sinoyd.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-01-28 16:50
 */
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    Integer deleteAllByEmployeeId(Collection<Integer> ids);
    Employee findByEmployeeCode(String empcloyeeCode);
}
