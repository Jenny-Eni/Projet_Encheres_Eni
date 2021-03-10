package fr.eni.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Categorie;

@WebServlet("/Administrateur/ServletAdministrateur")
public class ServletAdministrateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Administrateur/Administrateur.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CategorieManager cm = new CategorieManager();
		UtilisateurManager um = new UtilisateurManager();
		String btn = request.getParameter("btn");
		String nouvelleCategorie = request.getParameter("nouvelleCategorie");
				
		if (btn.equals("Ajouter") && !nouvelleCategorie.equals("saisir cat. � ajouter")) {
			cm.ajouterCategorie(0, nouvelleCategorie);
		}
			
		// pour supprimer une cat�gorie il faut d'abord toutes les lister
		if (btn.equals("Lister toutes les cat�gories") || btn.equals("Supprimer une cat�gorie")) {
			List<Categorie> listeCategorie = cm.selectCategorie();
			
			// filtrage des donn�es pour afficher uniquement le libelle de la table Cat�gorie de la DB
			List<String> categorie = new ArrayList<>();
			for (Categorie cat : listeCategorie) {
				categorie.add(cat.getLibelle());
			}
			request.setAttribute("listeCategorie", categorie);
		}
							
		if (btn.equals("Supprimer")) {
			//V�rifier si la cat�gorie � supprimer n'est pas utiliser pour une vente et retourner le message d'erreur
			String cat = (String) request.getParameter("Categories");
			cm.supprimerCategorie(cat);
		}
		
		
		if (btn.equals("D�sactiver un compte")) {
			//Filtrer les utilisateurs actif
			System.out.println("filtre utilisateurs actifs");
			//request.setAttribute("listeUtilisateur", utilisateur);
		}
		
		if (btn.equals("Activer un compte d�sactiv�")) {
			//filtrer les utilisateurs inactifs
			System.out.println("filtre utilisateurs inactifs");
			//request.setAttribute("listeUtilisateur", utilisateur);
		}
		
		if (btn.equals("D�sactiver")) {
			//R�cuperer l'object utilisateur et modifier son nom par le pr�fix * ou "desactivated" en concatenant avec son nom d'origine
			//mets � jour le nom de l'utilisateur
			System.out.println("Utilisateur d�sactiv�");
		}
		
		if (btn.equals("Activer")) {
			//R�cupere l'object utilisateur et modifier son nom en enlevant le prefix de d�sactivation
			//mets � jour le nom de l'utilisateur
			System.out.println("Utilisateur activ�");
		}
		
		if (btn.equals("Supprimer D�finitivement")) {
			//supprime l'utilisateur
			System.out.println("Utilisateur Supprim�");
		}
		
		doGet(request, response);
	}

}
