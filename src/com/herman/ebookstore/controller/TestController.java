package com.herman.ebookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.herman.ebookstore.common.model.ResultCode;
import com.herman.ebookstore.exception.MyException;
import com.herman.ebookstore.mapper.RoleMapper;
import com.herman.ebookstore.model.MessageDto;
import com.herman.ebookstore.model.RoleDto;
import com.herman.ebookstore.pojo.Book;
import com.herman.ebookstore.pojo.Message;
import com.herman.ebookstore.pojo.Role;
import com.herman.ebookstore.service.BookService;
import com.herman.ebookstore.service.MessageService;
import com.herman.ebookstore.service.RoleService;
import com.herman.ebookstore.util.IlismJSONEncoder;
import com.herman.ebookstore.util.ResponseWriter;
import com.herman.ebookstore.util.ReturnJson;

@Controller
@RequestMapping("test")
public class TestController {

	@Autowired
	private RoleService roleService;

	@RequestMapping("test1")
	public String test1() {
		return "index1";
	}

	@ResponseBody
	@RequestMapping("test")
	public void test(HttpServletResponse response) {
		ReturnJson result = new ReturnJson(true);
		PrintWriter writer = null;
		response.setContentType("text/html;charset=utf-8");
		try {
			List<Role> roleLists = roleService.findAll();
			result.setStatus(ResultCode.SUCCESS.getCode());
			result.setMessage(ResultCode.SUCCESS.getMessage());
			result.setObj(roleLists);
			writer = response.getWriter();
			writer.write(IlismJSONEncoder.encode(result));
			writer.flush();
			new ResponseEntity<ReturnJson>(result, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setStatus(ResultCode.NETWORK_ERROR.getCode());
			result.setMessage(ResultCode.NETWORK_ERROR.getMessage());
			new ResponseEntity<ReturnJson>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/test2")
	public String test1(Model model, String id) {

		MyException my = new MyException();
		my.setMsg("niaho");
		int i = 1 / 0;
		return null;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/test3")
	public String test2() {
		List<Role> roleLists = roleService.findAll();

		List<RoleDto> roleDtoLists = new ArrayList<RoleDto>();

		if (roleLists != null && roleLists.size() > 0) {
			for (Role dept : roleLists) {
				RoleDto dto = new RoleDto();
				BeanUtils.copyProperties(dept, dto);
				roleDtoLists.add(dto);
				System.out.println(dto.getCreateTime());
			}
		}

		BeanUtils.copyProperties(roleLists, roleDtoLists);

		System.out.println(roleDtoLists);
		return null;

	}

	@Autowired
	private MessageService messageService;

	@RequestMapping(method = RequestMethod.GET, value = "/test4")
	public void test4() {
		Message me = new Message();
		me.setMessInfo("在吗，你那本书还可以卖嘛？");
		me.setReceiveUserId("2201504242");
		me.setSendUserId("2201504239");

		this.messageService.save(me);

		List<Message> meList = this.messageService.findAll();
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/test5")
	public String test5(HttpServletResponse response) {
		List<Message> meList = this.messageService.findAll();		
		//new ResponseWriter().writerResponseObject(true, meList, response);
		new ResponseWriter().writerResponse(ResultCode.NETWORK_ERROR.getCode(), ResultCode.NETWORK_ERROR.getMessage(), null, meList, response);
		return "index1";
	}
	
	
	@Autowired
	private BookService bookService;
	@RequestMapping(method = RequestMethod.GET, value = "/test6")
	public void test6(HttpServletResponse response) {
		
		Book book = new Book();
		book.setUserId("2201504239");
		book.setName("影视鉴赏");
		book.setAuthor("老王");
		book.setOriginalPrice(42);
		book.setPrice(17);
		book.setDescription("大学选修");
		book.setEdition("第四版");
		book.setSemester("2017年第一学期");
		book.setCourse("影视鉴赏");
		
		Book book1 = new Book();
		book1.setUserId("2201504239");
		book1.setName("创造学");
		book1.setAuthor("老三");
		book1.setOriginalPrice(67);
		book1.setPrice(31);
		book1.setDescription("全新创造学必修");
		book1.setEdition("第四版");
		book1.setSemester("2015年第一学期");
		book1.setCourse("大学创造学");
		
		Book book2 = new Book();
		book2.setUserId("2201504001");
		book2.setName("大学语文");
		book2.setAuthor("老啊");
		book2.setOriginalPrice(54);
		book2.setPrice(24);
		book2.setDescription("全新大学语文必修");
		book2.setEdition("第三版");
		book2.setSemester("2016年第一学期");
		book2.setCourse("大学语文");

		Book book3 = new Book();
		book3.setUserId("2201504241");
		book3.setName("线代");
		book3.setAuthor("老王");
		book3.setOriginalPrice(78);
		book3.setPrice(41);
		book3.setDescription("全新线代必修");
		book3.setEdition("第四版");
		book3.setSemester("2015年第一学期");
		book3.setCourse("大学线代");
		List<Book> bookList = new ArrayList<Book>();
		for(int i= 0 ;i<20;i++) {
			try {
				
				Thread.sleep(500);
				this.bookService.save(book1);
				this.bookService.save(book2);
				
				this.bookService.save(book3);
				this.bookService.save(book);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@RequestMapping(method = RequestMethod.GET, value = "/test7")
	public void test7(HttpServletResponse response) {
		MessageDto messageDto =new MessageDto();
		messageDto.setReceiveUserId("2201504242");
		List<MessageDto> messages = this.messageService.findAllMessageByDto(messageDto);
		
	}
	
}
