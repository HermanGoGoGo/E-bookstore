package com.herman.ebookstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
	@Select("select * from MSTB_ROLE")
	public List<Role> selectAll();
	
	@Select("select * from MSTB_ROLE where role_id=#{roleId}")
	public List<Role> getRoleByRoleID(@Param(value = "roleId") String roleId);
}
