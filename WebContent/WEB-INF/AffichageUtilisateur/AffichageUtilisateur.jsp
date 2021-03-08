<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Profil</title>
</head>
<body>
<h1>Mon profil : </h1>
		<form action="<%=request.getContextPath()%>/AffichageUtilisateur/ServletAfficherUtilisateur" method="post" >
		<%	String pseudo = (String) request.getAttribute("pseudo");%>
		<label for="idPseudo">Pseudo : </label> <%=pseudo %>
		<br>
		<%	String nom = (String) request.getAttribute("nom");%>
		<label for="idNom">Nom : </label> <%=nom %>
		<br>
		<%	String prenom = (String) request.getAttribute("prenom");%>
		<label for="idPrenom">Prénom : </label> <%=prenom %>
		<br>
		<%	String email = (String) request.getAttribute("email");%>
		<label for="idEmail">Email : </label> <%=email %>
		<br>
		<%	String telephone = (String) request.getAttribute("telephone");%>
		<label for="idTelephone">Téléphone : </label> <%=telephone %>
		<br>
		<%	String rue = (String) request.getAttribute("rue");%>
		<label for="idrue">Rue : </label> <%=rue %>
		<br>
		<%	String cp = (String) request.getAttribute("cp");%>
		<label for="idcp">Code Postal : </label> <%=cp %>
		<br>
		<%	String ville = (String) request.getAttribute("ville");%>
		<label for="idVille">Ville : </label> <%=ville %>
		
		
</form>
</body>
</html>
