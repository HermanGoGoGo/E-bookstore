package com.herman.ebookstore.pojo;

import javax.persistence.*;

import com.herman.ebookstore.common.model.BaseEntity;

import java.util.Date;

/**
 * 交互信息表
 * 
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-13 16:43:30
 */
@Entity
@Table(name = "HSTB_MESSAGE")
public class Message extends BaseEntity<Message> {

	private static final long serialVersionUID = 1L;
	
    //信息内容
    @Column(name = "mess_info")
    private String messInfo;
    
    //接收用户id
    @Column(name = "receive_user_id")
    private String receiveUserId;
    
    //书籍id
    @Column(name = "book_id")
    private String bookId;
    
    //发送用户id
    @Column(name = "send_user_id")
    private String sendUserId;
    
    //状态，是否已读 1：已读；0：未读
    @Column(name = "status")
    private String status;
    
	public void setMessInfo(String messInfo) {
		this.messInfo = messInfo;
	}

	public String getMessInfo() {
		return messInfo;
	}
	
	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}

	public String getReceiveUserId() {
		return receiveUserId;
	}
	
	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}

	public String getSendUserId() {
		return sendUserId;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	
	
}
