<%--
  Created by IntelliJ IDEA.
  User: User0
  Date: 04/01/2024
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<!-- UpdateProfile.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Modification du profil</title>
</head>
<body>

<div class="container">
  <div class="col-md-8 offset-2 col-xm-8 col-sm-8 ">
    <div class="card my-5">
      <div class="card-header">
        <span>Modification du profil</span>
      </div>
      <div class="card-body">
        <form action="Update-user-profile" method="post">

          <div class="form-group">
            <label class="label-control">Nom :</label>
            <input class="form-control" name="nom" placeholder="Entrer le nom" value="${user.nom}">
          </div>
          <div class="form-group">
            <label class="label-control">Prénom :</label>
            <input class="form-control" name="prenom" placeholder="Entrer le prénom" value="${user.prenom}">
          </div>
          <div class="form-group">
            <label class="label-control">E-mail :</label>
            <input class="form-control" name="email" placeholder="Entrer l'e-mail" value="${user.email}">
          </div>
          <div class="form-group">
            <label class="label-control">Mot de passe :</label>
            <input type="password" class="form-control" name="motDePasse" placeholder="">
          </div>

          <!-- Ajouter d'autres propriétés du profil au besoin -->

          <button class="btn btn-warning btn-block" type="submit">Enregistrer</button>
          <button class="btn btn-danger float-right" type="button" onclick="cancelAction()">Annuler</button>

          <script>
            function cancelAction() {
              // Remplacez 'conseiller-servlet' par le chemin de votre page d'affichage de profil
              window.location.href = 'user-profile';
            }
          </script>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>
