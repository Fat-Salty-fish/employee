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
    private Integer certificateId;

    private String certificateCode;

    private String certificateName;

    private Date certificateDate;

    private Date certificateValidity;

    private Integer employeeId;

    private Integer examineBaseId;

    private Integer examineDetailId;

    private String examineRemark;
}
