<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>getProperty and set Property Test</title>
</head>
<body>
	<jsp:useBean id="employee" class="app03a.Employee"></jsp:useBean>
	<jsp:setProperty name="employee" property="firstName" value="Tss" />
	First name:<jsp:getProperty name="employee" property="firstName" />
</body>
</html>