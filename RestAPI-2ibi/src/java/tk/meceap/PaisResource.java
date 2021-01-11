package tk.meceap;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tk.meceap.db.dao.DAOSubRegiao;
import tk.meceap.db.entidade.Pais;
import tk.meceap.db.servico.ServicoPais;

/**
 * REST Web Service
 *
 * @author guirande
 */
@Path("pais")
public class PaisResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PaisResource
     */
    public PaisResource() {
    }

    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaises(){
        try {
            List<Pais> paiss = new ServicoPais().getAll();
            
            String json = new Gson().toJson(paiss);
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("{\"Error\":\""+e.toString()+"\"").build();
        }
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPais(@PathParam("id") int id){
        try {
            Pais pais = new ServicoPais().get(id);
            
            String json = new Gson().toJson(pais);
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("{\"Error\":\""+e.toString()+"\"").build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPais(Pais pais){
        try {
            DAOSubRegiao subRegiao = new DAOSubRegiao();
            pais.setSubRegiao(subRegiao.get(pais.getSubRegiaoId()));
          
            ServicoPais servico = new ServicoPais();
            
            String json = new Gson().toJson(servico.create(pais));
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("{\"Error\":\""+e.toString()+"\"").build();
        }
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePais(Pais pais, @PathParam("id") int id){
        try {
            
            pais.setId(id);
            
            String json = "{\"status\":\""+ (new ServicoPais().update(pais)) + "\"}";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("{\"Error\":\""+e.toString()+"\"").build();
        }
    }
    
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePais(@PathParam("id") int id){
        try {
            Pais pais = new Pais();
            
            pais.setId(id);
            
            String json = "{\"status\":\""+ (new ServicoPais().delete(pais)) + "\"}";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("{\"Error\":\""+e.toString()+"\"").build();
        }
    }
}
