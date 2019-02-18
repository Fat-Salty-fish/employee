package com.sinoyd.demo.service;

import com.sinoyd.frame.base.util.PageBean;
import org.omg.CORBA.OBJECT_NOT_EXIST;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-18 9:24
 */
public class ServiceTools {
    public static Map setMapFormat(PageBean pageBean){
        Map<String,Object> data = new HashMap<>();
        data.put("page",pageBean.getPageNo());
        data.put("rows",pageBean.getData());
        data.put("total",pageBean.getRowsCount());
        return data;
    }

    public static Map setMapFormat(String key,Object value){
        Map<String,Object> data = new HashMap<>();
        data.put(key,value);
        return data;
    }
}
