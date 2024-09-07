package Rest;

import java.util.List;

import Models.Commune;
import ejd.CommuneEJD;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("commune")
public class CommuneRS {

	
	



   //@Inject
	@EJB
	private CommuneEJD communeEJD;
	
    
    
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public Response P_commune(@FormParam("cp") int cp,@FormParam("nom") String nom) {
		
		Commune c=new Commune(cp,nom);
		long ID=communeEJD.createCommune(c);
		
		return Response.ok(c).status(200,"").build();  
	}
	
	
	
	@GET
	@Path("/{id}")
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public Response findById(@PathParam("id") long id) {
		
		Commune com=communeEJD.findCommuneById(id);
		return Response.ok(com).status(200,"").build();
		
		
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public Response update(@PathParam("id") long id,@FormParam("cp") int cp,@FormParam("nom") String nom) {
		
		Commune com=communeEJD.findCommuneById(id);
			if(com!=null ) {
				com.setName(nom);
				com.setCodePostael(cp);
				communeEJD.update(com);
	            	return Response.ok(com).status(200,"").build();  
			   }else {
				   com=new Commune(id,cp,nom);
				   communeEJD.createCommune(com);
				   return Response.ok(com).status(200,"").build();  
				   
			   }
			
		
	}
	
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	
    public Response deleteCommune(@PathParam("id")long id) {

       if(communeEJD.deleteCommuneById(id)) {

           return Response.status(Status.OK.getStatusCode(),"Commune by id "+id+"isdeleted").build();

       }

       else {

           return Response.status(Status.NOT_FOUND.getStatusCode(),"Commune by id "+id+"Not found").build();

       }

   }
	
	@GET
	@Path("/all")
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public Response findAll() {
		List<Commune> coms=communeEJD.findAllCommune();
		return Response.ok(coms).status(200,"").build();
	}
	
	
    
    
    
}
