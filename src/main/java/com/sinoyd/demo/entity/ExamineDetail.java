package com.sinoyd.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-01-28 16:18
 */
@Entity
@Table(name = "t_examine_detail_info")
@Getter
@Setter
public class ExamineDetail {
    @Id
    @GeneratedValue
    private Integer examineDetailId;    //考核详情id 考核详情理解为考核批次

    private Integer examineBaseId;      //考核批次绑定的考核基础信息id

    private Date examineDate;           //考核时间

    private String examineCode;         //考核编号

    private Integer isScored = 0;       //状态 判断考核批次是否已经给过分了 0为未给分 1为已给分
                                        //在给过分之后 对应批次的人员和分析项目不能再被修改

//    private Integer isCertificated;     //状态 判断考核批次是否已经发过证了

    @Transient
    private Integer totalTestProject;   //返回的测试项目总数

    @Transient
    private Integer totalPeople;        //返回的考核员工总数
}
