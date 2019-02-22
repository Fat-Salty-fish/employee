package com.sinoyd.demo.repository;

import com.sinoyd.demo.entity.Certificate;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-21 10:13
 */
public interface CertificateRepository extends CrudRepository<Certificate,Integer> {
    List<Certificate> findByExamineBaseId(Integer examineBaseId);

    List<Certificate> findByCertificateIdIn(Collection<Integer> certificateIds);

}
