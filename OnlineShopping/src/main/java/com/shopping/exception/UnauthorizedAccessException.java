package com.shopping.exception;

public class UnauthorizedAccessException extends RuntimeException {

	public UnauthorizedAccessException() {}
	
	public UnauthorizedAccessException(String msg) {
		super(msg);	
	}

}
