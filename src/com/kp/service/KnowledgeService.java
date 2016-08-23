package com.kp.service;

import com.kp.domain.Knowledge;
import com.kp.domain.KnowledgeWithBLOBs;

public interface KnowledgeService {
	
    int deleteByPrimaryKey(Integer kid);

    int insert(KnowledgeWithBLOBs record);

    int insertSelective(KnowledgeWithBLOBs record);

    KnowledgeWithBLOBs selectByPrimaryKey(Integer kid);

    int updateByPrimaryKeySelective(KnowledgeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(KnowledgeWithBLOBs record);

    int updateByPrimaryKey(Knowledge record);
}
