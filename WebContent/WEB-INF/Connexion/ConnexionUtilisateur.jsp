<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
    </head>
    <body>
        <h1>Connexion</h1>
	<c:choose>
		<c:when test="${!empty sessionScope.prenom && !empty sessionScope.nom}">Connection réussie vous êtes maintenant connecté comme ${sessionScope.prenom} ${sessionScope.nom}
			<p>Vous allez être redirigé automatiquement vers la page d'accueil</p>
			<meta http-equiv="refresh" content="4;url=<%=request.getContextPath()%>/PageAccueilTest.jsp">
		</c:when>
		<c:otherwise>
			<form action="<%=request.getContextPath()%>/Connexion/ServletConnexionUtilisateur" method="post">
			<div>
				<label for="email">Adresse mail : </label>
				<input type="email" id="email" name="email" required/>
			</div>
			<div>	
				<label for="password">Mot de passe: </label>
				<input type="password" id="password" name="password" required/>
			</div>
			<input type="submit" value="Se Connecter"/>
			</form>
			<form action="<%=request.getContextPath()%>/Connexion/ServletCreerUnUtilisateur" method="get">
				<input type="submit" value="Créer un compte"/>
			</form>
			<c:choose>
				<c:when test="${id == 0}">Il n'y a pas de compte avec cette adresse Email</c:when>
				<c:otherwise>
					<c:if test="${validationPassword == false}">Le mot de passe n'est pas correct</c:if>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
		
	</c:choose>
        
    </body>
</html>
