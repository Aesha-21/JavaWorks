<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="customer" method="POST">
		<table>
			<br>

			<tr>
				<td>Customer name</td>
				<td><input type="text" name="custName" value="" /></td>
			</tr>

			<tr>
				<td>Customer Age</td>
				<td><input type="number" name="age" value="" /></td>
			</tr>

			<tr>
				<td>Customer Address</td>
				<td><input type="text" name="address" value="" /></td>
			</tr>

			<tr>
				<td>Customer Permenat Address</td>
				<td><input type="text" name="perAdd" value="" /></td>
			</tr>



		</table>
		<input type="submit" name="submit" />
	</form>


	<br>
	<br>
	<div class="container">
		<table border="2">



			<th>Customer ID</th>
			<th>Customer name</th>
			<th>Age</th>
			<th>Address</th>
			<th>Perment Address</th>
			<th>Customer Status</th>

			<c:forEach items="${cvo}" var="c">
				<tr>
					<td><c:out value="${c.custId}"></c:out></td>
					<td>${c.custName}</td>
					<td>${c.age }</td>
					<td>${c.address }</td>
					<td>${c.perAdd }</td>
					<td>${c.customerStatus}</td>
				</tr>

			</c:forEach>
		</table>

	</div>


</body>
</html>