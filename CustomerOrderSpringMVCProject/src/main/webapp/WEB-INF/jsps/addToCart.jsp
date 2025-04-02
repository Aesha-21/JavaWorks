<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<table border="5">
		<th>Item Id</th>
		<th>Item Name</th>
		<th>Item Discription</th>
		<th>Item CurrentQty</th>
		<th>Item MaxQty</th>

		<th>Add Items</th>
		<c:forEach items="${ivo}" var="i">
			<tr>
				<td><c:out value="${i.id}"></c:out></td>
				<td>${i.name}</td>
				<td>${i.dis}</td>
				<td>${i.currentQty}</td>
				<td>${i.maxQty}</td>
		
				
			</tr>
		</c:forEach>


	</table>
	
	
</body>
</html>