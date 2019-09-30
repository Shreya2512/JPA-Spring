package com.capgemini.dao;

import java.util.List;

import com.capgemini.model.Student;

public interface StudentDao {

	public abstract Student getStudentById(int id);
	
	public abstract List<Student> getAllStudents();

	public abstract void addStudent(Student student);

	public abstract void removeStudent(Student student);

	public abstract void updateStudent(Student student);

	public abstract void commitTransaction();

	public abstract void beginTransaction();

}