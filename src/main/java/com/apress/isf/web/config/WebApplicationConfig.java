package com.apress.isf.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author dirkseActive
 * @since 4/25/2017
 *
 */
public class WebApplicationConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	@Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/mydocuments/*" };
    }

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
}