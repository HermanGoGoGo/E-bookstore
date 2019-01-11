package com.herman.ebookstore.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
* @ClassName: bookVo
* @Description: TODO(书本vo)
* @author 黄金宝
* @date 2019年1月10日
*
*/
@Document
public class BookVo {

	@Id
	private String bookId;
	@Field
	private String createdtime;
	@Field
	private String userId;
	@Field
	private String bookname;//书名
	@Field
	private String bookAuthor;//作者
	@Field
	private String bookOriginalPrice;//原价
	@Field
	private String bookPrice;//售价
	@Field
	private int status;//出售状态
	@Field
	private String bookDescription;//书描述
	@Field
	private String bookCondition;//书本质量
	@Field
	private String bookEdition;//版本
	@Field
	private String bookSemester;//学期
	@Field
	private String bookCourse;//课程
	@Field
	private String bookTransaction;//交易方式
	@Field
	private String purchaserId;//购买者ID
	@Field
	private String updatetime;//更新时间
	@Field
	private User user;//用户
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getCreatedtime() {
		return createdtime;
	}
	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookOriginalPrice() {
		return bookOriginalPrice;
	}
	public void setBookOriginalPrice(String bookOriginalPrice) {
		this.bookOriginalPrice = bookOriginalPrice;
	}
	public String getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	public String getBookCondition() {
		return bookCondition;
	}
	public void setBookCondition(String bookCondition) {
		this.bookCondition = bookCondition;
	}
	public String getBookEdition() {
		return bookEdition;
	}
	public void setBookEdition(String bookEdition) {
		this.bookEdition = bookEdition;
	}
	public String getBookSemester() {
		return bookSemester;
	}
	public void setBookSemester(String bookSemester) {
		this.bookSemester = bookSemester;
	}
	public String getBookCourse() {
		return bookCourse;
	}
	public void setBookCourse(String bookCourse) {
		this.bookCourse = bookCourse;
	}
	public String getBookTransaction() {
		return bookTransaction;
	}
	public void setBookTransaction(String bookTransaction) {
		this.bookTransaction = bookTransaction;
	}
	public String getPurchaserId() {
		return purchaserId;
	}
	public void setPurchaserId(String purchaserId) {
		this.purchaserId = purchaserId;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", createdtime=" + createdtime + ", userId=" + userId + ", bookname="
				+ bookname + ", bookAuthor=" + bookAuthor + ", bookOriginalPrice=" + bookOriginalPrice + ", bookPrice="
				+ bookPrice + ", status=" + status + ", bookDescription=" + bookDescription + ", bookCondition="
				+ bookCondition + ", bookEdition=" + bookEdition + ", bookSemester=" + bookSemester + ", bookCourse="
				+ bookCourse + ", bookTransaction=" + bookTransaction + ", purchaserId=" + purchaserId + ", updatetime="
				+ updatetime + ", user=" + user + "]";
	}
	
}	