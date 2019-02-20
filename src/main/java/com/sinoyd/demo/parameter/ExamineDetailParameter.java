package com.sinoyd.demo.parameter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-20 11:41
 */
@Getter
@Setter
public class ExamineDetailParameter {
    private Integer examineBaseId;
    private Integer examineDetailId;
    private List<Integer> data ;

    public void checkNull(){
        if(this.examineBaseId == null){
            throw new NullPointerException("考核基础信息id为空！");
        }
        if (this.examineDetailId == null){
            throw new NullPointerException("考核详细信息id为空！");
        }
        if(this.data == null || data.size()== 0){
            throw new NullPointerException("传入数组为空！");
        }
    }
}
