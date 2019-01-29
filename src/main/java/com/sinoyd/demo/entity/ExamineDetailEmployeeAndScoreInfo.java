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
 * @create 2019-01-28 16:31
 */
@Entity
@Table(name = "t_examine_detail_employee_and_score_info")
@Getter
@Setter
public class ExamineDetailEmployeeAndScoreInfo {
    @Id
    @GeneratedValue
    private Integer examineEmployeeId;

    private Integer examineBaseId;

    private Integer examineDetailId;

    private Integer employeeId;

    private Integer examineScore;

    private String examineProblem;

    private String examineResult;

    private String examineComment;

    private String examineCommentPerson;

    private Integer examineIsPassed;

    private Integer examineIsGetCertificate;
}
