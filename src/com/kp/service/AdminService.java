package com.kp.service;

import com.kp.domain.Admin;

public interface AdminService {

	int deleteByPrimaryKey(Integer adminId);

	int insert(Admin record);

	int insertSelective(Admin record);

	Admin selectByPrimaryKey(Integer adminId);
	
	Admin selectByName(String adminName);

	int updateByPrimaryKeySelective(Admin record);

	int updateByPrimaryKey(Admin record);
}
