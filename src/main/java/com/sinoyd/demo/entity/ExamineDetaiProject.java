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
 * @create 2019-01-28 16:27
 */
@Entity
@Table(name = "t_examine_detail_project_info")
@Getter
@Setter
public class ExamineDetaiProject {
    @Id
    @GeneratedValue
    private Integer examineProjectId;

    private Integer examineBaseId;

    private Integer examineDetailId;

    private Integer analysisProjectId;
}
