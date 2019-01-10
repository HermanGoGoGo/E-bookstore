package com.herman.ebookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herman.ebookstore.mapper.ErrorLogMapper;
import com.herman.ebookstore.pojo.ErrorLog;
import com.herman.ebookstore.service.ErrorLogService;

@Service
public class ErrorLogServiceImpl implements ErrorLogService{
	
	@Autowired
	private ErrorLogMapper errorLogMapper;
	
	@Override
	public Integer insertNewErrorLog(ErrorLog errorLog) {
		return errorLogMapper.insertNewErrorLog(errorLog);
	}

	@Override
	public ErrorLog selectOneErrorLog(ErrorLog errorLog) {
		return errorLogMapper.selectOneErrorLog(errorLog);
	}

}
