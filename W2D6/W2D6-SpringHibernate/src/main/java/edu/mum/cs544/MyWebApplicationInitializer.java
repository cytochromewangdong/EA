package edu.mum.cs544;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class MyWebApplicationInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// Create the Spring 'root' application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(Config.class);
		// Manage the lifecycle of the root application context
		container.addListener(new ContextLoaderListener(rootContext));
		// ServletRegistration.Dynamic hello = container.addServlet("Hello", new
		// Hello());
		// hello.addMapping("/hello");
		FilterRegistration.Dynamic openInView = container.addFilter("OpenInView", new OpenEntityManagerInViewFilter());
		openInView.addMappingForUrlPatterns(null, true, "/*");
	}
}
