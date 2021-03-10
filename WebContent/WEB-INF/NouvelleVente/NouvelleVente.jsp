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
<h1> Nouvelle Vente :</h1>

        <form action="<%=request.getContextPath()%>/NouvelleVente/NouvelleVente" method="post">
		<div>

		<% String idUtilisateur = (String) request.getAttribute("idUtilisateur");%>
		<label for="idUtilisateur">idUtilisateur : </label> <input type="text" name="idUtilisateur" value="<%=idUtilisateur %>"/>
		</div>
        </form>

</body>
</html>