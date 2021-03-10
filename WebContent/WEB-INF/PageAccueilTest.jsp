<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Accueil</title>
</head>
<body>
<c:if test="${!empty utilisateur}">
	Salut ${utilisateur.prenom}
</c:if>

<c:if test="${empty utilisateur}">
	Se connecter
</c:if>



</body>
</html>