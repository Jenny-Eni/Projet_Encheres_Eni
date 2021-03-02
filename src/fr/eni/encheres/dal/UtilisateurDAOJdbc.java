package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.encheres.bo.Utilisateurs;


public class UtilisateurDAOJdbc implements UtilisateurDAO{
	
	private static final String SQL_INSERT = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	@Override
	public int ajouterUtilisateur(Utilisateurs utilisateurs) {
		try(Connection cnx = ConnectionProvider.getConnection()){
			try {
				PreparedStatement stmt = null;
		        ResultSet rs = null;
		        stmt = cnx.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
		        stmt.setString(1, utilisateurs.getPseudo());
		        stmt.setString(2, utilisateurs.getNom());
		        stmt.setString(3, utilisateurs.getPrenom());
		        stmt.setString(4, utilisateurs.getEmail());
		        stmt.setString(5, utilisateurs.getTelephone());
		        stmt.setString(6, utilisateurs.getRue());
		        stmt.setString(7, utilisateurs.getCodePostal());
		        stmt.setString(8, utilisateurs.getVille());
		        stmt.setString(9, utilisateurs.getMotDePasse() );
		        stmt.setInt(10, 100);
		        stmt.setBoolean(11, false);
		        stmt.executeUpdate();
		        
		        rs = stmt.getGeneratedKeys();
		        if(rs.next()) {
		        	utilisateurs.setNoUtilisateur(rs.getInt(1));
		        }
		        rs.close();
		        stmt.close();
		        
		        
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return 0;
	}

	@Override
	public void updateUtilisateur(Utilisateurs utilisateurs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerUtilisateur(Utilisateurs utilisateurs) {
		// TODO Auto-generated method stub
		
	}

}
