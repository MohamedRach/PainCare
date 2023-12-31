<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form method="post" action="/login">
    <input type="text" name="email">
    <input type="password" name="password">
    <input type="submit" value="Login">
</form>
<form action="/login" method="post">
    <input type="hidden" value="normal" name="type">
    <input type="submit" value="login with google">
</form>
</body>
</html>