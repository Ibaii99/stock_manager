package es.deusto.spq.data_access;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Cesta;
import es.deusto.spq.data.Cliente;
import es.deusto.spq.data.Usuario;
import es.deusto.spq.data.Vendedor;
import es.deusto.spq.data.Articulo.Categoria;

/**
 * DAOTest
 */
public class DAOTest {

    DAO dao;
    long id;
    Articulo articulo;
    Usuario u;
    Cliente c;

    @Before
	public void setUp() {
        
        dao = new DAO();

        id = 0;

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        articulo = new Articulo("papaya", cal.getTime(), 1.0f, 200, "papaya", 0.5f, Categoria.FRUTAS, "imageUrl");

        dao.store(articulo);

        List<Articulo> lista = dao.getArticulos();

        for (Articulo articulo2 : lista) {
            if(articulo2.getNombre().equals(articulo)){
                id = articulo2.getId();
            }
        }

        u = new Usuario("usuario", "contrasenya");

        dao.store(u);

        c = new Cliente("nombre", "email", "contrasenya", "direccion");
        
        dao.store(c);


    }

    @Test
    public void testGetAriculos() {
        List<Articulo> lista = dao.getArticulos();

        assertNotNull(lista);
    }

    @Test
    public void testGetAriculo() {

        Articulo a = dao.getArticulo(id);

        assertEquals(articulo, a);
    }

    @Test
    public void testGetClientes() {

        List<Cliente> lista = dao.getClientes();

        assertNotNull(lista);

    }

    @Test
    public void testGetCliente() { 

        Cliente a = dao.getCliente("email", "contrasenya");

        assertEquals(c.getNombreCliente(), a.getNombreCliente());
    }

    @Test
    public void testGetUsuarios() {

        List<Usuario> lista = dao.getUsuarios();

        assertNotNull(lista);

    }
    
    @Test
    public void testGetUsuario() { 

        Usuario a = dao.getUsuario("usuario", "contrasenya");

        assertEquals(u.getNombre(), a.getNombre());
    }

    @Test
    public void testGetCestas() {

        List<Cesta> lista = dao.getCestas();

        assertNotNull(lista);

    } 
    
    @Test
    public void testGetCesta() { 

        Cesta cesta = dao.getCesta(c.getCarrito().getId());

        assertNotNull(c);

    }   

    @Test
    public void testGetVendedores() {

        List<Vendedor> lista = dao.getVendedores();

        assertNotNull(lista);

    }    
    
    @Test
    public void testMeter_datos() {

        String lista = dao.meter_datos();

        assertNotNull(lista);

    } 

}