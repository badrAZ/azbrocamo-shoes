package edu.m2pgi.azbrocamo.shoes.rest;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.m2pgi.azbrocamo.shoes.data.CategorieRepository;
import edu.m2pgi.azbrocamo.shoes.data.ModeleRepository;
import edu.m2pgi.azbrocamo.shoes.model.Categorie;
import edu.m2pgi.azbrocamo.shoes.model.Modele;
import edu.m2pgi.azbrocamo.shoes.service.CategorieRegistration;
import edu.m2pgi.azbrocamo.shoes.service.ModeleRegistration;



@Path("/admin")
@RequestScoped
public class adminRestService {
	@Inject
	 CategorieRegistration registringCategorie;
	 @Inject
	    private CategorieRepository categorieRepository;
	 @Inject
	 ModeleRegistration registringModele;
	 @Inject
	    private ModeleRepository modeleRepository;
	  @GET
	  @Path("/categorie")
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Categorie> listAllCategories() {
	        return categorieRepository.findAllOrderedByName();
	    }
	@POST
	@Path("/categorie")
  	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
  	public void createCategorie(Categorie categorie){
		registringCategorie.register(categorie);
  }
	@DELETE
	@Path("/categorie/{nomCategorie}")
	 @Produces(MediaType.APPLICATION_JSON)
	  public void lookupCategorieByName(@PathParam("nomCategorie") String nomCategorie) {
		registringCategorie.remove(nomCategorie);
	       
	    }
	 @GET
	  @Path("/modele")
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Modele> listAllModeles() {
	        return modeleRepository.findAllOrderedByName();
	    }
	@POST
	@Path("/modele")
 	@Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
 	public void createModele(Modele modele){
		registringModele.register(modele);
 }
	@DELETE
	@Path("/modele/{nomModele}")
	 @Produces(MediaType.APPLICATION_JSON)
	  public void lookupModeleByName(@PathParam("nomModele") String nomModele) {
		registringModele.remove(nomModele);
	       
	    }
	/*@PUT
	@Path("/modele/{nomModele}/{listCategories}")
	@Produces(MediaType.APPLICATION_JSON)
	  public void addModeleCat(@PathParam("nomModele") String nomModele,@PathParam("listCategories") List<String> listCategories) {
			       
	    }*/
	
}
