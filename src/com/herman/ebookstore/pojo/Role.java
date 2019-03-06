package com.herman.ebookstore.pojo;

import javax.persistence.*;

import com.herman.ebookstore.common.model.BaseEntity;

import java.util.Date;

/**
 * 角色表
 * 
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-05 11:24:15
 */
@Entity
@Table(name = "MSTB_ROLE")
public class Role extends BaseEntity<Role> {

	private static final long serialVersionUID = 1L;
	
    //角色ID
    @Column(name = "role_id")
    private String roleId;
    
    //角色名称
    @Column(name = "role")
    private String role;
    
    //备注
    @Column(name = "remarks")
    private String remarks;
    
    //状态，是否启用1：启用；0：禁用
    @Column(name = "status")
    private String status;
    
    //是否删除，0：未删除；1：已删除
    @Column(name = "delete_flag")
    private String deleteFlag;
    
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleId() {
		return roleId;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarks() {
		return remarks;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}
	
}
