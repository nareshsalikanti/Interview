package com.student.dao;

import java.util.List;

import com.student.model.Student;

public interface StudentDao {
	public void addStudent(final Student student);
	public List<Student> getStudent();
	public Student findById(final int id);
	public Student update(final Student student, int id);
	public void delete(final int id);
}
