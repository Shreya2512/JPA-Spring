package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Student;

public interface StudentService {

	public abstract void addStudent(Student student);

	public abstract void updateStudent(Student student);

	public abstract void removeStudent(Student student);

	public abstract Student findStudentById(int id);

	public abstract List<Student> findAllStudents();
	
}