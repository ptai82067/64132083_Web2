<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Result</title>
</head>
<body>
    <h2>Login Result</h2>

    <% 
        // Nhận dữ liệu từ request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra thông tin đăng nhập
        if("ABC".equals(username) && "MNK".equals(password)) {
        	response.sendRedirect("Profile.html");
        } else { 
        	response.sendRedirect("Login.html");
        } 
    %>

</body>
</html>
