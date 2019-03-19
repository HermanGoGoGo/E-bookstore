package com.herman.ebookstore.service;

import java.util.List;

import com.herman.ebookstore.common.core.Service;
import com.herman.ebookstore.pojo.University;
import com.herman.ebookstore.pojo.User;

/**
 * 学校表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-05 11:24:15
 */
public interface UniversityService extends Service<University> {
	/** 
	 * @Method_Name: selectAll 
	 * @Description: TODO(查询全部学校信息)
	 * @Description: * @return List<University>
	 * @date 2019年3月19日
	 * @author 黄金宝 
	 */
	public List<University> selectAll();
}