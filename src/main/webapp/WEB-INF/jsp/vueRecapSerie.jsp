<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RECAP SERIE</title>
</head>
<body>
	<h3>
		RECAPITULATIF DE LA SERIE
	</h3>
	<div>
		<p><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value ='${commande.datecmd}'/></p>
		<c:set var='id' value='${commande.idcocktail}' />	
		<p> NOM SERIE : <c:out value='${serie}'/></p>
				
		
		
		
		
	</div>
	
	

</body>
</html>