package com.herman.ebookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.herman.ebookstore.common.model.BaseForSDK;
import com.herman.ebookstore.common.model.ResultCode;
import com.herman.ebookstore.pojo.MstbUser;
import com.herman.ebookstore.pojo.Sdk;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.repository.UserRepository;
import com.herman.ebookstore.sdk.impl.JsonReqClient;
import com.herman.ebookstore.service.MstbUserService;
import com.herman.ebookstore.service.SdkService;
import com.herman.ebookstore.service.UserService;
import com.herman.ebookstore.util.IlismJSONEncoder;
import com.herman.ebookstore.util.MD5Util;
import com.herman.ebookstore.util.ResponseWriter;
import com.herman.ebookstore.util.ReturnJson;

/**
 * @ClassName: RegisterController
 * @Description: TODO(注册控制层)
 * @author 黄金宝
 * @date 2018年12月19日
 *
 */
@Controller
@RequestMapping("register")
public class RegisterController extends BaseForSDK {

	JsonReqClient jsonReqClient = new JsonReqClient();

	private String param;

	@Autowired
	private MstbUserService userService;
	@Autowired
	private SdkService sdkService;

	@RequestMapping("getVerificationCode")
	public void getVerificationCode(String phonenumber, String usercode, HttpServletResponse response) {
		MstbUser user = new MstbUser();
		if (StringUtils.isNotEmpty(usercode)) {
			user.setUsercode(usercode);
		}
		int index = -1;
		index = this.userService.selectCountByCondition(user);
		if (index == 0) {
			String getPatam = String.valueOf(new Random().nextInt(899999) + 100000);
			String result = this.jsonReqClient.sendSms(ACCOUNT_SID, AUTH_TOKEN, APPID, TEMPLATEID, getPatam,phonenumber, usercode);
			Sdk pushMsgContent = JSON.parseObject(result, Sdk.class);
			pushMsgContent.setParam(getPatam);
			this.sdkService.save(pushMsgContent);
			if(pushMsgContent.getCode()=="000000") {
				new ResponseWriter().writerResponse(true, response);
			}else {
				new ResponseWriter().writerResponse(ResultCode.SDK_SERVER_ERROR.getCode(),ResultCode.SDK_SERVER_ERROR.getMessage(), response);
			}
		} else if (index == 1) {
			new ResponseWriter().writerResponse(ResultCode.SDK_USERCODE_EXIT.getCode(),ResultCode.SDK_USERCODE_EXIT.getMessage(), response);
		} else {
			new ResponseWriter().writerResponse(false, response);
		}
	}

	@RequestMapping("register")
	public void register(String username, String password, String usercode, String phonenumber, String code,HttpServletResponse response) {
		MstbUser user = new MstbUser();
		Sdk sdk = new Sdk();
		int index = -1;
		if (StringUtils.isNotEmpty(usercode)) {
			sdk.setUid(usercode);
			sdk.setMobile(phonenumber);
			sdk = this.sdkService.selectOneSDKInfo(sdk);
			if ("000000".equals(sdk.getCode()) && code.equals(sdk.getParam())) {
				user.setUsercode(usercode);
				index = this.userService.selectCountByCondition(user);
				if (index == 0) {
					user.setUsername(username);
					user.setUsercode(usercode);
					user.setPassword(MD5Util.MD5Encode(password, "utf8"));
					user.setPhonenumber(phonenumber);
					user.setRoleId("1");
					this.userService.save(user);
					new ResponseWriter().writerResponse(true, response);
				} else {
					new ResponseWriter().writerResponse(ResultCode.USERCODE_EXIT.getCode(),ResultCode.USERCODE_EXIT.getMessage(), response);
				}
			} else {
				new ResponseWriter().writerResponse(false, response);
			}
		}
	}

}
