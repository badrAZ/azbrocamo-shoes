package edu.m2pgi.azbrocamo.shoes.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: Modele
 *
 */

@SuppressWarnings("serial")
@Entity
@XmlRootElement
public class Modele implements Serializable {

	   
	@Id
	private String nomModele;
	private Integer note;
	private float prix;
	private String photo;
	@Lob
	private String description;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(mappedBy="modeles", cascade=CascadeType.PERSIST,fetch = FetchType.EAGER)
	 @JsonManagedReference
	private List<Categorie> categories=new ArrayList<Categorie>();

	@OneToMany(mappedBy="modele",fetch = FetchType.EAGER)
	 @JsonManagedReference
	private Set<Article> articles=new HashSet<Article>();
	
	
	public Modele() {
		super();
	}   
	public String getNomModele() {
		return this.nomModele;
	}

	public void setNomModele(String nomModele) {
		this.nomModele = nomModele;
	}   
	public Integer getNote() {
		return this.note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}   
	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}   
	public String getPhoto() {
		return this.photo;
	}
	

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	 public Collection<Categorie> getCategories() {
	        return categories;
	    }
	    
	    public void addCategorie(Categorie categorie) {
	    		 if (!getCategories().contains(categorie)) {
	 	        	getCategories().add(categorie);
	 	        }
	 	        if (!categorie.getModeles().contains(this)) {
	 	        	categorie.getModeles().add(this);
	 	        }
	    }
	    public Set<Article> getArticles() {
	        return articles;
	    }
	    public void addArticle(Article article){
	    	 if (!getArticles().contains(article)) {
	    		 getArticles().add(article);
	 	        }
	    }
}
/*@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="nomCategorie")
private Categorie categorie;*/
/*public Categorie getCategorie(){
return this.categorie;
}
public void setCategorie(Categorie categorie) {
if(this.categorie != null){
	this.categorie.getModeles().remove(this);
}
this.categorie=categorie;
this.categorie.getModeles().add(this);

}*/