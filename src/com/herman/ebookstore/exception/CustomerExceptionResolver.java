package com.herman.ebookstore.exception;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.herman.ebookstore.common.model.ResultCode;
import com.herman.ebookstore.pojo.ErrorLog;
import com.herman.ebookstore.service.ErrorLogService;
import com.herman.ebookstore.util.ResponseWriter;

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
		LOGGER.error(request.getRequestURI());
		LOGGER.error(request.getSession().getAttribute("usercode"));
		LOGGER.error(ex.getMessage());
		LOGGER.error(ex.getClass());
		LOGGER.error(response.getStatus());
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		ErrorLog errorLog = new ErrorLog();
		errorLog.setCreatedUserId(String.valueOf(request.getSession().getAttribute("usercode")));
		errorLog.setStatus(response.getStatus());
		errorLog.setAction(request.getRequestURI());
		errorLog.setType(String.valueOf(ex.getClass()));
		if(ex.getMessage() !=null) {			
			errorLog.setContent(ex.getMessage().substring(0, 100));
		}else {
			errorLog.setContent(ex.getMessage());
		}
		errorLog.setCreateMonth(Integer.toString(month));
		//errorLog.setRemark(remark);
		this.errorLogService.save(errorLog);
		//自定义异常处理
//		if(ex instanceof MyException){
//			result = ((MyException)ex).getMsg();
//		}
		ModelAndView mav = new ModelAndView();
//		mav.addObject("msg", result);
		mav.setViewName("pages/error_maintenance");
		new ResponseWriter().writerResponse(ResultCode.INTERNAL_SERVER_ERROR.getCode(),ResultCode.INTERNAL_SERVER_ERROR.getMessage(), response);
		return mav;
	}

}
