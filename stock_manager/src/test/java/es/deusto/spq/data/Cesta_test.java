package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;
import java.util.Date;
import java.util.HashMap;

import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data.Cesta.Estado;



class Cesta_test {

    @org.junit.Test
	void testConstructor() {    

        final int idCliente = 0;
        final int idCesta = 999;
        final Articulo a1 = new Articulo("manzana", new Date(05/9/120) , 1.20f, 50, "verde", 0.85f, Categoria.FRUTA);
        final Articulo a2 = new Articulo("chocolate", new Date(05/9/120) , 1.20f, 50, "verde", 0.85f, Categoria.DULCE);
        final Articulo a3 = new Articulo("manzana", new Date(05/9/120) , 1.20f, 50, "verde", 0.85f, Categoria.FRUTA);
        final Articulo a4 = new Articulo("manzana", new Date(05/9/120) , 1.20f, 50, "verde", 0.85f, Categoria.FRUTA);
        final Articulo a5 = new Articulo("manzana", new Date(05/9/120) , 1.20f, 50, "verde", 0.85f, Categoria.FRUTA);
        Cesta cesta = new Cesta(new Cliente(), Estado.ACTUAL);

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