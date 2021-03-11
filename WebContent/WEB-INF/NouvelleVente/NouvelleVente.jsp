<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle Vente</title>
</head>
<body>

<script>
function increase(){
    var a = 1;
    var textBox = document.getElementById("text");
    textBox.value++;
    
}    
function decrease(){
  var textBox = document.getElementById("text");
    textBox.value--;
}
              


</script>
<h1> Nouvelle Vente :</h1>
<div>
<c:choose>
<c:when test="${message != 'ok'}">
	<form action="<%=request.getContextPath()%>/NouvelleVente/ServletNouvelleVente" method="post">
		<div>
			<label for="article">Article : </label>
			<input type="text" id="article" name="article" required/>
		</div>
		<div>
			<label for="idDescription">Description (max 300 caractères) : </label>
			<textarea rows="5" cols="30" id="description" name="description" required maxlength="300"><%=request.getParameter("description")!=null?request.getParameter("description"):""%></textarea>
		</div>
		<div>
			<label for="idCategorie">Catégorie de la vente : </label>
			<select name="Categories" id="Categories">
				<option value="0">--Choisir une catégorie--</option>
	   			<c:forEach var="var" items="${categorie}" >
	    			<option value="${var.noCategorie}">${var.libelle}</option>
	    		</c:forEach>
			</select>
		</div>
		<div>
			<label for="prix">Mise à prix : </label>
			<input type="text" id="text" value="100" name="prix" required><button type="button" onclick="increase()">+</button><button type="button" onclick="decrease()">-</button>
		</div>
		<div>
			<label for="date">Date début : </label>
			<input type="date" id="date" name="date" value="${today}" required min="${today}"/>
		</div>
		<div>
			<label for="datefin">Date fin : </label>
			<input type="date" id="datefin" name="datefin" value="${today7}" required min="${today7}"/>
		</div>
		<input type="submit" value="Valider"/>
		<input type="reset" value="Effacer"/>
	</form>
	<button onclick="window.location.href='<%=request.getContextPath()%>/ServletPageAccueil';">Annuler</button>
		<p>${message}</p>
</c:when>
<c:otherwise>
	<p>L'objet a été ajouté, vous allez être redirigé vers la page d'accueil</p>
	<meta http-equiv="refresh" content="4;url=<%=request.getContextPath()%>/ServletPageAccueil">
</c:otherwise>
</c:choose>
</div>
</body>
</html>