<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="easy" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<easy:invokeDemo>
		<jsp:attribute name="productDetails">
        <table width="220" border="1">
        <tr>
            <td><b>Product Name</b></td>
            <td>${productName}</td>
        </tr>
        <tr>
            <td><b>Description</b></td>
            <td>${description}</td>
        </tr>
        <tr>
            <td><b>Price</b></td>
            <td>${price}</td>
        </tr>
        </table>
    </jsp:attribute>
	</easy:invokeDemo>
</body>
</html>