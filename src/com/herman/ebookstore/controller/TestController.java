package com.herman.ebookstore.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.herman.ebookstore.common.model.ResultCode;
import com.herman.ebookstore.exception.MyException;
import com.herman.ebookstore.pojo.Role;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.service.RoleService;
import com.herman.ebookstore.util.IlismJSONEncoder;
import com.herman.ebookstore.util.ReturnJson;


@ResponseBody
@Controller
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
}
