package com.sp.spmain.exception;

public class ValidationException extends ApplicationException {


	private static final long serialVersionUID = -1474482757045798966L;

	public ValidationException() {
	}

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidationException(Throwable cause) {
		super(cause);
	}

}
