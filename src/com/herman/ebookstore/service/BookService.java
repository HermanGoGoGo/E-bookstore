package com.herman.ebookstore.service;

import com.herman.ebookstore.pojo.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.herman.ebookstore.common.core.Service;
import com.herman.ebookstore.mapper.BookMapper;
import com.herman.ebookstore.model.BookDto;
import com.herman.ebookstore.model.HomeReq;
import com.herman.ebookstore.model.SeachDto;
import com.herman.ebookstore.model.UserDto;

/**
 * 售书表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-15 10:23:30
 */
public interface BookService extends Service<Book> {

	/** 
	 * @Method_Name: findAllBooks 
	 * @Description: TODO()
	 * @Description: * @return List<Book>
	 * @date 2019年4月1日
	 * @author 黄金宝 
	 */
	public List<Book> findAllBooks();
	
	public List<BookDto> findAllBookList();
	
	public List<BookDto> selectByBookName(SeachDto seachDto);
	
	public HomeReq selectBookSum(UserDto currentUser);
}