package com.kp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
    
    List<KnowledgeWithBLOBs> getAllKnowledge();
    
    List<KnowledgeWithBLOBs> getKnowledgeByPage(int m,int n);

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
    
    void checkKnowledge(int id);
    
    void editKnowledge(KnowledgeWithBLOBs kp);

	void deleteKnowledge(int parseInt);
	
	List<KnowledgeWithBLOBs> searchKnowledge(@Param("content")String content);
}