package com.herman.ebookstore.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.service.UserService;


/**
* @ClassName: homeController
* @Description: TODO()
* @author 黄金宝
* @date 2018年12月28日
*
*/
@Controller
@RequestMapping("home")
public class homeController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("toHomePage")
	public String toHomepage(String searchByBookName,HttpServletRequest request,Model model) {
		Object usercode = request.getSession().getAttribute("usercode");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//秒
		User currentUser =new User();
		if(usercode != null && !"".equals(usercode)) {
			currentUser.setUsercode(usercode.toString());
			currentUser =this.userService.getOneUser(currentUser);
			
			model.addAttribute("currentUser", currentUser);
		}else {
			currentUser.setUsercode("请登录后获取");
		}
		
		return "home";
	}
}
