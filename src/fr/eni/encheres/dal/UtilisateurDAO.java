package fr.eni.encheres.dal;

import fr.eni.encheres.bo.*;

public interface UtilisateurDAO {
	
	public int ajouterUtilisateur(Utilisateurs utilisateurs);
	public void updateUtilisateur(Utilisateurs utilisateurs);
	public void supprimerUtilisateur(Utilisateurs utilisateurs);

}
