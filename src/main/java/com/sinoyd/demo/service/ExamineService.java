package com.sinoyd.demo.service;

import com.sinoyd.demo.repository.ExamineBaseRepository;
import com.sinoyd.demo.repository.ExamineDetailRepository;
import com.sinoyd.frame.base.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-15 17:06
 */
@Service
public class ExamineService {
    @Autowired
    private ExamineBaseRepository examineBaseRepository;

    @Autowired
    private ExamineDetailRepository examineDetailRepository;

    @Autowired
    private CommonRepository commonRepository;

    public
}
