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
		<label for="idPseudo">Pseudo : ${sessionScope.pseudo} </label> 
		<br>
		<label for="idNom">Nom : ${sessionScope.nom} </label>
		<br>
		<label for="idPrenom">Prenom : ${sessionScope.prenom} </label> 
		<br>
		<label for="idEmail">Email : ${sessionScope.email} </label>
		<br>
		<label for="idTelephone">Téléphone : ${sessionScope.telephone} </label> 
		<br>
		<label for="idRue">Rue : ${sessionScope.rue} </label>
		<br>
		<label for="idCp">Code postal : ${sessionScope.cp} </label> 
		<br>
		<label for="idVille">Ville : ${sessionScope.ville} </label>
		<br>
		<label for="idPassword">Mot de passe : ${sessionScope.password} </label> 
		<br>
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
		<label for="idEmail">Email : </label>
		<input type="text" id="idEmail" name="email_a_modifier" value=""/>
		<br/>
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
		</div>
		</form>
		
		

</body>
</html>
