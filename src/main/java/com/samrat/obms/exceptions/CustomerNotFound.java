package com.samrat.obms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Method to handle Customer related error reuqests
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerNotFound extends RuntimeException {

	public CustomerNotFound(String message) {
		super(message);
		
	}

}
