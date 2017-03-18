package com.web.servlet;


public class MyWebInitializer /*extends AbstractAnnotationConfigDispatcherServletInitializer*/ {

    //@Override
    protected Class<?>[] getServletConfigClasses() {
        /*return new Class[] { WebConfiguration.class }*/return null;
    }

    //@Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    //@Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
}
