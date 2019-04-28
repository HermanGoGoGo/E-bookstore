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
	
	/** 
	 * @Method_Name: findHotBookList 
	 * @Description: TODO(找到浏览次数最多的10本书)
	 * @Description: * @return List<BookDto>
	 * @date 2019年4月10日
	 * @author 黄金宝 
	 */
	public List<BookDto> findHotBookList();
	
	public List<BookDto> selectByBookName(SeachDto seachDto);
	
	public HomeReq selectBookSum(UserDto currentUser);
	
	/** 
	 * @Method_Name: addHotBrowseTimes 
	 * @Description: TODO(增加书籍热度BrowseTimes )
	 * @Description: * @param book
	 * @Description: * @return Integer
	 * @date 2019年4月12日
	 * @author 黄金宝 
	 */
	public Integer addHotBrowseTimes(Book book);
	
	/** 
	 * @Method_Name: findOneBook 
	 * @Description: TODO(根据bookid查找书籍)
	 * @Description: * @param book
	 * @Description: * @return BookDto
	 * @date 2019年4月16日
	 * @author 黄金宝 
	 */
	public BookDto findOneBook(Book book);
	
	/** 
	 * @Method_Name: findBookBy 
	 * @Description: TODO(根据条件查找书籍)
	 * @Description: * @param bookDto
	 * @Description: * @return List<BookDto>
	 * @date 2019年4月28日
	 * @author 黄金宝 
	 */
	public List<BookDto> findBookBy(BookDto bookDto);
}