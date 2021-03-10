<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eni-Encheres - S'inscrire</title>
</head>
<body>
	<h1>Inscription</h1>
	
		<form action="<%=request.getContextPath()%>/InscriptionUtilisateur/ServletTraitementInscrire" method="post" >
		<ul>
			<li>	
				<label for="idPseudo">Pseudo : </label>
				<c:choose>
				<c:when test="${!empty utilisateur.pseudo}">
					<input type="text" id="idPseudo" name="pseudo" required value="${utilisateur.pseudo}"/>
				</c:when>
				<c:otherwise>
					<input type="text" id="idPseudo" name="pseudo" required/>
				</c:otherwise>
				</c:choose>
				
			</li>
			<li>
				<label for="idNom">Nom: </label>
				<c:choose>
				<c:when test="${!empty utilisateur.nom}">
					<input type="text" id="idNom" name="nom" required value="${utilisateur.nom}"/>
				</c:when>
				<c:otherwise>
					<input type="text" id="idNom" name="nom" required/>
				</c:otherwise>
				</c:choose>
			</li>
			<li>
				<label for="idPrenom">Prénom : </label>
				<c:choose>
				<c:when test="${!empty utilisateur.prenom}">
					<input type="text" id="idPrenom" name="prenom" required value="${utilisateur.prenom}"/>
				</c:when>
				<c:otherwise>
					<input type="text" id="idPrenom" name="prenom" required/>
				</c:otherwise>
				</c:choose>
			</li>
			<li>	
				<label for="idEmail">Email : </label>
				<c:choose>
				<c:when test="${!empty utilisateur.email}">
					<input type="email" id="idEmail" name="email" required value="${utilisateur.email}"/>
				</c:when>
				<c:otherwise>
					<input type="email" id="idEmail" name="email" required/>
				</c:otherwise>
				</c:choose>
			</li>
			<li>	
				<label for="idTelephone">Téléphone : </label>
				<c:choose>
				<c:when test="${!empty utilisateur.telephone}">
					<input type="text" id="idTelephone" name="telephone" required value="${utilisateur.telephone}"/>
				</c:when>
				<c:otherwise>
					<input type="text" id="idTelephone" name="telephone" required/>
				</c:otherwise>
				</c:choose>
			</li>
			<li>	
				<label for="idPrenom">Rue : </label>
				<c:choose>
				<c:when test="${!empty utilisateur.rue}">
					<input type="text" id="idRue" name="rue" required value="${utilisateur.rue}"/>
				</c:when>
				<c:otherwise>
					<input type="text" id="idRue" name="rue" required/>
				</c:otherwise>
				</c:choose>
			</li>
			<li>
				<label for="idCodePostal">Code Postal : </label>
				<c:choose>
				<c:when test="${!empty utilisateur.codePostal}">
					<input type="text" id="idCodePostal" name="codePostal" required value="${utilisateur.codePostal}"/>
				</c:when>
				<c:otherwise>
					<input type="text" id="idCodePostal" name="codePostal" required/>
				</c:otherwise>
				</c:choose>
			</li>
			<li>
				<label for="idVille">Ville : </label>
				<c:choose>
				<c:when test="${!empty utilisateur.ville}">
					<input type="text" id="idVille" name="ville" required value="${utilisateur.ville}"/>
				</c:when>
				<c:otherwise>
					<input type="text" id="idVille" name="ville" required/>
				</c:otherwise>
				</c:choose>
				
			</li>
			<li>
				<label for="idPassword">Mot de passe : </label>
				<input type="password" id="idPassword" name="password" required/>
			</li>
			<li>
				<label for="idPassword">Confirmation du mot de passe: </label>
				<input type="password" id="idPassword" name="confirm" required/>
			</li>
			</ul>
	
			<input type="submit" name="btn" value="Valider"/>
			<input type="reset" value="Effacer"/>
	</form>
	<form action="<%=request.getContextPath()%>/InscriptionUtilisateur/ServletTraitementInscrire" method="post" >	
		<input type="submit" name="btn" value="Annuler"/>
	</form>
	<p>${message}</p>
	<c:if test="${message == 'Utilisateur créé'}">
	<p>Vous allez être redirigé automatiquement vers la page de connection</p>
			<meta http-equiv="refresh" content="4;url=<%=request.getContextPath()%>/Connexion/ServletConnexionUtilisateur">
	
	</c:if>
</body>
</html>