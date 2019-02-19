package com.sinoyd.demo.criteria;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.StringUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-18 14:47
 */
@Getter
@Setter
public class ExamineBaseCriteria extends BaseCriteria {
    private String examineName;
    private String examineType;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private Integer isDeleted;

    @Override
    public String getCondition() {
        values.clear();
        StringBuilder condition = new StringBuilder();
        if (StringUtils.isNotNullAndEmpty(this.examineName)) {
            condition.append(" and examineName like :examineName");
            values.put("examineName", "%" + this.examineName + "%");
        }
        if (StringUtils.isNotNullAndEmpty(this.examineType)) {
            condition.append(" and examineType = :examineType");
            values.put("examineType", this.examineType);
        }
        if (this.startDate != null) {
            condition.append(" and examineCreateDate >= :startDate");
            values.put("startDate", this.startDate);
        }
        if (this.endDate != null) {
            condition.append(" and examineCreateDate <= :endDate");
            values.put("endDate", this.endDate);
        }
        if (this.isDeleted != null) {
            condition.append(" and isDeleted = :isDeleted");
            values.put("isDeleted",this.isDeleted);
        }
        return condition.toString();
    }

    public ExamineBaseCriteria(String examineName, String examineType, String startDate, String endDate, Integer isDeleted) throws ParseException {
        if (StringUtils.isNotNullAndEmpty(examineName)) {
            this.examineName = examineName;
        }
        if (StringUtils.isNotNullAndEmpty(examineType)) {
            this.examineType = examineType;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotNullAndEmpty(startDate)) {
            this.startDate = dateFormat.parse(startDate);
        }
        if (StringUtils.isNotNullAndEmpty(endDate)) {
            this.endDate = dateFormat.parse(endDate);
        }
        if (isDeleted != null) {
            this.isDeleted = isDeleted;
        }
    }
}
