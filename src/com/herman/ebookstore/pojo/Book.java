package com.herman.ebookstore.pojo;

import javax.persistence.*;
import java.util.Date;
import com.herman.ebookstore.common.model.BaseEntity;

/**
 * 售书表
 * 
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-04-10 15:23:08
 */
@Table(name = "MSTB_SELL_BOOK")
public class Book extends BaseEntity<Book> {

	private static final long serialVersionUID = 1L;
	
    //用户id
    @Column(name = "user_id")
    private String userId;
    
    //书名
    @Column(name = "name")
    private String name;
    
    //作者
    @Column(name = "author")
    private String author;
    
    //原价
    @Column(name = "original_price")
    private Integer originalPrice;
    
    //现价
    @Column(name = "price")
    private Integer price;
    
    //状态，是否销售0：正在销售；1：已售出；2：暂停销售
    @Column(name = "status")
    private String status;
    
    //描述
    @Column(name = "description")
    private String description;
    
    //商品状态：0：全新；1：9.9成新； 2：6成新
    @Column(name = "conditions")
    private String conditions;
    
    //版本
    @Column(name = "edition")
    private String edition;
    
    //学期
    @Column(name = "semester")
    private String semester;
    
    //课程
    @Column(name = "course")
    private String course;
    
    //交易方式：0：校区当面交易；1：邮寄； 2：校区当面交易或者邮寄
    @Column(name = "transaction")
    private String transaction;
    
    //购买人id
    @Column(name = "purchaser_id")
    private String purchaserId;
    
    //书籍浏览次数
    @Column(name = "browse_times")
    private Integer browseTimes;
    
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setOriginalPrice(Integer originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Integer getOriginalPrice() {
		return originalPrice;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getPrice() {
		return price;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getConditions() {
		return conditions;
	}
	
	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getEdition() {
		return edition;
	}
	
	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getSemester() {
		return semester;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}

	public String getCourse() {
		return course;
	}
	
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public String getTransaction() {
		return transaction;
	}
	
	public void setPurchaserId(String purchaserId) {
		this.purchaserId = purchaserId;
	}

	public String getPurchaserId() {
		return purchaserId;
	}
	
	public void setBrowseTimes(Integer browseTimes) {
		this.browseTimes = browseTimes;
	}

	public Integer getBrowseTimes() {
		return browseTimes;
	}
	
}
