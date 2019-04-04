package com.herman.ebookstore.pojo;

import javax.persistence.*;
import java.util.Date;
import com.herman.ebookstore.common.model.BaseEntity;

/**
 * 用户表
 * 
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-04-02 17:50:39
 */
@Table(name = "MSTB_USER")
public class User extends BaseEntity<User> {

	private static final long serialVersionUID = 1L;
	
    //用户名
    @Column(name = "username")
    private String username;
    
    //登录账号（10位一卡通账号）
    @Column(name = "usercode")
    private String usercode;
    
    //密码
    @Column(name = "password")
    private String password;
    
    //电话号码
    @Column(name = "phonenumber")
    private String phonenumber;
    
    //头像地址
    @Column(name = "image")
    private String image;
    
    //所属角色
    @Column(name = "role_id")
    private String roleId;
    
    //所属学校
    @Column(name = "campus_id")
    private String campusId;
    
    //第一专业
    @Column(name = "degree")
    private String degree;
    
    //第二专业
    @Column(name = "second_degree")
    private String secondDegree;
    
    //开始学年
    @Column(name = "year_started")
    private String yearStarted;
    
    //结束学年
    @Column(name = "year_end")
    private String yearEnd;
    
    //是否删除，0：未删除；1：已删除
    @Column(name = "delete_flag")
    private String deleteFlag;
    
    //是否激活，0：未激活；1：已激活
    @Column(name = "status")
    private String status;
    
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsercode() {
		return usercode;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPhonenumber() {
		return phonenumber;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}
	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleId() {
		return roleId;
	}
	
	public void setCampusId(String campusId) {
		this.campusId = campusId;
	}

	public String getCampusId() {
		return campusId;
	}
	
	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDegree() {
		return degree;
	}
	
	public void setSecondDegree(String secondDegree) {
		this.secondDegree = secondDegree;
	}

	public String getSecondDegree() {
		return secondDegree;
	}
	
	public void setYearStarted(String yearStarted) {
		this.yearStarted = yearStarted;
	}

	public String getYearStarted() {
		return yearStarted;
	}
	
	public void setYearEnd(String yearEnd) {
		this.yearEnd = yearEnd;
	}

	public String getYearEnd() {
		return yearEnd;
	}
	
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}
