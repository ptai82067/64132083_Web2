<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! int x=10; int y; int z=0; %>
<%
y=200;
z=x+y;
out.append("kết quả là: ");
out.append(String.valueOf(z));
%>
<h1>Hoặc ta có thể xuất kiểu Expression:</h1>
<hr>
<%= "kết quả là" %>
<%= z %>

</body>
</html>