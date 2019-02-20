package com.sinoyd.demo.service;

import com.sinoyd.demo.repository.ExamineDetailEmployeeAndScoreInfoRepository;
import com.sinoyd.frame.base.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-20 15:24
 */
@Service
public class ScoreAndCertificateService {
    @Autowired
    private CommonRepository commonRepository;

    @Autowired
    private ExamineDetailEmployeeAndScoreInfoRepository examineDetailEmployeeAndScoreInfoRepositoryl;


}
