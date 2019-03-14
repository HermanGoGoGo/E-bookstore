package com.herman.ebookstore.service;

import com.herman.ebookstore.common.core.Service;
import com.herman.ebookstore.pojo.Sdk;

/**
 * 验证码信息表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-13 16:59:24
 */
public interface SdkService extends Service<Sdk> {

	public Sdk selectOneSDKInfo(Sdk sdk);
}