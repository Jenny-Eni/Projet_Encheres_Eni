<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eni-Encheres - S'inscrire</title>
</head>
<body>
	<h1>Inscription</h1>
	
		<form action="<%=request.getContextPath()%>/InscriptionUtilisateur/ServletTraitementInscrire" method="post" >
		<label for="idPseudo">Pseudo : </label>
		<input type="text" id="idPseudo" name="pseudo" value=""/>
		<br/>
		<label for="idNom">Nom: </label>
		<input type="text" id="idNom" name="nom" value=""/>
		<br/>
		<label for="idPrenom">Prénom : </label>
		<input type="text" id="idPrenom" name="prenom" value=""/>
		<br/>
		<label for="idEmail">Email : </label>
		<input type="text" id="idEmail" name="email" value=""/>
		<br/>
		<label for="idTelephone">Téléphone : </label>
		<input type="text" id="idTelephone" name="telephone" value=""/>
		<br/>
		<label for="idPrenom">Rue : </label>
		<input type="text" id="idRue" name="rue" value=""/>
		<br/>
		<label for="idCodePostal">Code Postal : </label>
		<input type="text" id="idCodePostal" name="codePostal" value=""/>
		<br/>
		<label for="idVille">Ville : </label>
		<input type="text" id="idVille" name="ville" value=""/>
		<br/>
		<label for="idPassword">Mot de passe : </label>
		<input type="password" id="idPassword" name="password" value=""/>
		<br/>
		<label for="idPassword">Confirmation : </label>
		<input type="password" id="idPassword" name="password" value=""/>
	<br>
		<input type="submit" value="Valider"/>
		<br>
		<input type="reset" value="Annuler"/>
	</form>
</body>
</html>