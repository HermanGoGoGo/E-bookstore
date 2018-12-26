package com.herman.ebookstore.service;

import com.herman.ebookstore.pojo.SDKInfo;

/**
 * @ClassName: SDKInfoService
 * @Description: TODO()
 * @author 黄金宝
 * @date 2018年12月25日
 *
 */
public interface SDKInfoService {
	Integer insertNewSDKInfo(SDKInfo sdkInfo);
	SDKInfo selectOneSDKInfo(SDKInfo sdkInfo);
}
