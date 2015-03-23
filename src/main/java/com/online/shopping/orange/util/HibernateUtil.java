/**
 *@Project: Team-Excellence-Hibernate-Repository
 *
 *@Date: 2015��1��21��
 *@Copyright: 2015 sg.nomaka.tk Inc. All rights reserved.
 */
package com.online.shopping.orange.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * @author Cain
 * 
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		try {
//			sessionFactory = new Configuration().configure().buildSessionFactory();
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		// Alternatively, you could look up in JNDI here
		System.out.println("*****************************************");
		return sessionFactory;
	}
	
	public static void shutdown(){
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
