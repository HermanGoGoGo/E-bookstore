package com.herman.ebookstore.service;

import com.herman.ebookstore.pojo.ErrorLog;

/**
 * @ClassName: ErrorLogService
 * @Description: TODO()
 * @author 黄金宝
 * @date 2018年12月30日
 *
 */
public interface ErrorLogService {
	Integer insertNewErrorLog(ErrorLog errorLog);
	ErrorLog selectOneErrorLog(ErrorLog errorLog);
}
