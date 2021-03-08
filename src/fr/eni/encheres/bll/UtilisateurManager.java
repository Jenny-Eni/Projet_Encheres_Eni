package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public Utilisateur ajouterUtilisateur(int noUtilisateur,String pseudo, String nom, String prenom, String email,
										   String telephone, String rue, String codePostal,
										   String ville, String motDePasse, int credit, boolean administrateur) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPseudo(pseudo);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setEmail(email);
		utilisateur.setTelephone(telephone);
		utilisateur.setRue(rue);
		utilisateur.setCodePostal(codePostal);
		utilisateur.setVille(ville);
		utilisateur.setMotDePasse(motDePasse);
		utilisateur.setCredit(100);
		utilisateur.setAdministrateur(false);
		this.utilisateurDAO.ajouterUtilisateur(utilisateur);
		return utilisateur;
		
	}
	
	public boolean verifierEmail(String email) {
		if(utilisateurDAO.verifierEmail(email)) {
			return true;
		}
		return false;
		
	}
	
	public Utilisateur afficherUtilisateur (int noUtilisateur) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur = utilisateurDAO.selectUtilisateur(noUtilisateur);
		return utilisateur;

		
	}


}
