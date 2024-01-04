<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/4/2024
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/blog" method="post">
    <input name="title" placeholder="blog title">
    <textarea id="w3review" name="description" rows="4" cols="50"></textarea>
    <input type="submit" value="add blog">
</form>

<form action="/blog" method="post">
    <input type="text" name="comment">
    <input type="hidden" name="hidden" value="comment">
    <input type="submit" value="add comment">
</form>
</body>
</html>
