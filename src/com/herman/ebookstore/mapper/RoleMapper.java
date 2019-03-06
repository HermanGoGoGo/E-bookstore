package com.herman.ebookstore.mapper;

import java.util.List;

import com.herman.ebookstore.common.core.Mapper;
import com.herman.ebookstore.pojo.Role;

/**
 * 角色表
 * 
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-05 11:24:15
 */
public interface RoleMapper extends Mapper<Role> {
	List<Role> selectAll();
}
