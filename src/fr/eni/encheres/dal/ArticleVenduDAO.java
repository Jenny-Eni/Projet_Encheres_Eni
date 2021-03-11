package fr.eni.encheres.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;

public interface ArticleVenduDAO {
	
	public void ajouterArticle(ArticleVendu articleVendu) throws SQLException;
	public List<ArticleVendu> selectArticle() throws SQLException;
	

}
