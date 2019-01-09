package com.herman.ebookstore.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.herman.ebookstore.exception.MyException;



@Controller
public class TestController {
	@RequestMapping("test")
	public void test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 假设这里是跟据id查询商品信息，搜索不到商品

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
