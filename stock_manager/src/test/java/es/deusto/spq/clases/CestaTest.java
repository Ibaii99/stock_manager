package es.deusto.spq.clases;

import static org.junit.Assert.assertEquals;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import es.deusto.spq.clases.Cesta.Estado;



class CombateTest {

    @org.junit.Test
	void testConstructor() {    

        final int idCliente = 0;
        final int idCesta = 999;
        final Articulo a1 = new Articulo(10, "manzana", new Date(2020, 3, 23), 0.23f, 120, "Manzana Naturas", 0.10f, "FRUTA");
        final Articulo a2 = new Articulo(14, "pera", new Date(2020, 3, 23), 0.40f, 120, "Pera Naturas", 0.20f, "FRUTA");
        final Articulo a3 = new Articulo(26, "mandarina", new Date(2020, 3, 23), 0.13f, 120, "Mandarina Naturas", 0.5f, "FRUTA");
        final Articulo a4 = new Articulo(14, "naranja", new Date(2020, 3, 23), 0.40f, 120, "Naranja Naturas", 0.25f, "FRUTA");
        final Articulo a5 = new Articulo(56, "manzana", new Date(2020, 3, 23), 0.23f, 120, "Manzana Naturas", 0.10f, "FRUTA");
        Cesta cesta = new Cesta(idCesta, idCliente, Estado.ACTUAL);

        cesta.addArticulo(a1, 40);
        cesta.addArticulo(a2, 30);
        cesta.addArticulo(a3, 30);

        HashMap<Articulo,Integer> a = new HashMap<Articulo,Integer>();
        a.put(a1, 40);
        a.put(a2, 30);
        a.put(a3, 30);

        assertEquals(idCliente, cesta.getIDCliente());
        assertEquals(idCesta, cesta.getID_cesta());
        assertEquals(a, cesta.getArticulos());

        cesta.addArticulo(a4, 80);
        cesta.addArticulo(a5, 30);
        cesta.addArticulo(a3, 20);

        int numArticulosA2 = cesta.getArticulos().get(a2);

        assertEquals(110, numArticulosA2);

        int tamañoDeCesta = cesta.getArticulos().size();

        assertEquals(4, tamañoDeCesta);

        int numArticulosA3 = cesta.getArticulos().get(a3);

        assertEquals(50, numArticulosA3);
    }

}