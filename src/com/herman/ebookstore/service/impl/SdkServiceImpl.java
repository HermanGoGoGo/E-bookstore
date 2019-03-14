package com.herman.ebookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herman.ebookstore.common.core.AbstractService;
import com.herman.ebookstore.mapper.SdkMapper;
import com.herman.ebookstore.pojo.Sdk;
import com.herman.ebookstore.service.SdkService;



/**
 * 验证码信息表
 *
 * @author herman
 * @email 1146465559@qq.com
 * @date 2019-03-13 16:59:24
 */
@Service
@Transactional
public class SdkServiceImpl extends AbstractService<Sdk> implements SdkService {

	@Autowired
	private SdkMapper sdkMapper;
	
	@Override
	public Sdk selectOneSDKInfo(Sdk sdk) {
		// TODO Auto-generated method stub
		return this.sdkMapper.selectOneSDKInfo(sdk);
	}

}