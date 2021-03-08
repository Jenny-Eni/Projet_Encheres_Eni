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
<script>

function masquer_div(id)
{
	       document.getElementById(id).style.display = 'none';
	}
	
function afficher_div(id)
{
	  if (document.getElementById(id).style.display == 'none')
	  {
	       document.getElementById(id).style.display = 'block';
	  }
	  else
	  {
	       document.getElementById(id).style.display = 'none';
	  }
	}
	
	</script>
<h1>Mon profil : </h1>
	<div id="a_masquer">
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
		<input type="button" id="modifier" value="Modifier" onclick="masquer_div('a_masquer'); afficher_div('a_afficher');" />
		</div>

 <form action="<%=request.getContextPath()%>/AffichageUtilisateur/ServletAfficherUtilisateur" method="post" >
	
		<div id="a_afficher" style= display:none>
		<label for="idPseudo">Pseudo : </label>
		<input type="text" id="idPseudo" name="pseudo_a_modifier" value=""/>
		<br/>
		<label for="idNom">Nom: </label>
		<input type="text" id="idNom" name="nom_a_modifier" value=""/>
		<br/>
		<label for="idPrenom">Prénom : </label>
		<input type="text" id="idPrenom" name="prenom_a_modifier" value=""/>
		<br/>
		<% email = (String) request.getAttribute("email");%>
		<label for="idEmail">Email : </label> <input type="text" name="email" value="<%=email %>"/>
		<br>
		<label for="idTelephone">Téléphone : </label>
		<input type="text" id="idTelephone" name="telephone_a_modifier" value=""/>
		<br/>
		<label for="idPrenom">Rue : </label>
		<input type="text" id="idRue" name="rue_a_modifier" value=""/>
		<br/>
		<label for="idCodePostal">Code Postal : </label>
		<input type="text" id="idCodePostal" name="codePostal_a_modifier" value=""/>
		<br/>
		<label for="idVille">Ville : </label>
		<input type="text" id="idVille" name="ville_a_modifier" value=""/>
		<br/>
		<label for="idPassword">Mot de passe : </label>
		<input type="password" id="idPassword" name="password_a_modifier" value=""/>
		<br/>
		
		<input type="submit" value="Valider"/>
		<input type="button" value="Annuler" onclick="masquer_div('a_afficher'); afficher_div('a_masquer');" />
		</div></form>
		
		
</div>
</body>
</html>
