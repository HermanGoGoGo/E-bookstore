package com.herman.ebookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.herman.ebookstore.base.BaseForSDK;
import com.herman.ebookstore.pojo.SDKInfo;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.sdk.impl.JsonReqClient;
import com.herman.ebookstore.service.SDKInfoService;
import com.herman.ebookstore.service.UserService;
import com.herman.ebookstore.util.IlismJSONEncoder;
import com.herman.ebookstore.util.MD5Util;
import com.herman.ebookstore.util.ReturnJson;

/**
 * @ClassName: RegisterController
 * @Description: TODO(忘记密码控制层)
 * @author 黄金宝
 * @date 2018年12月27日
 *
 */
@Controller
@RequestMapping("forget")
public class ForgetController extends BaseForSDK{
	
	JsonReqClient jsonReqClient = new JsonReqClient();

	private String param;
	
	@Autowired
	private UserService userService;
	@Autowired
	private SDKInfoService sdkInfoService;
	
	@RequestMapping("getVerificationCode")
	public String getVerificationCode(String phonenumber,String usercode, HttpServletResponse response) {
		String getPatam = String.valueOf(new Random().nextInt(899999) + 100000);
		String result = this.jsonReqClient.sendSms(ACCOUNT_SID, AUTH_TOKEN, APPID, TEMPLATEID, getPatam , phonenumber, usercode);
		SDKInfo pushMsgContent =  JSON.parseObject(result,SDKInfo.class);
		ReturnJson json = new ReturnJson(true);
		json.setValue(StringUtils.EMPTY);
		if(!"".equals(pushMsgContent.getUid()) && pushMsgContent.getUid() != null){
			pushMsgContent.setParam(getPatam);
			this.sdkInfoService.insertNewSDKInfo(pushMsgContent);
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(result);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
		}
		return null;
	}
	
	@RequestMapping("forget")
	public String forget(String usercode, String phonenumber, String code,String password, HttpServletResponse response) {
		User user =new User();
		SDKInfo sdkInfo = new SDKInfo();
		int index = -1;
		response.setContentType("text/html;charset=utf-8");
		ReturnJson json = new ReturnJson(true);
		json.setValue(StringUtils.EMPTY);
		PrintWriter writer = null;
		if(usercode !=null && !"".equals(usercode)) {
			sdkInfo.setUid(usercode);
			sdkInfo.setMobile(phonenumber);
			sdkInfo=this.sdkInfoService.selectOneSDKInfo(sdkInfo);
			try {
				if(!"".equals(sdkInfo.getSmsid()) && "000000".equals(sdkInfo.getCode()) && code.equals(sdkInfo.getParam())) {
					user.setUsercode(usercode);
					index = this.userService.getUserListWhere(user);
					if(index == 0){
						user.setUsercode(usercode);
						user.setPhonenumber(phonenumber);
						user.setPassword(MD5Util.MD5Encode(password,"utf8"));
						index = this.userService.insertNewUser(user);
						if(index ==1){
							json.setValue("1");
						}
					}else {
						json.setValue("2");
					}
				}else {
					json.setValue("4");
				}
			}catch(Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				json.setValue("3");
			}
			try {
				writer = response.getWriter();
				writer.write(IlismJSONEncoder.encode(json));
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (writer != null)
					writer.close();
			}	
		}	
		return null;
	}
}
