package edu.m2pgi.azbrocamo.shoes.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.m2pgi.azbrocamo.shoes.model.Categorie;
import edu.m2pgi.azbrocamo.shoes.model.Modele;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ModeleRegistration {
	  @Inject
	    private Logger log;
	    @PersistenceContext
	    private EntityManager em;

	    @Inject
	    private Event<Modele> modeleEventSrc;
	    
	    public void register(Modele modele){
	    	em.persist(modele);
	    	em.flush();
	    }
	    public void remove(String nomModele){
	    	  Modele mod = em.find(Modele.class, nomModele);
	    	  em.remove(mod);
	    }
	    public void addCat(String nomModele,List<String> categories){
	    	 Modele mod = em.find(Modele.class, nomModele);
	    	 for(String nomCategorie:categories){
	    		 Categorie cat=em.find(Categorie.class, nomCategorie);
	    		 mod.addCategorie(cat);
	    	 }
	    	 em.merge(mod);
	    	 em.flush();
	    }
}
