package com.sinoyd.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-01-28 16:08
 */
@Entity
@Table(name = "t_examine_base_info")
@Setter
@Getter
public class ExamineBase {
    @Id
    @GeneratedValue
    private Integer examineBaseId;

    private String examineProjectName;

    private String examineCompany;

    private String examineContent;

    private String examineType;

    private String examineTeacher;

    private String examineRecordPerson;

    private Integer examineLearningTime;

    private String examineCertificateType;

    private String examineRemark;
}
