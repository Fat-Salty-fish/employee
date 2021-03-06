package com.sinoyd.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-01-28 16:27
 */
@Entity
@Table(name = "t_examine_detail_project_info")
@Getter
@Setter
public class ExamineDetailProject {
    @Id
    @GeneratedValue
    private Integer examineProjectId;   //考核内容 即分析项目与考核绑定表id

    private Integer examineBaseId;      //绑定的考核基础信息id

    private Integer examineDetailId;    //绑定的考核详细信息id

    private Integer analysisProjectId;  //绑定的分析项目id

    @Transient
    private AnalysisProject analysisProject; //分析项目 每个绑定下面必定对应一个分析项目

}
