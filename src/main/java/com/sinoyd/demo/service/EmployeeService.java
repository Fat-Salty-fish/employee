package com.sinoyd.demo.service;

import com.sinoyd.demo.entity.Employee;
import com.sinoyd.demo.repository.EmployeeRepository;
import com.sinoyd.frame.base.repository.CommonRepository;
import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    public Map findByPage(PageBean pageBean , BaseCriteria employeeCriteria){
        pageBean.setEntityName("Employee a ");
        pageBean.setSelect("Select a ");
        commonRepository.findByPage(pageBean,employeeCriteria);
        Map<String,Object> data = new HashMap<>();
        data.put("page",pageBean.getPageNo());
        data.put("rows",pageBean.getData());
        data.put("total",pageBean.getRowsCount());
        return data;
    }

    public Map findById(Integer id){
        Employee employee = employeeRepository.findOne(id);
        Map<String,Object> data = new HashMap<>();
        data.put("employee",employee);
        return data;
    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public Map check(String employeeCode){
        Boolean check = Optional.ofNullable(employeeRepository.findByEmployeeCode(employeeCode)).isPresent();
        Map data = new HashMap();
        data.put("exist",check);
        return data;
    }

    @Transactional
    public Map delete(Collection<Integer> ids){
        Integer deleteNum = employeeRepository.deleteAllByEmployeeId(ids);
        Map data = new HashMap();
        data.put("deleteNumber",deleteNum);
        return data;
    }

    @Transactional
    public void update(Employee employee){
        employeeRepository.save(employee);
    }

}
