package fr.eni.encheres.bo;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;

public class ArticleVendu implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int prixInitial;
	private int prixVente;
	private int noUtilisateur;
	private int noCategorie;
	private String statut;

	
	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public ArticleVendu() {
		
	}
	
	public ArticleVendu( String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitial, int noUtilisateur, int noCategorie)  throws SQLException {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;


	}
	
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitial, int prixVente, int noUtilisateur, int noCategorie)  throws SQLException{
		this(nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, noUtilisateur, noCategorie) ;
		this.prixVente = prixVente;
		this.noArticle = noArticle;
	}

	public ArticleVendu(String nomArticle, int prixInitial, LocalDate dateFinEncheres) {
		this.nomArticle = nomArticle;
		this.prixInitial = prixInitial;
		this.dateFinEncheres = dateFinEncheres;
	
	}

	@Override
	public String toString() {
		return "ArticlesVendus [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" +
				description + ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres +
				", prixInitial=" + prixInitial + ", prixVente=" + prixVente + ", noUtilisateur=" + noUtilisateur +
				", noCategorie=" + noCategorie + "]";
	}
	
}
