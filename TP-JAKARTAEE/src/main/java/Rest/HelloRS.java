package Rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("hello")
public class HelloRS {
	
	@GET
	@Path("{nom}/{prenom}")
	public String Hello(@PathParam("nom") String name,@PathParam("prenom") String prenom) {
		
		return String.format("hello  %s %s.", name , prenom);
	}

}
