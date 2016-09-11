package edu.m2pgi.azbrocamo.shoes.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import edu.m2pgi.azbrocamo.shoes.data.ModeleRepository;

import edu.m2pgi.azbrocamo.shoes.model.Modele;

@Path("/modeles")
@RequestScoped
public class ModeleResourceRestService {
	     @Inject
	    private Logger log;

	    @Inject
	    private Validator validator;

	    @Inject
	    private ModeleRepository repository;

	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Modele> listAllModeles() {
	        return repository.findAllOrderedByName();
	    }

	    @GET
	    @Path("/{nomModele:[0-9][0-9]*}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Modele lookupModeleByName(@PathParam("nomModele") String nomModele) {
	        Modele modele = repository.findByName(nomModele);
	        if (modele == null) {
	            throw new WebApplicationException(Response.Status.NOT_FOUND);
	        }
	        return modele;
	    }

}
