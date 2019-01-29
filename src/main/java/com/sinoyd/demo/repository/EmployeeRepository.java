package com.sinoyd.demo.repository;

import com.sinoyd.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-01-28 16:50
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
