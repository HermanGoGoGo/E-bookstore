package com.herman.ebookstore.service;

import java.util.List;


import com.herman.ebookstore.pojo.User;

/**
 * @ClassName: UserService
 * @Description: TODO()
 * @author 黄金宝
 * @date 2018年11月19日
 *
 */
public interface UserService {
	/** 
	 * @Method_Name: getUserList 
	 * @Description: * @return List<User>
	 * @date 2018年11月19日
	 * @author 黄金宝 
	 */
	List<User> getUserList();
	
	/** 
	 * @Method_Name: getUserListWhere 
	 * @Description: * @param user
	 * @Description: * @return Integer
	 * @date 2018年12月20日
	 * @author 黄金宝 
	 */
	Integer getUserListWhere(User user);
	
	/** 
	 * @Method_Name: insertNewUser 
	 * @Description: * @param user
	 * @Description: * @return Integer
	 * @date 2018年12月20日
	 * @author 黄金宝 
	 */
	Integer insertNewUser(User user);
	
	/** 
	 * @Method_Name: updatePassword 
	 * @Description: * @param user
	 * @Description: * @return Integer
	 * @date 2018年12月26日
	 * @author 黄金宝 
	 */
	Integer updatePassword(User user);

	/** 
	 * @Method_Name: getUsercodeMobileWhere 
	 * @Description: * @param user
	 * @Description: * @return Integer
	 * @date 2018年12月26日
	 * @author 黄金宝 
	 */
	Integer getUsercodeMobileWhere(User user);
}
