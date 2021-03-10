package fr.eni.encheres.bll;


import java.sql.SQLException;
import java.time.LocalDate;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.DAOFactory;

public class ArticleVenduManager {
	
	private ArticleVenduDAO articleVenduDAO;
	
	public ArticleVenduManager() {
		this.articleVenduDAO = DAOFactory.getArticleVenduDAO();
	}
	
	public ArticleVendu ajouterArticle(String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitial, int noUtilisateur, int noCategorie) throws SQLException {
		ArticleVendu article = new ArticleVendu();
		article.setNomArticle(nomArticle);
		article.setDescription(description);
		article.setDateDebutEncheres(dateDebutEncheres);
		article.setDateFinEncheres(dateFinEncheres);
		article.setPrixInitial(prixInitial);
		article.setNoUtilisateur(noUtilisateur);
		article.setNoCategorie(noCategorie);
		this.articleVenduDAO.ajouterArticle(article);
		return article;
		}
}
