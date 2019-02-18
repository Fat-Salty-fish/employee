package com.sinoyd.demo.criteria;

import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-18 8:45
 */
@Setter
@Getter
public class AnalysisProjectCriteria extends BaseCriteria {
    private String analysisProjectName;

    private String analysisProjectSpecimenType;

    @Override
    public String getCondition() {
        this.values.clear();
        StringBuilder condition = new StringBuilder();
        if (StringUtils.isNotNullAndEmpty(this.analysisProjectName)) {
            condition.append(" and analysisProjectName like :analysisProjectName");
            this.values.put("analysisProjectName", "%" + this.analysisProjectName + "%");
        }
        if (StringUtils.isNotNullAndEmpty(this.analysisProjectSpecimenType)) {
            condition.append(" and analysisProjectSpecimenType like :analysisProjectSpecimenType ");
            this.values.put("analysisProjectSpecimenType", "%" + this.analysisProjectSpecimenType + "%");
        }
        return condition.toString();
    }
}
