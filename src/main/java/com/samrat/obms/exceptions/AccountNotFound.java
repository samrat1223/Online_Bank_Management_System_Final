package com.samrat.obms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Method to handle Account related error reuqest
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountNotFound extends RuntimeException {

	public AccountNotFound(String message) {
		super(message);
		
	}
	

}
