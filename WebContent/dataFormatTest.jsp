<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="easy"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<easy:dataFormat header="States"
		items="Alabama,Alaska,Georgia,Florida" />

	<br />
	<easy:dataFormat header="Countries">
		<jsp:attribute name="items">
        US,UK,Canada,Korea
    </jsp:attribute>
	</easy:dataFormat>
</body>
</html>