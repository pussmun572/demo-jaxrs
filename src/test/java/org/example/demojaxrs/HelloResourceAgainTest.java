package org.example.demojaxrs;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import org.example.demojaxrs.model.User;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloResourceAgainTest extends JerseyTest {


    @Override
    protected Application configure() {
        forceSet(TestProperties.CONTAINER_PORT, "0");
        return new ResourceConfig(HelloResource.class);
    }


//    @Override
//    protected void configureClient(ClientConfig config) {
//        config.property(ClientProperties.CONNECT_TIMEOUT, 5000);
//        config.property(ClientProperties.READ_TIMEOUT, 5000);
//    }

    @Test
    public void testHelloWorld() {
        Response response = target("/hello-world").request().get();
        assertEquals(200, response.getStatus());
        String responseText = response.readEntity(String.class);
        System.out.println(responseText);
        //System.out.println(response.readEntity(String.class));
        assertEquals("Hello, World!!!", responseText);
    }
    @Test
    public void testGetUsers() {
        Response response = target("/users").request().get();
        List<User> users = response.readEntity(new GenericType<List<User>>() {});

        assertEquals(200, response.getStatus());
        //System.out.println(response.readEntity(String.class));
       // assertEquals("Hello, World!!!", response.readEntity(String.class));
    }
    @Test
    public void addUser(){
        User newUser = new User("Kalle");
/*nedanstående kod skickar en post request mot din resource /users.
    Den postar in din nya användare*/
        Response response = target("/users").request().post(Entity.json(newUser));
        System.out.println(response.readEntity(String.class));
    }
}
