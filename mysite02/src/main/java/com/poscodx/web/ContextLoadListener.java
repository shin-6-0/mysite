package com.poscodx.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ContextLoadListener
 *
 */
public class ContextLoadListener implements ServletContextListener {

    public ContextLoadListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }


    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("");
    }
	
}
