package com.kp.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kp.dao.KnowledgeMapper;
import com.kp.domain.Knowledge;
import com.kp.domain.KnowledgeWithBLOBs;
import com.kp.service.KnowledgeService;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

	@Resource
	private KnowledgeMapper knowledgeDao;

	@Override
	public int deleteByPrimaryKey(Integer kid) {
		try {  
            return knowledgeDao.deleteByPrimaryKey(kid);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0; 
	}

	@Override
	public int insert(KnowledgeWithBLOBs record) {
		try {  
            return knowledgeDao.insert(record);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0; 
	}

	@Override
	public int insertSelective(KnowledgeWithBLOBs record) {
		try {  
            return knowledgeDao.insertSelective(record);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0; 
	}

	@Override
	public KnowledgeWithBLOBs selectByPrimaryKey(Integer kid) {
		try {  
            return knowledgeDao.selectByPrimaryKey(kid);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null; 
	}

	@Override
	public int updateByPrimaryKeySelective(KnowledgeWithBLOBs record) {
		try {  
            return knowledgeDao.updateByPrimaryKeySelective(record);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0; 
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(KnowledgeWithBLOBs record) {
		try {  
            return knowledgeDao.updateByPrimaryKeyWithBLOBs(record);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0; 
	}

	@Override
	public int updateByPrimaryKey(Knowledge record) {
		try {  
            return knowledgeDao.updateByPrimaryKey(record);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0; 
	}

}
