package com.sinoyd.demo.controller;


import com.sinoyd.demo.result.ResultBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-15 8:55
 */
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler
    @ResponseBody
    public Object nullPointerExceptionHandler(NullPointerException e){
        return ResultBean.error(1,e.getMessage());
    }

    @ExceptionHandler
    @ResponseBody
    public Object exceptionHandler(Exception e){
        return ResultBean.error(1,e.getMessage());
    }
}
