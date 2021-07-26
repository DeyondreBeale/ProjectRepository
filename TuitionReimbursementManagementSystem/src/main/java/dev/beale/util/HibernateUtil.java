package dev.beale.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	// Will create our SessionFactory using the Configuration Class

	private static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public static Session getSession() {
		return sf.openSession();
	}
}
