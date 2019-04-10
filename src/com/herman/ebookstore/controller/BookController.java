package com.herman.ebookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @ClassName: BookController
* @Description: TODO()
* @author 黄金宝
* @date 2019年3月21日
*
*/
@Controller
@RequestMapping("book")
public class BookController {

	@RequestMapping()
	public String showBook() {
		return null;
		
	}
}
