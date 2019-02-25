package com.sinoyd.demo.result;

import com.sinoyd.frame.base.util.PageBean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ResultBean1 {

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

}

