package com.shop.config;

import javax.servlet.*;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



public class SpringWebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		// TODO Auto-generated method stub
		 AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
     appContext.register(WebConfig.class,SpringConfig.class);

     ServletRegistration.Dynamic dispatcher = container.addServlet(
             "dispatcher", new DispatcherServlet(appContext));
     dispatcher.setLoadOnStartup(1);
     dispatcher.addMapping("/");
	}



}