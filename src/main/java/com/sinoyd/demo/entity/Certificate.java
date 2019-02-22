package com.sinoyd.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-01-28 16:39
 */

@Entity
@Table(name = "t_certificate")
@Setter
@Getter
public class Certificate {
    @Id
    @GeneratedValue
    private Integer certificateId;      //证书id

    private String certificateCode;     //证书编号

    private Date certificateDate;       //证书颁布日期    格式：yyyy-MM=-dd

    private Date certificateValidity;   //证书有效日期 格式：yyyy-MM-dd

    private Integer employeeId;         //证书所属的员工id

    private Integer examineBaseId;      //绑定的基础考核信息id

    private Integer examineDetailId;    //绑定的详细考核信息id

    private Integer examineEmployeeId;  //绑定的成绩表Id

    private String certificateRemark;   //考核证书备注

    private Integer isDeleted = 0 ;         //是否删除记号 即删除仅为修改此字段即可

    @Transient
    private ExamineBase examineBase;    //考核基础信息 用于前端展示

    @Transient
    private Employee employee;          //员工信息 用于前端展示
}
