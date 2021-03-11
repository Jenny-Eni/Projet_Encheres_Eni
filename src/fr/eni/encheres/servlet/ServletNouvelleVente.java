package fr.eni.encheres.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;


@WebServlet("/NouvelleVente/ServletNouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieManager cm = new CategorieManager();
		List<Categorie> listCategorie = cm.selectCategorie();
		request.setAttribute("categorie", listCategorie);
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		request.setAttribute("today", s.format(today));
		Date today7 = new Date(today.getTime() + (1000*60*60*24*7));
		request.setAttribute("today7", s.format(today7));
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NouvelleVente/NouvelleVente.jsp");
		rd.forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String article = request.getParameter("article");
		String description = request.getParameter("description");
		int prix = Integer.parseInt(request.getParameter("prix"));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateDebut = LocalDate.parse(request.getParameter("date"), dtf);
		LocalDate dateFin = LocalDate.parse(request.getParameter("datefin"), dtf);
		int categorie = Integer.parseInt(request.getParameter("Categories"));
		HttpSession session = request.getSession();
		int idUser = (int) session.getAttribute("id");
		String message = "";
				
		if (ChronoUnit.DAYS.between(dateDebut, dateFin) == 0) {
			message = "l'enchère ne peut avoir la même date de début et de fin";
		} else 	if (ChronoUnit.DAYS.between(dateDebut, dateFin) < 7 && ChronoUnit.DAYS.between(dateDebut, dateFin) >= 0) {
			message = "Il faut un minimum de 7 jour entre le début de l'enchère et la fin";
		} else if (ChronoUnit.DAYS.between(dateDebut, dateFin) < 0) {
			message = "La date de la fin de l'enchère ne peut être antérieure à celle du début de l'enchère";
		} else if (categorie == 0){
			message = "Merci de choisir une catégorie";
		} else {
			//J'envoie mes donnÃ©es
			try {
				ArticleVenduManager avm = new ArticleVenduManager();
				avm.ajouterArticle(article, description, dateDebut, dateFin, prix, idUser, categorie);
				message = "ok";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("message", message);
		CategorieManager cm = new CategorieManager();
		List<Categorie> listCategorie = cm.selectCategorie();
		request.setAttribute("categorie", listCategorie);
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		request.setAttribute("today", s.format(today));
		Date today7 = new Date(today.getTime() + (1000*60*60*24*7));
		request.setAttribute("today7", s.format(today7));
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NouvelleVente/NouvelleVente.jsp");
		rd.forward(request, response);
	}
}
			

	

	

