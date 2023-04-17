<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
	crossorigin="anonymous"></script>
<body>
	<h1>Product Details</h1>
	<p>${msg}</p>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-8 col-sm-12">
				<div class="card">
					<div class="card-head">
						<h1>Product Registration</h1>
					</div>
					<div class="card-body">

						<form:form action="insert" method="post" modelAttribute="product">
<div>Product Name : <form:input path="pname" /></div>
<div>Product Price : <form:input path="pprice" /></div>
<div><input class="btn btn-primary"type="Submit" value="Add Products" /></div>
							
						</form:form>
						</div>
						<form>
						<div><a href="viewProducts"> ViewAllProducts</a></div>
						
						 <div><a href="viewProduct"> ViewProductByID</a></div>
						 </form>
</body>
</html>
