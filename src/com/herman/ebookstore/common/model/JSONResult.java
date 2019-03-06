package com.herman.ebookstore.common.model;

/**
 * 返回json格式的数据
 * @author huanghonggen
 *
 */
public class JSONResult<T> {
    private int code;
    private String message;
    private T data;

    public JSONResult() {   }
    
    public JSONResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T>JSONResult<T> ok() {
        return new JSONResult<T>(200,"success", null);
    }

    public static <T>JSONResult<T> ok(T data) {
        return new JSONResult<T>(200,"success",data);
    }

    public static <T>JSONResult<T> error() {
        return new JSONResult<T>(500,"error", null);
    }
    
    public static <T>JSONResult<T> error(T data) {
        return new JSONResult<T>(500,"error",data);
    }

    public static <T>JSONResult<T> error(int code, String message){
        return new JSONResult<T>(code,message,null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

