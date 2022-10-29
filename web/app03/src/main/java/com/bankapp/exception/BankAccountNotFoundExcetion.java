package com.bankapp.exception;

public class BankAccountNotFoundExcetion extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public BankAccountNotFoundExcetion(String message) {
		super(message);
	}
}
