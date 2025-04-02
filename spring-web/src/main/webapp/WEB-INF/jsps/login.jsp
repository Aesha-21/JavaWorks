<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>From the Login page...</h1>
<span style="color: red">${message}</span>
<form method="post" action="login">
	<table>
		<tr>
			<td>Username</td>
			<td><input name="username" type="text"/> </td>
		</tr>
		
		<tr>
			<td>Password</td>
			<td><input name="password" type="password"/> </td>
		</tr>
		<td colspan="3">
			<input name="action" value="Login" type="submit" />
			<input name="action" value="cancel" type="submit" />
			
		</td>
	</table>
</form>

</body>
</html>