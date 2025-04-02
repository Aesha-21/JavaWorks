<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="changePassword" method="post">
		<table>
			<tr>
				<td>Current Password</td>
				<td><input type="password" name="currentPassword" /></td>
			</tr>
			<tr>
				<td>New Password</td>
			<td>	<input type="password" name="newPassword" /></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="confirmPassword" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Change Passsword" />
				</td>

			</tr>
		</table>

	</form>

</body>
</html>