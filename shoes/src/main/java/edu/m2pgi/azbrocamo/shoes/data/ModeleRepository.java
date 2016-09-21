package edu.m2pgi.azbrocamo.shoes.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import edu.m2pgi.azbrocamo.shoes.model.Categorie;
import edu.m2pgi.azbrocamo.shoes.model.Modele;

@ApplicationScoped
public class ModeleRepository {
	  @Inject
	    private EntityManager em;
	
	    public Modele findByName(String nomModele) {
	        return em.find(Modele.class, nomModele);
	    }

	    public List<Modele> findAllOrderedByName() {
	        CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Modele> criteria = cb.createQuery(Modele.class);
	        Root<Modele> modele = criteria.from(Modele.class);
	        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
	        // feature in JPA 2.0
	        // criteria.select(modele).orderBy(cb.asc(modele.get(modele_.name)));
	        criteria.select(modele).orderBy(cb.asc(modele.get("nomModele")));
	        return em.createQuery(criteria).getResultList();
	    }
	    /*public List<Modele> findModelesCategorie(String nomCategorie){
	    	
	    	CriteriaBuilder cb = em.getCriteriaBuilder();
	    	  CriteriaQuery<Modele> criteria = cb.createQuery(Modele.class);
		        Root<Modele> modele = criteria.from(Modele.class);
		        List<Modele> listMod= em.createQuery(criteria).getResultList();
		        List<Modele> newListMod=null;
		        for(Modele mod:listMod){
		        	if(mod.getNomCategorie() == nomCategorie) newListMod.add(mod);
		        	
		        }
		      return newListMod;
	    }*/
	
	  /*  public List<Modele> findModelesByCategorieName(String nomCategorie){
	    	em = emf.createEntityManager();
	    	em.getTransaction().begin();
	    	Query query = em.createQuery("SELECT DISTINCT m FROM Modele m, Categorie c WHERE m = c.modele");
	    	System.out.println();
	    	em.getTransaction().commit();
	    	em.close();
	       return  query.getResultList();

	    }*/
	    
	    
	}

