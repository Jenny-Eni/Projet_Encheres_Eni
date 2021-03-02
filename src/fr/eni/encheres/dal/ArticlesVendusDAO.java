package fr.eni.encheres.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.ArticlesVendus;

public interface ArticlesVendusDAO {
	
	public void ajouterArticle(ArticlesVendus articlesVendus, int noUtilisateur) throws SQLException;
	public List<ArticlesVendus> selectArticle() throws SQLException;
	public List<ArticlesVendus> selectArticle(String statut) throws SQLException;
	

}
