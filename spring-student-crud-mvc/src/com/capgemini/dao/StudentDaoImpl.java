package com.capgemini.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Student;

import java.util.List;


@Repository
public class StudentDaoImpl implements StudentDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public StudentDaoImpl() {
		System.out.println("called");

	}

	@Override
	public Student getStudentById(int id) {
		String query = "Select * from students where studentid=" + id + "";
		List<Student> list = jdbcTemplate.query(query, new StudentRowMapper());
		return list.get(0);
	}

	@Override
	public void addStudent(Student student) {

		String query = "Insert into students(studentid,name) values(" + student.getStudentId() + ",'"
				+ student.getName() + "')";
		System.out.println(query);
		jdbcTemplate.update(query);
	}

	@Override
	public void removeStudent(Student student) {

		String query = "Delete from students where studentid=" + student.getStudentId() + "";
		System.out.println(query);
		jdbcTemplate.update(query);
	}

	@Override
	public void updateStudent(Student student) {
		String query = "Update students set name='" + student.getName() + "' where studentid=" + student.getStudentId()
				+ "";
		System.out.println(query);
		jdbcTemplate.update(query);
	}

	@Override
	public void beginTransaction() {

	}

	@Override
	public void commitTransaction() {

	}

	@Override
	public List<Student> getAllStudents() {
		String query = "Select * from students";
		List<Student> list = jdbcTemplate.query(query, new StudentRowMapper());
		return list;
	}
}
