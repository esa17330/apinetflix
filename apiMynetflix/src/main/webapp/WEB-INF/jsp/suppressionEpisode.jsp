<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css" contentType="text/css">
<title>Episode</title>
</head>
<body>
<div class="fond">
<form action="" accept-charset="UTF-8" method="post" id="form-episode" id="wrap-serie-page">
		<h2>Section Episode</h2>
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
           <label>Saison :</label><br>
           <select name ="saison" required >
              <option value=" ">Sélectionner le numéro de la saison</option>
              <c:forEach  var="counter" begin="1" end="100">
             <option value="<c:out value="${counter}"/>">${counter}</option>
              </c:forEach>
          </select>
          <br><br>
          <input type="submit" value="Supprimer">
          <input type="submit" value="Modifier">
          <br>
          <div>
            <a href='<c:url value="/accueil"/>'>Retour à l'accueil</a>
        </div>
          
         
      </form>
      </div>
</body>
</html>