package com.herman.ebookstore.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herman.ebookstore.pojo.Book;
import com.herman.ebookstore.pojo.HstbSellBook;
import com.herman.ebookstore.service.HstbSellBookService;
import com.herman.ebookstore.common.core.AbstractService;
import com.herman.ebookstore.mapper.BookMapper;
import com.herman.ebookstore.mapper.HstbSellBookMapper;

/**
 * 售书历史表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-04-16 10:55:43
 */
@Service
@Transactional
public class HstbSellBookServiceImpl extends AbstractService<HstbSellBook> implements HstbSellBookService {

	@Autowired
	private HstbSellBookMapper hstbSellBookMapper;
	
	@Autowired
	private BookMapper bookMapper;
	
	//private Book book;
	@Override
	public void passBook(HstbSellBook hstbSellBook) {
		Book book =new Book();
		hstbSellBook.setStatus("1");
		this.hstbSellBookMapper.updateByPrimaryKey(hstbSellBook);
		hstbSellBook = this.hstbSellBookMapper.selectByPrimaryKey(hstbSellBook.getId());
		if(hstbSellBook != null) {
			BeanUtils.copyProperties(hstbSellBook, book);
			/*
			 * book.setCreateTime(null); book.setId(null); book.setUpdateTime(null);
			 */
			book.setStatus("0");
			book.setBrowseTimes(0);
			book.setHstbBookId(hstbSellBook.getId());
			this.bookMapper.insert(book);
		}
	}

}