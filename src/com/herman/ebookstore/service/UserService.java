package com.herman.ebookstore.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.herman.ebookstore.common.core.Service;
import com.herman.ebookstore.model.UserDto;
import com.herman.ebookstore.pojo.User;

import tk.mybatis.mapper.entity.Condition;

/**
 * 用户表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-14 14:40:46
 */
public interface UserService extends Service<User> {
	
	/** 
	 * @Method_Name: selectByCondition 
	 * @Description: TODO(条件查询返回实体)
	 * @Description: * @param user
	 * @Description: * @return List<User>
	 * @date 2019年3月14日
	 * @author 黄金宝 
	 */
	public List<User> selectByCondition(User user);
	/** 
	 * @Method_Name: selectCountByCondition 
	 * @Description: TODO(条件查询返回条数)
	 * @Description: * @param user
	 * @Description: * @return Integer
	 * @date 2019年3月14日
	 * @author 黄金宝 
	 */
	public Integer selectCountByCondition(User user);
	/** 
	 * @Method_Name: selectOne 
	 * @Description: TODO(条件查询单个实体)
	 * @Description: * @param user
	 * @Description: * @return User
	 * @date 2019年3月14日
	 * @author 黄金宝 
	 */
	public User selectOne(User user);
	
	/** 
	 * @Method_Name: selectAll 
	 * @Description: TODO(查找全部)
	 * @Description: * @return List<User>
	 * @date 2019年3月14日
	 * @author 黄金宝 
	 */
	public List<User> selectAll();
	
	/** 
	 * @Method_Name: selectMinuteOne 
	 * @Description: TODO(详细查询个人资料)
	 * @Description: * @param userDto
	 * @Description: * @return UserDto
	 * @date 2019年3月19日
	 * @author 黄金宝 
	 */
	public UserDto selectMinuteOne(UserDto userDto);

}