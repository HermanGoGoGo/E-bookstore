package com.herman.ebookstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.herman.ebookstore.model.BookDto;
import com.herman.ebookstore.model.HomeReq;
import com.herman.ebookstore.model.MessageDto;
import com.herman.ebookstore.model.SeachDto;
import com.herman.ebookstore.model.UserDto;
import com.herman.ebookstore.pojo.Message;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.service.MessageService;
import com.herman.ebookstore.service.UserService;
import com.herman.ebookstore.util.ResponseWriter;

/**
* @ClassName: MessageController
* @Description: TODO(查询信息)
* @author 黄金宝
* @date 2019年4月4日
*
*/
@Controller
@RequestMapping("message")
public class MessageController {

	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	@RequestMapping("showOneMessage")
	public String showOneMessage(String message,String sendUserId,HttpServletRequest request,Model model,HttpServletResponse response) {
		Object usercode = request.getSession().getAttribute("usercode");
		UserDto currentUser = new UserDto();
		User sendUser = new User();
		MessageDto messageDto = new MessageDto();
		List<MessageDto> listMessages = new ArrayList<MessageDto>();
		if(usercode != null && !"".equals(usercode)) {
			if(StringUtils.isEmpty(sendUserId)) {
				return "redirect:/home/toHomePage.action";
			}else {
				sendUser.setUsercode(sendUserId);
				sendUser = this.userService.selectOne(sendUser);
				if(StringUtils.isNotEmpty(message)) {
					Message messageDto1 = new Message();
					messageDto1.setReceiveUserId(sendUserId);
					messageDto1.setSendUserId(usercode.toString());
					messageDto1.setMessInfo(message);
					this.messageService.save(messageDto1);
					//new ResponseWriter().writerResponse(true, response);
				}
				messageDto.setReceiveUserId(usercode.toString());
				messageDto.setSendUserId(sendUserId);
				listMessages= this.messageService.findAllMessageByReAndSe(messageDto);
			}
			messageDto=new MessageDto();
			messageDto.setReceiveUserId(usercode.toString());
			messageDto.setStatus("0");
			currentUser.setUsercode(usercode.toString());
			currentUser =this.userService.selectMinuteOne(currentUser);
			List<MessageDto> messageDtos = this.messageService.findAllMessageByDto(messageDto);
			model.addAttribute("messageDtos", messageDtos);
		}
		messageDto.setSendUserId(sendUserId);
		messageDto.setMessInfo("个人信息");
		messageDto.setReceiveUserId(usercode.toString());
		messageDto.setSendUserName(sendUser.getUsername());
		model.addAttribute("messageReq", messageDto);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("listMessages", listMessages);
		return "pages/message";
	}
}
