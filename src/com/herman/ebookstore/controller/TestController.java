package com.herman.ebookstore.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.herman.ebookstore.pojo.Role;
import com.herman.ebookstore.pojo.User;
import com.herman.ebookstore.service.RoleService;
import com.herman.ebookstore.util.IlismJSONEncoder;
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
	@RequestMapping(method = RequestMethod.GET,value="/test2")
	public String test1(Model model,String id ) {
		List<Role> role = roleService.getRoleByRoleID(id);
		ReturnJson result = new ReturnJson(true);
		try {
			
			int i= 1/0;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		if(role.size()==0) {
			result.setStatus(ResultCode.NOT_FOUND.getCode());
			result.setMessage(ResultCode.NOT_FOUND.getMessage());
			model.addAttribute("role", IlismJSONEncoder.encode(result));
			return  null;
		}else {
			
			result.setStatus(ResultCode.SUCCESS.getCode());
			result.setMessage(ResultCode.SUCCESS.getMessage());
			System.out.println(role);
			result.setObj(role);
			model.addAttribute("role", IlismJSONEncoder.encode(result));
			return  "index1";
		}
	}
}
