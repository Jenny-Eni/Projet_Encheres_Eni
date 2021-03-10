<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Impossible de se connecter</h2>
	<form action="<%=request.getContextPath()%>/Connexion/ServletConnexionUtilisateur" method="get">
		<input type="submit" value="Retour"/>
	</form>
</body>
</html>