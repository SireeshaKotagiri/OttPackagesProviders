package com.onnet.ott.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public UserNotFoundException() {
	}

	public UserNotFoundException(String msg) {
		super(msg);
		this.message = msg;
	}

}