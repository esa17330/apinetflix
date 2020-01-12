<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/ajoutSerie.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Modifier Série</title>
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
<h1 class="title-add">Lire & Modifier Série</h1>
<form action="LireModifSerie" method="post">
  <div class="form-group">
  	
    <input type="text" value="${serie.nom}" class="form-control" name="nom" id="nom" placeholder="Nom">
  </div>
  <div class="form-group">
    <input type="text" value="${serie.nomOriginal}" class="form-control" name="nomoriginal" id="nonoriginal" placeholder="Nom Original">
  </div>
  <div class="form-group">
    <input type="text" value="${serie.anneeParution}" class="form-control" min="1900" max="2059" name="anneeparution" id="anneeparution" placeholder="Année Parution">
  </div>
  <div class="form-group">
    <select class="form-control" id="statut" name="statut">
				<option value="0">Choisissez le Statut de la Série</option>
				<c:forEach var="statut" items="${liste_statut}">
					<option value="${statut.id}"  ${idstatut == statut.id ? "selected" :""} >
						<c:out value="${statut.libelle}"/>
					</option>
				</c:forEach>
			</select> 
  </div>
  
  <div class="form-group">
  <select class="form-control" id="genre" name="genre[]" size=5 multiple="multiple">
     
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
    <select class="form-control" id="pays" name="pays">
      <option value="0">Pays d'Origine</option>
		<c:forEach var="pays" items="${liste_pays}">
			<option value="${pays.id}" ${idpaysorig == pays.id ? "selected" :""} >
				<c:out value="${pays.nom}"/>
			</option>
		</c:forEach>
    </select>
  </div>
  <div class="form-group">
    <textarea placeholder="Synopsis" name="synopsis" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
  </div>
  <div class="align-button">
  <a href="/apiMynetflix/accueil"><button type="button" class="btn btn-primary">Retour accueil</button></a>
  <input type="submit" class="btn btn-danger">Valider</button>
  </div>
</form>
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