package com.sinoyd.demo.result;

import com.sinoyd.frame.base.util.PageBean;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultBean1 {
//    private int code;
//    private String msg;
//    private T data;

    public static <T> Map<String, Object> success(T data) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", 0);
        result.put("data", data);
        return result;
    }

    public static <T> Map<String, Object> success(Collection<T> data) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", 0);
        result.put("data", data);
        return result;
    }

    public static <T> Map<String, Object> success(PageBean data) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", 0);
        result.put("data", data.getData());
        return result;
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

