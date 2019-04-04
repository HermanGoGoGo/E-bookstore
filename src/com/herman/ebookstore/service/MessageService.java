package com.herman.ebookstore.service;

import java.util.List;

import com.herman.ebookstore.common.core.Service;
import com.herman.ebookstore.model.MessageDto;
import com.herman.ebookstore.pojo.Message;

/**
 * 交互信息表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-13 16:43:30
 */
public interface MessageService extends Service<Message> {
	/** 
	 * @Method_Name: findAllMessages 
	 * @Description: TODO(条件查询所有信息)
	 * @Description: * @param message
	 * @Description: * @return List<Message>
	 * @date 2019年4月2日
	 * @author 黄金宝 
	 */
	public List<Message> findAllMessages(Message message);
	
	/** 
	 * @Method_Name: findAllMessageByDto 
	 * @Description: TODO(条件查询所有信息)
	 * @Description: * @param messageDto
	 * @Description: * @return List<MessageDto>
	 * @date 2019年4月3日
	 * @author 黄金宝 
	 */
	public List<MessageDto> findAllMessageByDto(MessageDto messageDto);
	
	/** 
	 * @Method_Name: findAllMessageByReAndSe 
	 * @Description: TODO(条件查询双方信息)
	 * @Description: * @param messageDto
	 * @Description: * @return List<MessageDto>
	 * @date 2019年4月4日
	 * @author 黄金宝 
	 */
	public List<MessageDto> findAllMessageByReAndSe(MessageDto messageDto);
}