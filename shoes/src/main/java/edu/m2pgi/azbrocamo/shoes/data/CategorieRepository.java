package edu.m2pgi.azbrocamo.shoes.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import edu.m2pgi.azbrocamo.shoes.model.Categorie;
import edu.m2pgi.azbrocamo.shoes.model.Modele;


@ApplicationScoped
public class CategorieRepository {
	  @Inject
	    private EntityManager em;
	  public List<Categorie> findAllOrderedByName() {
	        CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Categorie> criteria = cb.createQuery(Categorie.class);
	        Root<Categorie> categorie = criteria.from(Categorie.class);
	        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
	        // feature in JPA 2.0
	        // criteria.select(modele).orderBy(cb.asc(modele.get(modele_.name)));
	        criteria.select(categorie).orderBy(cb.asc(categorie.get("nomCategorie")));
	        return em.createQuery(criteria).getResultList();
	    }
	  public List<Modele> findCategoriesModeles(String nomCategorie){
		  Categorie cat = em.find(Categorie.class, nomCategorie);
		  return (List<Modele>) cat.getModeles();
	  }
}
