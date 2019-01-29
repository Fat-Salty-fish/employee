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
 * @create 2019-01-28 16:18
 */
@Entity
@Table(name = "t_examine_detail_info")
@Getter
@Setter
public class ExamineDetail {
    @Id
    @GeneratedValue
    private Integer examineDetailId;

    private Integer examineBaseId;

    private Date examineDate;

    private String examineCode;
}
