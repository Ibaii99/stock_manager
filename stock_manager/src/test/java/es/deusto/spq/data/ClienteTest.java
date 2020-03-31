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
    public void testSetEmail_cliente(String email_cliente) {
        c.setEmail_cliente(email_cliente);
        String email_cambiado = c.getEmail_cliente();
        assertEquals("setEmail", email_cliente, email_cambiado);
    }

	@Test
    public void testGetNombre_cliente() {
		String nombre = c.getNombre_cliente();
		String esperado = "Mikel";
        assertEquals("getNombre", nombre, esperado);
    }

	@Test
	  public void testSetNombre_cliente(String nombre_cliente){
		c.setNombre_cliente(nombre_cliente);
		String nombre = c.getNombre_cliente();
		assertEquals("SetNombre", nombre_cliente,nombre);
  }

    /**
     * @param ID the contrasenya to set
     */
	@Test
    public void testSetID_cliente(int ID) {
        c.setID_cliente(ID);
        int ID_new = c.getID_cliente();
		assertEquals("SetNombre", ID, ID_new);
    }

    /**
     * @param contrasenya the contrasenya to set
     */
	@Test
    public void testSetContrasenya_cliente(String contrasenya) {
        c.setContrasenya_cliente(contrasenya);
        String contrasenya_new = c.getContrasenya_cliente();
		assertEquals("SetContrasenya", contrasenya, contrasenya_new);
    }

    /**
     * @param direccion the direccion to set
     */
	@Test
    public void testSetDireccion_cliente(String direccion) {
       c.setDireccion_cliente(direccion);
       String dir = c.getDireccion_cliente();
		assertEquals("SetDireccion", direccion, dir);
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

   

 
    
	@Test
    public void testEnviarMensajeServicioTecnico(int ID, Vendedor vendedor, String mensaje) {
    	fail("Sin implementar por el momento");
	}

}
