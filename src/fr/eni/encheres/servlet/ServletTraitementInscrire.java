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



@WebServlet("/InscriptionUtilisateur/ServletTraitementInscrire")
public class ServletTraitementInscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/InscriptionUtilisateur/Inscription.jsp");
		rd.forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Je récupère les données
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("password");
		String message = null;
		Utilisateur utilisateur = new Utilisateur(0, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 100, false);
		UtilisateurManager um = new UtilisateurManager();
			
		//J'envoie mes données
		if (um.verifierEmail(email) == 0){
			message = "Il y a un compte existant reli� � cet email !";
		} else if (request.getParameter("password").equals(request.getParameter("confirm"))){
			message = "Les mots de passe ne correspondent pas";
		} else {
		
		
		if (request.getParameter("password").equals(request.getParameter("confirm")) && um.verifierEmail(email) == 0) {
			
			Utilisateur user = um.ajouterUtilisateur(0, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 100, false);
		} else {
			
		}
		
		request.setAttribute("message", message);
		doGet(request, response);
		}
	}

}
