package fr.eni.encheres.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bo.ArticleVendu;


@WebServlet("/ServletPageAccueil")
public class ServletPageAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArticleVenduManager am = new ArticleVenduManager();
		try {
			List<ArticleVendu> listeArticleVendu = am.afficherArticle();
			String nomArticle = "nomarticle";
			String prixArticle = "prixarticle";
			String dateFinEnchere = "datefinarticle";
			for(int i = 0; i < 6; i++) {
				String nomArticlePourJSP = nomArticle + i;
				String prixArticlePourJSP = prixArticle + i;
				String dateFinEncherePourJSP = dateFinEnchere +i;
				String nomArticleVendu = listeArticleVendu.get(i).getNomArticle();
				request.setAttribute(nomArticlePourJSP, nomArticleVendu);
				int prixArticleVendu = listeArticleVendu.get(i).getPrixInitial();
				request.setAttribute(prixArticlePourJSP, prixArticleVendu);
				LocalDate dateFinEnchereArticleVendu = listeArticleVendu.get(i).getDateFinEncheres();
				request.setAttribute(dateFinEncherePourJSP, dateFinEnchereArticleVendu);
			}
			
//			List<ArticleVendu> listeArticleVendu = am.afficherArticle();
//			for (ArticleVendu av : listeArticleVendu) {
//				String nomArticle1 = av.getNomArticle();
//				request.setAttribute("nomarticle1", nomArticle1);
//				int prixArticle1 = av.getPrixInitial();
//				LocalDate dateFinArticle1 = av.getDateFinEncheres();
//			}
//			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/PageAccueilTest.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		RequestDispatcher rd = request.getRequestDispatcher("/PageAccueilTest.jsp");
		rd.forward(request, response);
	}

}
