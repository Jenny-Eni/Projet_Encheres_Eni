<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    
    <script>
		function deleteBox() {
		  alert("Catégorie Supprimée");
		}
		function addBox() {
		  alert("Catégorie Ajoutée");
		}
	</script>
	         
        <h1>Rubrique Gestion des Catégories</h1>
        <h3>Que voulez vous faire ?</h3>
        <form action="<%=request.getContextPath()%>/GestionCategories/ServletGestionCategorie" method="post">
            <input name="btn" type="submit" value="Ajouter une catégorie"/>
            <input name="btn" type="submit" value="Lister toutes les catégories"/>
            <input name="btn" type="submit" value="Supprimer une catégorie"/>
            <div>
            <c:choose >
                <c:when test="${param.btn eq 'Ajouter une catégorie'}">
                	<input type="text" name="nouvelleCategorie" value="saisir cat. à ajouter">
                	<input name="btn" type="submit" value="Ajouter" onclick="addBox()">
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
	   					<option value="" disabled>--Choisir une catégorie à supprimer--</option>
	    				<c:forEach var="var" items="${listeCategorie}" >
	    					<option value="${var}">${var}</option>
	    				</c:forEach>
					</select>
                
                 	<input name="btn" type="submit" value="Supprimer" onclick="deleteBox()">
                </c:when>
            </c:choose>
            </div>
        </form>
    </body>
</html>
