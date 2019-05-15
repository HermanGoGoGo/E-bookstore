package com.herman.ebookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.herman.ebookstore.common.model.BaseForSDK;
import com.herman.ebookstore.common.model.ResultCode;
import com.herman.ebookstore.model.BookDto;
import com.herman.ebookstore.model.MessageDto;
import com.herman.ebookstore.model.UserDto;
import com.herman.ebookstore.pojo.University;
import com.herman.ebookstore.pojo.User;

import com.herman.ebookstore.sdk.impl.JsonReqClient;
import com.herman.ebookstore.service.UniversityService;
import com.herman.ebookstore.service.UserService;
import com.herman.ebookstore.util.IlismJSONEncoder;
import com.herman.ebookstore.util.MD5Util;
import com.herman.ebookstore.util.ResponseWriter;
import com.herman.ebookstore.util.ReturnJson;


/**
* @ClassName: UserController
* @Description: TODO()
* @author 黄金宝
* @date 2019年5月15日
*
*/
@Controller
public class UserController extends BaseForSDK {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UniversityService universityService;

	@RequestMapping("userInfo")
	public String toUserInfo(HttpServletRequest request,Model model) {
		Object usercode = request.getSession().getAttribute("usercode");
		UserDto currentUser = new UserDto();
		if(usercode != null && !"".equals(usercode)) {
			currentUser.setUsercode(usercode.toString());
			currentUser =this.userService.selectMinuteOne(currentUser);

		}else {			
		}
		model.addAttribute("currentUser", currentUser);
		return "pages/userInfo";
	}
	


}
