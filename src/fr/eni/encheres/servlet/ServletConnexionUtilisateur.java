package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;


@WebServlet("/Connexion/ServletConnexionUtilisateur")
public class ServletConnexionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private boolean presenceCookieEmailUtilisateur = false;
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connexion/ConnexionUtilisateur.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UtilisateurManager um = new UtilisateurManager();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int id = um.verifierEmail(email);
		boolean validationPassword = um.verifierPassword(id, password);
		if(id == 0 || !validationPassword) {
			System.out.println("Erreur de mot de passe ou d'adresse mail");
		} else {
			System.out.println("Login ok");
		}
	}
}
