package com.student.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

@Repository
public class StudentDaoImp implements StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addStudent(final Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
	}

	public List<Student> getStudent() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Student> list = session.createCriteria(Student.class).list();
		return list;
	}

	public Student findById(final int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Student.class, id);
	}

	public Student update(final Student val, final int id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.get(Student.class, id);
		student.setName(val.getName());
		session.update(student);
		return student;
	}

	public void delete(final int id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = findById(id);
		session.delete(student);
	}

	@Override
	public Student updateCountry(final Student val, final int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.load(Student.class, id);
	}

}
