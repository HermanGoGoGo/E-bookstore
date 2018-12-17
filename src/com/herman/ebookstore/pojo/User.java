package com.herman.ebookstore.pojo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document
public class User {
	@Id
	private int id;
	@Field
	private String username;
	@Field
	private String usercode;
	@Field
	private String password;
	@Field
	private Date createtime;
	@Field
	private Date updatetime;
	@Field
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", usercode=" + usercode + ", password=" + password
				+ ", createtime=" + createtime + ", updatetime=" + updatetime + ", role=" + role + "]";
	}
	
	

}
