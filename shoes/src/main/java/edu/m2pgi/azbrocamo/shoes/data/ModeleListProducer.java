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

@RequestScoped
public class ModeleListProducer {
	 @Inject
	    private ModeleRepository modeleRepository;
	 
	 private List<Modele> modeles;

	    // @Named provides access the return value via the EL variable name "modeles" in the UI (e.g.
	    // Facelets or JSP view)
	    @Produces
	    @Named
	    public List<Modele> getModeles() {
	        return modeles;
	    }

	    public void onModeleListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Modele modele) {
	        retrieveAllModelesOrderedByName();
	    }

	    @PostConstruct
	    public void retrieveAllModelesOrderedByName() {
	        modeles = modeleRepository.findAllOrderedByName();
	    }
}
