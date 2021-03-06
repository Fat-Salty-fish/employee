package com.sinoyd.demo.service;

import com.sinoyd.demo.entity.ExamineBase;
import com.sinoyd.demo.repository.ExamineBaseRepository;
import com.sinoyd.demo.repository.ExamineDetailRepository;
import com.sinoyd.frame.base.repository.CommonRepository;
import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-15 17:06
 */
@Service
public class ExamineBaseService {
    @Autowired
    private ExamineBaseRepository examineBaseRepository;

    @Autowired
    private CommonRepository commonRepository;

    public void create(ExamineBase examineBase){
        examineBaseRepository.save(examineBase);
    }

    public Map findByPage(PageBean pageBean, BaseCriteria examineBaseCriertia){
        pageBean.setEntityName("ExamineBase a");
        pageBean.setSelect("Select a");
        commonRepository.findByPage(pageBean,examineBaseCriertia);
        return ServiceTools.setMapFormat(pageBean);
    }

    public Map findById(Integer id){
        ExamineBase examineBase = examineBaseRepository.findOne(id);
        return ServiceTools.setMapFormat("examineBase",examineBase);
    }

    @Transactional
    public Map delete(Collection<Integer> ids){
        List<ExamineBase> examineBases = examineBaseRepository.findByExamineBaseIdIn(ids);
        Integer deleteNum = (int)examineBases.stream().filter(examineBase -> examineBase.getIsDeleted()==0).peek(examineBase -> examineBase.setIsDeleted(1)).count();
        examineBaseRepository.save(examineBases);
        return ServiceTools.setMapFormat("deleteNum",deleteNum);
    }

    @Transactional
    public void update(ExamineBase examineBase){
        if(examineBase.getExamineBaseId() == null){
            throw new NullPointerException("考核id为空!");
        }
        examineBaseRepository.save(examineBase);
    }
}
