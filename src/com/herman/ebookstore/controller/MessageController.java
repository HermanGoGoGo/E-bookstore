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
		//返回前端当前用户信息信息
		UserDto currentUser = new UserDto();
		//返回前端发送信息人的信息
		User sendUser = new User();
		//信息对象，界面属性
		MessageDto messageDto = new MessageDto();
		//返回信息列表
		List<MessageDto> listMessages = new ArrayList<MessageDto>();
		//返回最新提示消息
		List<MessageDto> messageDtos = new ArrayList<MessageDto>();
		//返回发送人列表
		List<MessageDto> listOfAllUser= new ArrayList<MessageDto>();
		int index =-1;
		if(usercode != null && !"".equals(usercode)) {
			messageDto.setReceiveUserId(usercode.toString());
			//根据接收人id查出所有发信息给当前用户的用户信息列表
			listOfAllUser=this.messageService.findAllUserInfo(messageDto);
			currentUser.setUsercode(usercode.toString());
			//根据接收人id查出当前用户信息
			currentUser =this.userService.selectMinuteOne(currentUser);
			//查询当前用户最新消息
			messageDtos = this.messageService.findAllMessageByDto(messageDto);
			if(StringUtils.isEmpty(sendUserId)) {
				//return "redirect:/home/toHomePage.action";
				//设置标题
				messageDto.setMessInfo("个人消息");
				//设置内容
				messageDto.setSendUserName("全部消息");
				listMessages = this.messageService.findAllMessageReceiveUserId(messageDto);
			}else {
				//如果发送人id等于接收人id则返回
				if(sendUserId.equals(usercode)) {
					return "redirect:/message/showOneMessage.action";
				}
				//查询发送用户是否存在
				sendUser.setUsercode(sendUserId);
				index = this.userService.selectCountByCondition(sendUser);
				if(index == 0) {
					//设置标题
					messageDto.setMessInfo("输入的用户不存在");
					//设置内容
					messageDto.setSendUserName("输入的用户不存在");
				}else if (index == 1) {
					//判断前端是否发送信息，发送信息了的话保存信息并重新刷新页面
					if(StringUtils.isNotEmpty(message)) {
						Message messageDto1 = new Message();
						messageDto1.setReceiveUserId(sendUserId);
						messageDto1.setSendUserId(usercode.toString());
						messageDto1.setMessInfo(message);
						this.messageService.save(messageDto1);
						//new ResponseWriter().writerResponse(true, response);
						return "redirect:/message/showOneMessage.action?sendUserId="+ sendUserId;
					}else {
						//没发送信息的话就查询当前用户和发送信息人的所有信息
						messageDto.setSendUserId(sendUserId);
						listMessages= this.messageService.findAllMessageByReAndSe(messageDto);
						//清除信息
						this.messageService.clearStatus(messageDto);	
						//查询发送人信息
						sendUser.setUsercode(sendUserId);
						sendUser = this.userService.selectOne(sendUser);
						messageDto.setSendUserId(sendUserId);
						messageDto.setMessInfo("个人消息");
						messageDto.setReceiveUserId(usercode.toString());
						messageDto.setSendUserName(sendUser.getUsername());
					}
				}		
			}
		}else {
			return "redirect:/home/toHomePage.action";
		}
		model.addAttribute("messageDtos", messageDtos);
		model.addAttribute("listOfAllUser", listOfAllUser);
		model.addAttribute("messageReq", messageDto);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("listMessages", listMessages);
		return "pages/message";
	}
	
	@RequestMapping("findAllUserMessage")
	public void findAllUserMessage(HttpServletRequest request,HttpServletResponse response) {
		Object usercode = request.getSession().getAttribute("usercode");
		MessageDto messageDto = new MessageDto();
		if(usercode != null && !"".equals(usercode)) {
			messageDto.setReceiveUserId(usercode.toString());
			List<MessageDto> listMessages = this.messageService.findAllUserInfo(messageDto);
			new ResponseWriter().writerResponseObject(true, listMessages, response);
		}else {
			new ResponseWriter().writerResponse(false,response);
		}
	}
}
