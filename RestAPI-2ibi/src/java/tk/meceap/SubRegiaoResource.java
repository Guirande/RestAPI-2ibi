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
import tk.meceap.db.dao.DAORegiao;
import tk.meceap.db.entidade.SubRegiao;
import tk.meceap.db.servico.ServicoSubRegiao;

/**
 * REST Web Service
 *
 * @author guirande
 */
@Path("sub-regiao")
public class SubRegiaoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SubSubRegiaoResource
     */
    public SubRegiaoResource() {
    }

    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRegioes(){
        try {
            List<SubRegiao> subregiaos = new ServicoSubRegiao().getAll();
            
            String json = new Gson().toJson(subregiaos);
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error"+e.toString()).build();
        }
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubRegiao(@PathParam("id") int id){
        try {
            SubRegiao subregiao = new ServicoSubRegiao().get(id);
            
            String json = new Gson().toJson(subregiao);
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error"+e.toString()).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSubRegiao(SubRegiao subregiao){
        try {
            DAORegiao regiao = new DAORegiao();
            subregiao.setRegiao(regiao.get(subregiao.getRegiaoId()));
            
            ServicoSubRegiao servico = new ServicoSubRegiao();
            
            servico.create(subregiao);
            
            subregiao = servico.get(subregiao.getId());
            
            String json = "{\"id\":\""+subregiao.getId() + "\"}";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error"+e.toString()).build();
        }
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSubRegiao(SubRegiao subregiao, @PathParam("id") int id){
        try {
            
            subregiao.setId(id);
            
            new ServicoSubRegiao().update(subregiao);
                       
            String json = "{\"id\":\""+subregiao.getId() + "\"}";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error"+e.toString()).build();
        }
    }
    
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSubRegiao(@PathParam("id") int id){
        try {
            SubRegiao subregiao = new SubRegiao();
            
            subregiao.setId(id);
            
            new ServicoSubRegiao().delete(subregiao);
                       
            String json = "{\"id\":\""+subregiao.getId() + "\"}";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error"+e.toString()).build();
        }
    }
}
