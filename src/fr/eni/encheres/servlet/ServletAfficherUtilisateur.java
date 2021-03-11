package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		int idUser=0;
		Utilisateur userAModifier = new Utilisateur();
		HttpSession session = request.getSession();


			
			//Je récupère les données et je construis mon user à modifier
				pseudo = request.getParameter("pseudo_a_modifier");
				userAModifier.setPseudo(pseudo);
				nom = request.getParameter("nom_a_modifier");
				userAModifier.setNom(nom);
				prenom = request.getParameter("prenom_a_modifier");
				userAModifier.setPrenom(prenom);
				email = request.getParameter("email_a_modifier");
				userAModifier.setEmail(email);
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
				idUser = (int) session.getAttribute("id");
				userAModifier.setNoUtilisateur(idUser);
				
			
			//J'envoie mes données
			
			UtilisateurManager nouvelUtilisateur = new UtilisateurManager();
			nouvelUtilisateur.modifierUtilisateur(userAModifier,idUser);
			Utilisateur userARenvoyer = nouvelUtilisateur.afficherUtilisateur(idUser);

			session.setAttribute("nom", userARenvoyer.getNom());
			session.setAttribute("prenom", userARenvoyer.getPrenom());
			session.setAttribute("admin", userARenvoyer.getAdministrateur());
			session.setAttribute("pseudo", userARenvoyer.getPseudo());
			session.setAttribute("email",userARenvoyer.getEmail());
			session.setAttribute("telephone", userARenvoyer.getTelephone());
			session.setAttribute("rue", userARenvoyer.getRue());
			session.setAttribute("cp", userARenvoyer.getCodePostal());
			session.setAttribute("ville", userARenvoyer.getVille());
			session.setAttribute("password", userARenvoyer.getMotDePasse());
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AffichageUtilisateur/AffichageUtilisateur.jsp");
			rd.forward(request, response);

			
			

	}

}
