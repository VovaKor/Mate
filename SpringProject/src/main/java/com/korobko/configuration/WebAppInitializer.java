package com.korobko.configuration;

import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Vova Korobko
 */

public class WebAppInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(AppConfig.class);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
