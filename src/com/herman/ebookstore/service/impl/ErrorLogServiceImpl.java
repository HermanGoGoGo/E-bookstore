package com.herman.ebookstore.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herman.ebookstore.common.core.AbstractService;
import com.herman.ebookstore.pojo.ErrorLog;
import com.herman.ebookstore.service.ErrorLogService;



/**
 * 错误信息表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-13 16:21:37
 */
@Service
@Transactional
public class ErrorLogServiceImpl extends AbstractService<ErrorLog> implements ErrorLogService {

}