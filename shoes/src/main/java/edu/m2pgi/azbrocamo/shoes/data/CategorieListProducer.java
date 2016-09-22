package edu.m2pgi.azbrocamo.shoes.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import edu.m2pgi.azbrocamo.shoes.model.Categorie;
import edu.m2pgi.azbrocamo.shoes.model.Modele;

@RequestScoped
public class CategorieListProducer {
	 @Inject
	    private CategorieRepository categorieRepository;
	 private List<Categorie> categories;
	 @Produces
	    @Named
	    public List<Categorie> getCategories() {
	        return categories;
	    }

	    public void onCategorieListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Modele modele) {
	        retrieveAllCategoriesOrderedByName();
	    }

	    @PostConstruct
	    public void retrieveAllCategoriesOrderedByName() {
	    	categories = categorieRepository.findAllOrderedByName();
	    }
}
