package com.sinoyd.demo.criteria;

import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-19 11:50
 */
@Getter
@Setter
public class ExamineDetailCriteria extends BaseCriteria {
    private Integer examineBaseId;
    private Integer examineDetailId ;

    @Override
    public String getCondition() {
        values.clear();
        StringBuilder condition = new StringBuilder();
        if(StringUtils.isNotNullAndEmpty(this.examineBaseId)){
            condition.append(" and examineBaseId = :examineBaseId ");
            values.put("examineBaseId",this.examineBaseId);
        }
        if(StringUtils.isNotNullAndEmpty(this.examineDetailId)){
            condition.append(" and examineDetailId = :examineDetailId ");
            values.put("examineDetailId",this.examineDetailId);
        }
        return condition.toString();
    }
}
