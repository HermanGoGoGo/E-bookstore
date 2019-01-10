package com.herman.ebookstore.exception;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.herman.ebookstore.pojo.ErrorLog;
import com.herman.ebookstore.service.ErrorLogService;
import com.herman.ebookstore.service.UserService;

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
	
	@Autowired
	private ErrorLogService errorLogService;

	public static final Logger LOGGER = LogManager.getLogger(CustomerExceptionResolver.class);
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object hanlder,
			Exception ex) {
		
		String result = "系统发生异常了，请联系管理员！";
		System.out.println(request.getRequestURI());
		System.out.println(request.getSession().getAttribute("usercode"));
		System.out.println(ex.getClass());
		System.out.println(ex.getMessage());
		
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		ErrorLog errorLog = new ErrorLog();
		errorLog.setCreatedUserId(String.valueOf(request.getSession().getAttribute("usercode")));
		errorLog.setEventAction(request.getRequestURI());
		errorLog.setEventType(String.valueOf(ex.getClass()));
		errorLog.setErrorLogContent(ex.getMessage());
		errorLog.setErrorLogTime(date.toString());
		errorLog.setErrorLogTimeMonth(Integer.toString(month));
		//errorLog.setRemark(remark);
		int index = -1;
		index = this.errorLogService.insertNewErrorLog(errorLog);
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
