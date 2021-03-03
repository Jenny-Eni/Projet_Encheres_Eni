<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="fr.eni.encheres.bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eni-Encheres - S'inscrire</title>
</head>
<body>
	<h1>Inscription</h1>
	
	<%
Utilisateur ajout = (Utilisateur)request.getAttribute("utilisateur");
%>
		<form action="<%=request.getContextPath()%>/InscriptionUtilisateur/ServletTraitementInscrire" method="post" >
		<label for="idPseudo">Pseudo : </label>
		<input type="text" id="idPseudo" name="pseudo" value="<%=request.getParameter("pseudo")%>"/>
		<br/>
		<label for="idNom">Nom: </label>
		<input type="text" id="idNom" name="nom" value="<%=request.getParameter("nom")%>"/>
		<br/>
		<label for="idPrenom">Prénom : </label>
		<input type="text" id="idPrenom" name="prenom" value="<%=request.getParameter("prenom")%>"/>
		<br/>
		<label for="idEmail">Email : </label>
		<input type="text" id="idEmail" name="email" value="<%=request.getParameter("email")%>"/>
		<br/>
		<label for="idTelephone">Téléphone : </label>
		<input type="text" id="idTelephone" name="telephone" value="<%=request.getParameter("telephone")%>"/>
		<br/>
		<label for="idPrenom">Rue : </label>
		<input type="text" id="idRue" name="rue" value="<%=request.getParameter("rue")%>"/>
		<br/>
		<label for="idCodePostal">Code Postal : </label>
		<input type="text" id="idCodePostal" name="codePostal" value="<%=request.getParameter("codePostal")%>"/>
		<br/>
		<label for="idVille">Ville : </label>
		<input type="text" id="idVille" name="ville" value="<%=request.getParameter("ville")%>"/>
		<br/>
		<label for="idPassword">Mot de passe : </label>
		<input type="password" id="idPassword" name="password" value="<%=request.getParameter("password")%>"/>
		<br/>
		<label for="idPassword">Confirmation : </label>
		<input type="password" id="idPassword" name="password" value="<%=request.getParameter("password")%>"/>
	<br>
		<input type="submit" value="Valider"/>
		<br>
		<input type="reset" value="Annuler"/>
	</form>
</body>
</html>