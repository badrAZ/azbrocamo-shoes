package edu.m2pgi.azbrocamo.shoes.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

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
	private String description;
	private static final long serialVersionUID = 1L;

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
   
}
