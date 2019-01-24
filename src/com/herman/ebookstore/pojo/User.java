package com.herman.ebookstore.pojo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document
public class User {
	@Field
	private String username;
	@Id
	private String usercode;
	@Field
	private String password;
	@Field
	private String phonenumber;
	@Field
	private Date createtime;
	@Field
	private Date updatetime;
	@Field
	private String rolecode;
	@Field
	private String university;
	@Field
	private String campus;
	@Field
	private String degree;
	@Field
	private String secondDegree;
	@Field
	private String yearStarted;
	@Field
	private String yearEnd;
	@Field
	private String city;
	@Field
	private String province;
	@Field
	private String email;


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
	
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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

	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSecondDegree() {
		return secondDegree;
	}

	public void setSecondDegree(String secondDegree) {
		this.secondDegree = secondDegree;
	}

	public String getYearStarted() {
		return yearStarted;
	}

	public void setYearStarted(String yearStarted) {
		this.yearStarted = yearStarted;
	}

	public String getYearEnd() {
		return yearEnd;
	}

	public void setYearEnd(String yearEnd) {
		this.yearEnd = yearEnd;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", usercode=" + usercode + ", password=" + password + ", createtime="
				+ createtime + ", updatetime=" + updatetime + ", rolecode=" + rolecode + "]";
	}

	

}
