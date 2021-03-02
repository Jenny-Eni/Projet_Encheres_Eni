package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public Utilisateurs ajouterUtilisateur(int noUtilisateur,String pseudo, String nom, String prenom, String email,
										   String telephone, String rue, String codePostal,
										   String ville, String motDePasse, int credit, boolean administrateur) {
		Utilisateurs utilisateurs = new Utilisateurs();
		utilisateurs.setPseudo(pseudo);
		utilisateurs.setNom(nom);
		utilisateurs.setPrenom(prenom);
		utilisateurs.setEmail(email);
		utilisateurs.setTelephone(telephone);
		utilisateurs.setRue(rue);
		utilisateurs.setCodePostal(codePostal);
		utilisateurs.setVille(ville);
		utilisateurs.setMotDePasse(motDePasse);
		utilisateurs.setCredit(100);
		utilisateurs.setAdministrateur(false);
		this.utilisateurDAO.ajouterUtilisateur(utilisateurs);
		return utilisateurs;
		
	}
}
