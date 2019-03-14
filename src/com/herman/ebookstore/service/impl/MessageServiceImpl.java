package com.herman.ebookstore.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herman.ebookstore.common.core.AbstractService;
import com.herman.ebookstore.pojo.Message;
import com.herman.ebookstore.service.MessageService;



/**
 * 交互信息表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-13 16:43:30
 */
@Service
@Transactional
public class MessageServiceImpl extends AbstractService<Message> implements MessageService {

}