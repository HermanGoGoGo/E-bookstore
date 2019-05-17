package com.herman.ebookstore.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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

import com.alibaba.fastjson.JSON;
import com.herman.ebookstore.model.BookDto;
import com.herman.ebookstore.model.MessageDto;
import com.herman.ebookstore.model.UserDto;
import com.herman.ebookstore.pojo.Book;
import com.herman.ebookstore.pojo.HstbSellBook;
import com.herman.ebookstore.pojo.Message;
import com.herman.ebookstore.pojo.Sdk;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.service.BookService;
import com.herman.ebookstore.service.HstbSellBookService;
import com.herman.ebookstore.service.MessageService;
import com.herman.ebookstore.service.SdkService;
import com.herman.ebookstore.service.UserService;
import com.herman.ebookstore.util.RelativeDateFormat;
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
	private HstbSellBookService hstbSellBookService;
	
	@Autowired
	private BookService bookService;
	@RequestMapping("bookDetails")
	public String bookDetails(String id,HttpServletRequest request,Model model) {
		Object usercode = request.getSession().getAttribute("usercode");
		UserDto currentUser = new UserDto();
		MessageDto messageDto = new MessageDto();
		Book book = new Book();
		BookDto bookInfo =new BookDto();
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
				bookInfo= this.bookService.findOneBook(book);
			}
		}else {
			
		}
		model.addAttribute("messageDtos", messageDtos);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("bookInfo", bookInfo);
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
			HstbSellBook bookInfo = new HstbSellBook();
			
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
					//bookInfo.setStatus("1");
					bookInfo.setImage("/" + imagePath +picName + extName);
					this.hstbSellBookService.save(bookInfo);
					//先自动认为通过审核
					this.hstbSellBookService.passBook(bookInfo);
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
	public String buyBook(String bookId,String userId,String messageInfo,HttpServletRequest request,Model model) {
		Object usercode = request.getSession().getAttribute("usercode");
		UserDto currentUser = new UserDto();
		//返回前端发送信息人的信息
		User sendUser = new User();
		//消息实体
		Message message = new Message();
		//消息model
		MessageDto messageDto = new MessageDto();
		//书籍信息model
		BookDto bookDto = new BookDto();
		//书籍实体
		Book book = new Book();
		//最新消息list
		List<MessageDto> messageDtos = new ArrayList<MessageDto>();
		//书籍交易list
		List<MessageDto> listMessageDtos = new ArrayList<MessageDto>();
		//判断用户code是否为空
		if(usercode != null && !"".equals(usercode)) {
			//判断是否是发送信息的请求
			if(StringUtils.isNotEmpty(messageInfo)&& !userId.equals(usercode)) {
				//有发送信息的请求则保存信息，并重定向到本方法体
				Message messageDto1 = new Message();
				messageDto1.setReceiveUserId(userId);
				messageDto1.setSendUserId(usercode.toString());
				messageDto1.setMessInfo(messageInfo);
				messageDto1.setBookId(bookId);
				//保存信息
				this.messageService.save(messageDto1);
				//new ResponseWriter().writerResponse(true, response);
				//重定向
				return "redirect:/book/buyBook.action?userId="+userId +"&bookId="+bookId;
			}	
			messageDto.setReceiveUserId(usercode.toString());
			messageDto.setStatus("0");
			currentUser.setUsercode(usercode.toString());
			//查询当前用户信息
			currentUser =this.userService.selectMinuteOne(currentUser);
			//查询当前用户最新消息
			messageDtos = this.messageService.findAllMessageByDto(messageDto);
			if(StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(bookId)) {
				messageDto.setBookId(bookId);
				messageDto.setSendUserId(userId);
				//查询交易双方交易书籍消息
				listMessageDtos= this.messageService.findBookMessageByReAndSe(messageDto);
				book.setId(bookId);
				//查询书籍信息
				bookDto = this.bookService.findOneBook(book);	
				if(listMessageDtos.size()==0) {
					//如果交易双方没有消息，则自定义第一次消息
					book.setPurchaserId(usercode.toString());
					book.setStatus("3");
					this.bookService.update(book);
					message.setSendUserId(usercode.toString());
					message.setReceiveUserId(userId);
					message.setBookId(bookId);
					message.setMessInfo("请问一下在嘛？");
					 this.messageService.save(message);
					listMessageDtos= this.messageService.findBookMessageByReAndSe(messageDto);
				}
				//将交易信息更新为已读
				this.messageService.clearStatus(messageDto);
				sendUser.setUsercode(userId);
				sendUser = this.userService.selectOne(sendUser);
				//检测交易对方是否在线
				long delta = new Date().getTime() - sendUser.getUpdateTime().getTime();
				if (delta < 5200L) {
					messageDto.setShowTime("在线");
				} else {
					messageDto.setShowTime("离线");
				}
				messageDto.setSendUserName(sendUser.getUsername());
			}else {
				
			}
		}else {
			
		}
		model.addAttribute("messageDtos", messageDtos);
		model.addAttribute("bookDto", bookDto);
		model.addAttribute("messageReq", messageDto);
		model.addAttribute("currentUser", currentUser);	
		model.addAttribute("listMessageDtos", listMessageDtos);	
		return "pages/buyBook";
		
	}
	
	@RequestMapping("selfBook")
	public String selfBook(HttpServletRequest request,Model model) {
		Object usercode = request.getSession().getAttribute("usercode");
		UserDto currentUser = new UserDto();
		MessageDto messageDto = new MessageDto();
		BookDto bookDto =new BookDto();
		List<MessageDto> messageDtos = new ArrayList<MessageDto>();
		//罗列全部书籍
		List<BookDto> oneselfBooks = new ArrayList<BookDto>();
		//罗列正在交易书籍
		List<BookDto> sellBooks = new ArrayList<BookDto>();
		//罗列暂停销售书籍
		List<BookDto> stopBooks = new ArrayList<BookDto>();
		if(usercode != null && !"".equals(usercode)) {
			messageDto.setReceiveUserId(usercode.toString());
			messageDto.setStatus("0");
			currentUser.setUsercode(usercode.toString());
			currentUser =this.userService.selectMinuteOne(currentUser);
			messageDtos = this.messageService.findAllMessageByDto(messageDto);
			bookDto.setUserId(usercode.toString());
			//全部书籍
			oneselfBooks= this.bookService.findBookBy(bookDto);
			//bookDto.setUserId(null);
			//bookDto.setPurchaserId(usercode.toString());
			bookDto.setStatus("3");
			//正在交易书籍
			sellBooks =this.bookService.findBookBy(bookDto);
			bookDto.setStatus("2");
			//暂停销售书籍
			stopBooks =this.bookService.findBookBy(bookDto);	
		}else {			
		}
		model.addAttribute("messageDtos", messageDtos);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("oneselfBooks", oneselfBooks);
		model.addAttribute("sellBooks", sellBooks);
		model.addAttribute("stopBooks", stopBooks);
		return "pages/selfBook";		
	}
	
	
	@RequestMapping("orderBook")
	public String orderBook(HttpServletRequest request,Model model) {
		Object usercode = request.getSession().getAttribute("usercode");
		UserDto currentUser = new UserDto();
		MessageDto messageDto = new MessageDto();
		BookDto bookDto =new BookDto();
		List<MessageDto> messageDtos = new ArrayList<MessageDto>();
		//List<BookDto> oneselfBooks = new ArrayList<BookDto>();
		List<BookDto> sellBooks = new ArrayList<BookDto>();
		List<BookDto> buyBooks = new ArrayList<BookDto>();
		if(usercode != null && !"".equals(usercode)) {
			messageDto.setReceiveUserId(usercode.toString());
			messageDto.setStatus("0");
			currentUser.setUsercode(usercode.toString());
			currentUser =this.userService.selectMinuteOne(currentUser);
			messageDtos = this.messageService.findAllMessageByDto(messageDto);
			bookDto.setPurchaserId(usercode.toString());
			bookDto.setStatus("3");
			sellBooks =this.bookService.findBookBy(bookDto);
			bookDto.setStatus("1");
			buyBooks =this.bookService.findBookBy(bookDto);	
		}else {			
		}
		model.addAttribute("messageDtos", messageDtos);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("sellBooks", sellBooks);
		model.addAttribute("buyBooks", buyBooks);
		return "pages/orderBook";		
	}
	
	
	@RequestMapping("confirmTransaction")
	public void confirmTransaction(String bookId, HttpServletResponse response ,HttpServletRequest request) {
		Object usercode = request.getSession().getAttribute("usercode");
		Book book =new Book();
		Message message =new Message();
		if(usercode != null && !"".equals(usercode)) {
			book =this.bookService.findById(bookId);
			if(book.getStatus().equals("3") ) {
				if(book.getPurchaserId().equals(usercode)) {
					book.setStatus("4");
					this.bookService.update(book);
					message.setBookId(bookId);
					message.setSendUserId(usercode.toString());
					message.setReceiveUserId(book.getUserId());
					message.setMessInfo("买家已确认交易，请您尽快确认交易");
					this.messageService.save(message);
					new ResponseWriter().writerResponse(true, response);
				}else if (book.getUserId().equals(usercode)){
					new ResponseWriter().writerResponse(false, response);
				}
			}else if(book.getStatus().equals("4") && book.getUserId().equals(usercode)) {
				book.setStatus("5");
				this.bookService.update(book);
				message.setBookId(bookId);
				message.setSendUserId(usercode.toString());
				message.setReceiveUserId(book.getPurchaserId());
				message.setMessInfo("卖家已确认交易，交易完成");
				this.messageService.save(message);
				new ResponseWriter().writerResponse(true, response);
			}else {
				new ResponseWriter().writerResponse(false, response);
			}
		}

	}
	
	
	@RequestMapping("cancelTransaction")
	public void cancelTransaction(String bookId, HttpServletResponse response ,HttpServletRequest request) {
		Object usercode = request.getSession().getAttribute("usercode");
		Book book =new Book();
		Message message =new Message();
		if(usercode != null && !"".equals(usercode)) {
			book =this.bookService.findById(bookId);
			if(book.getStatus().equals("3") || book.getStatus().equals("4")) {
				book.setStatus("0");
				book.setPurchaserId("");
				this.bookService.update(book);
				message.setBookId(bookId);
				message.setSendUserId(usercode.toString());
				if(book.getUserId().equals(usercode)) {
					message.setReceiveUserId(book.getPurchaserId());
				}else {
					message.setReceiveUserId(book.getUserId());
				}
				message.setMessInfo("对方已经取消交易");
				this.messageService.save(message);
				new ResponseWriter().writerResponse(true, response);
			}else {
				new ResponseWriter().writerResponse(false, response);
			}
		}

	}
}
