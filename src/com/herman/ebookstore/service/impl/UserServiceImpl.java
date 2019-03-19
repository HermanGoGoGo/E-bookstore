package com.herman.ebookstore.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.service.UserService;

import tk.mybatis.mapper.entity.Condition;

import com.herman.ebookstore.common.core.AbstractService;
import com.herman.ebookstore.mapper.UserMapper;
import com.herman.ebookstore.model.UserDto;

/**
 * 用户表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-14 14:40:46
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {

	@Autowired
	private UserMapper UserMapper;
	@Override
	public List<User> selectByCondition(User user){
		Condition condition = new Condition(User.class);
		condition.and().andEqualTo("deleteFlag", "0");
		condition.and().andEqualTo("status", "1");
		if(StringUtils.isNotEmpty(user.getUsercode())) {
			condition.and().andEqualTo("usercode", user.getUsercode());
		}
		if(StringUtils.isNotEmpty(user.getPassword())) {
			condition.and().andEqualTo("password", user.getPassword());
		}
		if(StringUtils.isNotEmpty(user.getPhonenumber())) {
			condition.and().andEqualTo("phonenumber", user.getPhonenumber());
		}
		return this.UserMapper.selectByCondition(condition);
	}
	@Override
	public Integer selectCountByCondition(User user){
		Condition condition = new Condition(User.class);
		condition.and().andEqualTo("deleteFlag", "0");
		condition.and().andEqualTo("status", "1");
		if(StringUtils.isNotEmpty(user.getUsercode())) {
			condition.and().andEqualTo("usercode", user.getUsercode());
		}
		if(StringUtils.isNotEmpty(user.getPassword())) {
			condition.and().andEqualTo("password", user.getPassword());
		}
		if(StringUtils.isNotEmpty(user.getPhonenumber())) {
			condition.and().andEqualTo("phonenumber", user.getPhonenumber());
		}
		return this.UserMapper.selectCountByCondition(condition);
	}
	@Override
	public User selectOne(User user){
		user.setDeleteFlag("0");
		user.setStatus("1");
		return this.UserMapper.selectOne(user);
	}

	@Override
	public List<User> selectAll() {
		return this.UserMapper.findAll();
	}
	
	@Override
	public UserDto selectMinuteOne(UserDto userDto) {
		// TODO Auto-generated method stub
		return this.UserMapper.selectMinuteOne(userDto);
	}
	
	
	
}