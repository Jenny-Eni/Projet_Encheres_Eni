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
		<ul>
			<li>	
				<label for="idPseudo">Pseudo : </label>
				<input type="text" id="idPseudo" name="pseudo" required/>
			</li>
			<li>
				<label for="idNom">Nom: </label>
				<input type="text" id="idNom" name="nom" required/>
			</li>
			<li>
				<label for="idPrenom">Prénom : </label>
				<input type="text" id="idPrenom" name="prenom" required/>
			</li>
			<li>	
				<label for="idEmail">Email : </label>
				<input type="email" id="idEmail" name="email" required/>
			</li>
			<li>	
				<label for="idTelephone">Téléphone : </label>
				<input type="text" id="idTelephone" name="telephone" required/>
			</li>
			<li>	
				<label for="idPrenom">Rue : </label>
				<input type="text" id="idRue" name="rue" required/>
			</li>
			<li>
				<label for="idCodePostal">Code Postal : </label>
				<input type="text" id="idCodePostal" name="codePostal" required/>
			</li>
			<li>
				<label for="idVille">Ville : </label>
				<input type="text" id="idVille" name="ville" required/>
			</li>
			<li>
				<label for="idPassword">Mot de passe : </label>
				<input type="password" id="idPassword" name="password" required/>
			</li>
			<li>
				<label for="idPassword">Confirmation : </label>
				<input type="password" id="idPassword" name="confirm" required/>
			</li>
			</ul>
	
			<input type="submit" value="Valider"/>
			<input type="submit" value="Annuler"/>
			<input type="reset" value="Effacer"/>
	</form>
</body>
</html>