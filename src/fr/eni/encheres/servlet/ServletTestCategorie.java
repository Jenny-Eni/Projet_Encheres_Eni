package fr.eni.encheres.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bo.Categorie;


@WebServlet("/ServletTestCategorie")
public class ServletTestCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieManager cm = new CategorieManager();
		cm.ajouterCategorie(0, "Pokemon");
		List<Categorie> listeCategorie = cm.selectCategorie();
		for(Categorie c: listeCategorie) {
			System.out.println(c);
		}
		cm.supprimerCategorie("Pokemon");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
