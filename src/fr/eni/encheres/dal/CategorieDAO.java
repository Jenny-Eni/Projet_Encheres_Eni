package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Categorie;

public interface CategorieDAO {

	public void ajouterCategorie(Categorie categorie);
	public List<Categorie> selectCategorie();
	public void supprimerCategorie(int noCategorie);
	public void supprimerCategorie(String libelle);
}
