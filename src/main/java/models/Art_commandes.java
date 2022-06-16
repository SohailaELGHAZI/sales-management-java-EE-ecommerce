package models;

import java.util.Date;

public class Art_commandes {
	
	private int codeArt;
	private String nomArt;
	private int prixArt;
	private String descArt;
	private int qteArt; 
	private String image;
	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Art_commandes() {
	}
	
	
	public  Art_commandes(int codeArt,String nomArt, int prixArt,int qteArt,String descArt,String image) {
		this.codeArt=codeArt;
		this.nomArt=nomArt;
		this.prixArt=prixArt;
		this.qteArt=qteArt;
		this.descArt=descArt;
		this.image=image;
	}
	public String getDescArt() {
		return descArt;
	}


	public void setDescArt(String descArt) {
		this.descArt = descArt;
	}


	public  Art_commandes ajouter(int codeArt,String nomArt, int prixArt,int qteArt,String descArt) {
		this.codeArt=codeArt;
		this.nomArt=nomArt;
		this.prixArt=prixArt;
		this.qteArt=qteArt;
		this.descArt=descArt;
		return this;
	}


	public int getCodeArt() {
		return codeArt;
	}


	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}


	public String getNomArt() {
		return nomArt;
	}


	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}


	public int getPrixArt() {
		return prixArt;
	}


	public void setPrixArt(int prixArt) {
		this.prixArt = prixArt;
	}


	public int getQteArt() {
		return qteArt;
	}


	public void setQteArt(int qteArt) {
		this.qteArt = qteArt;
	}
	
	
}