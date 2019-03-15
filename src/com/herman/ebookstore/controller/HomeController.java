package com.herman.ebookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.herman.ebookstore.model.BookDto;
import com.herman.ebookstore.model.SeachDto;
import com.herman.ebookstore.pojo.Book;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.service.BookService;
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
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("toHomePage")
	public String toHomepage(String searchByBookName,HttpServletRequest request,Model model) {
		Object usercode = request.getSession().getAttribute("usercode");
		User currentUser =new User();
		if(usercode != null && !"".equals(usercode)) {
			currentUser.setUsercode(usercode.toString());
			currentUser =this.userService.selectOne(currentUser);		
			model.addAttribute("currentUser", currentUser);
		}else {
			currentUser.setUsername("请登录后获取");
			currentUser.setUsercode("管理qq：1146465559");
			model.addAttribute("currentUser", currentUser);
		}
		SeachDto seachDto =new SeachDto();
		seachDto.setBookName(searchByBookName);
		seachDto.setUniversityId(currentUser.getUniversityId());
		List<BookDto> bookList =this.bookService.selectByBookName(seachDto);
		model.addAttribute("bookVoList", bookList);
		return "home";
	}
}
