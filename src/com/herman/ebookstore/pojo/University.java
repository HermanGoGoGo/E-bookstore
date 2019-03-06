package com.herman.ebookstore.pojo;

import javax.persistence.*;

import com.herman.ebookstore.common.model.BaseEntity;

import java.util.Date;

/**
 * 学校表
 * 
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-05 11:24:15
 */
@Entity
@Table(name = "MSTB_UNIVERSITY")
public class University extends BaseEntity<University> {

	private static final long serialVersionUID = 1L;
	
    //学校ID
    @Column(name = "university_id")
    private String universityId;
    
    //学校名称
    @Column(name = "university")
    private String university;
    
    //校区名称
    @Column(name = "campus")
    private String campus;
    
    //城市
    @Column(name = "city")
    private String city;
    
    //省份
    @Column(name = "province")
    private String province;
    
    //详细地址
    @Column(name = "address")
    private String address;
    
    //是否删除，0：未删除；1：已删除
    @Column(name = "delete_flag")
    private String deleteFlag;
    
	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}

	public String getUniversityId() {
		return universityId;
	}
	
	public void setUniversity(String university) {
		this.university = university;
	}

	public String getUniversity() {
		return university;
	}
	
	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getCampus() {
		return campus;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvince() {
		return province;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
	
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}
	
}
