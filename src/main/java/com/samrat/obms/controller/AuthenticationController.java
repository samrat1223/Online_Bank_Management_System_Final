package com.samrat.obms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.samrat.obms.model.User;
import com.samrat.obms.service.UserService;

@Controller
public class AuthenticationController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login"); // resources/template/login.html
		return modelAndView;
	}

	
	
	 @RequestMapping(value = "/register", method = RequestMethod.GET) 
	 public ModelAndView register() { 
		 ModelAndView modelAndView = new ModelAndView(); 
		 User user = new User(); 
		 modelAndView.addObject("user", user);
		 modelAndView.setViewName("register"); // resources/template/register.html
		 return modelAndView; 
		 }
	 
	 
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home"); // resources/template/home.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin"); // resources/template/admin.html
		return modelAndView;
	}
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap){
		ModelAndView modelAndView= new ModelAndView();
		//check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage","Please Correct the errors in form!");
			modelMap.addAttribute("bindingResult",bindingResult);
		}
		//we will save the user if, no binding errors
		else if(userService.isUserAlreadyPresent(user)) {
		//save the user registration form
			modelAndView.addObject("successMessage","user already exists!");
		} 
		//we will save the users if, no binding errors
		else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage","user is registered successfully!");
		}
		modelAndView.addObject("user",new User());
		modelAndView.setViewName("register");
		return modelAndView;
	}
}

