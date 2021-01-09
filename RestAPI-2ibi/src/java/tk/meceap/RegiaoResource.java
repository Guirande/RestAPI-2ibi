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
import tk.meceap.db.servico.ServicoRegiao;
import tk.meceap.db.entidade.Regiao;
/**
 * REST Web Service
 *
 * @author guirande
 */
@Path("regiao")
public class RegiaoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RegiaoResource
     */
    public RegiaoResource() {
    }

    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRegioes(){
        try {
            List<Regiao> regiaos = new ServicoRegiao().getAll();
            
            String json = new Gson().toJson(regiaos);
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error"+e.toString()).build();
        }
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRegiao(@PathParam("id") int id){
        try {
            Regiao regiao = new ServicoRegiao().get(id);
            
            String json = new Gson().toJson(regiao);
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error"+e.toString()).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRegiao(Regiao regiao){
        try {
            ServicoRegiao servico = new ServicoRegiao();
            
            servico.create(regiao);
            
            regiao = servico.get(regiao.getId());
            
            String json = "{\"id\":\""+regiao.getId() + "\"}";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error"+e.toString()).build();
        }
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRegiao(Regiao regiao, @PathParam("id") int id){
        try {
            
            regiao.setId(id);
            
            new ServicoRegiao().update(regiao);
                       
            String json = "{\"id\":\""+regiao.getId() + "\"}";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error"+e.toString()).build();
        }
    }
    
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRegiao(@PathParam("id") int id){
        try {
            Regiao regiao = new Regiao();
            
            regiao.setId(id);
            
            new ServicoRegiao().delete(regiao);
                       
            String json = "{\"id\":\""+regiao.getId() + "\"}";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error"+e.toString()).build();
        }
    }
}
