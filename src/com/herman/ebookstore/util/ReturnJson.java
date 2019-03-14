package com.herman.ebookstore.util;

import com.herman.ebookstore.common.model.ResultCode;

/**
 * @ClassName: ReturnJson
 * @Description: TODO(json类封装)
 * @author 黄金宝
 * @date 2018年12月18日
 *
 */
public class ReturnJson {

	private int status;
	private String message;
	private String value = null;
	private Object obj = null;
	
	public ReturnJson(boolean judge){
		if(judge){
			this.status = ResultCode.SUCCESS.getCode();
			this.message = ResultCode.SUCCESS.getMessage();
		}else{
			this.status = ResultCode.FAIL.getCode();
			this.message = ResultCode.FAIL.getMessage();
		}
	}
	
	public ReturnJson(int status, String message){
		this.status = status;
		this.message = message;
	}
	
	public ReturnJson(int status, String message, String value){
		this.status = status;
		this.message = message;
		this.value = value;
	}
	
	public void setJudge(boolean judge){
		if(judge){
			this.status = 200;
			this.message = "执行成功";
		}else{
			this.status = 300;
			this.message = "执行失败";
		}
	}
	
	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
