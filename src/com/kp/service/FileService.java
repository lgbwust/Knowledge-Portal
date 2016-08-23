package com.kp.service;

import com.kp.domain.File;

public interface FileService {

	int deleteByPrimaryKey(Integer fileId);

	int insert(File record);

	int insertSelective(File record);

	File selectByPrimaryKey(Integer fileId);

	int updateByPrimaryKeySelective(File record);

	int updateByPrimaryKey(File record);
}
