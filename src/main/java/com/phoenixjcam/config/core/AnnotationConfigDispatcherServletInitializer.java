package com.phoenixjcam.config.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.phoenixjcam.config.WebConfigurer;

/**
 * The Spring Web model-view-controller (MVC) framework is designed around a DispatcherServlet that dispatches requests
 * to handlers
 * 
 * @author Bart88
 *
 */
public class AnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	// @Override
	// public void onStartup(ServletContext servletContext) throws ServletException
	// {
	// super.onStartup(servletContext);
	// }

	// the configuration classes for the root application context
	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class[]
		{ WebConfigurer.class };
	}

	// the configuration classes for the dispatcher servlet application context
	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return null;
	}

	// servlet mapping(s) for the DispatcherServlet
	@Override
	protected String[] getServletMappings()
	{
		return new String[]
		{ "/" };
	}
}