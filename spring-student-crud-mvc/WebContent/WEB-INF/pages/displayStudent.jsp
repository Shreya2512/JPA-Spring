<%@page import="com.capgemini.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display student</title>
</head>
<body>

	<%
		List<Student> list = (List<Student>)request.getAttribute("listStudent");
	out.println("<Table>");
	out.println("<Tr><Th>Student Id</Th><Th>Student Name</Th><Th>Edit</Th><Th>Delete</Th></Tr>");
	
	for(Student student:list){
			out.println("<Tr>");
			out.println("<Td>"+student.getStudentId()+"</Td>");
			out.println("<Td>"+student.getName()+"</Td>");
			out.println("<Td><a href='update?id="+student.getStudentId()+"&name="+student.getName()+"'>Edit</a></Td>");
			out.println("<Td><a href='delete?id="+student.getStudentId()+"'>Delete</a></Td>");
			
			out.println("<Tr>");
		}
	out.println("</Table>");
	%>

</body>
</html>