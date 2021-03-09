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
		<div>
			<label for="email">Adresse mail : </label>
			<input type="email" id="email" name="email" required/>
		</div>
		<div>	
			<label for="password">Mot de passe: </label>
			<input type="password" id="password" name="password" required/>
		</div>
			<input type="submit" value="Se Connecter"/>
        </form>
    </body>
</html>
