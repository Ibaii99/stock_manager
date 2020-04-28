package es.deusto.spq.remote;

import javax.validation.constraints.Email;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import com.google.gson.Gson;

import es.deusto.spq.data.Cliente;
import es.deusto.spq.data_access.DAO;

import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.bind.annotation.JsonbTransient;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonParser;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class APITest {

    Cliente c;
    String cliente;
    
    @Mock
    API api;
    
    @Mock
    DAO dao;
    
    @Mock
    JsonObject json;

    @Before
	public void setUp(){
    	c = new Cliente("pepe", "pepe@gmail.com", "pepe1234", "pepeshouse");
    	c.setId(1);
    	cliente ="{ \"nombre\": \""+c.getNombreCliente() + "\" }";


    }
    
    @Test
    public void testRegister() {
    	String cl ="{ \"nombre\": \""+c.getNombreCliente() + "\" }";
    	when(api.register(json)).thenReturn("{ \"nombre\": \""+c.getNombreCliente() + "\" }");
       String s = api.register(json);
       assertTrue(s.equals(cl));
    }
    @Test
    public void testLogIn() {
        
    }
    
}