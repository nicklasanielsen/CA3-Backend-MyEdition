package rest;

import DTOs.MyTimeStampDTO;
import DTOs.RandomFactDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import errorhandling.exceptions.FetchException;
import facades.MyEditionFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import utils.EMF_Creator;

/**
 *
 * @author Nicklas Nielsen
 */
@Path("myEdition")
public class MyEditionResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final MyEditionFacade FACADE = MyEditionFacade.getMyEditionFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Path("timestamp")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimeStamp() {
        MyTimeStampDTO myTimeStampDTO = FACADE.getTimeStamp();
        return Response.ok(myTimeStampDTO).build();
    }

    @GET
    @Path("fact")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRandomFact() throws FetchException {
        RandomFactDTO randomFactDTO = FACADE.getRandomFact();
        return Response.ok(randomFactDTO).build();
    }

}
