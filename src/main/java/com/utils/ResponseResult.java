package com.utils;


import com.google.gson.Gson;

public class ResponseResult {
	// 定义gson对象
	private static Gson GSON = new Gson();
	// 响应业务状态
	private Integer status;
	// 响应消息
	private String msg;
	// 响应中的数据
	private Object data;

	public static String build(Integer status, String msg, Object data) {
		return GSON.toJson(new ResponseResult(status, msg, data));
	}

	public static String  ok(Object data) {
		return GSON.toJson(new ResponseResult(data));
	}

	public static String ok() {
		return GSON.toJson(new ResponseResult(null));
	}

	public ResponseResult() {

	}

	public static String build(Integer status, String msg) {
		return GSON.toJson(new ResponseResult(status, msg, null));
	}

	public ResponseResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public ResponseResult(Object data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
	/**
	 * 没有object对象的转化
	 * 
	 * @param json
	 * @return
	 */
	public static String format(String json) {
		try {
			return GSON.toJson(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
