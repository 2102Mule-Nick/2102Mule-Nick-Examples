package com.revature.exception;

public class OutOfStockException extends Exception {

	public OutOfStockException() {
		super();
	}

	public OutOfStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OutOfStockException(String message, Throwable cause) {
		super(message, cause);
	}

	public OutOfStockException(String message) {
		super(message);
	}

	public OutOfStockException(Throwable cause) {
		super(cause);
	}
	
}
