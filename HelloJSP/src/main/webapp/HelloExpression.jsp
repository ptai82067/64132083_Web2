<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>Hello đại học Nha Trang</h1>
	<%=
		new Date().toString()
	%>
	<%= 2+5 %>
	<%= "<br><b>Hôm nay tôi học JSP</b>" %>
</center>
</body>
</html>