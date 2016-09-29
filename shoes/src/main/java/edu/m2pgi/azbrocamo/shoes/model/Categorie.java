package edu.m2pgi.azbrocamo.shoes.model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Categorie
 *
 */
@SuppressWarnings("serial")
@Entity
@XmlRootElement

public class Categorie implements Serializable {

	   
	@Id
	private String nomCategorie;
	
	@ManyToMany (cascade=CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name="CAT_MOD", 
		joinColumns=@JoinColumn(name="nomCategorie"),
		inverseJoinColumns=@JoinColumn(name="nomModele"))
	@JsonIgnore
	private Set<Modele> modeles=new HashSet<Modele>();
	    
	
	private static final long serialVersionUID = 1L;	

	public Categorie() {
		super();
	}   
	public String getNomCategorie() {
		return this.nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	  public void addModele(Modele modele) {
			  if (!getModeles().contains(modele) ) {
		        	getModeles().add(modele);
		      }
			  
		      if (!modele.getCategories().contains(this)) {
		        	modele.getCategories().add(this);
		      }
		  
	        
	    }

	    public Set<Modele> getModeles() {
	        return modeles;
	       
	    }
   
}
/*public Set<Modele> getModeles(){
return this.modeles;
}*/
/*@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="categorie")
private Set<Modele> modeles = new HashSet<Modele>();*/