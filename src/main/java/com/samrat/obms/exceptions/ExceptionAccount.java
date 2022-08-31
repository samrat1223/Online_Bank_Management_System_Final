package com.samrat.obms.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Method to handle Account related error request and redirecting to error pages
@ControllerAdvice
@Controller
public class ExceptionAccount extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ModelAndView handleSmritica(Exception ex, WebRequest request) {
		ModelAndView modelandview= new ModelAndView("ErrorPage");
		return modelandview;
	}
	
	@ExceptionHandler(AccountNotFound.class)
	public final ModelAndView handleSidhant(Exception ex, WebRequest request) {
		ModelAndView modelandview= new ModelAndView("ErrorPage");
		return modelandview;
	}
}
