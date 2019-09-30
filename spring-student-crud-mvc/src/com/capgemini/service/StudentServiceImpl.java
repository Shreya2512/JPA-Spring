package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.StudentDao;
import com.capgemini.dao.StudentDaoImpl;
import com.capgemini.model.Student;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;

//	public StudentServiceImpl(StudentDao dao) {
//		System.out.println("Hello");
//		this.dao = dao;
//	}

	@Override
	public void addStudent(Student student) {
		dao.beginTransaction();
		dao.addStudent(student);
		dao.commitTransaction();
	}

	@Override
	public void updateStudent(Student student) {
		dao.beginTransaction();
		dao.updateStudent(student);
		dao.commitTransaction();
	}

	@Override
	public void removeStudent(Student student) {
		dao.beginTransaction();
		dao.removeStudent(student);
		dao.commitTransaction();
	}

	@Override
	public Student findStudentById(int id) {
		// no need of transaction, as it's an read operation
		Student student = dao.getStudentById(id);
		return student;
	}

	@Override
	public List<Student> findAllStudents() {

		return dao.getAllStudents();

	}
}
