<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/ajoutSerie.css" contentType="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Episode</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" id="nav">
  <a class="navbar-brand" href="/apiMynetflix/accueil"><img src="images/camera.jpg" alt="camera" id="camera"/></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/Serie"/>">Série</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/Saison"/>">Saisons</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value="/Episode"/>">Episodes</a>
      </li>
    </ul>
  </div>
</nav>
<div class="fond">
<h1 class="title-add"><img src="images/add.jpg" alt="ajouter" id="ajouter"/>Ajout Episode</h1>
<form>
  <div class="form-group">
    <input type="number" class="form-control" min="0" max="200" id="exampleFormControlInput1" name="numero" placeholder="Numéro">
  </div>
    <div class="form-group">
    <input type="text" class="form-control" id="exampleFormControlInput2" name="titre" placeholder="Titre">
  </div>
    <div class="form-group">
    <input type="text" class="form-control" id="exampleFormControlInput2" name="titreoriginal" placeholder="Titre Original">
  </div>
    <div class="form-group">
    <select class="form-control" id="exampleFormControlSelect1" name ="duree" >
              <option value="">Durée en minutes</option>
              <c:forEach  var="counter" begin="10" end="200">
             <option value="<c:out value="${counter}"/>">${counter}</option>
              </c:forEach>
          </select>
  </div>
  <div class="form-group">
    <select class="form-control" id="statut" name="statut">
				<option value="0">Choisissez le Statut de la Série</option>
				<c:forEach var="statut" items="${liste}">
					<option value="${statut.id}">
						<c:out value="${statut.libelle}"/>
					</option>
				</c:forEach>
			</select> 
  </div>
  <div class="form-group">
	<select class="form-control" name ="saison" required >
       <option value=" ">Sélectionner le numéro de la saison</option>
         <c:forEach  var="counter" begin="1" end="100">
          <option value="<c:out value="${counter}"/>">${counter}</option>
         </c:forEach>
    </select>
  </div>
  <div class="form-group">
    <select class="form-control" id="public" name="public">
				<option value="0">Public</option>
				<c:forEach var="pub" items="${listpublic}">
					<option value="${pub}">
						<c:out value="${pub}"/>
					</option>
				</c:forEach>
			</select>
  </div>
  <div class="form-group">
    <input type="number" class="form-control" min="1900" max="2060" id="exampleFormControlInput3" name="anneedediffusion" placeholder="Année Diffusion">
  </div>
  <div class="form-group">
    <input type="number" class="form-control" min="1900" max="2060" id="exampleFormControlInput3" name="anneederealisation" placeholder="Année de Réalisation">
  </div>
  <div class="form-group">
    <textarea placeholder="Résumé" class="form-control" id="exampleFormControlTextarea1" name="resume" rows="3"></textarea>
  </div>
  <div class="align-button">
  <button type="submit" class="btn btn-danger">Valider</button>
  </div>
</form>
<%--<form action="" accept-charset="UTF-8" method="post" id="form-episode" id="wrap-serie-page">
		<h2>Ajout Episode</h2>
       <label>Numéro :</label>
          <select type="number" name="numero" required > 
          <option value=" ">Sélectionner le numéro</option>
              <c:forEach  var="counter" begin="1" end="100">
             <option value="<c:out value="${counter}"/>">${counter}</option>
              </c:forEach>
          </select>
          <br><br>
        <label>Titre :</label>
          <textarea type="text" name="titre" required placeholder="Saisir le titre de l'épisode" required rows="1" cols="45" ></textarea>
          <br><br>
           <label>Titre Original :</label>
          <textarea type="text" name="titreoriginal" placeholder="Saisir le titre original" rows="1" cols="37" ></textarea>
          <br><br>
              <label>Durée :</label>
          <select name ="duree" >
              <option value=" ">minutes</option>
              <c:forEach  var="counter" begin="10" end="200">
             <option value="<c:out value="${counter}"/>">${counter}</option>
              </c:forEach>
          </select>
          <br><br>
              <label>Résumé:</label>
              <br>
          <textarea type="text" name="resume" placeholder="Veuillez saisir le résumé de la série" rows="4" cols="52"></textarea>
          <br><br>
          <label>Date de Réalisation :</label>    
    		<input type="date" name="datederealisation">
          <br><br>
          <label>Date de première diffusion :</label>    
          <input type="date" name="datedepremierediffusion">
          <br><br>
           <label>Type de public :</label><br>
          <select id="public" name="public">
				<option value="0">Choisissez le Statut de la Série</option>
				<c:forEach var="pub" items="${listpublic}">
					<option value="${pub}">
						<c:out value="${pub}"/>
					</option>
				</c:forEach>
			</select> 
          <br><br>
           <label>Statut :</label><br>
          <select id="statut" name="statut">
				<option value="0">Choisissez le Statut de la Série</option>
				<c:forEach var="statut" items="${liste}">
					<option value="${statut.id}">
						<c:out value="${statut.libelle}"/>
					</option>
				</c:forEach>
			</select> 
			<br><br>
           <label>Saison :</label><br>
           <select name ="saison" required >
              <option value=" ">Sélectionner le numéro de la saison</option>
              <c:forEach  var="counter" begin="1" end="100">
             <option value="<c:out value="${counter}"/>">${counter}</option>
              </c:forEach>
          </select>
          <br><br>
          <input type="submit" value="Ajouter">
          <div>
            <a href='<c:url value="/accueil"/>'>Retour à l'accueil</a>
        </div>
          
         
      </form>--%>
      </div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>