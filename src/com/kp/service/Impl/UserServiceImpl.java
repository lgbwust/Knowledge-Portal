package com.kp.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kp.dao.UserMapper;
import com.kp.domain.User;
import com.kp.service.UserService;

@Service  
public class UserServiceImpl implements UserService {
	
	@Resource  
    private UserMapper userDao; 
	
	@Override
	public int insert(User record) {
		 try {  
	            return userDao.insert(record);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return 0; 
	}

	@Override
	public int deleteByPrimaryKey(Integer userId) {
		 try {  
	            return userDao.deleteByPrimaryKey(userId); 
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return 0; 
	}

	@Override
	public int insertSelective(User record) {
		 try {  
	            return userDao.insertSelective(record);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return 0; 
	}

	@Override
	public User selectByPrimaryKey(Integer userId) {
		 try {  
	            return userDao.selectByPrimaryKey(userId);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return null; 
	}

	@Override
	public int updateByPrimaryKey(User record) {
		 try {  
	            return userDao.updateByPrimaryKey(record); 
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return 0; 
	}

	@Override
	public User findByUserName(String userName) {
		 try {  
	            return userDao.findByUserName(userName);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return null; 
	}

	@Override
	public User findByEmail(String userEmail) {
		try {  
            return userDao.findByEmail(userEmail);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null; 
	}

	@Override
	public int updateUserNameSelective(User record) {
		 try {  
	            return userDao.updateByUserNameSelective(record); 
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return 0; 
	}

	@Override
	public List<User> getAllUser() {
		try {  
            return userDao.getAllUser();
        } catch (Exception e) {  
            e.printStackTrace();
            System.out.println("getUser出现了异常"+e.getMessage());
        }  
        return null; 
	}

	@Override
	public List<User> getUserByPage(int m, int n) {
		try {  
            return userDao.getUserByPage(m, n);
        } catch (Exception e) {  
            e.printStackTrace(); 
            System.out.println("getUserByPage出现了异常"+e.getMessage());
        }  
        return null; 
	}


}
