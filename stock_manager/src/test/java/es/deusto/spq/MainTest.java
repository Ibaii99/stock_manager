//package es.deusto.spq;
//import org.junit.Before;
//import org.junit.Test;
//
//import junit.framework.JUnit4TestAdapter;
//
//import static org.junit.Assert.assertEquals;
//
//import org.glassfish.grizzly.http.server.HttpServer;
//import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
//import org.glassfish.jersey.server.ResourceConfig;
//
//public class MainTest {
//	 private static final String BASE_URI;
//	 private static HttpServer server;
//	 private Main main;
//	 
//	 public static junit.framework.Test suite() {
//			return new JUnit4TestAdapter(Main.class);
//		}
//	 
//	 @Before
//	 public void setUp() throws Exception {
//		 BASE_URI = "http://localhost:8080/stock_manager/";
//		 main = new Main();
//		 
//	 }
//	 
//	 @Test
//	 public void mainTest() throws Exception{
//		 String expected = main.BASE_URI;
//		 assertEquals(expected, BASE_URI);
//	 }
//	 @Test
//	 public void startServer() throws Exception{
//		
//	 }
//			
//}
