package com.herman.ebookstore.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
* @ClassName: ResponseWriter
* @Description: TODO(自定义返回)
* @author 黄金宝
* @date 2019年3月14日
*
*/
public class ResponseWriter {

	/** 
	 * @Method_Name: writerResponseValue 
	 * @Description: TODO(默认传输value)
	 * @Description: * @param status
	 * @Description: * @param value
	 * @Description: * @param response void
	 * @date 2019年3月14日
	 * @author 黄金宝 
	 */
	public void writerResponseValue(Boolean status, String value,HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		ReturnJson json = new ReturnJson(status);
		PrintWriter writer = null;
		if(StringUtils.isEmpty(value)) {
			json.setValue(StringUtils.EMPTY);		
		}else {			
			json.setValue(value);
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
	
	/** 
	 * @Method_Name: writerResponseObject 
	 * @Description: TODO(默认传输object)
	 * @Description: * @param status
	 * @Description: * @param object
	 * @Description: * @param response void
	 * @date 2019年3月14日
	 * @author 黄金宝 
	 */
	public void writerResponseObject(Boolean status, Object object,HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		ReturnJson json = new ReturnJson(status);
		PrintWriter writer = null;
		if(object != null) {
			json.setObj(object);
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
	
	/** 
	 * @Method_Name: writerResponse 
	 * @Description: TODO(自定义返回参数)
	 * @Description: * @param status
	 * @Description: * @param message
	 * @Description: * @param value
	 * @Description: * @param object
	 * @Description: * @param response void
	 * @date 2019年3月14日
	 * @author 黄金宝 
	 */
	public void writerResponse(int status,String message,String value, Object object,HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		ReturnJson json = new ReturnJson(status,message);
		PrintWriter writer = null;
		if(StringUtils.isEmpty(value)) {
			json.setValue(StringUtils.EMPTY);		
		}else {			
			json.setValue(value);
		}
		if(object != null) {
			json.setObj(object);
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
