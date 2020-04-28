package es.deusto.spq;

import java.awt.EventQueue;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import es.deusto.spq.data_access.DAO;


//

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/stock_manager/";
    private static HttpServer server = new HttpServer();
    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in es.deusto.spq package
        final ResourceConfig rc = new ResourceConfig().packages("es.deusto.spq");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
	public static boolean main(String[] args) throws IOException {
		server = startServer();
        DAO dao = new DAO();
        dao.meter_datos();
        
        
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.shutdownNow();
        
        return true;
    }

	public static HttpServer getServer() {
		return server;
	}

	public static void setServer(HttpServer server) {
		Main.server = server;
	}

	
}


