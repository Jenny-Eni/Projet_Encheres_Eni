package fr.eni.encheres.servlet;

import java.io.IOException;
import java.net.CookieStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UtilisateurManager;


@WebServlet("/Connexion/ServletConnexionUtilisateur")
public class ServletConnexionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("connect").equals("Connexion")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connexion/ConnexionUtilisateur.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("connect").equals("Déconnexion")){
			HttpSession session = request.getSession();
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("/PageAccueilTest.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurManager um = new UtilisateurManager();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int id = um.verifierEmail(email);
		boolean validationPassword = um.verifierPassword(id, password);
		request.setAttribute("id", id);
		request.setAttribute("validationPassword", validationPassword);
		if(id == 0 || !validationPassword) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connexion/ConnexionUtilisateur.jsp");
			rd.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("nom", um.afficherUtilisateur(id).getNom());
			session.setAttribute("prenom", um.afficherUtilisateur(id).getPrenom());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connexion/ConnexionUtilisateur.jsp");
			rd.forward(request, response);
			
		}
	}
}
