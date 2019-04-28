package com.herman.ebookstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.herman.ebookstore.common.model.BaseForSDK;
import com.herman.ebookstore.common.model.ResultCode;
import com.herman.ebookstore.mapper.MessageMapper;
import com.herman.ebookstore.model.BaseDto;
import com.herman.ebookstore.model.MessageDto;
import com.herman.ebookstore.model.UserDto;
import com.herman.ebookstore.pojo.Message;
import com.herman.ebookstore.pojo.Sdk;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.sdk.impl.JsonReqClient;
import com.herman.ebookstore.service.MessageService;
import com.herman.ebookstore.service.SdkService;
import com.herman.ebookstore.service.UserService;
import com.herman.ebookstore.util.ResponseWriter;

/**
* @ClassName: BaseController
* @Description: TODO(通用控制层)
* @author 黄金宝
* @date 2019年3月20日
*
*/
/**
 * @Method_Name: getVerificationCode
 * @Description: TODO(获取验证码)
 * @Description: * @param phonenumber
 * @Description: * @param usercode
 * @Description: * @param response void
 * @date 2019年3月20日
 * @author 黄金宝
 */
@Controller
@RequestMapping("base")
public class BaseController extends BaseForSDK {
	JsonReqClient jsonReqClient = new JsonReqClient();

	@Autowired
	private SdkService sdkService;

	@Autowired
	private UserService userService;

	@Autowired
	private MessageService messageService;

	@RequestMapping("getVerificationCode")
	public void getVerificationCode(String phonenumber, String usercode, HttpServletResponse response) {
		User user = new User();
		if (StringUtils.isNotEmpty(usercode)) {
			user.setUsercode(usercode);
			user = this.userService.selectOne(user);
		}
		if (user != null) {
			String getPatam = String.valueOf(new Random().nextInt(899999) + 100000);
			String result = this.jsonReqClient.sendSms(ACCOUNT_SID, AUTH_TOKEN, APPID, TEMPLATEID, getPatam,
					phonenumber, usercode);
			Sdk pushMsgContent = JSON.parseObject(result, Sdk.class);
			if (!"".equals(pushMsgContent.getUid()) && pushMsgContent.getUid() != null) {
				pushMsgContent.setParam(getPatam);
				this.sdkService.save(pushMsgContent);
				if ("000000".equals(pushMsgContent.getCode())) {
					new ResponseWriter().writerResponse(ResultCode.SDK_SUCCESS.getCode(),
							ResultCode.SDK_SUCCESS.getMessage(), response);
				} else {
					new ResponseWriter().writerResponseObject(false, result, response);
				}
			} else {
				new ResponseWriter().writerResponseObject(false, result, response);
			}
		} else {
			new ResponseWriter().writerResponse(ResultCode.USERCODE_NOTEXIT.getCode(),
					ResultCode.USERCODE_NOTEXIT.getMessage(), response);
		}
	}

	@RequestMapping("getUserMessage")
	public void getUserMessage(String sendUserId,String bookId,  HttpServletResponse response,
			HttpServletRequest request) {

		/*
		 * Object usercode = request.getSession().getAttribute("usercode"); User user =
		 * new User(); Message message = new Message(); MessageDto messageDto = new
		 * MessageDto(); List<MessageDto> listNewMessage = new ArrayList<MessageDto>();
		 * List<MessageDto> listAllMessage = new ArrayList<MessageDto>();
		 * List<MessageDto> listAllBookMessage = new ArrayList<MessageDto>(); BaseDto
		 * baseDto = new BaseDto(); int index = -1; if (usercode != null &&
		 * !"".equals(usercode)) { message.setReceiveUserId(usercode.toString());
		 * user.setUsercode(usercode.toString()); user =
		 * this.userService.selectOne(user); this.userService.update(user); index =
		 * this.messageService.findOneMessage(message); if (index == 1) {
		 * messageDto.setReceiveUserId(usercode.toString()); messageDto.setStatus("0");
		 * listNewMessage = this.messageService.findAllMessageByDto(messageDto);
		 * baseDto.setListNewMessage(listNewMessage); if
		 * (StringUtils.isNotEmpty(sendUserId)) { messageDto.setSendUserId(sendUserId);
		 * if (StringUtils.isNotEmpty(bookId)) { messageDto.setBookId(bookId);
		 * listAllBookMessage =
		 * this.messageService.findBookMessageByReAndSe(messageDto);
		 * baseDto.listAllBookMessage(listAllBookMessage); new
		 * ResponseWriter().writerResponse(ResultCode.BOOK_NEW_MESSAGE.getCode(),
		 * ResultCode.BOOK_NEW_MESSAGE.getMessage(),null, baseDto, response); } else {
		 * listAllMessage = this.messageService.findAllMessageByReAndSe(messageDto);
		 * baseDto.setListAllMessage(listAllMessage); new
		 * ResponseWriter().writerResponse(ResultCode.ALL_NEW_MESSAGE.getCode(),
		 * ResultCode.ALL_NEW_MESSAGE.getMessage(),null, baseDto, response); } //标记已读
		 * this.messageService.clearStatus(messageDto); }else { new
		 * ResponseWriter().writerResponseObject(true, baseDto, response); } } else {
		 * new ResponseWriter().writerResponse(false, response); } } else { new
		 * ResponseWriter().writerResponse(false, response); }
		 */

	}

	@RequestMapping("base")
	public String base(HttpServletRequest request, Model model) {
		Object usercode = request.getSession().getAttribute("usercode");
		UserDto currentUser = new UserDto();
		MessageDto messageDto = new MessageDto();
		List<MessageDto> messageDtos = new ArrayList<MessageDto>();
		if (usercode != null && !"".equals(usercode)) {
			messageDto.setReceiveUserId(usercode.toString());
			messageDto.setStatus("0");
			currentUser.setUsercode(usercode.toString());
			currentUser = this.userService.selectMinuteOne(currentUser);
			messageDtos = this.messageService.findAllMessageByDto(messageDto);
		} else {
			String msg = "请登录后查看";
			currentUser.setUsercode("管理员邮箱：1146465559@qq.com");
			currentUser.setUsername(msg);
			currentUser.setCampus(msg);
			currentUser.setUniversity(msg);
			currentUser.setImage("/images/user2-128x128.jpg");
		}
		model.addAttribute("messageDtos", messageDtos);
		model.addAttribute("currentUser", currentUser);
		return "pages/base";
	}

}
