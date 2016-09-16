package edu.m2pgi.azbrocamo.shoes.model;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

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
	/*@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="categorie")
	 private Set<Modele> modeles = new HashSet<Modele>();*/
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
	/*public Set<Modele> getModeles(){
		return this.modeles;
	}*/
	
   
}
