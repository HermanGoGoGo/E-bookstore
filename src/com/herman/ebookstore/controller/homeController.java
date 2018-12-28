package com.herman.ebookstore.controller;

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
public class homeController {

	@RequestMapping("toHomepage")
	public String toHomepage(HttpServletRequest request,String exampleInput1Group2) {
		String url = request.getScheme() + "://" + 
				request.getServerName() + 
				("http".equals(request.getScheme()) && request.getServerPort() == 80 || "https".equals(request.getScheme()) && request.getServerPort() == 443 ? "" : ":" + request.getServerPort()) + 
				request.getRequestURI() + 
				(request.getQueryString() != null ? "?" + request.getQueryString() : ""); 
				
				System.out.println(url);
				System.out.println(exampleInput1Group2);
		return "main/index";
	}
}
