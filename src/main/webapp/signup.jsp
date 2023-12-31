<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/31/2023
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/signup">
  <input type="text" name="nom" placeholder="nom">
  <input type="text" name="prenom" placeholder="prenom">
  <input type="text" name="email" placeholder="email">
  <input type="password" name="password">
  <input type="hidden" value="normal" name="type">
  <input type="submit" value="Login">
</form>
<form action="login" method="post">
  <input type="hidden" value="google" name="type">
  <input type="submit" value="Sign Up with google">
</form>
</body>
</html>
