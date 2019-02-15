package com.sinoyd.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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

    private String certificateCode;     //证书边海

    private String certificateName;     //证书名称

    private Date certificateDate;       //证书颁布日期    格式：yyyy-MM=-dd

    private Date certificateValidity;      //证书有效日期 格式：yyyy-MM-dd

    private Integer employeeId;         //证书所属的员工id

    private Integer examineBaseId;      //绑定的基础考核信息id

    private Integer examineDetailId;    //绑定的详细考核信息id

    private String examineRemark;       //考核备注
}
