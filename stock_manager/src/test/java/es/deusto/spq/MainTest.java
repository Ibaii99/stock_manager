package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import es.deusto.spq.*;

public class MainTest{
	private Main m;
	private Main m1;
	
	
	@Before
	public void setUp() {
		m = new Main();
		m1 = new Main();

		
	}
	@Test
	public void testMain() throws IOException {
		String[] args = null;
		String data = "\n";

		assertEquals(m.getServer().isStarted(), false);
		m = new Main();
		System.setIn(new ByteArrayInputStream( data.getBytes("UTF-8") ));
		m.main(args);
		assertEquals(m.getServer().isStarted(), false);
		
	}
	
	
	@Test
	public void testBASE_URI() {
		assertEquals("http://localhost:8080/stock_manager/", m.BASE_URI);
	}
	
	@Test
	public void testGetServer() {
		assertEquals(m.getServer().isStarted(), false);
	}
	
	@Test
	public void testSetServer() {
		HttpServer a = new HttpServer();
		
		m.setServer(a);
		assertEquals(m.getServer().getServerConfiguration(), a.getServerConfiguration());
	}
	
}
