package com.herman.ebookstore.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.herman.springmvc.exception.MyException;

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

	@RequestMapping("toHomepage")
	public String toHomepage(String searchByBookName) {
		return "index";
	}
}
