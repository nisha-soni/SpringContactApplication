package com.mycompany.springcontactapp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author Nisha
 */
public class ContactAppDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
      return new Class[]{SpringRootConfig.class};   
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
      return new Class[]{SpringWebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
     return  new String[]{"/"};
    }
    
    @Override
    public void onStartup(ServletContext servletcontext) throws ServletException{
      super.onStartup(servletcontext);
      //global resources
   }
}
