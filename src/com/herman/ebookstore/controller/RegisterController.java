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
import com.herman.ebookstore.base.BaseForSDK;
import com.herman.ebookstore.pojo.SDKInfo;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.repository.UserRepository;
import com.herman.ebookstore.sdk.impl.JsonReqClient;
import com.herman.ebookstore.service.UserService;
import com.herman.ebookstore.util.IlismJSONEncoder;
import com.herman.ebookstore.util.MD5Util;
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

	@RequestMapping("getVerificationCode")
	public String getVerificationCode(String phonenumber,String usercode, HttpServletResponse response) {
		System.out.println((int)((Math.random()*9+1)*100000)); 
		String getPatam = String.valueOf(new Random().nextInt(899999) + 100000);
		String result = this.jsonReqClient.sendSms(ACCOUNT_SID, AUTH_TOKEN, APPID, TEMPLATEID, getPatam , phonenumber, usercode);
		System.out.println("Response content is: " + result);
		SDKInfo pushMsgContent =  JSON.parseObject(result,SDKInfo.class);
		if(!"".equals(pushMsgContent.getUid()) && pushMsgContent.getUid() != null){
			pushMsgContent.setParam(getPatam);
		}
		param=getPatam;
		System.out.println(pushMsgContent);
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

	@RequestMapping("register")
	public String register(String username, String password, String usercode, String phonenumber, String code,HttpServletResponse response) {	
		User user =new User();
		int index = -1;
		System.out.println(param);
		response.setContentType("text/html;charset=utf-8");
		ReturnJson json = new ReturnJson(true);
		json.setValue(StringUtils.EMPTY);
		PrintWriter writer = null;
		if(usercode !=null && !"".equals(usercode)){
			user.setUsercode(usercode);
			index = this.userService.getUserListWhere(user);
			if(index == 0){
				user.setUsername(username);
				user.setUsercode(usercode);
				user.setPassword(MD5Util.MD5Encode(password,"utf8"));
				user.setPhonenumber(phonenumber);
				user.setRolecode("user");
				index = this.userService.insertNewUser(user);
				if(index ==1){
					json.setValue("1");
				}else{				
					json.setValue("3");
				}
			}else{
				json.setValue("2");
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
