package com.sinoyd.demo.criteria;

import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description 用于员工信息的模糊检索以及分页查询
 * @auther 李忠杰
 * @create 2019-02-15 8:57
 */
@Getter
@Setter
public class EmployeeCriteria extends BaseCriteria {
    private String employeeName;
    private String employeeCode;

    @Override
    public String getCondition() {
        values.clear();
        StringBuilder condition = new StringBuilder();
        if (StringUtils.isNotNullAndEmpty(this.employeeName)) {
            condition.append(" and employeeName like :employeeName ");
            this.values.put("employeeName", "%" + this.employeeName + "%");
        }
        if (StringUtils.isNotNullAndEmpty(this.employeeCode)) {
            condition.append(" and employeeCode like :employeeCode");
            this.values.put("employeeCode", "%" + this.employeeCode + "%");
        }
        return condition.toString();
    }
}
