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
 * @create 2019-01-28 16:44
 */
@Entity
@Table(name = "t_analysis_project")
@Setter
@Getter
public class AnalysisProject {
    @Id
    @GeneratedValue
    private Integer analysisProjectId;      //分析项目id

    private String analysisProjectName;     //分析项目名

    private String analysisProjectNationalStandard; //分析项目国家标准

    private String analysisProjectMethod;   //分析项目方法

    private String analysisProjectYear;     //分析项目年份

    private String analysisProjectSpecimenType;     //分析项目样品类型

    private Integer isDivided;              //是否分包 1为是 0为否

    private Integer isLocal;                //是否现场 1为是 0为否
}
