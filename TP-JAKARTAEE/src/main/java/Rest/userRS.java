package Rest;

import Models.User;
import cdi.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("user")
public class userRS {
    @Inject
    private UserService UserCDI;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response P_commune(@FormParam("prenom") String prenom, @FormParam("nom") String nom) {

        User c=new User(prenom,nom);
        long ID= UserCDI.createCommune(c);

        return Response.ok(c).status(200,"").build();
    }

}
