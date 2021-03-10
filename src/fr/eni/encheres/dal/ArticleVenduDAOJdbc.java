package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;

public class ArticleVenduDAOJdbc implements ArticleVenduDAO {
	private static final String SQL_INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?);";

	@Override
	public void ajouterArticle(ArticleVendu articleVendu) throws SQLException {
		try(Connection cnx = ConnectionProvider.getConnection()){
			try {
				PreparedStatement stmt = null;
		        stmt = cnx.prepareStatement(SQL_INSERT_ARTICLE);
		        stmt.setString(1, articleVendu.getNomArticle());
		        stmt.setString(2, articleVendu.getDescription());
		        stmt.setDate(3, java.sql.Date.valueOf(articleVendu.getDateDebutEncheres()));
		        stmt.setDate(4, java.sql.Date.valueOf(articleVendu.getDateFinEncheres()));
		        stmt.setInt(5, articleVendu.getPrixInitial());
		        stmt.setInt(6, articleVendu.getNoUtilisateur());
		        stmt.setInt(7, articleVendu.getNoCategorie());
		        stmt.executeUpdate();

		        stmt.close();
		        cnx.close();
		        
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ArticleVendu> selectArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> selectArticle(String statut) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
