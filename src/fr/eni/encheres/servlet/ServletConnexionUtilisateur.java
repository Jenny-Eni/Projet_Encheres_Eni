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
import fr.eni.encheres.bo.Utilisateur;


@WebServlet("/Connexion/ServletConnexionUtilisateur")
public class ServletConnexionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String connexion = request.getParameter("connect");
		
		if(connexion == null || connexion.isEmpty()) 
			connexion = "Connexion";
			
		if (connexion.equals("S'inscrire - Se Connecter")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connexion/ConnexionUtilisateur.jsp");
			rd.forward(request, response);
		} else if (connexion.equals("Déconnexion")){
			HttpSession session = request.getSession();
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("/ServletPageAccueil");
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
			Utilisateur user = um.afficherUtilisateur(id);
			session.setAttribute("nom", user.getNom());
			session.setAttribute("prenom", user.getPrenom());
			session.setAttribute("admin", user.getAdministrateur());
			session.setAttribute("pseudo", user.getPseudo());
			session.setAttribute("email",user.getEmail());
			session.setAttribute("telephone", user.getTelephone());
			session.setAttribute("rue", user.getRue());
			session.setAttribute("cp", user.getCodePostal());
			session.setAttribute("ville", user.getVille());
			session.setAttribute("password", user.getMotDePasse());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connexion/ConnexionUtilisateur.jsp");
			rd.forward(request, response);
			
		}
	}
}
