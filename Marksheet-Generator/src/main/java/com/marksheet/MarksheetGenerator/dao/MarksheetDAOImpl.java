package com.marksheet.MarksheetGenerator.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.marksheet.MarksheetGenerator.entity.Student;

@Repository
public class MarksheetDAOImpl implements MarksheetDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Student getdetails(int rollnumber) {
	// get the current hibernate session
		Session currentsession = entityManager.unwrap( Session.class );
		
			 
			// now retrieve/read from database using the primary key
			Student student = currentsession.get(Student.class, rollnumber);
			
			return student;
	}

}