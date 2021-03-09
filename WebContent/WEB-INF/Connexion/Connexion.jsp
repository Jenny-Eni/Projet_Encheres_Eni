<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
    </head>
    <body>
    
    <script>
	</script>
	         
        <h1>Connexion</h1>

        <form action="<%=request.getContextPath()%>/Connexion/ServletConnexion" method="post">
		<label for="email">Adresse mail : </label>
<<<<<<< HEAD
		<input type="email" id="email" name="email" required/>
=======
		<input type="text" id="email" name="email" value=""/>
>>>>>>> branch 'main' of https://github.com/Jenny-Eni/Projet_Encheres_Eni.git
		<br/>
		<label for="password">Mot de passe: </label>
<<<<<<< HEAD
		<input type="password" id="password" name="password" required/>
=======
		<input type="password" id="password" name="password" value=""/>
>>>>>>> branch 'main' of https://github.com/Jenny-Eni/Projet_Encheres_Eni.git
		<br/>
		
	<br>
		<input type="submit" value="Se Connecter"/>
        </form>
    </body>
</html>
