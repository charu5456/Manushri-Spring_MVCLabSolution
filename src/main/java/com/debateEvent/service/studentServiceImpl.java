package com.debateEvent.service;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.debateEvent.entity.Student;

@Service
public class studentServiceImpl implements studentService {
	
	public SessionFactory sessionFactory;
	
	public Session session;
	
	@Autowired
	public studentServiceImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		try {
			
			session = sessionFactory.getCurrentSession();
		}
		catch (HibernateException e) {
        
			session = sessionFactory.openSession();
		}
	}

	@Override
	@Transactional
	public void save(Student student) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();	
	}

	@Override
	public List<Student> findAll() {
		Transaction tx = session.beginTransaction();
		List <Student> students = session.createQuery("from Student").list();
		tx.commit();
		return students;
	}
	
	@Override
	public Student findById(long id) {
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, id);
		tx.commit();
		return student;
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, id);
		if(student != null) {
			session.delete(student);
		}
		tx.commit();
	}
}