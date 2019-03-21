package com.herman.ebookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.herman.ebookstore.common.model.BaseForSDK;
import com.herman.ebookstore.common.model.ResultCode;
import com.herman.ebookstore.model.UserDto;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.pojo.Sdk;

import com.herman.ebookstore.sdk.impl.JsonReqClient;
import com.herman.ebookstore.service.UserService;
import com.herman.ebookstore.service.SdkService;
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
	private UserService userService;
	@Autowired
	private SdkService sdkService;

	@RequestMapping("getVerificationCode")
	public void getVerificationCode(String phonenumber, String usercode, HttpServletResponse response) {
		User user = new User();
		if (StringUtils.isNotEmpty(usercode)) {
			user.setUsercode(usercode);
		}
		int index = -1;
		index = this.userService.selectCountByCondition(user);
		if (index == 0) {
			String getPatam = String.valueOf(new Random().nextInt(899999) + 100000);
			String result = this.jsonReqClient.sendSms(ACCOUNT_SID, AUTH_TOKEN, APPID, TEMPLATEID, getPatam,
					phonenumber, usercode);
			Sdk pushMsgContent = JSON.parseObject(result, Sdk.class);
			pushMsgContent.setParam(getPatam);
			this.sdkService.save(pushMsgContent);
			if (pushMsgContent.getCode() == "000000") {
				new ResponseWriter().writerResponse(true, response);
			} else {
				new ResponseWriter().writerResponse(ResultCode.SDK_SERVER_ERROR.getCode(),
						ResultCode.SDK_SERVER_ERROR.getMessage(), response);
			}
		} else if (index == 1) {
			new ResponseWriter().writerResponse(ResultCode.SDK_USERCODE_EXIT.getCode(),
					ResultCode.SDK_USERCODE_EXIT.getMessage(), response);
		} else {
			new ResponseWriter().writerResponse(false, response);
		}
	}

	@RequestMapping("register")
	public void register(String username, String password, String usercode, String phonenumber, String code,
			HttpServletResponse response) {
		User user = new User();
		Sdk sdk = new Sdk();
		int index = -1;
		if (StringUtils.isNotEmpty(usercode)) {
			sdk.setUid(usercode);
			sdk.setMobile(phonenumber);
			sdk = this.sdkService.selectOneSDKInfo(sdk);
		}
		if ("000000".equals(sdk.getCode())) {
			if (code.equals(sdk.getParam())) {
				// user.setUsercode(usercode);
				user = this.userService.findBy("usercode", usercode);
				// index = this.userService.selectCountByCondition(user);
				if (user == null) {
					new ResponseWriter().writerResponse(ResultCode.USERCODE_NOTEXIT.getCode(),
							ResultCode.USERCODE_NOTEXIT.getMessage(), response);
				} else {
					if ("0".equals(user.getStatus())) {
						user.setUsername(username);
						user.setPassword(MD5Util.MD5Encode(password, "utf8"));
						user.setPhonenumber(phonenumber);
						user.setRoleId("2");
						user.setStatus("1");
						user.setDeleteFlag("0");
						this.userService.update(user);
						new ResponseWriter().writerResponse(true, response);
					} else {
						new ResponseWriter().writerResponse(ResultCode.USERCODE_EXIT.getCode(),
								ResultCode.USERCODE_EXIT.getMessage(), response);
					}
				}
			} else {
				new ResponseWriter().writerResponse(false, response);
			}
		} else if("400".equals(sdk.getCode())){
			new ResponseWriter().writerResponse(ResultCode.SDK_FAIL.getCode(), ResultCode.SDK_FAIL.getMessage(),
					response);
		}else {
			new ResponseWriter().writerResponse(ResultCode.SDK_ERROR.getCode(), ResultCode.SDK_ERROR.getMessage(),
					response);
		}
	}

	@RequestMapping("getUser")
	public void getUser(String usercode, HttpServletResponse response) {
		UserDto userDto = new UserDto();
		if (StringUtils.isNotEmpty(usercode)) {
			userDto.setUsercode(usercode);
			userDto = this.userService.selectMinuteOne(userDto);
			if (userDto != null) {
				if ("0".equals(userDto.getStatus())) {
					new ResponseWriter().writerResponseObject(true, userDto, response);
				} else if ("1".equals(userDto.getStatus())) {
					new ResponseWriter().writerResponse(ResultCode.USERCODE_EXIT.getCode(),
							ResultCode.USERCODE_EXIT.getMessage(), response);
				}
			} else {
				new ResponseWriter().writerResponse(ResultCode.USERCODE_NOTEXIT.getCode(),
						ResultCode.USERCODE_NOTEXIT.getMessage(), response);
			}
		} else {
			new ResponseWriter().writerResponseObject(false, userDto, response);
		}
	}

}
