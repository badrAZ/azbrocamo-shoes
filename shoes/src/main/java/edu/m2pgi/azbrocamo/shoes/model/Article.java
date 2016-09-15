package edu.m2pgi.azbrocamo.shoes.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Article
 *
 */
@SuppressWarnings("serial")
@Entity
@XmlRootElement
public class Article implements Serializable {

	   
	@Id
	private Integer IdArticle;
	private String nomModele;
	private String couleur;
	private Integer taille;
	private static final long serialVersionUID = 1L;

	public Article() {
		super();
	}   
	public Integer getIdArticle() {
		return this.IdArticle;
	}

	public void setIdArticle(Integer IdArticle) {
		this.IdArticle = IdArticle;
	}   
	public String getNomModele() {
		return this.nomModele;
	}

	public void setNomModele(String nomModele) {
		this.nomModele = nomModele;
	}   
	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}   
	public Integer getTaille() {
		return this.taille;
	}

	public void setTaille(Integer taille) {
		this.taille = taille;
	}
   
}
