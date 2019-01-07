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
public class homeController {

	@RequestMapping("toHomepage")
	public String toHomepage(String searchByBookName) {
		return "index";
	}
	
	@RequestMapping("test")
	public void test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 假设这里是跟据id查询商品信息，搜索不到商品
				if (true) {
					throw new MyException("你查找的商品不存在，请确认信息！");
				}

				int i = 1 / 0;

				// response响应用户请求
				// response.sendRedirect("itemList.action");

				// 设置响应的字符编码
				// response.setContentType("text/html;charset=utf-8");
				response.setCharacterEncoding("utf-8");

				PrintWriter printWriter = response.getWriter();

				printWriter.println("这个是response打印的消息");
	}
}
