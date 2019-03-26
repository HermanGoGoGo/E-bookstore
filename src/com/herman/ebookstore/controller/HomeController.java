package com.herman.ebookstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.herman.ebookstore.model.BookDto;
import com.herman.ebookstore.model.HomeReq;
import com.herman.ebookstore.model.SeachDto;
import com.herman.ebookstore.model.UserDto;
import com.herman.ebookstore.pojo.Book;
import com.herman.ebookstore.pojo.University;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.service.BookService;
import com.herman.ebookstore.service.UniversityService;
import com.herman.ebookstore.service.UserService;

import tk.mybatis.mapper.util.StringUtil;


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
	
	@Autowired
	private UniversityService universityService;
	
	@RequestMapping("toHomePage")
	public String toHomepage(String searchByBookName,String queryScope,HttpServletRequest request,Model model) {
		Object usercode = request.getSession().getAttribute("usercode");
		SeachDto seachDto =new SeachDto();
		seachDto.setBookName(searchByBookName);
		List<BookDto> bookList =new ArrayList<BookDto>();
		UserDto currentUser = new UserDto();
		HomeReq homeReq =new HomeReq();
		String showLoad = "全部书籍";
		if(usercode != null && !"".equals(usercode)) {
			currentUser.setUsercode(usercode.toString());
			currentUser =this.userService.selectMinuteOne(currentUser);
			if("campus".equals(queryScope)) {		
				showLoad=currentUser.getCampus();
				seachDto.setCampusId(currentUser.getCampusId());
			}else if("university".equals(queryScope)){
				showLoad=currentUser.getUniversity();
				seachDto.setUniversityId(currentUser.getUniversityId());
			}
		}else {
			if(StringUtils.isNotEmpty(queryScope)) {
				return "redirect:/page.action?type=login";
			}
			String msg= "请登录后查看";
			currentUser.setUsercode("管理员邮箱：1146465559@qq.com");
			currentUser.setUsername(msg);
			currentUser.setCampus(msg);
			currentUser.setUniversity(msg);
		}
		homeReq = this.bookService.selectBookSum(currentUser);
		homeReq.setShowLoad(showLoad);
		bookList = this.bookService.selectByBookName(seachDto);
		model.addAttribute("bookVoList", bookList);
		model.addAttribute("homeReq", homeReq);
		model.addAttribute("currentUser", currentUser);
		return "home";
	}
}
