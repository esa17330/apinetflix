<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/saison.css" contentType="text/css">

<title>Saisons</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/apiMynetflix/accueil"><img src="images/camera.jpg" alt="camera" id="camera"/></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/Serie"/>">Série</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value="/Saison"/>">Saisons</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/Episode"/>">Episodes</a>
      </li>
    </ul>
  </div>
</nav>
<div class="fond">
<div class="button-add">
<a href="#">
<img src="images/add.jpg" alt="ajouter" id="ajouter"/>
</a>
<h2>Ajouter</h2>
</div>
<h1>Mes Saisons</h1>
<form action="" accept-charset="UTF-8" method="post" id="form-serie">
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">Nom</th>
      <th scope="col">Saison</th>
      <th scope="col">Lire/Modifier</th>
      <th scope="col">Supprimer</th>
      <th scope="col">Saisons</th>
      <th scope="col">Episodes</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><select id="serie" name="serie">
				<option value="0">Choisissez une Série</option>
				<c:forEach var="serie" items="${serie}">
					<option value="${serie.id}">
						<c:out value="${serie.nom}"/>
					</option>
				</c:forEach>
			</select> </td>
      <td><select id="serie" name="serie">
				<option value="0">Choisissez une saison</option>
				<c:forEach var="serie" items="${serie}">
					<option value="${serie.id}">
						<c:out value="${serie.nom}"/>
					</option>
				</c:forEach>
			</select> </td>
      <td><a href='<c:url value="/serie/${statut.id}"/>'><img src="images/lire.JPG" alt="lire" id="lire" class="img-size"></a></td>
      <td><a href='<c:url value="/serie/${statut.id}"/>'><img src="images/trash.jpg" alt="supprimer" id="supprimer" class="img-size"></a></td>
       <td><a href='<c:url value="/saison/${statut.id}"/>'><img src="images/link.jpg" alt="link" id="link1" class="img-size"></a></td>
       <td><a href='<c:url value="/episodes/${statut.id}"/>'><img src="images/link.jpg" alt="link" id="link2" class="img-size"></a></td>
    </tr>
  </tbody>
</table>
      </form>
      </div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>











