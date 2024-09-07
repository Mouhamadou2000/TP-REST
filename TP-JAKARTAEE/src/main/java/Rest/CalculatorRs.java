package Rest;

import java.util.ArrayList;
import java.util.List;

import Models.Calculor;
import Models.Commune;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("Calculator")
public class CalculatorRs {
	
    
	@GET
	@Path("add/{ch1}/{ch2}")
    public Calculor add(@PathParam("ch1") int c1,@PathParam("ch2") int c2) {
		 
		return  Calculor.add(c1, c2);
	}
	
	@GET
	@Path("add")
   public Calculor add1(@QueryParam("a") int c1,@QueryParam("b") int c2) {
		 
		
		return  Calculor.add(c1, c2);
	}
	
	@POST
	@Path("multiply")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public Calculor multiply(@FormParam("a") int c1,@FormParam("b") int c2) {
		 
		
		return  Calculor.multiply(c1, c2);
	}
	
	@POST
	@Path("multiply_2")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public Calculor multiply_2(@FormParam("a") int c1,@FormParam("b") int c2) {
		 
		
		return  Calculor.multiply(c1, c2);
	}
	
	@POST
	@Path("divise")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	//@Produces(MediaType.APPLICATION_JSON)
    public Response divise(@FormParam("a") int c1,@FormParam("b") int c2) {
		 if(c2==0) {
			 return Response.status(400, "Denominateur NULL").build();
		}else {
			 Calculor Cal=Calculor.divise(c1, c2);

			return Response.ok(Cal).status(200,"").build();
		}
		 
		
		
	}
	
	 @GET
		@Path("/{cp}/{nom}")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   public Commune communeRS(@PathParam("cp") int cp,@PathParam("nom") String nom) {
			 
			Commune com= new Commune(cp,nom);
			return  com;
		}
	
	
	

}
