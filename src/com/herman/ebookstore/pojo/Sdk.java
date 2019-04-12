package com.herman.ebookstore.pojo;

import javax.persistence.*;

import com.herman.ebookstore.common.model.BaseEntity;

import java.util.Date;

/**
 * 验证码信息表
 * 
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-13 16:59:24
 */
@Entity
@Table(name = "MSTB_SDKINFO")
public class Sdk extends BaseEntity<Sdk> {

	private static final long serialVersionUID = 1L;
	
    //返回码
    @Column(name = "code")
    private String code;
    
    //返回条数
    @Column(name = "count")
    private Integer count;
    
    //参数
    @Column(name = "param")
    private String param;
    
    //发送电话号码
    @Column(name = "mobile")
    private String mobile;
    
    //返回内容
    @Column(name = "msg")
    private String msg;
    
    //信息id
    @Column(name = "sms_id")
    private String smsId;
    
    //设备id
    @Column(name = "uid")
    private String uid;
    
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}
	
	public void setParam(String param) {
		this.param = param;
	}

	public String getParam() {
		return param;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile() {
		return mobile;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
	
	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}

	public String getSmsId() {
		return smsId;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUid() {
		return uid;
	}
	
}
