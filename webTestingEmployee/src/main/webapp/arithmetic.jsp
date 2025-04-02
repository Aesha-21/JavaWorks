<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

welcome <%= request.getAttribute("username") %>
<%= request.getAttribute("role") %>

A = <%= request.getParameter("a") %><br/>
B = <%= request.getParameter("b") %><br/>
Operation = <%= request.getParameter("operation") %><br/>
Result = <%= request.getAttribute("result") %>

<form action="arithmetic" method = "post">

  A = <input type="text" name="a" /><br>
  B = <input type="text" name="b" /><br>
  
    <input type="submit" name="operation" value="Add"/>
    <input type="submit" name="operation" value="Sub"/>
    <input type="submit" name="operation" value="Div"/>
    <input type="submit" name="operation" value="Mul"/>
  
</form>


</body>
</html>