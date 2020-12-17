<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<title>List Customers</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<style type="text/css">
html, body {
	margin-left: 15px;
	margin-right: 15px;
	padding: 0px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
}

table {
	border-collapse: collapse;
	border-bottom: 1px solid gray;
	font-family: Tahoma, Verdana, Segoe, sans-serif;
	width: 72%;
}

th {
	border-bottom: 1px solid gray;
	background: none repeat scroll 0 0 #ff05a8;
	padding: 10px;
	color: #FFFFFF;
}

tr {
	border-top: 1px solid gray;
	text-align: center;
}

tr:nth-child(even) {
	background: #FFFFFF
}

tr:nth-child(odd) {
	background: #BBBBBB
}

#wrapper {
	width: 100%;
	margin-top: 0px;
}

#header {
	width: 70%;
	background: #ff05a8;
	margin-top: 0px;
	padding: 15px 0px 15px 15px;
}

#header h2 {
	width: 100%;
	margin: auto;
	color: #FFFFFF;
}

#container {
	width: 100%;
	margin: auto
}

#container h3 {
	color: #000;
}

#container #content {
	margin-top: 20px;
}

.add-button {
	border: 1px solid #666;
	border-radius: 5px;
	padding: 4px;
	font-size: 12px;
	font-weight: bold;
	width: 120px;
	padding: 5px 10px;
	margin-bottom: 15px;
	background: #cccccc;
	form
	{
	margin-top
	:
	10px;
}

label {
	font-size: 16px;
	width: 100px;
	display: block;
	text-align: right;
	margin-right: 10px;
	margin-top: 8px;
	margin-bottom: 8px;
}

input {
	width: 250px;
	border: 1px solid #666;
	border-radius: 5px;
	padding: 4px;
	font-size: 16px;
}

.save {
	font-weight: bold;
	width: 130px;
	padding: 5px 10px;
	margin-top: 30px;
	background: #cccccc;
}

table {
	border-style: none;
	width: 50%;
}

tr:nth-child(even) {
	background: #FFFFFF
}

tr:nth-child(odd) {
	background: #FFFFFF
}

tr {
	border-style: none;
	text-align: left;
}

}
</style>
</head>

<body>

	<div id="wrapper">
		<div id="header">
		
			<h2>this is a simple demo practicing on hibernate with spring mvc developed by <span style="color:#ff0">Mohammed Khaled</span></h2>
		
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<button class="add-button" onclick="window.location.href='showFormForAdd'">Add
				Customer</button>
			<!--  add our html table here -->

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
	<c:url var="deleteLink" value="/customer/deleteCustomer">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>  | 
					<!-- display the delete link --> <a href="${deleteLink}" 
					onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>









