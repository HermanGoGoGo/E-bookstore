package com.herman.ebookstore.repository;

import java.util.List;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.repository.CrudRepository;

import com.herman.ebookstore.pojo.User;


/**
 * @ClassName: UserRepository
 * @Description: TODO()
 * @author 黄金宝
 * @date Nov 23, 2018
 *
 */
public interface UserRepository extends CrudRepository<User, String> {
	
	/** 
	 * @Method_Name: findById 
	 * @Description: 通过id查询用户信息 * @param id
	 * @Description: * @return User
	 * @date Nov 23, 2018
	 * @author 黄金宝 
	 */
	public User findById(int Id);
	
	/** 
	 * @Method_Name: findByUsercode 
	 * @Description: * @param Usercode
	 * @Description: * @return List<User>
	 * @date 2018年11月27日
	 * @author 黄金宝 
	 */
	public List<User> findByUsercode(String Usercode);
	
	

}
