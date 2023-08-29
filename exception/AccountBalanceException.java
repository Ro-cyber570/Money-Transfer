package com.example.exception;

public class AccountBalanceException extends RuntimeException{

	public AccountBalanceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountBalanceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AccountBalanceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccountBalanceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AccountBalanceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
