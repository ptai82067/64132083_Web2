<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SUM</title>
</head>
<body>
	<% 
	String a = request.getParameter("a");
    String b = request.getParameter("b");
    out.append("Kết quả tính được <hr>");
    out.append(String.valueOf(a+b));
	%>
</body>
</html>