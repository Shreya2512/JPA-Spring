package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.model.Student;
import com.capgemini.service.StudentService;

@Controller("")
public class StudentController {

	@Autowired
	private StudentService service;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String homePage() {

		return "index";

	}

	@RequestMapping(path = "add", method = RequestMethod.GET)
	public String addPage() {
		return "addStudent";
	}

	@RequestMapping(path = "add", method = RequestMethod.POST)
	public String addToDatabase(@RequestParam("studentId") int id, @RequestParam("studentName") String name) {

		Student s = new Student();
		s.setStudentId(id);
		s.setName(name);
		service.addStudent(s);
		return "redirect:display";

	}

	@RequestMapping(path = "display", method = RequestMethod.GET)

	public String displayStudent(Model model) {

		List<Student> list = service.findAllStudents();
		System.out.println(list);
		model.addAttribute("listStudent", list);

		return "displayStudent";
	}

	@RequestMapping(path = "delete", method = RequestMethod.GET)
	public String deleteStudent(@RequestParam("id") int id) {
		Student s = new Student();
		s.setStudentId(id);
		service.removeStudent(s);

		return "redirect:display";
	}

	@RequestMapping(path = "update", method = RequestMethod.GET)
	public String updateStudent(@RequestParam("id") int id, @RequestParam("name") String name,Model model) {
		Student s1 = new Student();
		s1.setStudentId(id);
		s1.setName(name);
		model.addAttribute("student", s1);
		return "updateStudent";
	}
@RequestMapping(path="update", method=RequestMethod.POST)
	public String updateToDatabase(@RequestParam("studentId") int id, @RequestParam("studentName") String name){
		Student s = new Student();
		s.setStudentId(id);
		s.setName(name);
		service.updateStudent(s);
		return "redirect:display";
	}
}
