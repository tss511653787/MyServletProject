<%@tag import="java.text.SimpleDateFormat"%>
<%@tag import="java.text.DateFormat"%>
<%@tag import="java.util.Date"%>
<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<!-- var型变量必须提前声明 否则jsp中无法获取 -->
<%@ variable name-given="date"%>
<%@ variable name-given="time"%>
<%
	Date now = new Date();
	DateFormat fmt1 = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
	DateFormat fmt2 = new SimpleDateFormat("HH-mm-ss");
	jspContext.setAttribute("date", fmt1.format(now));
	jspContext.setAttribute("time", fmt2.format(now));
%>
<jsp:doBody />

