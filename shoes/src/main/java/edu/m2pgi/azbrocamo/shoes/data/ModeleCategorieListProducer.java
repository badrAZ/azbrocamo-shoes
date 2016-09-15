package edu.m2pgi.azbrocamo.shoes.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import edu.m2pgi.azbrocamo.shoes.model.Modele;
import edu.m2pgi.azbrocamo.shoes.model.ModeleCategorie;

@RequestScoped
public class ModeleCategorieListProducer {
	 @Inject
	    private ModeleCategorieRepository modeleCategorieRepository;
	 
	 private List<ModeleCategorie> modeleCategories;

	    // @Named provides access the return value via the EL variable name "modeles" in the UI (e.g.
	    // Facelets or JSP view)
	    @Produces
	    @Named
	    public List<ModeleCategorie> getModelesCategories() {
	        return modeleCategories;
	    }

	    public void onModeleListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Modele modele) {
	        retrieveAllModelesOrderedByName();
	    }

	    @PostConstruct
	    public void retrieveAllModelesOrderedByName() {
	    	modeleCategories = modeleCategorieRepository.findAllOrderedByName();
	    }
}
