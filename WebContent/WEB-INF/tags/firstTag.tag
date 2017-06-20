<%@tag import="java.text.SimpleDateFormat"%>
<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ tag import="java.util.Date" import="java.text.DateFormat"%>
<%
	DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	Date date = new Date();
	String strDate = dateformat.format(date);
	out.print(strDate);
%>
