package com.app.exception_handler;

public class CustomException extends Exception {
	private String msg;

	public CustomException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	
	
}
