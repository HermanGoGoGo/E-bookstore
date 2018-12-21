package com.herman.ebookstore.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class SDKInfo {
	@Id
	private String id;
	@Field
	private String code;
	@Field
	private String count;
	@Field
	private String param;
	@Field
	private String create_date;
	@Field
	private String mobile;
	@Field
	private String msg;
	@Field
	private String smsid;
	@Field
	private String uid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSmsid() {
		return smsid;
	}

	public void setSmsid(String smsid) {
		this.smsid = smsid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "SDKInfo [code=" + code + ", count=" + count + ", create_date=" + create_date + ", mobile=" + mobile
				+ ", msg=" + msg + ", smsid=" + smsid + ", uid=" + uid + "]";
	}

}
