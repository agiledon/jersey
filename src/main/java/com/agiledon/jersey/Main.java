package com.agiledon.jersey;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: Zhang Yi
 * Date: 11/15/12
 * Time: 5:03 PM
 */
public class Main {
    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(9998).build();
    }

    public static final URI BASE_URI = getBaseURI();

    protected static HttpServer startServer() throws IOException {
        System.out.println("Starting....");
        ResourceConfig rc = new PackagesResourceConfig("com.agiledon.jersey.resource");
        return GrizzlyServerFactory.createHttpServer(BASE_URI, rc);
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at " +
                "%sapplication.wadl\nTry out %shelloworld\nHit enter to stop it...", BASE_URI, BASE_URI));
        System.in.read();
        server.stop();

    }
}
