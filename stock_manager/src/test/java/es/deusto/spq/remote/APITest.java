//package es.deusto.spq.remote;
//
//import static org.junit.Assert.assertTrue;
//import es.deusto.spq.data.*;
//import javax.validation.constraints.Email;
//
//import javax.json.JsonObject;
//import javax.json.JsonArray;
//import javax.json.bind.annotation.JsonbTransient;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Request;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.core.MediaType;
//
//import com.google.gson.Gson;
//import com.fasterxml.jackson.annotation.JsonFilter;
//import com.fasterxml.jackson.core.JsonParser;
//
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class APITest {
//
//    Cliente cliente;
//    API api;
//    Gson gson;
//
//    @Before
//	public void setUp(){
//    gson = new Gson();
//    cliente = new Cliente("jon", "jon@gmailcom", "jon", "jon kalea");
//    api = new API();
//    String obj = cliente.toString();
//    JsonObject json = gson.fromJson(obj);
//    api.register(json);
//    }
//    
//    @Test
//    public void testRegister() {
//       assertTrue(api.getUsuarios().contains(json));
//    }
//    @Test
//    public void testLogIn() {
//        
//    }
//}
//package es.deusto.spq.remote;
//
//import javax.validation.constraints.Email;
//
//import com.google.gson.Gson;
//
//import javax.json.JsonObject;
//import javax.json.JsonString;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class APITest {
//
//    String cliente;
//    API api;
//
//    @Before
//	public void setUp(){
//       cliente = "{ \"name\": \"Baeldung\", \"java\": true }";
//
//    }
//    
//    @Test
//    public void testRegister() {
//        String json = "{'id': 1001, "
//        + "'firstName': 'Lokesh',"
//        + "'lastName': 'Gupta',"
//        + "'email': 'howtodoinjava@gmail.com'}";
//        JsonObject convertedObject = new Gson().fromJson(json, JsonObject.class);
//    }
//    @Test
//    public void testLogIn() {
//        
//    }
//    
//}

