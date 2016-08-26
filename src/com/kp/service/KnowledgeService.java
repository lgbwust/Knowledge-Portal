package com.kp.service;

import java.util.List;

import com.kp.domain.Knowledge;
import com.kp.domain.KnowledgeWithBLOBs;

public interface KnowledgeService {
	
    int deleteByPrimaryKey(Integer kid);

    int insert(KnowledgeWithBLOBs record);

    int insertSelective(KnowledgeWithBLOBs record);

    List<KnowledgeWithBLOBs> selectByPrimaryKey(Integer kid);
    
    List<KnowledgeWithBLOBs> listKnowledge(int status);

    int updateByPrimaryKeySelective(KnowledgeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(KnowledgeWithBLOBs record);

    int updateByPrimaryKey(Knowledge record);
    
    List<KnowledgeWithBLOBs> getAllKnowledge();
    
    List<KnowledgeWithBLOBs> getKnowledgeByPage(int m,int n);
}
