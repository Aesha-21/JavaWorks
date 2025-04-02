<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login page</h2>
	<form action="login" method="post">

		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<td><input type="submit" value="login" name="login" /></td>
		</table>

	</form>

</body>
</html>