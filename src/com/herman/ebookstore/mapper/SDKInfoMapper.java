package com.herman.ebookstore.mapper;

import com.herman.ebookstore.pojo.SDKInfo;

/**
 * @ClassName: SDKInfoMapper
 * @Description: TODO(验证码信息mapper)
 * @author 黄金宝
 * @date 2018年12月24日
 *
 */
public interface SDKInfoMapper {

	/** 
	 * @Method_Name: insertNewSDKInfo 
	 * @Description: * @param sdkInfo
	 * @Description: * @return Integer
	 * @date 2018年12月24日
	 * @author 黄金宝 
	 */
	Integer insertNewSDKInfo(SDKInfo sdkInfo);
	
	/** 
	 * @Method_Name: selectOneSDKInfo 
	 * @Description: * @param sdkInfo
	 * @Description: * @return SDKInfo
	 * @date 2018年12月26日
	 * @author 黄金宝 
	 */
	SDKInfo selectOneSDKInfo(SDKInfo sdkInfo);
}
