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
<div>
<h1>Liste des enchères</h1>
</div>

<div id="d1">
<c:choose>
	<c:when test="${!empty sessionScope.prenom && !empty sessionScope.nom}">
		<p>Bonjour ${sessionScope.prenom} ${sessionScope.nom}</p>
		<c:if test="${sessionScope.admin == true}">
			<form action="<%=request.getContextPath()%>/Administrateur/ServletAdministrateur" method="get">
			<input type="submit" name="connect" value="Administration">
		</form>
		</c:if>
		<form action="<%=request.getContextPath()%>/Connexion/ServletConnexionUtilisateur" method="get">
			<input type="submit" name="connect" value="Déconnexion">
		</form> 
	</c:when>
	<c:otherwise>
		<form action="<%=request.getContextPath()%>/Connexion/ServletConnexionUtilisateur" method="get">
			<input type="submit" name="connect" value="S'inscrire - Se Connecter"/>
		</form>
		
	</c:otherwise>
</c:choose>
</div>
<p>Faudrait cacher ces boutons et les faire afficher seulement quand l'user est connecté (j ai pas réussi on peut voir ca ensemble)
		<form action="<%=request.getContextPath()%>/AffichageUtilisateur/ServletAfficherUtilisateur" method="get">
			<input type="submit"  value="Mon profil"  />
			</form>
 		<form action="<%=request.getContextPath()%>/NouvelleVente/ServletNouvelleVente" method="get">
			<input type="submit"  value="Vendre un article" />
			</form>



</body>
</html>