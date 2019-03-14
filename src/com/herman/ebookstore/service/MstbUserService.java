package com.herman.ebookstore.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.herman.ebookstore.common.core.Service;
import com.herman.ebookstore.pojo.MstbUser;

import tk.mybatis.mapper.entity.Condition;

/**
 * 用户表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-14 14:40:46
 */
public interface MstbUserService extends Service<MstbUser> {
	
	/** 
	 * @Method_Name: selectByCondition 
	 * @Description: TODO(条件查询返回实体)
	 * @Description: * @param user
	 * @Description: * @return List<MstbUser>
	 * @date 2019年3月14日
	 * @author 黄金宝 
	 */
	public List<MstbUser> selectByCondition(MstbUser user);
	/** 
	 * @Method_Name: selectCountByCondition 
	 * @Description: TODO(条件查询返回条数)
	 * @Description: * @param user
	 * @Description: * @return Integer
	 * @date 2019年3月14日
	 * @author 黄金宝 
	 */
	public Integer selectCountByCondition(MstbUser user);
	/** 
	 * @Method_Name: selectOne 
	 * @Description: TODO(条件查询单个实体)
	 * @Description: * @param user
	 * @Description: * @return MstbUser
	 * @date 2019年3月14日
	 * @author 黄金宝 
	 */
	public MstbUser selectOne(MstbUser user);
	
	/** 
	 * @Method_Name: selectAll 
	 * @Description: TODO(查找全部)
	 * @Description: * @return List<MstbUser>
	 * @date 2019年3月14日
	 * @author 黄金宝 
	 */
	public List<MstbUser> selectAll();

}