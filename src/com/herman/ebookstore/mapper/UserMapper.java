package com.herman.ebookstore.mapper;

import java.util.List;
import com.herman.ebookstore.pojo.User;

public interface UserMapper {
	
	/** 
	 * @Method_Name: getUserList 
	 * @Description: * @return List<User>
	 * @date 2018年12月20日
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
	 * @date 2018年12月30日
	 * @author 黄金宝 
	 */
	Integer getUsercodeMobileWhere(User user);

}
