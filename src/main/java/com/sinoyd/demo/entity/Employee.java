package com.sinoyd.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Description 公司员工信息表
 * @auther 李忠杰
 * @create 2019-01-28 15:14
 */

@Entity
@Table(name = "t_employee_info")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue
    private Integer employeeId;

    private String employeeName;

    private String employeeCode;

    private String employeeOffice;

    private String employeeJob;

    private String employeeEnglishName;

    private Date employeeBirthday;

    private String  employeeEmail;

    private Integer employeeSex;

    private String employeeIdNumber;

    private String employeeNationality;

    private Integer employeeOrderNumber;

    private String employeeEducation;

    private String employeeTopEducation;

    private String employeeEducationSchool;

    private String employeeMajor;

    private Integer employeeMobilePhone;

    private Integer employeeTelephone;

    private String employeeBirthPlace;

    private String employeeAddress;

    private String employeeTechnicalTitle;

    private Date employeeTechnicalTitleGetDate;

    private String employeeTechnicalQualification;

    private Date employeeTechnicalQualificationGetDate;

    private String employeeEntryCertificate;

    private Date employeeEntryCertificateGetDate;

    private Integer employeeWorkingTime;

    private String employeeCompanyEmail;

    private Date employeeEntryDate;

    private Date employeeStartWorkingDate;

    private Date employeeDimissionDate;

    private Date employeeJoinPartyDate;

    private Integer employeeImportantPosition;

    private String employeeTechnicalAbility;

    private String employeeRemark;
}
