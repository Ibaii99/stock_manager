package es.deusto.spq.remote;

import javax.validation.constraints.Email;

import com.google.gson.Gson;

import javax.json.JsonObject;
import javax.json.JsonString;0

import org.junit.Before;
import org.junit.Test;

public class APITest {

    String cliente;
    API api;

    @Before
	public void setUp(){
       cliente = "{ \"name\": \"Baeldung\", \"java\": true }";

    }
    /*
    @Test
    public void testRegister() {
        String json = "{'id': 1001, "
        + "'firstName': 'Lokesh',"
        + "'lastName': 'Gupta',"
        + "'email': 'howtodoinjava@gmail.com'}";
        JsonObject convertedObject = new Gson().fromJson(json, JsonObject.class);
    }
    @Test
    public void testLogIn() {
        
    }
    */
}