package com.herman.ebookstore.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.herman.ebookstore.base.BaseForSDK;
import com.herman.ebookstore.sdk.impl.JsonReqClient;


/**
 * @ClassName: LoginController
 * @Description: TODO()
 * @author 黄金宝
 * @date 2018年12月12日
 *
 */
@Controller
public class LoginController extends BaseForSDK{
	
	JsonReqClient jsonReqClient = new JsonReqClient();
	
	@RequestMapping("toLogin")
	public String toLoginPage() {
		
		//String result = this.jsonReqClient.sendSms(ACCOUNT_SID, AUTH_TOKEN, APPID, TEMPLATEID, "888", "18507043734","");
		//System.out.println("Response content is: " + result);
		System.out.println("1");
		return "login";
	}
	
	@RequestMapping("toHome")
	public String toHomePage(String username,String password,HttpServletResponse response) {
		
		String result = this.jsonReqClient.sendSms(ACCOUNT_SID, AUTH_TOKEN, APPID, TEMPLATEID, "888", "18507043734","");
		System.out.println("Response content is: " + result);
		System.out.println(username+":"+password);
		System.out.println("2");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = null;
        try {
        	writer = response.getWriter();
        	writer.write(result);
            writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            if (writer != null) writer.close();
        }
		return "login";
	}
	

}
