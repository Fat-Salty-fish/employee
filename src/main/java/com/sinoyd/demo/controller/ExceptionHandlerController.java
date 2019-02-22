package com.sinoyd.demo.controller;


import com.sinoyd.demo.result.ResultBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** 异常拦截controller层 将异常捕获进行统一处理 截获顺序为从上到下
 * @Description
 * @auther 李忠杰
 * @create 2019-02-15 8:55
 */
@RestControllerAdvice
public class ExceptionHandlerController {

    /**
     * 截获空指针异常方法
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public Object nullPointerExceptionHandler(NullPointerException e){
        return ResultBean.error(1,e.getMessage());
    }

    /**
     * 截获非法参数异常方法
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public Object illegalArgumentExceptionHandler(IllegalArgumentException e){
        return ResultBean.error(1,e.getMessage());
    }

    /**
     * 截获其他未知异常方法
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public Object exceptionHandler(Exception e){
        return ResultBean.error(1,e.getMessage());
    }

}
