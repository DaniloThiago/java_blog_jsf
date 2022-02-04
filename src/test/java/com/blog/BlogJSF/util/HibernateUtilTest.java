package com.blog.BlogJSF.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {
	
	@Test
	public void conn() {
		Session section = HibernateUtil.getFabricaDeSessoes().openSession();
		section.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}

}
