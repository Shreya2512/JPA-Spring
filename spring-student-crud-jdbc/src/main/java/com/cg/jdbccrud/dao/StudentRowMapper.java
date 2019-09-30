package com.cg.jdbccrud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cg.jdbccrud.entities.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int arg1) throws SQLException {

		int id = rs.getInt("studentid");
		String name = rs.getString("name");
		Student s = new Student();
		s.setStudentId(id);
		s.setName(name);

		return s;
	}

}
