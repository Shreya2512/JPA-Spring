<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update student</title>
</head>
<body>
<form action="update" method="post">
	Student Id<input type="text" name="studentId" value="${student.studentId}" readonly="readonly"><br>
	Student Name<input type="text" name="studentName" value="${student.name}"><br>
	<input type="submit">
</form>
	

</body>
</html>