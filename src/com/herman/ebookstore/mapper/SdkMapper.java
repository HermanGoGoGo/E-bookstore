package com.herman.ebookstore.mapper;

import org.apache.ibatis.annotations.Select;

import com.herman.ebookstore.common.core.Mapper;
import com.herman.ebookstore.pojo.Sdk;

/**
 * 验证码信息表
 * 
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-13 16:59:24
 */
public interface SdkMapper extends Mapper<Sdk> {
	
	@Select("select * "
			+ " from MSTB_SDKINFO"
			+ " where id=(select MAX(id) from MSTB_SDKINFO where uid= #{uid} and mobile=#{mobile}  )")
	public Sdk selectOneSDKInfo(Sdk sdk);
}
