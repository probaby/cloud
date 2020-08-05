package com.hb;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.hb.hibernate_out_spring.entity.Students;

@Component("service")
public class Service{
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void show() {
		
		Students students=new Students();
		students.setStudentsId(4);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(students);
		session.getTransaction().commit();
	}
	
	
}
