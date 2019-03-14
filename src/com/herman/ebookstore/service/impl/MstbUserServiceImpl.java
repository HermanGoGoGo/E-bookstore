package com.herman.ebookstore.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herman.ebookstore.pojo.MstbUser;
import com.herman.ebookstore.service.MstbUserService;

import tk.mybatis.mapper.entity.Condition;

import com.herman.ebookstore.common.core.AbstractService;
import com.herman.ebookstore.mapper.MstbUserMapper;

/**
 * 用户表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-14 14:40:46
 */
@Service
@Transactional
public class MstbUserServiceImpl extends AbstractService<MstbUser> implements MstbUserService {

	@Autowired
	private MstbUserMapper mstbUserMapper;
	@Override
	public List<MstbUser> selectByCondition(MstbUser user){
		Condition condition = new Condition(MstbUser.class);
		condition.and().andEqualTo("deleteFlag", "0");
		if(StringUtils.isNotEmpty(user.getUsercode())) {
			condition.and().andEqualTo("usercode", user.getUsercode());
		}
		if(StringUtils.isNotEmpty(user.getPassword())) {
			condition.and().andEqualTo("password", user.getPassword());
		}
		if(StringUtils.isNotEmpty(user.getPhonenumber())) {
			condition.and().andEqualTo("phonenumber", user.getPhonenumber());
		}
		return this.mstbUserMapper.selectByCondition(condition);
	}
	@Override
	public Integer selectCountByCondition(MstbUser user){
		Condition condition = new Condition(MstbUser.class);
		condition.and().andEqualTo("deleteFlag", "0");
		if(StringUtils.isNotEmpty(user.getUsercode())) {
			condition.and().andEqualTo("usercode", user.getUsercode());
		}
		if(StringUtils.isNotEmpty(user.getPassword())) {
			condition.and().andEqualTo("password", user.getPassword());
		}
		if(StringUtils.isNotEmpty(user.getPhonenumber())) {
			condition.and().andEqualTo("phonenumber", user.getPhonenumber());
		}
		return this.mstbUserMapper.selectCountByCondition(condition);
	}
	@Override
	public MstbUser selectOne(MstbUser user){
		user.setDeleteFlag("0");
		return this.mstbUserMapper.selectOne(user);
	}

	@Override
	public List<MstbUser> selectAll() {
		return this.mstbUserMapper.findAll();
	}
	
	
	
}