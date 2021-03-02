package fr.eni.encheres.bo;

import java.io.Serializable;
import java.time.LocalDate;

public class Encheres implements Serializable {

	private static final long serialVersionUID = 1L;
	private int noUtilisateur;
	private int noArticle;
	private LocalDate dateEnchere;
	private int montantEnchere;
	
	public Encheres() {
		
	}

	public Encheres(int noUtilisateur, int noArticle, LocalDate dateEnchere, int montantEnchere) {
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	
	@Override
	public String toString() {
		return "Encheres [noUtilisateur=" + noUtilisateur + ", noArticle=" + noArticle + ", DateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere +"]";
	}
	
}
