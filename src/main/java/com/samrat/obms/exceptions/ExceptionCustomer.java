package com.samrat.obms.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Class to Handle customer related error request and redirecting to error page
@ControllerAdvice
@Controller
public class ExceptionCustomer extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ModelAndView handleSamrat(Exception ex, WebRequest request) {
		ModelAndView modelandview= new ModelAndView("ErrorPage2");
		return modelandview;
	}
	
	@ExceptionHandler(CustomerNotFound.class)
	public final ModelAndView handleMuskan(Exception ex, WebRequest request) {
		ModelAndView modelandview= new ModelAndView("ErrorPage2");
		return modelandview;
	}
}
