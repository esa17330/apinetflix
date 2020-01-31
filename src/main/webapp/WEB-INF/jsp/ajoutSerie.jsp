<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/ajoutSerie.css" contentType="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Ajout Série</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" id="nav">
  <a class="navbar-brand" href="/apiMynetflix/accueil"><img src="images/camera.jpg" alt="camera" id="camera"/></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value="/Serie"/>">Série</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/Saison"/>">Saisons</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/Episode"/>">Episodes</a>
      </li>
    </ul>
  </div>
</nav>
<div class="">
<h1 class="title-add"><img src="images/add.jpg" alt="ajouter" id="ajouter"/>Ajout Série</h1>
<form method="post">
  <div class="form-group">
    <input type="text" class="form-control" name="nom" id="exampleFormControlInput1" placeholder="Nom">
  </div>
  <div class="form-group">
    <input type="text" class="form-control" name="nomoriginal" id="exampleFormControlInput2" placeholder="Nom Original">
  </div>
  <div class="form-group">
    <input type="number" min="1900" max="2059" name="anneedeparution" class="form-control" id="exampleFormControlInput3" placeholder="Année Parution">
  </div>
  <div class="form-group">
    <select class="form-control" id="statut" name="statut">
				<option value="0">Choisissez le Statut de la Série</option>
				<c:forEach var="statut" items="${liste_statut_serie}">
					<option value="${statut.id}">
						<c:out value="${statut.libelle}"/>
					</option>
				</c:forEach>
			</select>
  </div>
  <div class="form-group">
    <select class="form-control" id="genre" name="genre" size=5 multiple="multiple">
     
		<c:forEach var="genre" items="${liste_genre}">
			<option value="${genre.id}" ${idgenre == genre.id ? "selected" :""} >
				<c:out value="${genre.libelle}"/>
			</option>
		</c:forEach>
    </select>
  </div>
  <div class="form-group">
    <input type="text" value="${genresTolibelle}" class="form-control" id="genres" name="genres" disabled="disabled"/>
  </div>
  <div class="form-group">
    <select class="form-control" id="exampleFormControlSelect1" name="pays">
      <option value="0">Pays d'Origine</option>
		<c:forEach var="pays" items="${liste_pays}">
			<option value="${pays.id}">
				<c:out value="${pays.nom}"/>
			</option>
		</c:forEach>
    </select>
  </div>
  <div class="form-group">
    <textarea placeholder="Synopsis" name="synopsis" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
  </div>
  <div class="align-button">
  <button type="submit" class="btn btn-danger">Valider</button>
  </div>
</form>
<%--<form action="" accept-charset="UTF-8" method="post" id="form-serie">
		
       <label>Nom :</label><br>
          <textarea type="text" name="nom" placeholder="Saisir le nom de la série" required rows="1" cols="45" ></textarea>
          <br>
        <label>Nom Original :</label><br>
          <textarea type="text" name="nomoriginal" placeholder="Saisir le nom original" rows="1" cols="37" ></textarea>
          <br>
          <label>Année de parution :</label><br>    
          <input type="number" min="1900" max="2059" />
          
          
          <br>
          <label>Synopsis :</label><br>
          <textarea type="text" name="synopsis" placeholder="Veuillez saisir le résumé de l'épisode" rows="4" cols="52"></textarea>
          <br>
          <label>Statut :</label><br>
			<select id="statut" name="statut">
				<option value="0">Choisissez le Statut de la Série</option>
				<c:forEach var="statut" items="${liste}">
					<option value="${statut.id}">
						<c:out value="${statut.libelle}"/>
					</option>
				</c:forEach>
			</select> 
			<br>
			<label>Pays d'Origine :</label><br>
			<select id="pays" name="pays">
				<option value="0">Choisissez le Pays d'Origine</option>
				<c:forEach var="pays" items="${listep}">
					<option value="${pays.id}">
						<c:out value="${pays.nom}"/>
					</option>
				</c:forEach>
			</select> 
			<br><br>
          <input type="submit" name="ajouter" value="Ajouter" />
          <br>
          <div>
            <a href='<c:url value="/accueil"/>'>Retour à l'accueil</a>
        </div>
      </form>--%>
      </div>
      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script type="application/javascript">

var genre_sel=document.querySelector("select#genre");
	
genre_sel.onchange=function() {
	
	document.querySelector("input#genres").value='';
	var i;   
    
 
for (i=0; i < genre_sel.options.length; i++) 
{
	if (genre_sel.options[i].selected) 
		document.querySelector("input#genres").value+=genre_sel.options[i].label+",";
		
	
} 
}	
</script>


</body>
</html>











