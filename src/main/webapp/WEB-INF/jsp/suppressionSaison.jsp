<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css" contentType="text/css">
<title>Saison</title>
</head>
<body>
<div class="fond">
<form action="" accept-charset="UTF-8" method="post" id="form-saison" >
		<h2>Section Saison</h2>
       <label>Numéro :</label>
       <br>
          <select type="number" name="numero" required > 
          <option value=" ">Sélectionner le numéro</option>
              <c:forEach  var="counter" begin="1" end="100">
             <option value="<c:out value="${counter}"/>">${counter}</option>
              </c:forEach>
          </select>
          <br><br>s
            <label>Série :</label><br>
           <select name ="série" required >
              <option value=" ">Sélectionner le nom de la Série</option>
          	<c:forEach var="serie" items="${nomserie}">
					<option value="${serie}">
						<c:out value="${serie}"/>
					</option>
				</c:forEach>
			</select>
          <br><br>
          <input type="submit" value="Supprimer">
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