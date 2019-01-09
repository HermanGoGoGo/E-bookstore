package com.herman.ebookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.herman.ebookstore.base.BaseForSDK;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.repository.UserRepository;
import com.herman.ebookstore.sdk.impl.JsonReqClient;
import com.herman.ebookstore.service.UserService;
import com.herman.ebookstore.util.IlismJSONEncoder;
import com.herman.ebookstore.util.MD5Util;
import com.herman.ebookstore.util.ReturnJson;

/**
 * @ClassName: LoginController
 * @Description: TODO(登录控制层)
 * @author 黄金宝
 * @date 2018年12月12日
 *
 */
@Controller
public class LoginController extends BaseForSDK {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	JsonReqClient jsonReqClient = new JsonReqClient();

	@RequestMapping("toLoginPage")
	public String toLoginPage() {
		return "login";
	}

	@RequestMapping("verificationLogin")
	public void verificationLogin(String username, String password, HttpServletResponse response ,HttpSession session) {
		List<User> userList = this.userService.getUserList();
		response.setContentType("text/html;charset=utf-8");
		ReturnJson json = new ReturnJson(true);
		json.setValue(StringUtils.EMPTY);
		PrintWriter writer = null;
		for (User user : userList) {
			if (user.getUsercode().equals(username)) {
				if (user.getPassword().equals(MD5Util.MD5Encode(password,"utf8"))) {
					this.userRepository.save(user);
					User user2 = this.userRepository.findByUsercode(user.getUsercode());
					Long list= this.userRepository.count();
					System.out.println(user2);
					System.out.println(list);
					session.setAttribute("usercode", username);
					json.setValue("1");
					//json.setObj(user);
					break;
				} else {
					json.setValue("3");
					break;
				}
			} else {
				json.setValue("2");
			}
		}
		try {
			writer = response.getWriter();
			writer.write(IlismJSONEncoder.encode(json));
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
		}
	}

}
