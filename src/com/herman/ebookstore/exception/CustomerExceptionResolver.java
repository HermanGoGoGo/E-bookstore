package com.herman.ebookstore.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
* @ClassName: CustomerExceptionResolver
* @Description: TODO(异常处理)
* @author 黄金宝
* @date 2019年1月4日
*
*/
@ControllerAdvice
public class CustomerExceptionResolver implements HandlerExceptionResolver {

	public static final Logger LOGGER = LogManager.getLogger(CustomerExceptionResolver.class);
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object hanlder,
			Exception ex) {
		
		String result = "系统发生异常了，请联系管理员！";
		//自定义异常处理
		if(ex instanceof MyException){
			result = ((MyException)ex).getMsg();
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", result);
		mav.setViewName("pages/error_maintenance");
		return mav;
	}

}
