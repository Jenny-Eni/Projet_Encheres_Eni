package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categorie;

public class CategorieDAOJdbc implements CategorieDAO {
	
	private static final String SQL_INSERT = "INSERT INTO CATEGORIES (libelle) Values (?);";
	private static final String SQL_SELECT = "Select no_categorie, libelle From CATEGORIES ORDER BY libelle;";
	private static final String SQL_DELETE_PAR_NO_CATEGORIE = "DELETE FROM CATEGORIES WHERE no_categorie = ?;";
	private static final String SQL_DELETE_PAR_LIBELLE = "DELETE FROM CATEGORIES WHERE libelle = ?;";

	@Override
	public void ajouterCategorie(Categorie categorie) {
		try(Connection cnx = ConnectionProvider.getConnection()){
			try {
				PreparedStatement stmt = null;
		        ResultSet rs = null;
		        stmt = cnx.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
		        stmt.setString(1, categorie.getLibelle());
		        stmt.executeUpdate();
		        rs = stmt.getGeneratedKeys();
		        if(rs.next()) {
		        	categorie.setNoCategorie(rs.getInt(1));
		        }
		        rs.close();
		        stmt.close();
		        		        
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Categorie> selectCategorie() {
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
		try(Connection cnx = ConnectionProvider.getConnection()){
			try {
				PreparedStatement stmt = null;
		        ResultSet rs = null;
		        stmt = cnx.prepareStatement(SQL_SELECT);
		        rs = stmt.executeQuery();
		        while(rs.next()) {
		        	listeCategorie.add(new Categorie(rs.getInt("no_categorie"), rs.getString("libelle")));
		        }
		        rs.close();
		        stmt.close();
		        
		        
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeCategorie;
	}

	@Override
	public void supprimerCategorie(int noCategorie) {
		try(Connection cnx = ConnectionProvider.getConnection()){
			try {
				PreparedStatement stmt = null;
		        stmt = cnx.prepareStatement(SQL_DELETE_PAR_NO_CATEGORIE);
		        stmt.setInt(1, noCategorie);
		        stmt.executeUpdate();
		        stmt.close();
		        		        
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimerCategorie(String libelle) {
		try(Connection cnx = ConnectionProvider.getConnection()){
			try {
				PreparedStatement stmt = null;
		        stmt = cnx.prepareStatement(SQL_DELETE_PAR_LIBELLE);
		        stmt.setString(1, libelle);
		        stmt.executeUpdate();
		        stmt.close();
		        		        
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
