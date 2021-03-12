<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Accueil</title>
</head>
<body>


<div id="d1">
<c:choose>
	<c:when test="${!empty sessionScope.prenom && !empty sessionScope.nom}">
		<p>Bonjour ${sessionScope.prenom} ${sessionScope.nom}</p>
		<c:if test="${sessionScope.admin == true}">
			<form action="<%=request.getContextPath()%>/Administrateur/ServletAdministrateur" method="get">
			<input type="submit" name="connect" value="Administration">
		</form>
		</c:if>
		<form action="<%=request.getContextPath()%>/Connexion/ServletConnexionUtilisateur" method="get">
			<input type="submit" name="connect" value="Déconnexion">
		</form> 
	</c:when>
	<c:otherwise>
		<form action="<%=request.getContextPath()%>/Connexion/ServletConnexionUtilisateur" method="get">
			<input type="submit" name="connect" value="S'inscrire - Se Connecter"/>
		</form>
		
	</c:otherwise>
</c:choose>
</div>
		<c:if test="${!empty sessionScope.id}">
			<form action="<%=request.getContextPath()%>/AffichageUtilisateur/ServletAfficherUtilisateur" method="get">
			<input type="submit"  value="Mon profil"  />
		</form>
		</c:if>
		<c:if test="${!empty sessionScope.id}">
 		<form action="<%=request.getContextPath()%>/NouvelleVente/ServletNouvelleVente" method="get">
			<input type="submit"  value="Vendre un article" />
		</form>
		</c:if>
		
		<c:if test="${!empty sessionScope.id}">
	 		<h2>Liste de mes articles en vente</h2>
			<p>afficher les articles en vente de l'utilisateur (à coder)</p>
		</c:if>


<h2>Liste des enchères</h2>




<div style = "width : 80%; display : block;">
<div style =" width : 33%; padding-top:10px; padding-bottom:10px;border: 3px solid #000000; float : left;">
<%	String nomarticle0 = (String) request.getAttribute("nomarticle0");%>
<div style="margin-left : 275px"><%=nomarticle0 %> </div>
</br>
<%	int prixarticle0 = (int) request.getAttribute("prixarticle0");%>
<div style="margin-left : 275px">Prix : <%=prixarticle0 %> points </div>
</br>
<%	LocalDate datefinarticle0 = (LocalDate) request.getAttribute("datefinarticle0");%>
<div style="margin-left : 275px">Date Fin Enchères : <%=datefinarticle0 %> </div>
</br>
<div style="margin-left : 275px">Vendeur : </div>
</div>
<div style ="width : 33%; padding-top:10px; padding-bottom:10px;border: 3px solid #000000; margin-left : 50px; float : left;">
<%	String nomarticle1 = (String) request.getAttribute("nomarticle1");%>
<div style="margin-left : 275px"><%=nomarticle1 %> </div>
</br>
<%	int prixarticle1 = (int) request.getAttribute("prixarticle1");%>
<div style="margin-left : 275px">Prix : <%=prixarticle1 %> points </div>
</br>
<%	LocalDate datefinarticle1 = (LocalDate) request.getAttribute("datefinarticle1");%>
<div style="margin-left : 275px">Date Fin Enchères : <%=datefinarticle1 %> </div>
</br>
<div style="margin-left : 275px">Vendeur : </div>
</div>
</div>
<div style = "width : 80%; display : block;">
<div style =" width : 33%; padding-top:10px; padding-bottom:10px;border: 3px solid #000000; float : left;">
<%	String nomarticle2 = (String) request.getAttribute("nomarticle2");%>
<div style="margin-left : 275px"><%=nomarticle2 %> </div>
</br>
<%	int prixarticle2 = (int) request.getAttribute("prixarticle2");%>
<div style="margin-left : 275px">Prix : <%=prixarticle2 %> points </div>
</br>
<%	LocalDate datefinarticle2 = (LocalDate) request.getAttribute("datefinarticle2");%>
<div style="margin-left : 275px">Date Fin Enchères : <%=datefinarticle2 %> </div>
</br>
<div style="margin-left : 275px">Vendeur : </div>
</div>
<div style ="width : 33%; padding-top:10px; padding-bottom:10px;border: 3px solid #000000; margin-left : 50px; float : left;">
<%	String nomarticle3 = (String) request.getAttribute("nomarticle3");%>
<div style="margin-left : 275px"><%=nomarticle3 %> </div>
</br>
<%	int prixarticle3 = (int) request.getAttribute("prixarticle3");%>
<div style="margin-left : 275px">Prix : <%=prixarticle3 %> points </div>
</br>
<%	LocalDate datefinarticle3 = (LocalDate) request.getAttribute("datefinarticle3");%>
<div style="margin-left : 275px">Date Fin Enchères : <%=datefinarticle3 %> </div>
</br>
<div style="margin-left : 275px">Vendeur : </div>
</div>
</div>
<div style = "width : 80%; display : block;">
<div style =" width : 33%; padding-top:10px; padding-bottom:10px;border: 3px solid #000000; float : left;">
<%	String nomarticle4 = (String) request.getAttribute("nomarticle4");%>
<div style="margin-left : 275px"><%=nomarticle4 %> </div>
</br>
<%	int prixarticle4 = (int) request.getAttribute("prixarticle4");%>
<div style="margin-left : 275px">Prix : <%=prixarticle4 %> points </div>
</br>
<%	LocalDate datefinarticle4 = (LocalDate) request.getAttribute("datefinarticle4");%>
<div style="margin-left : 275px">Date Fin Enchères : <%=datefinarticle4 %> </div>
</br>
<div style="margin-left : 275px">Vendeur : </div>
</div>
<div style ="width : 33%; padding-top:10px; padding-bottom:10px;border: 3px solid #000000; margin-left : 50px; float : left;">
<%	String nomarticle5 = (String) request.getAttribute("nomarticle5");%>
<div style="margin-left : 275px"><%=nomarticle5 %> </div>
</br>
<%	int prixarticle5 = (int) request.getAttribute("prixarticle5");%>
<div style="margin-left : 275px">Prix : <%=prixarticle5 %> points </div>
</br>
<%	LocalDate datefinarticle5 = (LocalDate) request.getAttribute("datefinarticle5");%>
<div style="margin-left : 275px">Date Fin Enchères : <%=datefinarticle5 %> </div>
</br>
<div style="margin-left : 275px">Vendeur : </div>
</div>
</div>


</body>
</html>