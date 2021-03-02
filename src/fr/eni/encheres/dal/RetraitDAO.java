package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Retrait;

public interface RetraitDAO {

	public void ajoutRetrait(int noArticle, String rue, String codePostal, String ville);
	public Retrait selectRetrait(int noArticle);
	
	
}
