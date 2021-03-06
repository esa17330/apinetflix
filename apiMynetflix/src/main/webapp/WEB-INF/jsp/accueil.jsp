<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/style.css"/>" media="screen">
<title>Accueil</title>
</head>
<body>
<div id="accueil-wrapper">
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
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/Saison"/>">Saisons</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/Episode"/>">Episodes</a>
      </li>
    </ul>
  </div>
</nav>
	<h1 id="title-accueil">My Netflix</h1>
	<div id="img-wrapper">
		<img src="images/photo.JPG" alt="photo" id="photo">
	</div>

	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script type="application/javascript">

function getAjaxRequestObject(){
	var xhr_object = null;

	if(window.XMLHttpRequest) // Firefox
		xhr_object = new XMLHttpRequest();
	else if(window.ActiveXObject) // Internet Explorer
		xhr_object = new ActiveXObject("Microsoft.XMLHTTP");
	else { // XMLHttpRequest non supporté par le navigateur
		alert("Votre navigateur ne gère pas les requêtes Javascript");
		return null;
	}

	return xhr_object;
}


function test_jk() {
	var xmlHttpSeries = getAjaxRequestObject();
	xmlHttpSeries.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			//var lesSeries = JSON.parse(this.responseText);
			//localStorage.setItem("lesSeries",JSON.stringify(lesSeries));
			
			
			
		}
	}
	xmlHttpSeries.open("GET", "accueil?data=series");
	xmlHttpSeries.send();
	}
	


		
test_jk();

	
</script>
</body>
</html>