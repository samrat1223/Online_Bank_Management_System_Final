package com.samrat.obms;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//import com.samrat.obms.OnlineBankManagementSystemFinalApplication;

//SpringBootServletInitializer is an interface to run SpringApplication from a traditional WAR deployment.
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OnlineBankManagementSystemFinalApplication.class);
	}

}
