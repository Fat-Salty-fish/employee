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
    private Integer analysisProjectId;

    private String analysisProjectName;

    private String analysisProjectNationalStandard;

    private String analysisProjectMethod;

    private String analysisProjectYear;
}
