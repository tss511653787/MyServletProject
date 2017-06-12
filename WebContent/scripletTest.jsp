<%@page import="java.util.Calendar"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<b>Http:Headers: </b>
	<br />
	<%--first scriplet --%>
	<%
		for (Enumeration<String> e = request.getHeaderNames(); e
				.hasMoreElements();) {
			String header = e.nextElement();
			out.print(header + ": " + request.getHeader(header) + "<br />");
		}
		String messagr = "thank you";
	%>
	<%
		out.print(messagr);
	%>
	<%--表达式 --%>
	Today is
	<%=Calendar.getInstance().getTime()%>

</body>
</html>