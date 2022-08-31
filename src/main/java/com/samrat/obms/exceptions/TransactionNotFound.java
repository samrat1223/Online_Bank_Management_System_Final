package com.samrat.obms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Method to handle Account related error request
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TransactionNotFound extends RuntimeException {

	public TransactionNotFound(String message) {
		super(message);
		
	}
	
	
}
