package com.sinoyd.demo.criteria;

import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-20 16:07
 */
@Getter
@Setter
public class ScoreAndCertificateCriteria extends BaseCriteria {
    private Integer employeeId;
    private String examineName;                 //转换为examineBaseId

    private List<Integer> examineBaseIds;              //被转换

    @Override
    public String getCondition() {
        this.values.clear();
        StringBuilder condition = new StringBuilder();

        if (this.examineBaseIds != null && this.examineBaseIds.size() > 0) {
            condition.append(" and examineBaseId in :examineBaseIds ");
            values.put("examineBaseIds", this.examineBaseIds);
        }
        if (this.employeeId != null) {
            condition.append(" and employeeId = :employeeId ");
            values.put("employeeId", this.employeeId);
        }

        condition.append(" and isDeleted = 0 ");
        return condition.toString();
    }
}
