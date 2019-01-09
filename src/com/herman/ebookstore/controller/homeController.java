package com.herman.ebookstore.controller;

import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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

	@RequestMapping("toHomePage")
	public String toHomepage(String searchByBookName,HttpServletRequest request) {
		Object usercode = request.getSession().getAttribute("usercode");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//秒
		System.out.println(searchByBookName);
		System.out.println(usercode);
		return "home";
	}
}
