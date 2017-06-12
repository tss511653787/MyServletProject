<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javafx.scene.input.DataFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%--这是一个jsp注释 --%>
	<%
		DateFormat fomat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String s = fomat.format(new Date());
		out.println(s);
	%>
	<%
		String username = request.getParameter("username");
		//也可以通过pageContext获取jsp页面的各个对象
		ServletRequest res = pageContext.getRequest();
		//保存属性到界面中
		pageContext.setAttribute("abc", "value1");
	%>
</body>
<!-- 这是一个html注释 -->
</html>