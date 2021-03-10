package fr.eni.encheres.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletAfficherUtilisateur
 */
@WebServlet("/AffichageUtilisateur/ServletAfficherUtilisateur")
public class ServletAfficherUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AffichageUtilisateur/AffichageUtilisateur.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		int idUtilisateur = 0;
		Utilisateur userAModifier = new Utilisateur();


			
			//Je récupère les données et je construis mon user à modifier
				pseudo = request.getParameter("pseudo_a_modifier");
				userAModifier.setPseudo(pseudo);
				nom = request.getParameter("nom_a_modifier");
				userAModifier.setNom(nom);
				prenom = request.getParameter("prenom_a_modifier");
				userAModifier.setPrenom(prenom);
				email = request.getParameter("email");
				telephone = request.getParameter("telephone_a_modifier");
				userAModifier.setTelephone(telephone);
				rue = request.getParameter("rue_a_modifier");
				userAModifier.setRue(rue);
				codePostal = request.getParameter("codePostal_a_modifier");
				userAModifier.setCodePostal(codePostal);
				ville = request.getParameter("ville_a_modifier");
				userAModifier.setVille(ville);
				motDePasse = request.getParameter("password_a_modifier");
				userAModifier.setMotDePasse(motDePasse);
			
			//J'envoie mes données
			
			UtilisateurManager nouvelUtilisateur = new UtilisateurManager();
			nouvelUtilisateur.modifierUtilisateur(userAModifier,email);
			
			Utilisateur user = new Utilisateur();
			user = nouvelUtilisateur.afficherUtilisateur(nouvelUtilisateur.verifierEmail(email));
			 pseudo = user.getPseudo();
			 nom = user.getNom();
			 prenom = user.getPrenom();
			 email = user.getEmail();
			 telephone = user.getTelephone();
			 rue = user.getRue();
			 codePostal = user.getCodePostal();
			 ville = user.getVille();
			 motDePasse = user.getMotDePasse();
			 idUtilisateur = user.getNoUtilisateur();
			 
			request.setAttribute("pseudo", pseudo);
			request.setAttribute("nom", nom);
			request.setAttribute("prenom", prenom);
			request.setAttribute("email", email);
			request.setAttribute("telephone", telephone);
			request.setAttribute("rue", rue);
			request.setAttribute("cp", codePostal);
			request.setAttribute("ville", ville);
			request.setAttribute("idUtilisateur", idUtilisateur);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AffichageUtilisateur/AffichageUtilisateur.jsp");
			rd.forward(request, response);
			
			

	}

}
