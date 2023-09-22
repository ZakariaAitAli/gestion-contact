<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Username</title>
</head>
<body>
<body>
    <h1>Username:</h1>
    <%
        db.DB db = new db.DB();
        String username = db.getUsername();
    %>
    <p><%= username %></p>
</body>
</body>
</html>