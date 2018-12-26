package com.herman.ebookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herman.ebookstore.mapper.SDKInfoMapper;
import com.herman.ebookstore.pojo.SDKInfo;
import com.herman.ebookstore.service.SDKInfoService;

@Service
public class SDKInfoServiceImpl implements SDKInfoService {

	@Autowired
	private SDKInfoMapper sdkInfoMapper;
	
	@Override
	public Integer insertNewSDKInfo(SDKInfo sdkInfo) {
		// TODO Auto-generated method stub
		return sdkInfoMapper.insertNewSDKInfo(sdkInfo);
	}
	@Override
	public SDKInfo selectOneSDKInfo(SDKInfo sdkInfo) {
		// TODO Auto-generated method stub
		return sdkInfoMapper.selectOneSDKInfo(sdkInfo);
	}

}
