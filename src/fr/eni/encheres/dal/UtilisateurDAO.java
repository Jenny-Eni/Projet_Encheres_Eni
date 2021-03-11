package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.*;

public interface UtilisateurDAO {
	
	public void ajouterUtilisateur(Utilisateur utilisateurs);
	public Utilisateur selectUtilisateur(int no_Utilisateur);
	public void modifierUtilisateur(Utilisateur userAModifier, int noUtilisateur);
	public void supprimerUtilisateur(Utilisateur utilisateurs);
	public List<Utilisateur> selectAllUtilisateur();
	public int verifierEmail(String email);
	public boolean verifierPassword(int noUtilisateur, String password);

}
