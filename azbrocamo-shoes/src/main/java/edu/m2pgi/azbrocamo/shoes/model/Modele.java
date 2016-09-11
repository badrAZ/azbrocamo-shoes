package edu.m2pgi.azbrocamo.shoes.model;

import java.io.Serializable;
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
	private int note;
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
	public int getNote() {
		return this.note;
	}

	public void setNote(int note) {
		this.note = note;
	}
   
}
