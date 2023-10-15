package com.example.demo.Repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

	private static SessionFactory factory = null;  // "hibernate.cfg.xml"
	
	public static SessionFactory getFactory() {
		
		if(factory == null) {
			factory = new Configuration().configure().buildSessionFactory();
		}
		return factory;
	}

}
