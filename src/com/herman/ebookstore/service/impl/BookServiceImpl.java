package com.herman.ebookstore.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herman.ebookstore.common.core.AbstractService;
import com.herman.ebookstore.mapper.BookMapper;
import com.herman.ebookstore.model.BookDto;
import com.herman.ebookstore.model.HomeReq;
import com.herman.ebookstore.model.SeachDto;
import com.herman.ebookstore.model.UserDto;
import com.herman.ebookstore.pojo.Book;
import com.herman.ebookstore.service.BookService;
import com.herman.ebookstore.util.RelativeDateFormat;

/**
 * 售书表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-15 10:23:30
 */
@Service
@Transactional
public class BookServiceImpl extends AbstractService<Book> implements BookService {

	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		List<Book> bookList = new ArrayList<Book>();
		List<Book> bookList1 = this.bookMapper.findAllBooks();
		for (Book book : bookList1) {
			book.setPurchaserId(RelativeDateFormat.format(book.getCreateTime()));
			bookList.add(book);
		}
		return bookList;
	}

	@Override
	public List<BookDto> findAllBookList() {
		// TODO Auto-generated method stub
		List<BookDto> bookList = new ArrayList<BookDto>();
		List<BookDto> bookList1 = this.bookMapper.findAllBookList();
		for (BookDto book : bookList1) {
			book.setcreateTimeCompare(RelativeDateFormat.format(book.getCreateTime()));
			bookList.add(book);
		}
		return bookList;
	}

	@Override
	public List<BookDto> selectByBookName(SeachDto seachDto) {
		// TODO Auto-generated method stub
		List<BookDto> bookList = new ArrayList<BookDto>();
		List<BookDto> bookList1 = this.bookMapper.selectByBookName(seachDto);
		for (BookDto book : bookList1) {
			book.setcreateTimeCompare(RelativeDateFormat.format(book.getCreateTime()));
			bookList.add(book);
		}
		return bookList;
	}

	@Override
	public HomeReq selectBookSum(UserDto currentUser) {
		// TODO Auto-generated method stub
		return this.bookMapper.selectBookSum(currentUser);
	}

	@Override
	public List<BookDto> findHotBookList() {
		// TODO Auto-generated method stub
		return this.bookMapper.findHotBookList();
	}

	@Override
	public Integer addHotBrowseTimes(Book book) {
		// TODO Auto-generated method stub
		return this.bookMapper.addHotBrowseTimes(book);
	}

	@Override
	public BookDto findOneBook(Book book) {
		// TODO Auto-generated method stub
		return this.bookMapper.findOneBook(book);
	}

}