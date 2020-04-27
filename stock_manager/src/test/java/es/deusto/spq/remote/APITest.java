package es.deusto.spq.remote;

import javax.validation.constraints.Email;

import com.google.gson.JsonObject;

import org.junit.Before;
import org.junit.Test;

public class APITest {

    JsonObject cliente;

    @Before
	public void setUp(){
        cliente = new JsonObject();
        cliente.addProperty("email", "test@testing.es");
        cliente.addProperty("password", "123");
        cliente.addProperty("name", "test-man");
        cliente.addProperty("address", "TestHouse 22");
    }
    @Test
    public void testRegister() {
        
    }
    @Test
    public void testLogIn() {
        
    }
}