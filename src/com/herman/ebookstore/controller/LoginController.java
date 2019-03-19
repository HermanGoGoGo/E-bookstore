package com.herman.ebookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.herman.ebookstore.common.model.BaseForSDK;
import com.herman.ebookstore.common.model.ResultCode;
import com.herman.ebookstore.pojo.User;

import com.herman.ebookstore.sdk.impl.JsonReqClient;
import com.herman.ebookstore.service.UserService;
import com.herman.ebookstore.util.IlismJSONEncoder;
import com.herman.ebookstore.util.MD5Util;
import com.herman.ebookstore.util.ResponseWriter;
import com.herman.ebookstore.util.ReturnJson;

/**
 * @ClassName: LoginController
 * @Description: TODO(登录控制层)
 * @author 黄金宝
 * @date 2018年12月12日
 *
 */
@Controller
public class LoginController extends BaseForSDK {
	@Autowired
	private UserService userService;

	@RequestMapping("toLoginPage")
	public String toLoginPage(HttpServletRequest request) {
		request.getSession().invalidate();
		return "login";
	}
	
	@RequestMapping("verificationLogin")
	public String verificationLogin(String username, String password, HttpServletResponse response ,HttpSession session) {
		
		List<User> userList = this.userService.findAll();
		for (User user : userList) {
			if (user.getUsercode().equals(username)) {
				if (user.getPassword().equals(MD5Util.MD5Encode(password,"utf8"))) {
					session.setAttribute("usercode", username);
					new ResponseWriter().writerResponse(true,response);
					return null;
				} else {
					new ResponseWriter().writerResponse(ResultCode.PASSWORD_ERROR.getCode(),ResultCode.PASSWORD_ERROR.getMessage(), response);
					return null;
				}
			} 
		}
		new ResponseWriter().writerResponse(false,response);
		return null;
	}
	

}
