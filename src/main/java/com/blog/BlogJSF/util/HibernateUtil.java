package com.blog.BlogJSF.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}
	
	private static SessionFactory criarFabricaDeSessoes() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			// return new Configuration().configure().criarFabricadeSessoes(new StandardServiceRegistryBuilder().build());
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			return config.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Erro na inicialização da sessão." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

}
