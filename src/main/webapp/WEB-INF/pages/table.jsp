<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/res/table/css/jquery.dataTables.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/res/table/css/shCore.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/res/table/css/demo.css">
	
<script type="text/javascript" src="<%=request.getContextPath()%>/res/table/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/res/table/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/res/table/js/shCore.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/res/table/js/demoTable.js"></script>

<title>Data Table</title>

</head>
<body>

<script type="text/javascript" class="init">

	var linkFirstPart = "<a href=\"${pageContext.request.contextPath}/employee/edit/";
	var linkSecondPart = ">Edit</a>";
	
	$(document).ready(function() {
		$('#example')
			.css('display', 'block')
			.dataTable( {
				"processing": true,
				"serverSide": true,
			    "ajax": '${pageContext.request.contextPath}/getEmployers',
			    "columns": [
	               	{ "data": "id", "width": "5%" },
	                { "data": "lastName", "width": "15%" },
	                { "data": "firstName", "width": "15%" },
	                { "data": "position", "width": "20%" },
					{ "data": "office", "width": "10%" },
					{ "data": "startDate", "width": "10%" },
					{ "data": "salary", "width": "10%" },
					{ "data": null, "width": "5%"},
					{ "data": null, "width": "5%"},
					{ "data": null, "width": "5%"}
	            ],
				"fnRowCallback" : function(nRow, aData, iDisplayIndex) {
					nRow.innerHTML = "<td>" + aData.id + "</td>"
						+ "<td>" + aData.lastName + "</td>"
						+ "<td>" + aData.firstName + "</td>"
						+ "<td>" + aData.position + "</td>"
						+ "<td>" + aData.office + "</td>"
						+ "<td>" + aData.startDate + "</td>"
						+ "<td>" + aData.salary + "</td>"
						+ "<td><a href=\"details/" + aData.id + "\"><img src=\"res/ico/details.png\" /></a></td>"
						+ "<td><a href=\"update/" + aData.id + "\"><img src=\"res/ico/update.png\" /></a></td>"
						+ "<td><a href=\"delete/" + aData.id + "\"><img src=\"res/ico/delete.png\" /></a></td>";
					
					return nRow;
				}
			});
	});
</script>


	<div class="dt-example">
		<div class="container">
			<table id="example" class="display" style="display: none; cellspacing:0; width:950px; margin-left: 70px;">
				<thead>
					<tr>
						<th>Id</th>
						<th>Last name</th>
						<th>First name</th>
						<th>Position</th>
						<th>Office</th>
						<th>Start date</th>
						<th>Salary</th>	
						<th>Details</th>
						<th>Update</th>	
						<th>Delete</th>				
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Id</th>
						<th>Last name</th>
						<th>First name</th>
						<th>Position</th>
						<th>Office</th>
						<th>Start date</th>
						<th>Salary</th>
						<th>Details</th>
						<th>Update</th>	
						<th>Delete</th>	
					</tr>
				</tfoot>
			</table>
		</div>
	</div>

</body>
</html>