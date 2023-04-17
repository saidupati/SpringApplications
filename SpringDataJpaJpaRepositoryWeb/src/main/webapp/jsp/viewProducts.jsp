<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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




<script
	    src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"
	    integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="
	    crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<link rel="stylesheet" type="text/css"
	    href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">

 

<script type="text/javascript" charset="utf8"
	    src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js">
	
</script>



<body>
	<table class="table" id="page">
		<thead>
			<tr class="table-warning">
				<th scope="col">PID</th>
				<th scope="col">PNAME</th>
				<th scope="col">PPRICE</th>
				<th scope="col">Action_1</th>
				<th scope="col">Action_2</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="pro">
				<tr>
					<th scope="row">${pro.pid}</th>
					<th scope="row">${pro.pname}</th>
					<th scope="row">${pro.pprice}</th>
					<th scope="row"><button class="btn btn-primary">
							<a href="edit" class="table-success"> Edit</a>
						</button></th>
					<th scope="row"><button class="btn btn-success">
							<a href="delete" class="table-danger"> Delete</a>
						</button></th>
				</tr>
			</c:forEach>
		</tbody>
	
		<tfoot>
			<div>
				<button class="btn btn-warning">
					<a href="pdf">PDF</a>
				</button>
				<button class="btn btn-danger">
					<a href="excel">Excel</a>
				</button>
				<button class="btn btn-warning">
					<a href="mail">Mail</a>
				</button>
						<button><a href="addProduct"> Add Products</a></button>
				
			</div>
		</tfoot>
		<script>
        $(document).ready(function() {
            $('#page').DataTable({
                responsive : false,
               pageLength : 3,
            });
        })
</script>
	</table>
</body>
</html>
