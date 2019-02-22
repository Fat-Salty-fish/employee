package com.sinoyd.demo.controller;

import com.sinoyd.demo.criteria.ExamineBaseCriteria;
import com.sinoyd.demo.entity.ExamineBase;
import com.sinoyd.demo.result.ResultBean;
import com.sinoyd.demo.service.ExamineBaseService;
import com.sinoyd.frame.base.controller.BaseController;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;

/**
 * @Description 考核基础信息controller 响应与考核基础信息有关的请求
 * @auther 李忠杰
 * @create 2019-02-15 16:56
 */
@RestController
@RequestMapping("/api/bas/employeeManagement/examine/baseInfo")
public class ExamineBaseInfoController extends BaseController {
    @Autowired
    private ExamineBaseService examineBaseService;

    /**
     * 考核基础信息 分页搜索和模糊搜索
     *
     * @param examineName 查询条件 考核名（同时为证书名）
     * @param examineType 查询条件 考核类型
     * @param startDate   查询条件 创建时间的范围 开始
     * @param endDate     查询条件 创建时间的范围 结束
     * @return
     * @throws ParseException
     */
    @GetMapping("")
    public Object examineBaseFindByPage(String examineName,
                                        String examineType,
                                        String startDate,
                                        String endDate) throws ParseException {
        PageBean pageBean = this.getPageBean();
        ExamineBaseCriteria examineBaseCriteria = new ExamineBaseCriteria(examineName, examineType, startDate, endDate, 0);
        return ResultBean.success(examineBaseService.findByPage(pageBean, examineBaseCriteria));
    }

    /**
     * 考核基础信息 根据id进行查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Object examineBaseFindById(@PathVariable  Integer id) {
        return ResultBean.success(examineBaseService.findById(id));
    }

    /**
     * 考核基础信息 新增一条考核基础信息
     *
     * @param examineBase
     * @return
     */
    @PostMapping("")
    public Object examineBaseCreate(@RequestBody ExamineBase examineBase) {
        System.out.println();
        examineBaseService.create(examineBase);
        return ResultBean.success();
    }

    /**
     * 考核基础信息 删除多个考核基础信息 实现假删 即数据库修改isDeleted字段为1 即为删除
     *
     * @param examineBaseIds
     * @return
     */
    @DeleteMapping("")
    public Object examineBaseDelete(@RequestBody Collection<Integer> examineBaseIds) {
        return ResultBean.success(examineBaseService.delete(examineBaseIds));
    }

    /**
     * 考核基础信息 修改考核基础信息
     *
     * @param examineBase
     * @return
     */
    @PutMapping("")
    public Object examineBaseUpdate(@RequestBody ExamineBase examineBase) {
        examineBaseService.update(examineBase);
        return ResultBean.success();
    }


}
