package com.practice;

/**
 * @author LW
 * @version 1.0
 * @date 2023/2/15 20:42
 */
public class R<T> {
	//接口状态（成功还是失败）
	private Boolean success;
	//错误码
	private String code;
	//提示信息
	private String msg;
	//数据
	private T data;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static <T> R<T> success(T data) {
		return success(data, "操作成功!");
	}
	public static <T> R<T> success() {
		return success("操作成功!");
	}


	public static <T> R<T> success(T data, String msg) {
		R<T> result = new R<>();
		result.setSuccess(Boolean.TRUE);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}

	public static <T> R<T> success(String msg) {
		R<T> result = new R<>();
		result.setSuccess(Boolean.TRUE);
		result.setMsg(msg);
		result.setData(null);
		return result;
	}

	public static <T> R<T> error(String msg) {
		return error(null, msg);
	}

	public static <T> R<T> error(String code, String msg) {
		return error(code, msg, null);
	}

	public static <T> R<T> error(String code, String msg, T data) {
		R<T> result = new R<>();
		result.setSuccess(Boolean.FALSE);
		result.setCode(code);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}
}