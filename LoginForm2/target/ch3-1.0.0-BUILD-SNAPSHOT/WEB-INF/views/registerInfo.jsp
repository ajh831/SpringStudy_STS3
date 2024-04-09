<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("uName");
	String birth = request.getParameter("birth");
	String address = request.getParameter("address");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>id=<%=id %></h1>
	<h1>pwd=<%=pwd %></h1>
	<h1>name=<%=name %></h1>
	<h1>birth=<%=birth %></h1>
	<h1>address=<%=address %></h1>
</body>
</html>