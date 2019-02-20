package com.sinoyd.demo.repository;

import com.sinoyd.demo.entity.ExamineDetailEmployeeAndScoreInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-19 10:20
 */
public interface ExamineDetailEmployeeAndScoreInfoRepository extends CrudRepository<ExamineDetailEmployeeAndScoreInfo,Integer> {
    List<ExamineDetailEmployeeAndScoreInfo> findByExamineDetailIdIn(Collection<Integer> examineDetailIds);
    Integer deleteByExamineEmployeeIdIn(Collection<Integer> examineDetailEmployeeRecordIds);
}
