package fr.eni.encheres.dal;

import fr.eni.encheres.bo.*;

public interface UtilisateurDAO {
	
	public void ajouterUtilisateur(Utilisateur utilisateurs);
	public void updateUtilisateur(Utilisateur utilisateurs);
	public void supprimerUtilisateur(Utilisateur utilisateurs);

}
