package org.example.demojaxrs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.example.demojaxrs.model.User;

import java.util.ArrayList;
import java.util.List;

@Path("/users")

public class UserResource {

    @GET
    @Produces("application/json")
    public List<User> getUser() {
        List<User> users = new ArrayList<>();
        users.add(new User("Håkan"));
        users.add(new User("Pelle"));
        return users;
    }
    @POST
    public Response addUser(User user){
        return Response.ok().entity("user created").build();
    }
}
