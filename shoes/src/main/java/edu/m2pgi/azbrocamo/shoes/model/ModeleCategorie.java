package edu.m2pgi.azbrocamo.shoes.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: ModeleCategorie
 *
 */
@SuppressWarnings("serial")
@Entity
@XmlRootElement
public class ModeleCategorie implements Serializable {
	@Id
	private String nomCategorie;
	
	private String nomModele;
	
	private static final long serialVersionUID = 1L;

	public ModeleCategorie() {
		super();
	}   
	public String getNomModele() {
		return this.nomModele;
	}

	public void setNomModele(String nomModele) {
		this.nomModele = nomModele;
	}   
	public String getNomCategorie() {
		return this.nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
   
}
