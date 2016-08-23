package com.kp.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kp.dao.CategoryMapper;
import com.kp.domain.Category;
import com.kp.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Resource
	private CategoryMapper categoryDao;

	@Override
	public int deleteByPrimaryKey(Integer cid) {
		try {  
            return categoryDao.deleteByPrimaryKey(cid);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0; 
	}

	@Override
	public int insert(Category record) {
		try {  
            return categoryDao.insert(record);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0; 
	}

	@Override
	public int insertSelective(Category record) {
		try {  
            return categoryDao.insertSelective(record);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0; 
	}

	@Override
	public Category selectByPrimaryKey(Integer cid) {
		try {  
            return categoryDao.selectByPrimaryKey(cid);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null; 
	}

	@Override
	public int updateByPrimaryKeySelective(Category record) {
		try {  
            return categoryDao.updateByPrimaryKeySelective(record);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0; 
	}

	@Override
	public int updateByPrimaryKey(Category record) {
		try {  
            return categoryDao.updateByPrimaryKey(record);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0; 
	}

}
