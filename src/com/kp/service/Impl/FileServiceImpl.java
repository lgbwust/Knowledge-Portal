package com.kp.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kp.dao.FileMapper;
import com.kp.domain.File;
import com.kp.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	@Resource  
	private FileMapper fileDao;

	@Override
	public int deleteByPrimaryKey(Integer fileId) {
		 try {  
	            return fileDao.deleteByPrimaryKey(fileId);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return 0; 
	}

	@Override
	public int insert(File record) {
		 try {  
	            return fileDao.insert(record);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return 0; 
	}

	@Override
	public int insertSelective(File record) {
		 try {  
	            return fileDao.insertSelective(record);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return 0; 
	}

	@Override
	public File selectByPrimaryKey(Integer fileId) {
		 try {  
	            return fileDao.selectByPrimaryKey(fileId);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return null; 
	}

	@Override
	public int updateByPrimaryKeySelective(File record) {
		 try {  
	            return fileDao.updateByPrimaryKeySelective(record);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return 0; 
	}

	@Override
	public int updateByPrimaryKey(File record) {
		 try {  
	            return fileDao.updateByPrimaryKey(record);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return 0; 
	}

	@Override
	public List<File> listFile(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
