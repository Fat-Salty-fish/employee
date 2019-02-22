package com.sinoyd.demo.parameter;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-21 10:35
 */
@Getter
@Setter
public class CertificateParameter {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private List<EmployeeScoreIdAndCertificateCode> data;

    public void checkNull(){
        if(startDate == null){
            throw new NullPointerException("传入的发证时间为空！");
        }
        if(endDate == null){
            throw new NullPointerException("传入的截止时间为空！");
        }
    }
}

