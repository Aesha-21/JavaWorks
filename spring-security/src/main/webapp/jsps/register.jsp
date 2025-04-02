<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Registration Page</h2>
	<form action="register" method="post">

		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<td><input type="submit" value="register" name="register" /></td>
		</table>

	</form>

</body>
</html>