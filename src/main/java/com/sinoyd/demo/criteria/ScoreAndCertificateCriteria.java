package com.sinoyd.demo.criteria;

import com.sinoyd.frame.base.util.BaseCriteria;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-20 16:07
 */
@Getter
@Setter
public class ScoreAndCertificateCriteria extends BaseCriteria {
    private Integer examineBaseId;
    private Integer examineDetailId;
    private Integer examineIsGetCertificate;

    @Override
    public String getCondition() {
        this.values.clear();
        StringBuilder condition = new StringBuilder();

        return null;
    }
}
