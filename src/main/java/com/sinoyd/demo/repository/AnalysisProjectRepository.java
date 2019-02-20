package com.sinoyd.demo.repository;

import com.sinoyd.demo.entity.AnalysisProject;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-18 8:37
 */
public interface AnalysisProjectRepository extends CrudRepository<AnalysisProject, Integer> {
    List<AnalysisProject> findByAnalysisProjectIdIn(Collection<Integer> analysisProjectIds);
}
