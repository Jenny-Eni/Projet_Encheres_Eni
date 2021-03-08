package fr.eni.encheres.dal;

import fr.eni.encheres.bo.*;

public interface UtilisateurDAO {
	
	public void ajouterUtilisateur(Utilisateur utilisateurs);
	public Utilisateur selectUtilisateur(String email);
	public void modifierUtilisateur(Utilisateur userAModifier, String email);
	public void supprimerUtilisateur(Utilisateur utilisateurs);
	public boolean verifierEmail(String email);

}
