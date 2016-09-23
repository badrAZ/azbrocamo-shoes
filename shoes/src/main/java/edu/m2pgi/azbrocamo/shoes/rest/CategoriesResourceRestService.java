package edu.m2pgi.azbrocamo.shoes.rest;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.m2pgi.azbrocamo.shoes.data.CategorieRepository;
import edu.m2pgi.azbrocamo.shoes.model.Categorie;
import edu.m2pgi.azbrocamo.shoes.model.Modele;



@Path("/categories")
@RequestScoped
public class CategoriesResourceRestService {
	
	 @Inject
	    private CategorieRepository repository;
	 
	  @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Categorie> listAllModeles() {
	        return repository.findAllOrderedByName();
	    }
	  
	  @GET
	    @Path("/{nomCategorie}")
	    @Produces(MediaType.APPLICATION_JSON)
	  public Set<Modele> lookupModeleByName(@PathParam("nomCategorie") String nomCategorie) {
	        Set<Modele> modele = repository.findCategoriesModeles(nomCategorie);
	        if (modele == null) {
	            throw new WebApplicationException(Response.Status.NOT_FOUND);
	        }
	        return modele;
	    }
}
