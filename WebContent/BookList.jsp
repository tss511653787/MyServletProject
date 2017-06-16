<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book List</title>
<style>
table, tr, td {
	border: 1px solid brown;
}
</style>
</head>
<body>
	Books in Simple Table
	<table>
		<tr>
			<td>ISBN</td>
			<td>Title</td>
		</tr>
		<!-- 循环输出book的信息 -->
		<c:forEach items="${requestScope.books}" var="book">
			<tr>
				<td>${book.isbn}</td>
				<td>${book.title}</td>
			</tr>
		</c:forEach>
	</table>
	<br /> Books in Styled Table
	<table>
		<tr style="background: #ababff">
			<td>ISBN</td>
			<td>Title</td>
		</tr>
		<!-- 循环输出book的信息  如果行数为偶数就变换颜色-->
		<c:forEach items="${requestScope.books}" var="book" varStatus="status">
			<c:if test="${status.count%2 == 0}">
				<tr style="background: #eeeeff">
			</c:if>
			<c:if test="${status.count%2 != 0}">
				<tr style="background: #dedeff">
			</c:if>
			<td>${book.isbn}</td>
			<td>${book.title}</td>
			</tr>
		</c:forEach>
	</table>

	<br /> ISBNs only:
	<c:forEach items="${requestScope.books}" var="book" varStatus="status">
        ${book.isbn}<c:if test="${!status.last}">,</c:if>
	</c:forEach>

</body>
</html>