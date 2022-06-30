package com.sp.spmain.exception;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = -1881053009529943834L;

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException() {
	}
}
