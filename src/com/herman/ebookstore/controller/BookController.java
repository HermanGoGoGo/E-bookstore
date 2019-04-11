package com.herman.ebookstore.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.herman.ebookstore.model.MessageDto;
import com.herman.ebookstore.model.UserDto;
import com.herman.ebookstore.service.MessageService;
import com.herman.ebookstore.service.SdkService;
import com.herman.ebookstore.service.UserService;
import com.herman.ebookstore.util.ResponseWriter;

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
	
	@Autowired
	private UserService userService;

	@Autowired
	private MessageService messageService;
	@RequestMapping("bookDetails")
	public String bookDetails(String id,HttpServletRequest request,Model model) {
		Object usercode = request.getSession().getAttribute("usercode");
		UserDto currentUser = new UserDto();
		MessageDto messageDto = new MessageDto();
		List<MessageDto> messageDtos = new ArrayList<MessageDto>();
		if(usercode != null && !"".equals(usercode)) {
			messageDto.setReceiveUserId(usercode.toString());
			messageDto.setStatus("0");
			currentUser.setUsercode(usercode.toString());
			currentUser =this.userService.selectMinuteOne(currentUser);
			messageDtos = this.messageService.findAllMessageByDto(messageDto);
		}else {
			
		}
		model.addAttribute("messageDtos", messageDtos);
		model.addAttribute("currentUser", currentUser);
		return "pages/bookInfo";		
	}
	
	
	@RequestMapping("saveBook")
	public void saveBook(@RequestParam("image")CommonsMultipartFile file,HttpServletRequest request,HttpServletResponse response) {
		try {
			//获取上传后原图的相对地址
			String realUploadPath=request.getServletContext().getRealPath("/")+"images/book/";	
			//获取上传后原图的相对地址
			System.out.println(realUploadPath);
			String picName = UUID.randomUUID().toString();
			 
			// 获取文件名
			String oriName = file.getOriginalFilename();
			// 获取图片后缀
			String extName = oriName.substring(oriName.lastIndexOf("."));
		 
			// 开始上传保存到指定位置/www/server/tomcat/webapps/E-bookstore/images
			//file.transferTo(new File("/www/server/tomcat/webapps/E-bookstore/images/" + picName + extName));
			file.transferTo(new File(realUploadPath + picName + extName));
			//new ResponseWriter().writerResponse(true, response);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
