package com.sinoyd.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description 公司员工信息表
 * @auther 李忠杰
 * @create 2019-01-28 15:14
 */

@Entity
@Table(name = "t_employee_info")
public class Employee {
    @Id
    @GeneratedValue
    private Integer employeeId;         //员工id

    private String employeeName;        //员工姓名 非空

    private String employeeCode;        //员工编号 非空

    private String employeeOffice;      //员工办公室 非空

    private String employeeJob;         //员工职位 非空

    private String employeeEnglishName; //员工英文名

    private Date employeeBirthday;      //员工生日 格式；yyyy-MM-dd

    private String employeeEmail;      //员工电子邮箱

    private Integer employeeSex;        //员工性别 0为女性 1为男性

    private String employeeIdNumber;    //员工身份证号

    private String employeeNationality; //员工国籍

    private Integer employeeOrderNumber;//员工排序值

    private String employeeEducation;   //员工学历

    private String employeeTopEducation;//员工最高学历

    private String employeeEducationSchool; //员工毕业学校

    private String employeeMajor;       //员工所学专业

    private String employeeMobilePhone; //员工移动电话

    private String employeeTelephone;   //员工固定电话

    private String employeeBirthPlace;  //员工出生地

    private String employeeAddress;     //员工住址

    private String employeeTechnicalTitle;  //员工技术职称

    private Date employeeTechnicalTitleGetDate; //员工技术职称获得时间

    private String employeeTechnicalQualification;  //员工技术资格

    private Date employeeTechnicalQualificationGetDate; //员工技术资格获得时间

    private String employeeEntryCertificate;    //员工员工准入证书

    private Date employeeEntryCertificateGetDate;   //员工准入证书获得时间

    private Integer employeeWorkingTime;    //在岗时间

    private String employeeCompanyEmail;    //员工公司邮箱

    private Date employeeEntryDate;         //员工入职日期 格式：yyyy-MM-dd

    private Date employeeStartWorkingDate;  //员工开始工作日期 格式：yyyy-MM-dd

    private Date employeeDimissionDate;     //员工离职时间 格式：yyyy-MM-dd

    private Date employeeJoinPartyDate;     //员工入党时间 格式：yyyy-MM-dd

    @Transient
    private List<Integer> employeeImportantPosition;  //员工关键岗位 复选框

    private String employeeTechnicalAbility;    //员工技术能力

    private String employeeRemark;              //员工备注

    private Integer employeeImportantPositionInt;   //员工关键岗位折算为数字储存在数据库中

    public void intToArray() {                  //将数字转换为数组
        employeeImportantPosition = new ArrayList<>();
        if (employeeImportantPositionInt != null && employeeImportantPositionInt != 0) {
            for (int i = 1; i < 16; i++) {
                Integer check = employeeImportantPositionInt & (int) Math.pow(2, i);
                if (!check.equals(0)) {
                    employeeImportantPosition.add(i);
                }
            }
        }
    }

    public void arrayToInt() {                  //将数组转换为数字
        employeeImportantPositionInt = 0;
        if (employeeImportantPosition != null && employeeImportantPosition.size() != 0) {
            for (int i = 0; i < employeeImportantPosition.size(); i++) {
                employeeImportantPositionInt += (int) Math.pow(2, employeeImportantPosition.get(i));
            }
        }
    }



    public Employee() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeOffice() {
        return employeeOffice;
    }

    public void setEmployeeOffice(String employeeOffice) {
        this.employeeOffice = employeeOffice;
    }

    public String getEmployeeJob() {
        return employeeJob;
    }

    public void setEmployeeJob(String employeeJob) {
        this.employeeJob = employeeJob;
    }

    public String getEmployeeEnglishName() {
        return employeeEnglishName;
    }

