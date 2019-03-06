package com.herman.ebookstore.common.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import com.herman.ebookstore.util.SnowflakeIdWorker;


public abstract class BaseEntity<T>  implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Id
    private String id;
    
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;
    
	/**
	 * 插入之前执行方法，需要手动调用
	 */
	public void preInsert(){
		Date date = new Date();
		setCreateTime(date);
		setUpdateTime(date);
		setId(SnowflakeIdWorker.getSnowflakeIdWorker().nextId() + "");
	}
	
	/**
	 * 更新之前执行方法，需要手动调用
	 */
	public void preUpdate(){
		this.updateTime = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}      
    
    
}
