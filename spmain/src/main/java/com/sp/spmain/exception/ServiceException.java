package com.sp.spmain.exception;

public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 115683640980537310L;

	public ServiceException() {
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable throwable) {
		super(throwable);
	}

	public ServiceException(String message, Throwable throwable) {
		super(message, throwable);
	}

}