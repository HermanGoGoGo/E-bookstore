package com.herman.ebookstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import com.herman.ebookstore.common.core.Mapper;
import com.herman.ebookstore.mapper.BookMapper.BookSqlBuilder;
import com.herman.ebookstore.model.MessageDto;
import com.herman.ebookstore.pojo.Message;

/**
 * 交互信息表
 * 
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-13 16:43:30
 */
public interface MessageMapper extends Mapper<Message> {
	/** 
	 * @Method_Name: findAllMessageByDto 
	 * @Description: TODO(根据条件查询信息)
	 * @Description: * @param messageDto
	 * @Description: * @return List<MessageDto>
	 * @date 2019年4月3日
	 * @author 黄金宝 
	 */
	@SelectProvider(type = messageSqlBuilder.class, method = "findAllMessageByDto")	
	public List<MessageDto> findAllMessageByDto(MessageDto messageDto);
	
	
	/** 
	 * @Method_Name: findAllMessageByReAndSe 
	 * @Description: TODO(条件查询双方信息)
	 * @Description: * @param messageDto
	 * @Description: * @return List<MessageDto>
	 * @date 2019年4月3日
	 * @author 黄金宝 
	 */
	@SelectProvider(type = messageSqlBuilder.class, method = "findAllMessageByReAndSe")	
	public List<MessageDto> findAllMessageByReAndSe(MessageDto messageDto);
	class messageSqlBuilder {
		public String findAllMessageByDto(MessageDto messageDto) {
			return new SQL() {
				{
					SELECT("m.*,u.username as sendUserName,u.image as sendUserImage");
					FROM("HSTB_MESSAGE m");
					LEFT_OUTER_JOIN("MSTB_USER u ON u.usercode=m.send_user_id");
					if(null != messageDto.getReceiveUserId()) {
						WHERE("m.receive_user_id = #{receiveUserId}");
					}
					if(null != messageDto.getSendUserId()) {
						WHERE("m.send_user_id = #{sendUserId}");
					}
					if(null != messageDto.getStatus()) {
						WHERE("m.status= #{status}");
					}
					ORDER_BY("m.create_time  desc, m.id desc");
				}			
				
			}.toString();
		}
		
		public String findAllMessageByReAndSe(MessageDto messageDto) {
			return new SQL() {
				{
					SELECT("m.*,u.username as sendUserName,u.image as sendUserImage");
					FROM("HSTB_MESSAGE m");
					LEFT_OUTER_JOIN("MSTB_USER u ON u.usercode=m.send_user_id");
					if(null != messageDto.getReceiveUserId() &&  null != messageDto.getSendUserId()) {
						WHERE("(m.receive_user_id =#{receiveUserId} And m.send_user_id =#{sendUserId}) OR(m.receive_user_id =#{sendUserId} And m.send_user_id =#{receiveUserId})");
					}
					if(null != messageDto.getStatus()) {
						WHERE("m.status= #{status}");
					}
					ORDER_BY("m.create_time , m.id ");
				}			
				
			}.toString();
		}
	}
}
