package es.deusto.spq.data_access;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Cliente;
import es.deusto.spq.data.Articulo.Categoria;

/**
 * DAOTest
 */
public class DAOTest {

    DAO dao;

    @Before
	public void setUp() {
        
        dao = new DAO();

    }

    @Test
    public void testGetAriculos() {
        List<Articulo> lista = dao.getArticulos();

        assertNotNull(lista);
    }

    @Test
    public void testGetAriculo() {
        
        long id = 0;

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        Articulo articulo = new Articulo("papaya", cal.getTime(), 1.0f, 200, "papaya", 0.5f, Categoria.FRUTAS, "imageUrl");

        dao.store(articulo);

        List<Articulo> lista = dao.getArticulos();

        for (Articulo articulo2 : lista) {
            if(articulo2.getNombre().equals(articulo)){
                id = articulo2.getId();
            }
        }

        Articulo a = dao.getArticulo(id);

        assertEquals(articulo, a);
    }

    @Test
    public void testGetClientes() {

        List<Cliente> lista = dao.getClientes();

        assertNotNull(lista);

    }
    
}