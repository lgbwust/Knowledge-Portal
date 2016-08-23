package com.kp.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kp.dao.AdminMapper;
import com.kp.domain.Admin;
import com.kp.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Resource
	private AdminMapper adminDao;

	@Override
	public int deleteByPrimaryKey(Integer adminId) {
		 try {  
	            return adminDao.deleteByPrimaryKey(adminId);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return 0; 
	}

	@Override
	public int insert(Admin record) {
		try {  
            return adminDao.insert(record);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0; 
	}

	@Override
	public int insertSelective(Admin record) {
		try {  
            return adminDao.insertSelective(record);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0; 
	}

	@Override
	public Admin selectByPrimaryKey(Integer adminId) {
		try {  
            return adminDao.selectByPrimaryKey(adminId);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null; 
	}

	@Override
	public int updateByPrimaryKeySelective(Admin record) {
		try {  
            return adminDao.updateByPrimaryKeySelective(record);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0; 
	}

	@Override
	public int updateByPrimaryKey(Admin record) {
		try {  
            return adminDao.updateByPrimaryKey(record);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0; 
	}

}
