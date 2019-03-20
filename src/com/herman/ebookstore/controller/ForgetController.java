package com.herman.ebookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import tk.mybatis.mapper.entity.Condition;

/**
 * @ClassName: ForgetController
 * @Description: TODO()
 * @author 黄金宝
 * @date 2019年01月09日
 *
 */
@Controller
@RequestMapping("forget")
public class ForgetController extends BaseForSDK {

	JsonReqClient jsonReqClient = new JsonReqClient();

	private String param;

	@Autowired
	private UserService userService;
	@Autowired
	private SdkService sdkService;

	/**
	 * @Title: getVerificationCode @Description: TODO(获取验证码) @param @param
	 * phonenumber @param @param usercode @param @param
	 * response @param @return @return String @throws
	 */

	@RequestMapping("getVerificationCode")
	public void getVerificationCode(String phonenumber, String usercode, HttpServletResponse response) {
		User user = new User();
		if (StringUtils.isNotEmpty(usercode)) {
			user.setUsercode(usercode);
		}
		int index = -1;
		index = this.userService.selectCountByCondition(user);
		if (index == 1) {
			String getPatam = String.valueOf(new Random().nextInt(899999) + 100000);
			String result = this.jsonReqClient.sendSms(ACCOUNT_SID, AUTH_TOKEN, APPID, TEMPLATEID, getPatam, phonenumber, usercode);
			Sdk pushMsgContent = JSON.parseObject(result, Sdk.class);
			if (!"".equals(pushMsgContent.getUid()) && pushMsgContent.getUid() != null) {
				pushMsgContent.setParam(getPatam);
				this.sdkService.save(pushMsgContent);
			}
			new ResponseWriter().writerResponseObject(true, result, response);
		} else {
			new ResponseWriter().writerResponseValue(false, "2", response);
		}

	}

	/**
	 * @Method_Name: forget
	 * @Description: TODO()
	 * @Description: * @param usercode
	 * @Description: * @param phonenumber
	 * @Description: * @param code
	 * @Description: * @param password
	 * @Description: * @param response
	 * @Description: * @return String
	 * @date 9 Jan. 2019
	 * @author Franklin
	 */
	@RequestMapping("forget")
	public void forget(String usercode, String phonenumber, String code, String password, HttpServletResponse response) {
		User user = new User();
		Sdk sdkInfo = new Sdk();
		int index = -1;
		if (usercode != null && !"".equals(usercode)) {
			sdkInfo.setUid(usercode);
			sdkInfo.setMobile(phonenumber);
			sdkInfo = this.sdkService.selectOneSDKInfo(sdkInfo);
			if (code.equals(sdkInfo.getParam())) {
				user.setUsercode(usercode);
				user.setPhonenumber(phonenumber);
				user = this.userService.selectOne(user);
				if (user == null) {
					new ResponseWriter().writerResponse(ResultCode.USERCODE_NOTEXIT.getCode(),ResultCode.USERCODE_NOTEXIT.getMessage(), response);
				} else {
					if("1".equals(user.getStatus())) {
						user.setPassword(MD5Util.MD5Encode(password, "utf8"));
						this.userService.update(user);
						new ResponseWriter().writerResponse(true, response);
					}else {					
						new ResponseWriter().writerResponse(ResultCode.USERCODE_ACTIVATION.getCode(),ResultCode.USERCODE_ACTIVATION.getMessage(), response);
					}
				}
			} else {
				new ResponseWriter().writerResponse(false,response);
			}
		}
	}
	
	@RequestMapping("getUser")
	public void getUser(String usercode, HttpServletResponse response,Model model) {
		UserDto userDto =new UserDto();
		if(StringUtils.isNotEmpty(usercode)) {
			userDto.setUsercode(usercode);
		}
		userDto = this.userService.selectMinuteOne(userDto);
		try {
			if(userDto != null){
				if("0".equals(userDto.getStatus())) {
					new ResponseWriter().writerResponse(ResultCode.USERCODE_ACTIVATION.getCode(),ResultCode.USERCODE_ACTIVATION.getMessage(), response);
				}else if("1".equals(userDto.getStatus())){
					new ResponseWriter().writerResponseObject(true, userDto, response);
				}
			}else {
				new ResponseWriter().writerResponse(ResultCode.USERCODE_NOTEXIT.getCode(),ResultCode.USERCODE_NOTEXIT.getMessage(), response);
			}
		} catch (Exception e) {
			new ResponseWriter().writerResponse(false, response);
			// TODO: handle exception
		}
		model.addAttribute("campus",userDto.getCampus());
	}
}
