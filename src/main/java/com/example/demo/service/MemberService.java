package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.MemberRepository;
import com.example.demo.entity.Member;

@Service
public class MemberService {
	
	private Transaction tx;
	
	public List<Member> getMemberList(){
		
		List<Member> member = new ArrayList<Member>();
		
		try {
			SessionFactory factory = MemberRepository.getFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			member = session.createQuery("FROM Member").list(); //대소문자 구분
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
		        tx.rollback();
		    }
			e.printStackTrace();
		}
		
		return member;
		
	}
	
	public void insertMember() {
		
	}
	
	public void updateMember() {
		
	}
	
	public void deleteMember() {
		
	}
	
}
