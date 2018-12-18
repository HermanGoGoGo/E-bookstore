package com.herman.ebookstore.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.herman.ebookstore.util.IlismJSONEncoder;
import com.herman.ebookstore.base.BaseForSDK;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.repository.UserRepository;
import com.herman.ebookstore.sdk.impl.JsonReqClient;
import com.herman.ebookstore.service.UserService;
import com.herman.ebookstore.util.ReturnJson;


/**
 * @ClassName: LoginController
 * @Description: TODO(登录控制层)
 * @author 黄金宝
 * @date 2018年12月12日
 *
 */
@Controller
public class LoginController extends BaseForSDK{
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	JsonReqClient jsonReqClient = new JsonReqClient();

	@RequestMapping("toLoginPage")
	public String toLoginPage() {
		
		//String result = this.jsonReqClient.sendSms(ACCOUNT_SID, AUTH_TOKEN, APPID, TEMPLATEID, "888", "18507043734","");
		//System.out.println("Response content is: " + result);
		System.out.println("1");
		return "login";
	}
	
	@RequestMapping("toHome")
	public String toHome(String username,String password,HttpServletResponse response) {
		List<User> userList = this.userService.getUserList();
		for (User user : userList) {
			if(user.getUsercode().equals(username) && user.getPassword().equals(password)){
				this.userRepository.save(user);
				User user2=this.userRepository.findById(1);
				System.out.println(user2);
		        response.setContentType("text/html;charset=utf-8");
		        ReturnJson json = new ReturnJson(true);
				json.setValue(StringUtils.EMPTY);
		        PrintWriter writer = null;
		        try {
		        	json.setValue("1");
		        	json.setObj(user);
		        	writer = response.getWriter();
		        	writer.write(IlismJSONEncoder.encode(json));
		            writer.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
		            if (writer != null) writer.close();
		        }
			        return null; 
			}
		}
//		String result = this.jsonReqClient.sendSms(ACCOUNT_SID, AUTH_TOKEN, APPID, TEMPLATEID, "888", "18507043734","");
//		System.out.println("Response content is: " + result);
//		System.out.println(username+":"+password);
//		System.out.println("2");
		return null;
	}
	
	@RequestMapping("toHomePage")
	public String toHomePage(){
		
		return "home";
	}
	
	

}
