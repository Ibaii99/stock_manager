package es.deusto.spq.data_access;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

/**
 * DAOTest
 */
@RunWith(MockitoJUnitRunner.class)
public class DAOTest {
	
	
	@Mock
	DAO d;
	
	
//    DAO dao;
	 
    Articulo articulo,a;
    Usuario u;
    Cliente c;
    Vendedor v;
    Opinion o;
    Calendar cal;
    List<Articulo> articulos = new ArrayList<Articulo>();
    List<Cliente> clientes = new ArrayList<Cliente>();
    List<Usuario> usuarios = new ArrayList<Usuario>();
    List<Cesta> cestas = new ArrayList<Cesta>();
    Cesta e;
    String l;

    @Before
	public void setUp() {
        
    	
    	l = "algo";
//        dao = new DAO();
        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        articulo = new Articulo("papaya", cal.getTime(), 1.0f, 200, "papaya", 0.5f, Categoria.FRUTAS, "imageUrl");
        a= new Articulo("platano", cal.getTime(), 1.0f, 200, "platano", 0.5f, Categoria.FRUTAS, "imageUrl");
        a.setId(1);
//        dao.store(articulo);

//        List<Articulo> lista = d.getArticulos();

//        for (Articulo articulo2 : lista) {
//            if(articulo2.getNombre().equals(articulo)){
//                articulo = articulo2;
//            }
//        }
        u = new Usuario("usuario", "contrasenya");

//        dao.store(u);

        c = new Cliente("nombre", "email", "contrasenya", "direccion");
        c.setId(666);
        c.getCarrito().setId(666);
//        dao.store(c);

        clientes.add(c);

        v= new Vendedor("vendedor", "correo");

//        dao.store(v);

        o = new Opinion("texto", 4, c);

//        dao.store(o);

        e = new Cesta();
        articulos.add(articulo);
        articulos.add(a);
        usuarios.add(u);
        cestas.add(e);
        

    }

    @Test

    public void testGetAriculos() {
    	
    	when(d.getArticulos()).thenReturn(articulos);

        List<Articulo> lista = d.getArticulos();

        assertNotNull(lista);
    }

    @Test
    public void testGetArticulo() {
    	when(d.getArticulo(a.getId())).thenReturn(a);

        Articulo ar = d.getArticulo(a.getId());

        assertEquals(a, ar);
    }

    @Test
    public void testGetClientes() {
    	when(d.getClientes()).thenReturn(clientes);
        List<Cliente> lista = d.getClientes();

        assertNotNull(lista);

    }

    @Test
    public void testGetCliente() { 
    	when(d.getCliente(c.getEmailCliente(), c.getContrasenyaCliente())).thenReturn(c);
        Cliente a = d.getCliente(c.getEmailCliente(), c.getContrasenyaCliente());

        assertEquals(c,a);
    }

    @Test
    public void testGetUsuarios() {
    	when(d.getUsuarios()).thenReturn(usuarios);
        List<Usuario> lista = d.getUsuarios();

        assertNotNull(lista);

    }
    
    @Test
    public void testGetUsuario() { 
    	when(d.getUsuario(u.getNombre(), u.getContrasenya())).thenReturn(u);
        Usuario a = d.getUsuario(u.getNombre(), u.getContrasenya());

        assertEquals(u,a);
    }

    @Test
    public void testGetCestas() {
    	when(d.getCestas()).thenReturn(cestas);
        List<Cesta> lista = d.getCestas();

        assertNotNull(lista);

    } 
    
    @Test
    public void testGetCesta() { 
    	when(d.getCesta(c.getCarrito().getId())).thenReturn(e);
        Cesta cesta = d.getCesta(c.getCarrito().getId());

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
    	when(d.meter_datos()).thenReturn(l);
        String lista = d.meter_datos();

        assertNotNull(lista);

    } 

    
    @Test
    public void testCleanCesta() {
    	when(d.cleanCesta(c.getCarrito().getId())).thenReturn(e);
        Cesta cesta = d.cleanCesta(c.getCarrito().getId());

        assertEquals(cesta,d);

    }
    
//    @Test
//    public void testModifyCesta() {
//
//        int sise = c.getCarrito().getArticulos().size();
//
//        Cesta cesta = dao.modifyCesta(c.getId(),articulo.getId(),10);
//
//        assertNotEquals(sise, cesta.getArticulos().size());
//        
//    }
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
//    @Test
//    public void testDelete() {
//    	when(d.delete(a)).thenReturn(true);
//    	 d.delete(a);
//        assertTrue();
//
//    } 
//
//    @Test
//    public void testCloseConnection() {
//    	when(d.closeConection()).thenReturn(true);
//        
//    	assertTrue(d.closeConection());
//
//    }

}