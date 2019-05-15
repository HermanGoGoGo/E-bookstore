package com.herman.ebookstore.common.model;


/**
* @ClassName: ResultCode
* @Description: TODO(响应码枚举)
* @author 黄金宝
* @date 2019年3月14日
*
*/
public enum ResultCode {
    SUCCESS(200,"成功"),//成功
    FAIL(400,"失败"),//失败
    UNAUTHORIZED(401,"未认证"),//未认证（签名错误）
    INTERNAL_SERVER_ERROR(500,"服务器异常"),
    PARAMS_NOT_NULL(7001,"参数不能为空"),
    
	NOT_FOUND(404,"查询无此记录"),

	PASSWORD_ERROR(445,"密码错误"),

	SAME_PASSWORD(446,"新密码不能与原密码一样！"),

	MULTI_ACCOUNT_RECORD(1001,"同一账号有多条记录"),

	/**
	 * 参数错误
	 */
	PARAMETER_ERROR(9998,"参数错误"),
	SDK_ERROR(10001,"验证码获取错误"),
	SDK_FAIL(10008,"验证码已失效"),
	SDK_USERCODE_EXIT(10002,"验证发送失败，该账号已存在"),
	SDK_SERVER_ERROR(10004,"验证码获取异常"),
	SDK_SUCCESS(10006,"验证码发送成功"),
	USERCODE_EXIT(10003,"该一卡通账号已被注册，请重新输入或者直接登录"),
	USERCODE_NOTEXIT(10005,"该一卡通账号在教务系统中不存在"),
	USERCODE_ACTIVATION(10007,"该一卡通账号未注册请先注册"),

	/**
	 * 服务器繁忙
	 */
	NETWORK_ERROR(9999,"服务器繁忙"),
	/**
	 * buyBook
	 */
	ALL_NEW_MESSAGE(20001,"有新的人交易书信息"),
	BOOK_NEW_MESSAGE(20002,"有新的人交易书信息");
	private final int code;

    private final String message;

	ResultCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
