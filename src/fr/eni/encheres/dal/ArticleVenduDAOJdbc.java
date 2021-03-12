package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;

public class ArticleVenduDAOJdbc implements ArticleVenduDAO {
	private static final String SQL_INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?);";
	private static final String SQL_SELECT_ARTICLE = "SELECT * FROM ARTICLES_VENDUS ORDER BY no_article DESC";
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
		List<ArticleVendu> listeArticle = new ArrayList<ArticleVendu>();
		try(Connection cnx = ConnectionProvider.getConnection()){
			try {
				PreparedStatement stmt = null;
		        ResultSet rs = null;
		        stmt = cnx.prepareStatement(SQL_SELECT_ARTICLE);
		        rs = stmt.executeQuery(); 
		        while(rs.next()) {
		        	listeArticle.add(new ArticleVendu(rs.getString("nom_article"), rs.getInt("prix_initial"),rs.getDate("date_fin_encheres").toLocalDate(),rs.getInt("no_utilisateur")));
		        }
		        rs.close();
		        stmt.close();
		        
		        
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeArticle;
	}
	



}
