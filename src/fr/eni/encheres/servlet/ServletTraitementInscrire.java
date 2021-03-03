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
	String pseudo = null;
	String nom = null;
	String prenom = null;
	String email = null;
	String telephone = null;
	String rue = null;
	String codePostal = null;
	String ville = null;
	String motDePasse = null;


		
		//Je récupère les données
		
		pseudo = request.getParameter("pseudo");
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		email = request.getParameter("email");
		telephone = request.getParameter("telephone");
		rue = request.getParameter("rue");
		codePostal = request.getParameter("codePostal");
		ville = request.getParameter("ville");
		motDePasse = request.getParameter("password");
		
		
		//J'envoie mes données
		
		UtilisateurManager nouvelUtilisateur = new UtilisateurManager();
		Utilisateur user = nouvelUtilisateur.ajouterUtilisateur(0, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 0, false);

		request.setAttribute("user", user);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/InscriptionUtilisateur/Inscription.jsp");
		rd.forward(request, response);
		doGet(request, response);
	}

}
