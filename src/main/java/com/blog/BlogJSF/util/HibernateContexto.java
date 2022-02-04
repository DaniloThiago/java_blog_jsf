package com.blog.BlogJSF.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtil.getFabricaDeSessoes();
		
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
