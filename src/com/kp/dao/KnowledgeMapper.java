package com.kp.dao;

import java.util.List;

import com.kp.domain.Knowledge;
import com.kp.domain.KnowledgeWithBLOBs;

public interface KnowledgeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer kid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    int insert(KnowledgeWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    int insertSelective(KnowledgeWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    List<KnowledgeWithBLOBs> selectByPrimaryKey(Integer kid);
    
    //列出知识点
    List<KnowledgeWithBLOBs>listKnowledge(int status);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(KnowledgeWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(KnowledgeWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Knowledge record);
}