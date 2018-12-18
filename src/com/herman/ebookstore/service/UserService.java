package com.herman.ebookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
}
