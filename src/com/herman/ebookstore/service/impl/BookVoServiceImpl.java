package com.herman.ebookstore.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herman.ebookstore.mapper.BookVoMapper;
import com.herman.ebookstore.mapper.UserMapper;
import com.herman.ebookstore.pojo.BookVo;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.service.BookVoService;

@Service
public class BookVoServiceImpl implements BookVoService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private BookVoMapper bookVoMapper;
	
	@Override
	public List<BookVo> getBooKVoList(BookVo bookVo) {
		// TODO Auto-generated method stub
		User user = new User();
		List<BookVo> bookVoList = new ArrayList() ;
		List<BookVo> bookVoList1= this.bookVoMapper.getBooKVoList(bookVo);
		for (BookVo bookVo2 : bookVoList1) {
			if(bookVo2.getUserId() !=null && !"".equals(bookVo2.getUserId())) {
				user.setUsercode(bookVo2.getUserId());
				bookVo2.setUser(userMapper.getOneUser(user));
				bookVoList.add(bookVo2);
			}
		}
		return bookVoList;
	}

}
