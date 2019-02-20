package com.sinoyd.demo.controller;

import com.sinoyd.demo.service.ScoreAndCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-20 15:19
 */
@RestController
@RequestMapping("/api/bas/employeeManagement/scoreAndCertificate")
public class ScoreAndCertificateController {
    @Autowired
    private ScoreAndCertificateService scoreAndCertificateService;

    @GetMapping("")
    public Object findScoreByExamineBaseId(){return null;}
}
