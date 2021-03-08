package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/Connexion/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connexion/Connexion.jsp");
			rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = null;
		email = request.getParameter("email");
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		if(utilisateurManager.verifierEmail(email)) {
			Utilisateur user = new Utilisateur();
			user = utilisateurManager.afficherUtilisateur(email);
			String pseudo = user.getPseudo();
			String nom = user.getNom();
			String prenom = user.getPrenom();
			String email2 = user.getEmail();
			String telephone = user.getTelephone();
			String rue = user.getRue();
			String cp = user.getCodePostal();
			String ville = user.getVille();
			String mdp = user.getMotDePasse();
			
			request.setAttribute("pseudo", pseudo);
			request.setAttribute("nom", nom);
			request.setAttribute("prenom", prenom);
			request.setAttribute("email", email2);
			request.setAttribute("telephone", telephone);
			request.setAttribute("rue", rue);
			request.setAttribute("cp", cp);
			request.setAttribute("ville", ville);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AffichageUtilisateur/AffichageUtilisateur.jsp");
			rd.forward(request, response);

		}
		
	}

}
