package com.kp.service;

import java.util.List;

import com.kp.domain.User;

public interface UserService {
	public int insert(User record);
	public int deleteByPrimaryKey(Integer userId);
	public int insertSelective(User record);
	public User selectByPrimaryKey(Integer userId);
	public User findByUserName(String userName);
	public User findByEmail(String userEmail);
	public int updateUserNameSelective(User record);
	public int updateByPrimaryKey(User record);
	//
	public List<User> getAllUser();
	    
	public List<User> getUserByPage(int m,int n);
}
