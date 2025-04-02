<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%  String name = (String) request.getAttribute("name");

	 List<String> nam = (List<String>) request.getAttribute("nm"); 
	
%>
<h1>hello <%=name%></h1>

<% for(String s : nam) { %>

<%= s %>

<% } %>

</body>
</html>