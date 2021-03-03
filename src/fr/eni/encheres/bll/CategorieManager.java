package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;

public class CategorieManager {

	private CategorieDAO categorieDAO;
	
	public CategorieManager() {
		this.categorieDAO = DAOFactory.getCategorieDAO();
	}
	
	public void ajouterCategorie(int noCategorie, String libelle) {
		Categorie categorie = new Categorie();
		categorie.setNoCategorie(noCategorie);
		categorie.setLibelle(libelle);
		this.categorieDAO.ajouterCategorie(categorie);
	}
	
	public List<Categorie> selectCategorie(){
		return categorieDAO.selectCategorie();
	}
	
	public void supprimerCategorie(int noCategorie) {
		this.categorieDAO.supprimerCategorie(noCategorie);
	}
	
	public void supprimerCategorie(String libelle) {
		this.categorieDAO.supprimerCategorie(libelle);
	}
}
