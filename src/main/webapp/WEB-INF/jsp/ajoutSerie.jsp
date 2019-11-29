<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="" accept-charset="utf-8" method="post">
       <label>Nom :</label>
          <input type="text" name="nom" required > 
          <br><br>
        <label>Nom Original :</label>
          <input type="text" name="nomoriginal"  >
          <br><br>
          <label>Année de parution :</label>    
          <select name ="anneedeparution" required >
              <option value="">--</option>
              <c:forEach  var="counter" begin="1900" end="2020">
             <option value="<c:out value="${counter}"/>">${counter}</option>
              </c:forEach>
          </select>
          <br><br>
         
          <label>Synopsis:</label>
          <input type="text" name="synopsis" >
          <br><br>
          <label>Statut :</label>
         <select id="statut" name="statut">
				<option value="0">-- Choisissez --</option>
				<c:forEach var="statut" items="${liste}">
					<option value="${statut.id}">
						<c:out value="${statut.libelle}"/>
					</option>
				</c:forEach>
			</select> 
          <br><br>
           <label>Pays</label>
           <select id="pays" name="pays">
				<option value="0">-- Choisissez --</option>
				<c:forEach var="pays" items="${listep}">
					<option value="${pays.id}">
						<c:out value="${pays.nom}"/>
					</option>
				</c:forEach>
			</select>  
         
          <br><br>
          <input type="submit" name="ajouter" value="ajouter">
          
         
      </form>
</body>
</html>