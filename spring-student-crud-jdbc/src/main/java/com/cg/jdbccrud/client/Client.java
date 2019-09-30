package com.cg.jdbccrud.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.jdbccrud.entities.Student;
import com.cg.jdbccrud.service.StudentService;


public class Client {

	public static void main(String[] args) {

		//Debug this program as Debug -> Debug as Java Application
		
		ApplicationContext context= new ClassPathXmlApplicationContext("spring-config.xml");
		
		
		StudentService service = (StudentService) context.getBean("service");
		
		Student student =(Student) context.getBean("student");
		student.setStudentId(102);
		student.setName("Sachin");
		service.addStudent(student);
		
		//at this breakpoint, we have added one record to table
		student = service.findStudentById(100);
		System.out.print("ID:"+student.getStudentId());
		System.out.println(" Name:"+student.getName());
		
		student.setName("Sachin Tendulkar");
		service.updateStudent(student);
		
		//at this breakpoint, we have updated record added in first section
		student = service.findStudentById(100);
		System.out.print("ID:"+student.getStudentId());
		System.out.println(" Name:"+student.getName());
		
		//at this breakpoint, record is removed from table
		service.removeStudent(student);
		System.out.println("End of program...");
		
		
		

	}
}
