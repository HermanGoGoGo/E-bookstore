package com.herman.ebookstore.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herman.ebookstore.common.core.AbstractService;
import com.herman.ebookstore.mapper.MessageMapper;
import com.herman.ebookstore.model.MessageDto;
import com.herman.ebookstore.pojo.Message;
import com.herman.ebookstore.service.MessageService;
import com.herman.ebookstore.util.RelativeDateFormat;

import tk.mybatis.mapper.entity.Condition;



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

	@Autowired
	private MessageMapper messageMapper;
	
	@Override
	public List<Message> findAllMessages(Message message) {
		Condition condition =new Condition(Message.class);
		condition.and().andEqualTo("status", 0);
		if(StringUtils.isNotEmpty(message.getReceiveUserId())) {
			condition.and().andEqualTo("receiveUserId", message.getReceiveUserId());
		}
		if(StringUtils.isNotEmpty(message.getSendUserId())) {
			condition.and().andEqualTo("sendUserId", message.getSendUserId());
		}
		condition.setOrderByClause("create_time desc , id desc");
		return this.messageMapper.selectByCondition(condition);
	}

	@Override
	public List<MessageDto> findAllMessageByDto(MessageDto messageDto) {
		List<MessageDto> messageDtos =this.messageMapper.findAllMessageByDto(messageDto);
		List<MessageDto> messageDtos1 = new ArrayList<MessageDto>();
		for (MessageDto messageDto2 : messageDtos) {
			messageDto2.setShowTime(RelativeDateFormat.format(messageDto2.getCreateTime()));
			messageDtos1.add(messageDto2);
		}
		return messageDtos1;
	}

	@Override
	public List<MessageDto> findAllMessageByReAndSe(MessageDto messageDto) {
		// TODO Auto-generated method stub
		List<MessageDto> messageDtos =this.messageMapper.findAllMessageByReAndSe(messageDto);
		List<MessageDto> messageDtos1 = new ArrayList<MessageDto>();
		for (MessageDto messageDto2 : messageDtos) {
			messageDto2.setShowTime(RelativeDateFormat.format(messageDto2.getCreateTime()));
			messageDtos1.add(messageDto2);
		}
		return messageDtos1;
	}

	@Override
	public Integer findOneMessage(Message message) {
		try {
		    message = this.messageMapper.findOneMessage(message);
		    if(message !=null) {	    	
		    	long delta = new Date().getTime() - message.getCreateTime().getTime();
		    	if(delta < 4000L) {
		    		return 1;
		    	}
		    }
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 0;
	}

	@Override
	public void clearStatus(MessageDto messageDto) {
		// TODO Auto-generated method stub
		this.messageMapper.clearStatus( messageDto);
	}

	@Override
	public List<MessageDto> findAllUserInfo(MessageDto messageDto) {
		List<MessageDto> messageDtos =this.messageMapper.findAllUserInfo(messageDto);
		List<MessageDto> messageDtos1 = new ArrayList<MessageDto>();
		for (MessageDto messageDto2 : messageDtos) {
			messageDto2.setShowTime(RelativeDateFormat.format(messageDto2.getCreateTime()));
			if(messageDto2.getStatus().equals("0")) {
				messageDto2.setStatus("未读");
			}else {
				messageDto2.setStatus("已读");
			}
			messageDtos1.add(messageDto2);
		}
		return messageDtos1;
		
	}

	@Override
	public List<MessageDto> findAllMessageReceiveUserId(MessageDto messageDto) {
		// TODO Auto-generated method stub
		return this.messageMapper.findAllMessageReceiveUserId(messageDto);
	}
	
	

}