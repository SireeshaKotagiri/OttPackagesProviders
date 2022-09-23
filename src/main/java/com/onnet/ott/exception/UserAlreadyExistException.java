package com.onnet.ott.exception;

public class UserAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public UserAlreadyExistException() {
	}

	public UserAlreadyExistException(String msg) {
		super(msg);
		this.message = msg;
	}

}
