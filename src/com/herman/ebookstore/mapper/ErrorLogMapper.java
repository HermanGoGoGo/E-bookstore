package com.herman.ebookstore.mapper;

import com.herman.ebookstore.pojo.ErrorLog;

/**
 * @ClassName: SDKInfoMapper
 * @Description: TODO(错误信息mapper)
 * @author 黄金宝
 * @date 2018年12月30日
 *
 */
public interface ErrorLogMapper {
	/** 
	 * @Method_Name: insertNewErrorlog 
	 * @Description: * @param errorLog
	 * @Description: * @return Integer
	 * @date 2018年12月30日
	 * @author 黄金宝 
	 */
	Integer insertNewErrorLog(ErrorLog errorLog);
	
	/** 
	 * @Method_Name: selectOneErrorLog 
	 * @Description: * @param errorLog
	 * @Description: * @return ErrorLog
	 * @date 2018年12月30日
	 * @author 黄金宝 
	 */
	ErrorLog selectOneErrorLog(ErrorLog errorLog);
}
