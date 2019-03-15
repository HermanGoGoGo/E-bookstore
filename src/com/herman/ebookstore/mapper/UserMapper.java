package com.herman.ebookstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.herman.ebookstore.common.core.Mapper;
import com.herman.ebookstore.pojo.User;

/**
 * 用户表
 * 
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-14 14:40:46
 */
public interface UserMapper extends Mapper<User> {
	@Select("SELECT t.* from MSTB_USER t WHERE delete_flag='0'")
	public List<User> findAll();
}
