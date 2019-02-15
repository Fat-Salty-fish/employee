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
    private Integer examineEmployeeId;  //员工考核id 理解为考核成绩

    private Integer examineBaseId;      //对应的考核基础信息id（证书）

    private Integer examineDetailId;    //对应的考核详细信息id（考核批次）

    private Integer employeeId;         //对应的员工id

    private Integer examineScore;       //考核分数

    private String examineProblem;      //考核问题

    private String examineResult;       //考核结果

    private String examineComment;      //考核评审

    private String examineCommentPerson;    //考核评审人

    private Integer examineIsPassed;    //是否通过 0为不通过 1为通过

    private Integer examineIsGetCertificate;    //考核是否发证 0为未发证 1为发证
}
