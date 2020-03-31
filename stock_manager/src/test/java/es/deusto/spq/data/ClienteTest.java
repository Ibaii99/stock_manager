package es.deusto.spq.data;

import static org.junit.Assert.*;

import org.junit.BeforeClass;

import org.junit.Test;

public class ClienteTest {
	
	private static Cliente c = new Cliente(001, "Mikel", "mikelmartinez999@opendeusto.es", "12345", "Universidad de Deusto");
	@Test
	public void testGetEmail_cliente() {
        String email = c.getEmail_cliente();
        String esperado = "mikelmartinez999@opendeusto.es";
        assertEquals("getEmail", email, esperado);
    }
	

	@Test
    public void testGetNombre_cliente() {
		String nombre = c.getNombre_cliente();
		String esperado = "Mikel";
        assertEquals("getNombre", nombre, esperado);
    }





   
    /**
     * @return the ID
     */
	@Test
    public void testGetID() {
		int ID_cliente = c.getID_cliente();
		int esperado = 001;
        assertEquals("getNombre", ID_cliente, esperado);
        
    }

    /**
     * @return the contrasenya
     */
	@Test
    public void testGetContrasenya_cliente() {
        String contraseya = c.getContrasenya_cliente();
        String esperado = "12345";
        assertEquals("getContrasenya", contraseya, esperado);
    }

    /**
     * @return the direccion
     */
	@Test
    public void testGetDireccion_cliente() {
        String dir = c.getDireccion_cliente();
        String esperado = "Universidad de Deusto";
        assertEquals("getDireccion", dir, esperado);
    }

   

 //ddd
    
//	@Test
//    public void testEnviarMensajeServicioTecnico(int ID, Vendedor vendedor, String mensaje) {
//    	fail("Sin implementar por el momento");
//	}

}
