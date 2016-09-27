package edu.m2pgi.azbrocamo.shoes.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.m2pgi.azbrocamo.shoes.data.CategorieRepository;
import edu.m2pgi.azbrocamo.shoes.model.Categorie;
import edu.m2pgi.azbrocamo.shoes.service.CategorieRegistration;



@Path("/admin")
@RequestScoped
public class adminRestService {
	@Inject
	 CategorieRegistration registringCategorie;
	 @Inject
	    private CategorieRepository repository;
	 
	  @GET
	  @Path("/categorie")
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Categorie> listAllCategories() {
	        return repository.findAllOrderedByName();
	    }
	@POST
	@Path("/categorie")
  	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
  	public void createCategorie(Categorie categorie){
		registringCategorie.register(categorie);
  }
}
