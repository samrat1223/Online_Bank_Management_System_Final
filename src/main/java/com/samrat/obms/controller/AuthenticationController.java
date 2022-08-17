package com.samrat.obms.controller;

import java.util.logging.Logger;

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

//Controlling the authentication of the system 
@Controller
public class AuthenticationController {

	final Logger logger = Logger.getLogger(AuthenticationController.class.getName());

	// It allows Spring to resolve and inject collaborating beans into our bean.
	@Autowired
	UserService userService;

	// Mapping the GET request to home
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		// resources/template/login.html
		modelAndView.setViewName("login");
		return modelAndView;
	}

	// Mapping the GET request to register a uesr
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		// resources/template/register.html
		modelAndView.setViewName("register");
		return modelAndView;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		// resources/template/home.html
		modelAndView.setViewName("home");
		return modelAndView;
	}

	// Mapping the GET request to redirect in admin page
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminHome() {
		ModelAndView modelAndView = new ModelAndView();
		// resources/template/admin.html
		modelAndView.setViewName("admin");
		return modelAndView;
	}

	// POST mapping for error inside a form
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		// check for the validations
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please Correct the errors in form!");
			modelMap.addAttribute("bindingResult", bindingResult);
		}
		// we will save the user if, no binding errors
		else if (userService.isUserAlreadyPresent(user)) {
			// save the user registration form
			modelAndView.addObject("successMessage", "user already exists!");
		}
		// we will save the users if, no binding errors
		else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "user is registered successfully!");
		}
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("register");
		return modelAndView;
	}
}
