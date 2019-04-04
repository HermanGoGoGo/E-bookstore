package com.herman.ebookstore.controller;

import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.herman.ebookstore.common.model.BaseForSDK;
import com.herman.ebookstore.common.model.ResultCode;
import com.herman.ebookstore.model.MessageDto;
import com.herman.ebookstore.pojo.Sdk;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.sdk.impl.JsonReqClient;
import com.herman.ebookstore.service.SdkService;
import com.herman.ebookstore.service.UserService;
import com.herman.ebookstore.util.ResponseWriter;

/**
* @ClassName: BaseController
* @Description: TODO(通用控制层)
* @author 黄金宝
* @date 2019年3月20日
*
*/
/**
 * @Method_Name: getVerificationCode
 * @Description: TODO(获取验证码)
 * @Description: * @param phonenumber
 * @Description: * @param usercode
 * @Description: * @param response void
 * @date 2019年3月20日
 * @author 黄金宝
 */
@Controller
@RequestMapping("base")
public class BaseController extends BaseForSDK {
	JsonReqClient jsonReqClient = new JsonReqClient();

	@Autowired
	private SdkService sdkService;
	
	@Autowired
	private UserService userService;

	@RequestMapping("getVerificationCode")
	public void getVerificationCode(String phonenumber, String usercode, HttpServletResponse response) {
		User user =new User();
		if(StringUtils.isNotEmpty(usercode)) {			
			user.setUsercode(usercode);
			user =this.userService.selectOne(user);
		}
		if(user != null ) {		
			String getPatam = String.valueOf(new Random().nextInt(899999) + 100000);
			String result = this.jsonReqClient.sendSms(ACCOUNT_SID, AUTH_TOKEN, APPID, TEMPLATEID, getPatam, phonenumber,usercode);
			Sdk pushMsgContent = JSON.parseObject(result, Sdk.class);
			if (!"".equals(pushMsgContent.getUid()) && pushMsgContent.getUid() != null) {
				pushMsgContent.setParam(getPatam);
				this.sdkService.save(pushMsgContent);
				if("000000".equals(pushMsgContent.getCode())) {
					new ResponseWriter().writerResponse(ResultCode.SDK_SUCCESS.getCode(), ResultCode.SDK_SUCCESS.getMessage(), response);
				}else {
					new ResponseWriter().writerResponseObject(false, result, response);
				}
			}else {
				new ResponseWriter().writerResponseObject(false, result, response);
			}
		}else {
			new ResponseWriter().writerResponse(ResultCode.USERCODE_NOTEXIT.getCode(), ResultCode.USERCODE_NOTEXIT.getMessage(), response);
		}
	}
	
	public void getUserMessage(MessageDto messageDto ,HttpServletResponse response) {
		
	}
}
