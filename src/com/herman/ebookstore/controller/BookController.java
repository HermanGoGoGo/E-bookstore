package com.herman.ebookstore.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.herman.ebookstore.model.MessageDto;
import com.herman.ebookstore.model.UserDto;
import com.herman.ebookstore.pojo.Book;
import com.herman.ebookstore.service.BookService;
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
	
	@Autowired
	private BookService bookService;
	@RequestMapping("bookDetails")
	public String bookDetails(String id,HttpServletRequest request,Model model) {
		Object usercode = request.getSession().getAttribute("usercode");
		UserDto currentUser = new UserDto();
		MessageDto messageDto = new MessageDto();
		Book book = new Book();
		List<MessageDto> messageDtos = new ArrayList<MessageDto>();
		if(usercode != null && !"".equals(usercode)) {
			messageDto.setReceiveUserId(usercode.toString());
			messageDto.setStatus("0");
			currentUser.setUsercode(usercode.toString());
			currentUser =this.userService.selectMinuteOne(currentUser);
			messageDtos = this.messageService.findAllMessageByDto(messageDto);
			if(StringUtils.isNotEmpty(id)) {
				book.setId(id);
				this.bookService.addHotBrowseTimes(book);
				book= this.bookService.findById(id);
			}
		}else {
			
		}
		model.addAttribute("messageDtos", messageDtos);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("bookInfo", book);
		return "pages/bookInfo";		
	}
	
	
	@RequestMapping("saveBook")
	public void saveBook(
						@RequestParam("image")CommonsMultipartFile file,
						@RequestParam("name")String name,
						@RequestParam("author")String author,
						@RequestParam("originalPrice")Integer originalPrice,
						@RequestParam("price")Integer price,
						@RequestParam("description")String description,
						@RequestParam("conditions")String conditions,
						@RequestParam("edition")String edition,
						@RequestParam("semester")String semester,
						@RequestParam("course")String course,
						@RequestParam("transaction")String transaction,
						HttpServletRequest request,
						HttpServletResponse response) {
		try {
			Object usercode = request.getSession().getAttribute("usercode");
			Book bookInfo = new Book();
			
			if(usercode != null && !"".equals(usercode)) {
				//获取上传后原图的相对地址
				String realUploadPath=request.getServletContext().getRealPath("/");	
				//获取上传后原图的相对地址
				String  imagePath = "images/book/";
				//获取唯一id
				String picName = UUID.randomUUID().toString();
				// 获取文件名
				String oriName = file.getOriginalFilename();
				// 获取图片后缀
				String extName = oriName.substring(oriName.lastIndexOf("."));
				if(StringUtils.isNotEmpty(oriName)) {
					//上传文件
					file.transferTo(new File(realUploadPath +imagePath +picName + extName));
					bookInfo.setUserId(usercode.toString());				
					if(StringUtils.isNotEmpty(edition)) {					
						bookInfo.setEdition(edition);
					}
					if(StringUtils.isNotEmpty(course)) {					
						bookInfo.setCourse(course);
					}
					bookInfo.setName(name);
					bookInfo.setAuthor(author);
					bookInfo.setOriginalPrice(originalPrice);
					bookInfo.setPrice(price);
					bookInfo.setConditions(conditions);
					bookInfo.setDescription(description);
					bookInfo.setTransaction(transaction);
					bookInfo.setSemester(semester);
					bookInfo.setStatus("1");
					bookInfo.setImage("/" + imagePath +picName + extName);
					this.bookService.save(bookInfo);
					new ResponseWriter().writerResponse(true, response);
				}
			}else {
				
			}
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			new ResponseWriter().writerResponse(false, response);
			e.printStackTrace();
		}
	}
	
	@RequestMapping("sellBook")
	public String sellBook(HttpServletRequest request,Model model) {
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
		return "pages/sellBook";
		
	}
	
	@RequestMapping("buyBook")
	public String buyBook(String bookId,String userId,HttpServletRequest request,Model model) {
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
		return "pages/buyBook";
		
	}
}
