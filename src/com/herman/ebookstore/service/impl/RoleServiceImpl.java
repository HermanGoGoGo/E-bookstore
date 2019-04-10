package com.herman.ebookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herman.ebookstore.common.core.AbstractService;
import com.herman.ebookstore.mapper.RoleMapper;
import com.herman.ebookstore.model.RoleDto;
import com.herman.ebookstore.pojo.Role;
import com.herman.ebookstore.service.RoleService;


/**
 * 角色表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-05 11:24:15
 */
@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<RoleDto> selectAll() {
		// TODO Auto-generated method stub
		
		return roleMapper.selectAll1();
	}

	@Override
	public List<Role> getRoleByRoleID(String roleId) {
		// TODO Auto-generated method stub
		return roleMapper.getRoleByRoleID(roleId);
	}

}