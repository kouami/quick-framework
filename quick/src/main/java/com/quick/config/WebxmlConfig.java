/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quick.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author Emmanuel
 */
public class WebxmlConfig implements WebApplicationInitializer {

    private static final String CONFIG_LOCATION = "com.quick.config";
    private static final String MAPPING_URL = "*.htm";

    //private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
       // "classpath:/META-INF/resources/", "classpath:/resources/",
       // "classpath:/static/", "classpath:/public/"};

    /*
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(MAPPING_URL);

        ServletRegistration.Dynamic ws = servletContext.addServlet("MessageDispatcherServlet", new MessageDispatcherServlet(context));
        ws.setInitParameter("transformWsdlLocations", "true"); // Don't use this in production
        ws.addMapping("/services/*");

    }*/
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {        
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
        ctx.register(MvcConfiguration.class);  
        ctx.setServletContext(servletContext);    
        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));  
        servlet.addMapping("/");  
        servlet.setLoadOnStartup(1);
    }

   /* public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
        }
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
        }
    }*/

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION);
        context.register(MvcConfiguration.class);
        return context;
    }

}
