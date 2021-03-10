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
        <form action="<%=request.getContextPath()%>/NouvelleVente/ServletNouvelleVente" method="post">
		<label for="article">Article : </label>
		<br>
		<input type="text" id="article" name="article" value=""/>
		<br/>
		<br>
		<label for="idDescription">Description: </label>
		<br>
		<textarea rows="5" cols="30" id="description" name="description" ><%=request.getParameter("description")!=null?request.getParameter("description"):""%></textarea>
		<br/>
		<br>
<!-- 		<label for="categorie">Categorie:</label> -->
<!-- 		<br> -->
<!-- 		<button type="button" name="informatique">Informatique</button> -->
<!-- 		<button type="button" name="ameublement">Informatique</button> -->
<!-- 		<button type="button" name="vetement">Informatique</button> -->
<!-- 		<button type="button" name="sportloisirs">Informatique</button> -->
		<br>
		<br>
		<label for="prix">Mise à prix :</label>			 <input type="text" id="text" value="100" name="prix"><button type="button" onclick="increase()">+</button><button type="button" onclick="decrease()">-</button>
		<br>
		<br>
		<label for="date">Date début : </label>
		<input type="date" id="date" name="date" value="<%=request.getParameter("date")%>"/>
		<br/>
		<br>
		<label for="datefin">Date fin : </label>
		<input type="date" id="datefin" name="datefin" value="<%=request.getParameter("date")%>"/>
		<br/>
		<br>	
		<input type="submit" value="Valider"/>    <input type="reset" value="Annuler"/>
			</form>
			</div>



</body>
</html>