package com.herman.ebookstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
* @ClassName: HandlerInterceptorAdapter 
* @Description: TODO(检查是否登录)
* @author 黄金宝
* @date 2019年1月4日
*
*/
public class HandlerInterceptorAdapter  implements HandlerInterceptor {

	//方法执行后被执行
	//处理异常，清资源，记录日志等等
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//方法执行之后，返回ModelAndView之前被执行
	//设置页面的共用参数等等
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//进入方法前被执行
	//登录拦截，权限验证等等
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        return true;
    }
}
