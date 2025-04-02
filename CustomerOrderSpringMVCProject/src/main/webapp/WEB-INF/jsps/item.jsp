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

<h2>Item Form</h2>
	<form action="item" method="POST">
	
		<table>
		
			<tr>
				<td>Item Name</td>
				<td><input type="text" name="name" /></td>
			</tr>

			<tr>
				<td>Item Discription</td>
				<td><input type="text" name="dis" /></td>
			</tr>

			<tr>
				<td>Item CurrentQty</td>
				<td><input type="number" name="currentQty" /></td>
			</tr>

			<tr>
				<td>Item MaxQty</td>
				<td><input type="number" name="maxQty" /></td>
			</tr>

			<tr>
				<td>Item ReorderQty</td>
				<td><input type="number" name="reOrderQty" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>
<br>

<h2>All Item Data</h2>
	<table border="5">
		<th>Item Id</th>
		<th>Item Name</th>
		<th>Item Discription</th>
		<th>Item CurrentQty</th>
		<th>Item MaxQty</th>
		<th>Item ReorderQty</th>
		<c:forEach items="${ivo}" var="i">
			<tr>
				<td><c:out value="${i.id}"></c:out></td>
				<td>${i.name}</td>
				<td>${i.dis}</td>
				<td>${i.currentQty}</td>
				<td>${i.maxQty}</td>
				<td>${i.reOrderQty}</td>
				
			</tr>
		</c:forEach>


	</table>





















</body>
</html>