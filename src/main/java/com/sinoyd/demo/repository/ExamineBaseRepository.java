package com.sinoyd.demo.repository;

import com.sinoyd.demo.entity.ExamineBase;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-15 17:07
 */
public interface ExamineBaseRepository extends CrudRepository<ExamineBase,Integer> {
    List<ExamineBase> findByExamineBaseIdIn(Collection<Integer> ids);
    List<ExamineBase> findByExamineNameLike(String examineName);
}
