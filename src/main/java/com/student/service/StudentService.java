package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {
	public void createStudent(Student student);
	public List<Student> getStudent();
	public Student findById(int id);
	public Student update(Student student, int id);
	public void deleteStudentById(int id);
	public Student findByName(final String name);
}
