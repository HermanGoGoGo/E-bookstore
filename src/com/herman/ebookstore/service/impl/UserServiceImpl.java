package com.herman.ebookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herman.ebookstore.mapper.UserMapper;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getUserList() {
		return this.userMapper.getUserList();
	}

	@Override
	public Integer getUserListWhere(User user) {
		// TODO Auto-generated method stub
		return this.userMapper.getUserListWhere(user);
	}

	@Override
	public Integer insertNewUser(User user) {
		
		return this.userMapper.insertNewUser(user);
	}

	@Override
	public Integer updatePassword(User user) {
		// TODO Auto-generated method stub
		return this.userMapper.updatePassword(user);
	}

	@Override
	public User getOneUser(User user) {
		// TODO Auto-generated method stub
		return this.userMapper.getOneUser(user);
	}

	@Override
	public Integer getUsercodeMobileWhere(User user) {
		// TODO Auto-generated method stub
		return this.userMapper.getUsercodeMobileWhere(user);
	}

}
