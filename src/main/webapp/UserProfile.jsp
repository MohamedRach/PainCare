<%--
  Created by IntelliJ IDEA.
  User: User0
  Date: 04/01/2024
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <script>
        function redirectToUpdateProfile() {
            window.location.href = "/Update-user-profile";
        }
    </script>
</head>
<body>

<h2>User Profile</h2>

<c:if test="${not empty user}">
    <table>

        <tr>
            <td>Nom:</td>
            <td>${user.nom}</td>
        </tr>
        <tr>
            <td>Prénom:</td>
            <td>${user.prenom}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>${user.email}</td>
        </tr>
        <!-- Ajoutez d'autres champs au besoin -->
    </table>
    <form action="Update-user-profile">

        <input type = "hidden" value="${user.id}" >
        <button type="button" onclick="redirectToUpdateProfile()">Modifier le profil</button>
    </form>
</c:if>

</body>
</html>

