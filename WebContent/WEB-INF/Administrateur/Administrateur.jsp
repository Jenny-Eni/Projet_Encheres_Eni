<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administrateur</title>
<style>
	#content{
  		clear: both;
  		height: 20rem;
  		background-color: #DDD;
  		padding: 1rem;
	}
</style>

</head>
<body>

	
	<div id="content">
	    <h3>Rubrique Gestion des Catégories</h3>
        <h4>Que voulez vous faire ?</h4>
        <form action="<%=request.getContextPath()%>/Administrateur/ServletAdministrateur" method="post">
            <input name="btn" type="submit" value="Ajouter une catégorie"/>
            <input name="btn" type="submit" value="Lister toutes les catégories"/>
            <input name="btn" type="submit" value="Supprimer une catégorie"/>
            <div>
            <c:choose>
                <c:when test="${param.btn eq 'Ajouter une catégorie'}">
                	<input type="text" name="nouvelleCategorie" value="saisir cat. à ajouter">
                	<input name="btn" type="submit" value="Ajouter">
                	
                </c:when>
                 
                 <c:when test="${param.btn eq 'Lister toutes les catégories'}">
                 	<ul>
                 		<c:forEach var="var" items="${listeCategorie}" >
          					<li>${var}</li>
						</c:forEach>
					</ul>	
                </c:when>
                
                <c:when test="${param.btn eq 'Supprimer une catégorie'}">
	                <select name="Categories" id="Categories">
	   					<option value="">--Choisir une catégorie à supprimer--</option>
	    				<c:forEach var="var" items="${listeCategorie}" >
	    					<option value="${var}">${var}</option>
	    				</c:forEach>
					</select>
                   	<input name="btn" type="submit" value="Supprimer">
                   	
                </c:when>
            </c:choose>
            </div>
        </form>
	</div>
	
	
	
	
	<div id="content">
		<h3>Rubrique Gestion des utilisateurs</h3>
        <h4>Que voulez vous faire ?</h4>
	  	<form action="<%=request.getContextPath()%>/Administrateur/ServletAdministrateur" method="post">
            <input name="btn" type="submit" value="Désactiver un compte"/>
            <input name="btn" type="submit" value="Activer un compte désactivé"/>
            <input name="btn" type="submit" value="Supprimer un compte"/>
            <div>
            <c:choose >
                <c:when test="${param.btn eq 'Désactiver un compte'}">
                	
                	<input name="btn" type="submit" value="Désactiver">
                </c:when>
                
                <c:when test="${param.btn eq 'Activer un compte désactivé'}">
                	
                	<input name="btn" type="submit" value="Activer">
                </c:when>
                 
                <c:when test="${param.btn eq 'Supprimer un compte'}">
	                               
                 	<input name="btn" type="submit" value="Supprimer Définitivement">
                </c:when>
            </c:choose>
            </div>
        </form>
	</div>
	

</body>
</html>