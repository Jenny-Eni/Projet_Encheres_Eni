<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Accueil</title>
</head>
<body>

<c:choose>
	<c:when test="${!empty sessionScope.prenom && !empty sessionScope.nom}">
		<p>Bonjour ${sessionScope.prenom} ${sessionScope.nom}</p>
		<form action="<%=request.getContextPath()%>/Connexion/ServletConnexionUtilisateur" method="get">
			<input type="submit" name="connect" value="Déconnexion">
		</form> 
	</c:when>
	<c:otherwise>
		<form action="<%=request.getContextPath()%>/Connexion/ServletConnexionUtilisateur" method="get">
			<input type="submit" name="connect" value="Connexion">
		</form>
	</c:otherwise>
</c:choose>



</body>
</html>