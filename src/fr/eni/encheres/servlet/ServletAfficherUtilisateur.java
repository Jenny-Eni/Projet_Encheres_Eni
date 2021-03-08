//package fr.eni.encheres.servlet;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import fr.eni.encheres.bll.UtilisateurManager;
//import fr.eni.encheres.bo.Utilisateur;
//
///**
// * Servlet implementation class ServletAfficherUtilisateur
// */
//@WebServlet("/AffichageUtilisateur/ServletAfficherUtilisateur")
//public class ServletAfficherUtilisateur extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Utilisateur user = new Utilisateur();
//		UtilisateurManager user2 = new UtilisateurManager();
//		user = user2.afficherUtilisateur(email);
//		String pseudo = user.getPseudo();
//		String nom = user.getNom();
//		String prenom = user.getPrenom();
//		String email = user.getEmail();
//		String telephone = user.getTelephone();
//		String rue = user.getRue();
//		String cp = user.getCodePostal();
//		String ville = user.getVille();
//		String mdp = user.getMotDePasse();
//		
//		request.setAttribute("pseudo", pseudo);
//		request.setAttribute("nom", nom);
//		request.setAttribute("prenom", prenom);
//		request.setAttribute("email", email);
//		request.setAttribute("telephone", telephone);
//		request.setAttribute("rue", rue);
//		request.setAttribute("cp", cp);
//		request.setAttribute("ville", ville);
//
//		
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AffichageUtilisateur/AffichageUtilisateur.jsp");
//		rd.forward(request, response);
//
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		
////		doGet(request, response);
//	}
//
//}
