package edu.m2pgi.azbrocamo.shoes.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import edu.m2pgi.azbrocamo.shoes.model.Modele;
import edu.m2pgi.azbrocamo.shoes.model.ModeleCategorie;

@ApplicationScoped
public class ModeleCategorieRepository {
	  @Inject
	    private EntityManager em;
	  	
	    public List<ModeleCategorie> findByName(String nomCategorie) {
	    	CriteriaBuilder cb = em.getCriteriaBuilder();
	    	CriteriaQuery<ModeleCategorie> criteria = cb.createQuery(ModeleCategorie.class);
	    	 Root<ModeleCategorie> modeleCategorie = criteria.from(ModeleCategorie.class);
	        return em.find(ModeleCategorie.class, nomCategorie);
	    }

	    public List<ModeleCategorie> findAllOrderedByName() {
	        CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<ModeleCategorie> criteria = cb.createQuery(ModeleCategorie.class);
	        Root<ModeleCategorie> modeleCategorie = criteria.from(ModeleCategorie.class);
	        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
	        // feature in JPA 2.0
	        // criteria.select(modele).orderBy(cb.asc(modele.get(modele_.name)));
	        criteria.select(modeleCategorie).orderBy(cb.asc(modeleCategorie.get("nomModele")));
	        return em.createQuery(criteria).getResultList();
	    }
	}

