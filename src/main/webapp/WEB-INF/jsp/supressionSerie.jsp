<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css" contentType="text/css">

<title>Série</title>
</head>
<body>
<div class="fond">
<form action="" accept-charset="UTF-8" method="post" id="form-serie">
		<h2>Section Série</h2>
       <label>Nom :</label><br>
          <textarea type="text" name="nom" placeholder="Saisir le nom de la série" required rows="1" cols="45" ></textarea>
          <br>
        <label>Nom Original :</label><br>
          <textarea type="text" name="nomoriginal" placeholder="Saisir le nom original" rows="1" cols="37" ></textarea>
          <br>
          <label>Année de parution :</label><br>    
          <select name ="anneedeparution" required >
              <option value=" ">Sélectionner l'Année de Parution</option>
              <c:forEach  var="counter" begin="1900" end="2020">
             <option value="<c:out value="${counter}"/>">${counter}</option>
              </c:forEach>
          </select>
			<br><br>
          <input type="submit" name="supprimer" value="Supprimer" />
          <br>
          <input type="submit" value="Modifier">
          <br>
          <div>
            <a href='<c:url value="/accueil"/>'>Retour à l'accueil</a>
        </div>
      </form>
      </div>
</body>
</html>











