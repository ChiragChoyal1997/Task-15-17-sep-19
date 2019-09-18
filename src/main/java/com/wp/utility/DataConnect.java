package com.wp.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataConnect {
	public static SessionFactory getSessionFactory() {
		Configuration config=new Configuration().configure();
		SessionFactory sf=config.buildSessionFactory();
		return sf;
	}
}
