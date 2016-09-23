package edu.m2pgi.azbrocamo.shoes.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.m2pgi.azbrocamo.shoes.model.Article;
import edu.m2pgi.azbrocamo.shoes.model.Categorie;
import edu.m2pgi.azbrocamo.shoes.model.Modele;
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DaoBD {
	  @Inject
	    private Logger log;
	    @PersistenceContext
	    private EntityManager em;

	    @Inject
	    private Event<Modele> modeleEventSrc;
	    @Inject
	    private Event<Categorie> categorieEventSrc;
	    public  void register(){
	    	try{
	    		Categorie categorie1 = new Categorie();
		    	categorie1.setNomCategorie("classiques");
		    	Categorie categorie2 = new Categorie();
		    	categorie2.setNomCategorie("ville");
		    	Categorie categorie3= new Categorie();
		    	categorie3.setNomCategorie("pantoufles");
		    	Categorie categorie4= new Categorie();
		    	categorie4.setNomCategorie("marche");
		    	Categorie categorie5= new Categorie();
		    	categorie5.setNomCategorie("sport");
		    	Modele modele1= new Modele();
		    	modele1.setNomModele("A200");
		    	modele1.setNote(20);
		    	modele1.setPrix(20);
		    	modele1.setPhoto("http://www.chausport.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/8/0/8078-chaussures-converse-chuck-taylor-all-star-haute-vue-interieure.jpg");
		    	modele1.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		    	Modele modele2= new Modele();
		    	modele2.setNomModele("A400");
		    	modele2.setNote(30);
		    	modele2.setPrix(1000);
		    	modele2.setPhoto("http://imworld.aufeminin.com/manage/bloc/D20150601/Chaussure-femme-Escarpin-Dior-112213-XL-163723_XL.jpg");
		    	modele2.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		    	Modele modele3= new Modele();
		    	modele3.setNomModele("A300");
		    	modele3.setNote(20);
		    	modele3.setPrix(800);
		    	modele3.setPhoto("http://www.grandes-chaussures.com/Files/21851/Img/01/Chaussures-grandes-pointures-hommes-Romika-R10L01B2-DxN.jpg");
		    	modele3.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		    	Article article1Modele1 = new Article();
		    	article1Modele1.setCouleur("Bleu");
		    	article1Modele1.setTaille(38);
		    	Article article2Modele1 = new Article();
		    	article2Modele1.setCouleur("Bleu");
		    	article2Modele1.setTaille(44);
		    	Article article3Modele1 = new Article();
		    	article3Modele1.setCouleur("Noir");
		    	article3Modele1.setTaille(44);
		    	Article article4Modele1 = new Article();
		    	article4Modele1.setCouleur("Noir");
		    	article4Modele1.setTaille(39);
		    	Article article1Modele2 = new Article();
		    	article1Modele2.setCouleur("Noir");
		    	article1Modele2.setTaille(38);
		    	Article article2Modele2 = new Article();
		    	article2Modele2.setCouleur("Marron");
		    	article2Modele2.setTaille(40);
		    	em.persist(modele1);
		    	em.persist(modele2);
		    	em.persist(modele3);
		    	em.persist(categorie1);
		    	em.persist(categorie2);
		    	em.persist(categorie3);
		    	em.persist(categorie4);
		    	em.persist(categorie5);
		    	em.persist(article1Modele1);
		    	em.persist(article2Modele1);
		    	em.persist(article3Modele1);
		    	em.persist(article4Modele1);
		    	em.persist(article1Modele2);
		    	em.persist(article2Modele2);
		    	em.flush();
		    	if(modele1 != null && categorie1 != null){
		    		modele1.addCategorie(categorie4);
		    		modele1.addCategorie(categorie5);
		    		modele2.addCategorie(categorie1);
		    		modele2.addCategorie(categorie2);
		    		modele3.addCategorie(categorie1);
		    		categorie1.addModele(modele2);
		    		categorie1.addModele(modele3);
		    		categorie2.addModele(modele2);
			    	categorie4.addModele(modele1);
			    	categorie5.addModele(modele1);
			    	modele1.addArticle(article1Modele1);
		    		modele1.addArticle(article2Modele1);
		    		modele1.addArticle(article3Modele1);
		    		modele1.addArticle(article4Modele1);
		    		modele2.addArticle(article1Modele2);
		    		modele2.addArticle(article2Modele2);
			    	article1Modele1.addModele(modele1);
			    	article2Modele1.addModele(modele1);
			    	article3Modele1.addModele(modele1);
			    	article4Modele1.addModele(modele1);
			    	article1Modele2.addModele(modele2);
			    	article2Modele2.addModele(modele2);
			    	em.merge(modele1);
			    	em.merge(modele2);
			    	em.merge(modele3);
			    	em.merge(categorie1);
			    	em.merge(categorie2);
			    	em.merge(categorie4);
			    	em.merge(categorie5);
			    	em.merge(article1Modele1);
			    	em.merge(article2Modele1);
			    	em.merge(article3Modele1);
			    	em.merge(article4Modele1);
			    	em.merge(article1Modele2);
			    	em.merge(article2Modele2);
			    	em.flush();
		    	}
		    	
		    	
	    	}catch(Exception e){
	             e.printStackTrace();
	    	}
	    }
}
