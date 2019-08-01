package com.skbaek.board.entity;

import java.util.Map;

public class ResponseVO<T> {
	
	private String result;
	private String reason;
	private String if_name;
	private T data;
	
	public ResponseVO<T> setResult(T data, Map<String, String> map){
		this.result = map.get("result");
		this.data = data;
		this.if_name = "";  
		
		return this;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getIf_name() {
		return if_name;
	}
	public void setIf_name(String if_name) {
		this.if_name = if_name;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	

}
