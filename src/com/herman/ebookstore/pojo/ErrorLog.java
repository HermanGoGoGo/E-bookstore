package com.herman.ebookstore.pojo;

import javax.persistence.*;

import com.herman.ebookstore.common.model.BaseEntity;

import java.util.Date;

/**
 * 错误信息表
 * 
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-13 16:21:37
 */
@Entity
@Table(name = "MSTB_ERROR_LOG_INFO")
public class ErrorLog extends BaseEntity<ErrorLog> {

	private static final long serialVersionUID = 1L;
	
    //创建用户
    @Column(name = "created_user_id")
    private String createdUserId;
    
    //发生的请求
    @Column(name = "action")
    private String action;
    
    //错误类型
    @Column(name = "type")
    private String type;
    
    //错误代码
    @Column(name = "status")
    private Integer status;
    
    //错误信息
    @Column(name = "content")
    private String content;
    
    //错误月份
    @Column(name = "create_month")
    private String createMonth;
    
    //备注
    @Column(name = "remark")
    private String remark;
    
	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}

	public String getCreatedUserId() {
		return createdUserId;
	}
	
	public void setAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
	
	public void setCreateMonth(String createMonth) {
		this.createMonth = createMonth;
	}

	public String getCreateMonth() {
		return createMonth;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}
	
}
