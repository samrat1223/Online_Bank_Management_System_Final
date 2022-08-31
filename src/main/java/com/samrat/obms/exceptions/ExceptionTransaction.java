package com.samrat.obms.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

//Method to handle Account related error request and redirecting to error pages
@ControllerAdvice
@Controller
public class ExceptionTransaction {
	
	@ExceptionHandler(Exception.class)
	public final ModelAndView handleRohit(Exception ex, WebRequest request) {
		ModelAndView modelandview= new ModelAndView("ErrorPage3");
		return modelandview;
	}
	
	@ExceptionHandler(TransactionNotFound.class)
	public final ModelAndView handleTrisha(Exception ex, WebRequest request) {
		ModelAndView modelandview= new ModelAndView("ErrorPage4");
		return modelandview;
	}
}
