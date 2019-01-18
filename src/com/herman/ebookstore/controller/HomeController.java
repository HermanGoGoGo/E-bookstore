package com.herman.ebookstore.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.herman.ebookstore.pojo.BookVo;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.repository.BookVoRepository;
import com.herman.ebookstore.service.BookVoService;
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
	private BookVoService bookVoService;
	@Autowired
	private BookVoRepository bookVoRepository;
	
	@RequestMapping("toHomePage")
	public String toHomepage(String searchByBookName,HttpServletRequest request,Model model) {
		Object usercode = request.getSession().getAttribute("usercode");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String Start =df.format(new Date());
		BookVo bookVo =new BookVo();
		List<BookVo> bookVoList = this.bookVoService.getBooKVoList(bookVo);
		
		//Iterable<BookVo> bookVoList = this.bookVoRepository.findAll();
		//this.bookVoRepository.save(bookVoList);
		String end =df.format(new Date());
		System.out.println(end);
		System.out.println(Start);
		long a=this.bookVoRepository.count();
		bookVo = this.bookVoRepository.findOne("333");
		System.out.println(a);
		System.out.println(bookVo);
		model.addAttribute("bookVoList", bookVoList);
		User currentUser =new User();
		if(usercode != null && !"".equals(usercode)) {
			currentUser.setUsercode(usercode.toString());
			currentUser =this.userService.getOneUser(currentUser);
			
			model.addAttribute("currentUser", currentUser);
		}else {
			currentUser.setUsername("请登录后获取");
			currentUser.setUsercode("管理qq：1146465559");
			model.addAttribute("currentUser", currentUser);
		}
		
		return "home";
	}
}
