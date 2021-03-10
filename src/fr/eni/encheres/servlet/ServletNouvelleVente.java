package fr.eni.encheres.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bo.ArticleVendu;

/**
 * Servlet implementation class ServletNouvelleVente
 */
@WebServlet("/NouvelleVente/ServletNouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NouvelleVente/NouvelleVente.jsp");
		 rd.forward(request, response);
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
//je dois terminer la partie categorie
				String article=null;
				String description = null;
				int categorie=0;
				int prix=0;
				LocalDate dateDebut = null;
				LocalDate dateFin = null;
				
				
				//Je récupère les données 
				
				article = request.getParameter("article");
				description = request.getParameter("description");
				categorie = 1;
				prix = Integer.parseInt(request.getParameter("prix"));
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				dateDebut = LocalDate.parse(request.getParameter("date"),dtf);
				dateFin = LocalDate.parse(request.getParameter("datefin"), dtf);
				HttpSession session = request.getSession();
				int idUser = (int) session.getAttribute("id");
				
				//J'envoie mes données
				
				ArticleVenduManager avm = new ArticleVenduManager();

					try {
						ArticleVendu av = avm.ajouterArticle(article, description, dateDebut, dateFin, prix, idUser, categorie);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}}
			

	

	