    public void setEmployeeEnglishName(String employeeEnglishName) {
        this.employeeEnglishName = employeeEnglishName;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Integer getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(Integer employeeSex) {
        this.employeeSex = employeeSex;
    }

    public String getEmployeeIdNumber() {
        return employeeIdNumber;
    }

    public void setEmployeeIdNumber(String employeeIdNumber) {
        this.employeeIdNumber = employeeIdNumber;
    }

    public String getEmployeeNationality() {
        return employeeNationality;
    }

    public void setEmployeeNationality(String employeeNationality) {
        this.employeeNationality = employeeNationality;
    }

    public Integer getEmployeeOrderNumber() {
        return employeeOrderNumber;
    }

    public void setEmployeeOrderNumber(Integer employeeOrderNumber) {
        this.employeeOrderNumber = employeeOrderNumber;
    }

    public String getEmployeeEducation() {
        return employeeEducation;
    }

    public void setEmployeeEducation(String employeeEducation) {
        this.employeeEducation = employeeEducation;
    }

    public String getEmployeeTopEducation() {
        return employeeTopEducation;
    }

    public void setEmployeeTopEducation(String employeeTopEducation) {
        this.employeeTopEducation = employeeTopEducation;
    }

    public String getEmployeeEducationSchool() {
        return employeeEducationSchool;
    }

    public void setEmployeeEducationSchool(String employeeEducationSchool) {
        this.employeeEducationSchool = employeeEducationSchool;
    }

    public String getEmployeeMajor() {
        return employeeMajor;
    }

    public void setEmployeeMajor(String employeeMajor) {
        this.employeeMajor = employeeMajor;
    }

    public String getEmployeeMobilePhone() {
        return employeeMobilePhone;
    }

    public void setEmployeeMobilePhone(String employeeMobilePhone) {
        this.employeeMobilePhone = employeeMobilePhone;
    }

    public String getEmployeeTelephone() {
        return employeeTelephone;
    }

    public void setEmployeeTelephone(String employeeTelephone) {
        this.employeeTelephone = employeeTelephone;
    }

    public String getEmployeeBirthPlace() {
        return employeeBirthPlace;
    }

    public void setEmployeeBirthPlace(String employeeBirthPlace) {
        this.employeeBirthPlace = employeeBirthPlace;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeTechnicalTitle() {
        return employeeTechnicalTitle;
    }

    public void setEmployeeTechnicalTitle(String employeeTechnicalTitle) {
        this.employeeTechnicalTitle = employeeTechnicalTitle;
    }

    public Date getEmployeeTechnicalTitleGetDate() {
        return employeeTechnicalTitleGetDate;
    }

    public void setEmployeeTechnicalTitleGetDate(Date employeeTechnicalTitleGetDate) {
        this.employeeTechnicalTitleGetDate = employeeTechnicalTitleGetDate;
    }

    public String getEmployeeTechnicalQualification() {
        return employeeTechnicalQualification;
    }

    public void setEmployeeTechnicalQualification(String employeeTechnicalQualification) {
        this.employeeTechnicalQualification = employeeTechnicalQualification;
    }

    public Date getEmployeeTechnicalQualificationGetDate() {
        return employeeTechnicalQualificationGetDate;
    }

    public void setEmployeeTechnicalQualificationGetDate(Date employeeTechnicalQualificationGetDate) {
        this.employeeTechnicalQualificationGetDate = employeeTechnicalQualificationGetDate;
    }

    public String getEmployeeEntryCertificate() {
        return employeeEntryCertificate;
    }

    public void setEmployeeEntryCertificate(String employeeEntryCertificate) {
        this.employeeEntryCertificate = employeeEntryCertificate;
    }

    public Date getEmployeeEntryCertificateGetDate() {
        return employeeEntryCertificateGetDate;
    }

    public void setEmployeeEntryCertificateGetDate(Date employeeEntryCertificateGetDate) {
        this.employeeEntryCertificateGetDate = employeeEntryCertificateGetDate;
    }

    public Integer getEmployeeWorkingTime() {
        return employeeWorkingTime;
    }

    public void setEmployeeWorkingTime(Integer employeeWorkingTime) {
        this.employeeWorkingTime = employeeWorkingTime;
    }

    public String getEmployeeCompanyEmail() {
        return employeeCompanyEmail;
    }

    public void setEmployeeCompanyEmail(String employeeCompanyEmail) {
        this.employeeCompanyEmail = employeeCompanyEmail;
    }

    public Date getEmployeeEntryDate() {
        return employeeEntryDate;
    }

    public void setEmployeeEntryDate(Date employeeEntryDate) {
        this.employeeEntryDate = employeeEntryDate;
    }

    public Date getEmployeeStartWorkingDate() {
        return employeeStartWorkingDate;
    }

    public void setEmployeeStartWorkingDate(Date employeeStartWorkingDate) {
        this.employeeStartWorkingDate = employeeStartWorkingDate;
    }

    public Date getEmployeeDimissionDate() {
        return employeeDimissionDate;
    }

    public void setEmployeeDimissionDate(Date employeeDimissionDate) {
        this.employeeDimissionDate = employeeDimissionDate;
    }

    public Date getEmployeeJoinPartyDate() {
        return employeeJoinPartyDate;
    }

    public void setEmployeeJoinPartyDate(Date employeeJoinPartyDate) {
        this.employeeJoinPartyDate = employeeJoinPartyDate;
    }

    public List<Integer> getEmployeeImportantPosition() {
        return employeeImportantPosition;
    }

    public void setEmployeeImportantPosition(List<Integer> employeeImportantPosition) {
        this.employeeImportantPosition = employeeImportantPosition;
        System.out.println("setEmployeeImportantPosition方法被调用" + this.employeeImportantPosition);
    }

    public String getEmployeeTechnicalAbility() {
        return employeeTechnicalAbility;
    }

    public void setEmployeeTechnicalAbility(String employeeTechnicalAbility) {
        this.employeeTechnicalAbility = employeeTechnicalAbility;
    }

    public String getEmployeeRemark() {
        return employeeRemark;
    }

    public void setEmployeeRemark(String employeeRemark) {
        this.employeeRemark = employeeRemark;
    }

    public Integer getEmployeeImportantPositionInt() {
        return employeeImportantPositionInt;
    }

    public void setEmployeeImportantPositionInt(Integer employeeImportantPositionInt) {
        this.employeeImportantPositionInt = employeeImportantPositionInt;
        System.out.println("setEmployeeImportantPositionInt方法被调用" + this.employeeImportantPositionInt);
    }
}


