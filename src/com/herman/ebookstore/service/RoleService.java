package com.herman.ebookstore.service;

import java.util.List;

import com.herman.ebookstore.common.core.Service;
import com.herman.ebookstore.pojo.Role;

/**
 * 角色表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-05 11:24:15
 */
public interface RoleService extends Service<Role> {
	public List<Role> selectAll();

	public List<Role> getRoleByRoleID(String roleId);
}