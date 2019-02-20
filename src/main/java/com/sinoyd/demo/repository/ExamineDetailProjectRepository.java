package com.sinoyd.demo.repository;

import com.sinoyd.demo.entity.ExamineDetailProject;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-19 10:18
 */
public interface ExamineDetailProjectRepository extends CrudRepository<ExamineDetailProject,Integer> {
    List<ExamineDetailProject> findByExamineDetailIdIn(Collection<Integer> examineDetailIds);
    List<ExamineDetailProject> findByExamineDetailId(Integer examineDetail);
    Integer deleteByExamineProjectIdIn(Collection<Integer> examineDetailProjectIds);
}
