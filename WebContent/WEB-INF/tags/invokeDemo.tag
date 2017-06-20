<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="productDetails" fragment="true"%>
<%@ variable name-given="productName"%>
<%@ variable name-given="description"%>
<%@ variable name-given="price"%>
<%
	jspContext.setAttribute("productName", "Pelesonic DVD Player");
	jspContext
			.setAttribute(
					"description",
					"Dolby Digital output through coaxial digital-audio jack,"
							+ " 500 lines horizontal resolution-image digest viewing");
	jspContext.setAttribute("price", "65");
%>
<jsp:invoke fragment="productDetails" />