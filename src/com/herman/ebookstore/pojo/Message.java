package com.herman.ebookstore.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Message {
	@Id
	private String messId;
	@Field
	private String messInfo;
	@Field
	private String receiveCode;
	@Field
	private String sendCode;
	@Field
	private String state;
	@Field
	private String createtime;
	@Field
	private String updatetime;
	public String getMessId() {
		return messId;
	}
	public void setMessId(String messId) {
		this.messId = messId;
	}
	public String getMessInfo() {
		return messInfo;
	}
	public void setMessInfo(String messInfo) {
		this.messInfo = messInfo;
	}
	public String getReceiveCode() {
		return receiveCode;
	}
	public void setReceiveCode(String receiveCode) {
		this.receiveCode = receiveCode;
	}
	public String getSendCode() {
		return sendCode;
	}
	public void setSendCode(String sendCode) {
		this.sendCode = sendCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	@Override
	public String toString() {
		return "Message [messId=" + messId + ", messInfo=" + messInfo + ", receiveCode=" + receiveCode + ", sendCode="
				+ sendCode + ", state=" + state + ", createtime=" + createtime + ", updatetime=" + updatetime + "]";
	}
	
	
}
