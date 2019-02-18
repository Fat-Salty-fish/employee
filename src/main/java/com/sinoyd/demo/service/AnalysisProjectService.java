package com.sinoyd.demo.service;

import com.sinoyd.demo.repository.AnalysisProjectRepository;
import com.sinoyd.frame.base.repository.CommonRepository;
import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-18 8:36
 */
@Service
public class AnalysisProjectService {
    @Autowired
    private AnalysisProjectRepository analysisProjectRepository;

    @Autowired
    private CommonRepository commonRepository;

    public Map findByPage(PageBean pageBean, BaseCriteria analysisProjectCriteria){
        pageBean.setEntityName(" AnalysisProject a ");
        pageBean.setSelect(" Select a ");
        commonRepository.findByPage(pageBean,analysisProjectCriteria);
        return ServiceTools.setMapFormat(pageBean);
    }
}
