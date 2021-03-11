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
		<c:if test="${!empty sessionScope.id}">
			<form action="<%=request.getContextPath()%>/AffichageUtilisateur/ServletAfficherUtilisateur" method="get">
			<input type="submit"  value="Mon profil"  />
		</form>
		</c:if>
		<c:if test="${!empty sessionScope.id}">
 		<form action="<%=request.getContextPath()%>/NouvelleVente/ServletNouvelleVente" method="get">
			<input type="submit"  value="Vendre un article" />
		</form>
		</c:if>
		
		<c:if test="${!empty sessionScope.id}">
	 		<h2>Liste de mes articles en vente</h2>
			<p>afficher les articles en vente de l'utilisateur (à coder)</p>
		</c:if>


<h2>Liste des enchères</h2>

<div style = "width : 80%; display : block;">
<div style =" width : 33%; padding-top:10px; padding-bottom:10px;border: 3px solid #000000; text-align : right; float : left;">
<input name="" value="" style="border-style : none" />
</br>
Prix : <input name="" value="" style="border-style : none" />
</br>
Fin de l'enchère : <input name="" value ="" style="border-style : none" />
</br>
Vendeur : <input name="" value="" style="border-style : none" />
</div>
<div style ="width : 33%; padding-top:10px; padding-bottom:10px;border: 3px solid #000000; text-align : right; margin-left : 50px; float : left;">
<input name="" value="" style="border-style : none" />
</br>
Prix : <input name="" value="" style="border-style : none" />
</br>
Fin de l'enchère : <input name="" value ="" style="border-style : none" />
</br>
Vendeur : <input name="" value="" style="border-style : none" />
</div>
</div>
</br>
<div style="width : 80%; display : block; margin-top: 120px;">
<div style ="width : 33%; padding-top:10px; padding-bottom:10px;border: 3px solid #000000; text-align : right; float : left;">
<input name="" value="" style="border-style : none" />
</br>
Prix : <input name="" value="" style="border-style : none" />
</br>
Fin de l'enchère : <input name="" value ="" style="border-style : none" />
</br>
Vendeur : <input name="" value="" style="border-style : none" />
</div>
<div style ="width : 33%; padding-top:10px; padding-bottom:10px;border: 3px solid #000000; text-align : right; margin-left : 50px; float : left;">
<input name="" value="" style="border-style : none" />
</br>
Prix : <input name="" value="" style="border-style : none" />
</br>
Fin de l'enchère : <input name="" value ="" style="border-style : none" />
</br>
Vendeur : <input name="" value="" style="border-style : none" />
</div>
</div>
</br>
<div style="width : 80%; display : block; margin-top: 120px;">
<div style ="width : 33%; padding-top:10px; padding-bottom:10px;border: 3px solid #000000; text-align : right; float : left;">
<input name="" value="" style="border-style : none" />
</br>
Prix : <input name="" value="" style="border-style : none" />
</br>
Fin de l'enchère : <input name="" value ="" style="border-style : none" />
</br>
Vendeur : <input name="" value="" style="border-style : none" />
</div>
<div style ="width : 33%; padding-top:10px; padding-bottom:10px;border: 3px solid #000000; text-align : right; margin-left : 50px; float : left;">
<input name="" value="" style="border-style : none" />
</br>
Prix : <input name="" value="" style="border-style : none" />
</br>
Fin de l'enchère : <input name="" value ="" style="border-style : none" />
</br>
Vendeur : <input name="" value="" style="border-style : none" />
</div>
</div>

</body>
</html>