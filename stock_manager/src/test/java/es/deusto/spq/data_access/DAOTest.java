package es.deusto.spq.data_access;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.spi.ErrorCode;
import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Cesta;
import es.deusto.spq.data.Cliente;
import es.deusto.spq.data.Opinion;
import es.deusto.spq.data.Usuario;
import es.deusto.spq.data.Vendedor;
import es.deusto.spq.data.Articulo.Categoria;

/**
 * DAOTest
 */
public class DAOTest {

    DAO dao;
    Articulo articulo;
    Usuario u;
    Cliente c;
    Vendedor v;
    Opinion o;
    Calendar cal;

    @Before
	public void setUp() {
        
        dao = new DAO();

        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        articulo = new Articulo("papaya", cal.getTime(), 1.0f, 200, "papaya", 0.5f, Categoria.FRUTAS, "imageUrl");

        dao.store(articulo);

        List<Articulo> lista = dao.getArticulos();

        for (Articulo articulo2 : lista) {
            if(articulo2.getNombre().equals(articulo)){
                articulo = articulo2;
            }
        }

        u = new Usuario("usuario", "contrasenya");

        dao.store(u);

        c = new Cliente("nombre", "email", "contrasenya", "direccion");
        c.setId(666);
        c.getCarrito().setId(666);
        dao.store(c);

        
/*
        v= new Vendedor("vendedor", "correo");

        dao.store(v);

        o = new Opinion("texto", 4, c);

        dao.store(o);
*/
    }

    @Test
    public void testGetAriculos() {
        List<Articulo> lista = dao.getArticulos();

        assertNotNull(lista);
    }

    @Test
    public void testGetAriculo() {

        Articulo a = dao.getArticulo(articulo.getId());

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

        assertNotNull(cesta);
        
    }   
/*
    @Test
    public void testGetVendedores() {

        List<Vendedor> lista = dao.getVendedores();

        assertNotNull(lista);

    }    

    @Test
    public void testGetVendedor() {

        Vendedor vendedor = dao.getVendedor("correo");

        

       assertEquals(v.getNombreVendedor(), vendedor.getNombreVendedor());

    } 
 */   
    @Test
    public void testMeter_datos() {

        String lista = dao.meter_datos();

        assertNotNull(lista);

    } 

    
    @Test
    public void testCleanCesta() {

        Cesta cesta = dao.cleanCesta(c.getCarrito().getId());

        assertEquals(0, cesta.getArticulos().size());

    }
    
    @Test
    public void testModifyCesta() {

        int sise = c.getCarrito().getArticulos().size();

        Cesta cesta = dao.modifyCesta(c.getId(),articulo.getId(),10);

        assertNotEquals(sise, cesta.getArticulos().size());
        
    }
/*
    @Test
    public void testGetOpiniones() {

        List<Opinion> lista = dao.getOpiniones();

        assertNotNull(lista);

    }    

    @Test
    public void testGetOpinion() {

       Opinion opinion = dao.getOpinion(351684);

       assertNull(opinion);

       opinion =  dao.getOpinion(1);;

       assertNotNull(opinion);

    } 
    
*/
    @Test
    public void testDelete() {

        Articulo articulo2 = new Articulo("papaya", cal.getTime(), 1.0f, 200, "papaya", 0.5f, Categoria.FRUTAS, "imageUrl");
        articulo2.setId(999);
        dao.store(articulo2);

        dao.delete(articulo2);

        Articulo a = dao.getArticulo(999);

        assertNull(a);
    } 

    @Test
    public void testCloseConnection() {
        
        dao.closeConection();

    }

}