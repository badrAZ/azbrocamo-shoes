package edu.m2pgi.azbrocamo.shoes.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.m2pgi.azbrocamo.shoes.service.DaoBD;

@Path("/DAO")
@RequestScoped
public class DaoRestService {
	@Inject
	DaoBD inserting;
	@GET
	 @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createTuple() {
    	inserting.register();
    }
}
