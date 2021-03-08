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
		<input type="text" id="email" name="email" value="<%=request.getParameter("email")%>"/>
		<br/>
		<label for="password">Mot de passe: </label>
		<input type="password" id="password" name="password" value="<%=request.getParameter("password")%>"/>
		<br/>
	<br>
		<input type="submit" value="Valider"/>
        </form>
    </body>
</html>
