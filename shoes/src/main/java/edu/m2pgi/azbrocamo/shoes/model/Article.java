package edu.m2pgi.azbrocamo.shoes.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity implementation class for Entity: Article
 *
 */
@SuppressWarnings("serial")
@Entity
@XmlRootElement
public class Article implements Serializable {

	   
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long IdArticle;
	private String couleur;
	private Integer taille;
	
	@ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="nomModele")
	@JsonBackReference
	Modele modele;
	private static final long serialVersionUID = 1L;

	public Article() {
		super();
	}   
	public Long getIdArticle() {
		return this.IdArticle;
	}

	public void setIdArticle(Long IdArticle) {
		this.IdArticle = IdArticle;
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
	
	public Modele getModele(){
		return this.modele;
	}
	public void addModele(Modele modele){
		if(getModele() != modele){
			this.modele=modele;
		}
	}
   
}
