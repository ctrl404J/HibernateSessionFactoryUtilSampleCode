package com.example.demo.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Member;

@Repository
public class MemberRepository {

	private static SessionFactory factory = null;  // "hibernate.cfg.xml"
	private Transaction tx;
	
	public static SessionFactory getFactory() {
		
		if(factory == null) {
			factory = new Configuration().configure().buildSessionFactory();
		}
		return factory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Member> findAll(){

		List<Member> member = new ArrayList<Member>();

		try {
			SessionFactory factory = getFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			//Hibernate의 HQL (Hibernate Query Language)은 대소문자를 구분합니다. 
			member = session.createQuery("FROM Member").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
		        tx.rollback();
		    }
			e.printStackTrace();
		}

		return member;

	}

}
