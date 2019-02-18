package com.sinoyd.demo.result;

import com.sinoyd.frame.base.util.PageBean;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 用来规范返回数据的结构类 code 表示代码 0为正常 1、2代表用户输入错误 -1、-2代表服务器错误
 * @auther 李忠杰
 * @create 2019-01-15 14:30
 */
@Getter
@Setter
public class ResultBean<K, V> {
    private Integer code;
    private String message;
    private Map<K, V> data;

    public ResultBean() {
    }

    public static ResultBean error(Integer code, String message) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(code);
        resultBean.setMessage(message);
        return resultBean;
    }

    public static ResultBean success() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setMessage("success");
        return resultBean;
    }

    public static <K, V> ResultBean<K, V> success(Map<K, V> data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }
}
