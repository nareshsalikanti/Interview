package com.student.dao;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.student.model.Student;

@Repository
public class StudentDaoImp implements StudentDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public void addStudent(final Student student) {
		try (Session session = getSessionFactory().openSession()) {
			session.save(student);
		}
	}

	public List<Student> getStudent() {
		try (Session session = getSessionFactory().openSession()) {
			@SuppressWarnings("unchecked")
			List<Student> list = session.createCriteria(Student.class).list();
			return list;
		}

	}

	public Student findById(final int id) {
		try (Session session = getSessionFactory().openSession()) {
			return session.get(Student.class, id);
		}
	}

	public Student update(final Student val, final int id) {
		try (Session session = getSessionFactory().openSession()) {
			Student student = session.get(Student.class, id);
			student.setName(val.getName());
			student.setAddress(val.getAddress());
			student.setClasses(val.getClasses());
			session.update(student);
			return student;
		}
	}

	public void delete(final int id) {
		try (Session session = getSessionFactory().openSession()) {
			Student student = findById(id);
			session.delete(student);
		}
	}

	private SessionFactory getSessionFactory() {
		return entityManagerFactory.unwrap(SessionFactory.class);
	}
}
