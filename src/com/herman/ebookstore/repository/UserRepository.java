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
	 * @Method_Name: findByUsercode 
	 * @Description: * @param Usercode
	 * @Description: * @return List<User>
	 * @date 2018年11月27日
	 * @author 黄金宝 
	 */
	public User findByUsercode(String Usercode);
	
	

}
