package edu.m2pgi.azbrocamo.shoes.service;

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
public class CategorieRegistration {
	 @Inject
	    private Logger log;
	    @PersistenceContext
	    private EntityManager em;
	    @Inject
	    private Event<Categorie> categorieEventSrc;
	    
	    public void register(Categorie categorie){
	    	em.persist(categorie);
	    	em.flush();
	    }
	    
}
