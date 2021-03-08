package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.encheres.bo.Utilisateur;


public class UtilisateurDAOJdbc implements UtilisateurDAO{
	
	private static final String SQL_INSERT = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	private static final String SQL_SELECT = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE email = ?;";
	private static final String SQL_VERIF = "Select email from utilisateurs where email = ?;";
	
	
	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		try(Connection cnx = ConnectionProvider.getConnection()){
			try {
				PreparedStatement stmt = null;
		        ResultSet rs = null;
		        stmt = cnx.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
		        stmt.setString(1, utilisateur.getPseudo());
		        stmt.setString(2, utilisateur.getNom());
		        stmt.setString(3, utilisateur.getPrenom());
		        stmt.setString(4, utilisateur.getEmail());
		        stmt.setString(5, utilisateur.getTelephone());
		        stmt.setString(6, utilisateur.getRue());
		        stmt.setString(7, utilisateur.getCodePostal());
		        stmt.setString(8, utilisateur.getVille());
		        stmt.setString(9, utilisateur.getMotDePasse() );
		        stmt.setInt(10, 100);
		        stmt.setBoolean(11, false);
		        stmt.executeUpdate();
		        
		        rs = stmt.getGeneratedKeys();
		        if(rs.next()) {
		        	utilisateur.setNoUtilisateur(rs.getInt(1));
		        }
		        rs.close();
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
	public void updateUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur selectUtilisateur(String email) {
		try(Connection cnx = ConnectionProvider.getConnection()){
			try {
				PreparedStatement stmt = null;
		        ResultSet rs = null;
		        stmt = cnx.prepareStatement(SQL_SELECT);
		        stmt.setString(1, email);
		        rs = stmt.executeQuery();
		        Utilisateur user = new Utilisateur();
		        while (rs.next()) {
		        user.setNoUtilisateur(rs.getInt("no_utilisateur"));
		        user.setPseudo(rs.getString("pseudo"));
		        user.setNom(rs.getString("nom"));
		        user.setPrenom(rs.getString("prenom"));
		        user.setEmail(rs.getString("email"));
		        user.setTelephone(rs.getString("telephone"));
		        user.setRue(rs.getString("rue"));
		        user.setCodePostal(rs.getString("code_postal"));
		        user.setVille(rs.getString("ville"));
		        user.setMotDePasse(rs.getString("mot_de_passe"));
		        user.setCredit(rs.getInt("credit"));
		        user.setAdministrateur(rs.getBoolean("administrateur"));
		        }
		        rs.close();
		        stmt.close();
				return user;
				
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
			
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		return null;
	}

	}

	@Override
	public boolean verifierEmail(String email) {
		try(Connection cnx = ConnectionProvider.getConnection()){
			try {
				PreparedStatement stmt = null;
				ResultSet rs = null;
		        stmt = cnx.prepareStatement(SQL_VERIF);
		        stmt.setString(1, email);
		        rs = stmt.executeQuery();
		        
		        while (rs.next()) {
		        	return true;
		        }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
		
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
		return false;
	}}
		



		
	

