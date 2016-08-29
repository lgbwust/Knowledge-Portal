package com.kp.service;

import java.util.List;

import com.kp.domain.Admin;
import com.kp.domain.SysMenu;

public interface AdminService {

	int deleteByPrimaryKey(Integer adminId);

	int insert(Admin record);

	int insertSelective(Admin record);

	Admin selectByPrimaryKey(Integer adminId);
	
	Admin selectByName(String adminName);

	int updateByPrimaryKeySelective(Admin record);

	int updateByPrimaryKey(Admin record);
	
	List<SysMenu> getMenu();
}
