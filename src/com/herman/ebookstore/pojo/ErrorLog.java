package com.herman.ebookstore.pojo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document
public class ErrorLog {
	@Id
	private String errorLogId;
	@Field
	private Date createdTime;
	@Field
	private String createdUserId;
	@Field
	private String eventAction;
	@Field
	private String eventType;
	@Field
	private String errorLogContent;
	@Field
	private String errorLogTime;
	@Field
	private String errorLogTimeMonth;
	@Field
	private String remark;
	
	
	public String getErrorLogId() {
		return errorLogId;
	}
	public void setErrorLogId(String errorLogId) {
		this.errorLogId = errorLogId;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getCreatedUserId() {
		return createdUserId;
	}
	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}
	public String getEventAction() {
		return eventAction;
	}
	public void setEventAction(String eventAction) {
		this.eventAction = eventAction;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getErrorLogContent() {
		return errorLogContent;
	}
	public void setErrorLogContent(String errorLogContent) {
		this.errorLogContent = errorLogContent;
	}
	public String getErrorLogTime() {
		return errorLogTime;
	}
	public void setErrorLogTime(String errorLogTime) {
		this.errorLogTime = errorLogTime;
	}
	public String getErrorLogTimeMonth() {
		return errorLogTimeMonth;
	}
	public void setErrorLogTimeMonth(String errorLogTimeMonth) {
		this.errorLogTimeMonth = errorLogTimeMonth;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
