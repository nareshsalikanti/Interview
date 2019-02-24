package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.dao.StudentDao;
import com.student.model.Student;

@Service
@Transactional
public class StudentServiceImp implements StudentService {
	
	@Autowired
	StudentDao studentDao;

	public List<Student> getStudent() {
		return studentDao.getStudent();
	}

	public Student findById(final int id) {
		return studentDao.findById(id);
	}

	public void createStudent(final Student student) {
		studentDao.addStudent(student);
	}

	public void deleteStudentById(final int id) {
		studentDao.delete(id);
	}
	

	public Student update(final Student student, final int id) {
		return studentDao.update(student, id);
	}

	public Student findByName(String name) {
		return studentDao.findByName(name);
	}

}
