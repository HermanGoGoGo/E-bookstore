package com.herman.ebookstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
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
	
	/** 
	 * @Method_Name: findOneMessage 
	 * @Description: TODO(查询接收人最新信息)
	 * @Description: * @param message
	 * @Description: * @return Message
	 * @date 2019年4月8日
	 * @author 黄金宝 
	 */
	@Select("select * from HSTB_MESSAGE where id=(select MAX(id) from HSTB_MESSAGE where receive_user_id=#{receiveUserId} and status='0')")
	public Message findOneMessage(Message message);
		
	/** 
	 * @Method_Name: clearStatus 
	 * @Description: TODO(清理消息)
	 * @Description: * @param messageDto void
	 * @date 2019年4月8日
	 * @author 黄金宝 
	 */
	@SelectProvider(type = messageSqlBuilder.class, method = "clearStatus")	
	public void clearStatus(MessageDto messageDto);
	
	/** 
	 * @Method_Name: findAllUserInfo 
	 * @Description: TODO(查询所有用户信息)
	 * @Description: * @param messageDto
	 * @Description: * @return List<MessageDto>
	 * @date 2019年4月8日
	 * @author 黄金宝 
	 */
	@Select("SELECT t.*, " + 
			"       u.username AS sendUserName, " + 
			"       u.image AS sendUserImage " + 
			"FROM (SELECT t.*, " + 
			"             CASE " + 
			"               WHEN t.send_user_id = #{receiveUserId} THEN t.receive_user_id " + 
			"               WHEN t.receive_user_id = #{receiveUserId} THEN t.send_user_id " + 
			"             END AS chatUser " + 
			"      FROM (SELECT m.* " + 
			"            FROM HSTB_MESSAGE m " + 
			"            WHERE (m.id IN (SELECT MAX(id) " + 
			"                            FROM HSTB_MESSAGE " + 
			"                            WHERE (receive_user_id = #{receiveUserId} OR send_user_id = #{receiveUserId}) " + 
			"                            GROUP BY receive_user_id, " + 
			"                                     send_user_id))) t " + 
			"      WHERE t.receive_user_id NOT IN ((SELECT t.* " + 
			"                                       FROM (SELECT MAX(receive_user_id) AS receive_user_id " + 
			"                                             FROM HSTB_MESSAGE " + 
			"                                             WHERE (send_user_id = #{receiveUserId}) " + 
			"                                             GROUP BY receive_user_id) t " + 
			"                                       WHERE t.receive_user_id IN (SELECT MAX(send_user_id) AS send_user_id " + 
			"                                                                   FROM HSTB_MESSAGE " + 
			"                                                                   WHERE (receive_user_id = #{receiveUserId}) " + 
			"                                                                   GROUP BY send_user_id)))) t " + 
			"  LEFT OUTER JOIN MSTB_USER u ON u.usercode = t.chatUser " + 
			"  GROUP BY t.id DESC")
	public List<MessageDto> findAllUserInfo(MessageDto messageDto);
	
	@Select("SELECT m.*," + 
			"       u.username AS sendUserName," + 
			"       u.image AS sendUserImage" + 
			" FROM HSTB_MESSAGE m  LEFT JOIN MSTB_USER u ON u.usercode = m.send_user_id " + 
			" WHERE receive_user_id = #{receiveUserId} "+ 
			" ORDER BY m.create_time  desc, m.id desc ")
	public List<MessageDto> findAllMessageReceiveUserId(MessageDto messageDto);
	
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
					WHERE("m.status= '0'");
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
					ORDER_BY("m.create_time desc, m.id desc");
				}			
				
			}.toString();
		}
		
		public String clearStatus(MessageDto messageDto) {
			return new SQL() {
				{
					UPDATE("HSTB_MESSAGE ");
					SET("`status` = '1'");
					if(null != messageDto.getReceiveUserId()) {
					    WHERE("receive_user_id =#{receiveUserId}");
					}
					if(null != messageDto.getSendUserId()) {
						WHERE("send_user_id = #{sendUserId}");
					}
				}
			}.toString();
		}
		
		public String findAllUserInfo(MessageDto messageDto) {
			return new SQL() {
				{
					SELECT("m.*,u.username as sendUserName,u.image as sendUserImage");
					FROM("HSTB_MESSAGE m");
					LEFT_OUTER_JOIN("MSTB_USER u ON u.usercode=m.send_user_id");
					if(null != messageDto.getReceiveUserId()) {
					    WHERE("m.id IN (SELECT MAX(id) " + 
					    		"             FROM HSTB_MESSAGE " + 
					    		"             WHERE receive_user_id = #{receiveUserId} " + 
					    		"             GROUP BY send_user_id) ");
					}
					GROUP_BY(" m.id DESC ");
				}
			}.toString();
		}
	}
}
