<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>
		<form:form action="/EditProduct" method="post" modelAttribute="product" >
		<form:hidden path="pid"/>
		<form:input path="pname"/>
		<form:input path="pprice" value="Submit" />
		</form:form>
	</div>
	<div>
		<a href="/viewProducts">View All Products</a>
	</div>






</body>
</html>