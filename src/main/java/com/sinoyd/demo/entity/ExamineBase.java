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
    private Integer examineBaseId;      //考核基础信息id

    private String examineProjectName;  //考核名称 理解为证书名称

    private String examineCompany;      //考核公司

    private String examineContent;      //考核内容

    private String examineType;         //考核类型

    private String examineTeacher;      //考核人、讲师

    private String examineRecordPerson; //考核记录人

    private Integer examineLearningTime;//考核学时

    private String examineCertificateType;//考核证书类型

    private String examineRemark;   //考核备注
}
