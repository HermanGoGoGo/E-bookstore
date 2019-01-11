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
	private String bookname;
	@Field
	private String bookAuthor;
	@Field
	private String bookOriginalPrice;
	@Field
	private String bookPrice;
	@Field
	private String status;
	@Field
	private String bookDescription;
	@Field
	private String bookCondition;
	@Field
	private String bookEdition;
	@Field
	private String bookSemester;
	@Field
	private String bookTransaction;
	@Field
	private String purchaserId;
	@Field
	private String updatetime;
	@Field
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", createdtime=" + createdtime + ", userId=" + userId + ", bookname="
				+ bookname + ", bookAuthor=" + bookAuthor + ", bookOriginalPrice=" + bookOriginalPrice + ", bookPrice="
				+ bookPrice + ", status=" + status + ", bookDescription=" + bookDescription + ", bookCondition="
				+ bookCondition + ", bookEdition=" + bookEdition + ", bookSemester=" + bookSemester
				+ ", bookTransaction=" + bookTransaction + ", purchaserId=" + purchaserId + ", updatetime=" + updatetime
				+ ", user=" + user + "]";
	}
}
