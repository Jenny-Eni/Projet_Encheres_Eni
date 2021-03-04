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
import fr.eni.encheres.bo.Categorie;

@WebServlet("/GestionCategories/ServletGestionCategorie")
public class ServletGestionCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/GestionCategories/GestionCategorie.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CategorieManager cm = new CategorieManager();
		String param = request.getParameter("btn");
		String nouvelleCategorie = request.getParameter("nouvelleCategorie");
		
		if (param.equals("Ajouter") && !nouvelleCategorie.equals("saisir cat. à ajouter")) {
			//gérer le retour d'erreur quand on ne mets rien dans la catégorie ou quand on a le message par défaut.
			cm.ajouterCategorie(0, nouvelleCategorie);
		}
			
		// pour supprimer une catégorie il faut d'abord toutes les lister d'où le || (ou)
		if (param.equals("Lister toutes les catégories") || param.equals("Supprimer une catégorie")) {
			List<Categorie> listeCategorie = cm.selectCategorie();
			
			// filtrage des données pour afficher uniquement le libelle de la table Catégorie de la DB
			List<String> categorie = new ArrayList<>();
			for (Categorie cat : listeCategorie) {
				categorie.add(cat.getLibelle());
			}
			
			request.setAttribute("listeCategorie", categorie);
		}
		
					
		if (param.equals("Supprimer")) {
			String cat = (String) request.getParameter("Categories");
			cm.supprimerCategorie(cat);
			//alert("La catégorie " + cat + "a été supprimée de la base de données");
		
		}
				
		doGet(request, response);
	}

}
