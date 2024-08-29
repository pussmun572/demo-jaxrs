package org.example.demojaxrs;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloResourceTest {

    private static final String BASE_URI = "http://localhost:8080/demo-jaxrs-1.0-SNAPSHOT/api/hello-world";

    @Test
    public void testHelloWorld() {
        // Create a new client
        Client client = ClientBuilder.newClient();

        // Send a GET request to the hello resource
        Response response = client.target(BASE_URI)
                .request(MediaType.TEXT_PLAIN)
                .get();

        // Verify the status code is 200 OK
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        // Verify the response body contains "Hello, World!"
        String responseBody = response.readEntity(String.class);
        System.out.println(responseBody);
        Assertions.assertEquals("Hello, World!", responseBody);

        // Close the client
        client.close();
    }
}

