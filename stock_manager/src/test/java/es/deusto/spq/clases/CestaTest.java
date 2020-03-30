package es.deusto.spq.clases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import es.deusto.spq.clases.Cesta.Estado; 



class CombateTest {

    @org.junit.Test
	void testConstructor() {    

        final int idCliente = 0;
        final int idCesta = 0;
        final Articulo a1 = new Articulo(10, "manzana", new Date(2020, 3, 23), 0.23f, 120, "Manzana Naturas", 0.10f, "FRUTA");
        final Articulo a2 = new Articulo(14, "pera", new Date(2020, 3, 23), 0.40f, 120, "Pera Naturas", 0.20f, "FRUTA");
        final Articulo a3 = new Articulo(26, "mandarina", new Date(2020, 3, 23), 0.13f, 120, "Mandarina Naturas", 0.5f, "FRUTA");
        final Articulo a4 = new Articulo(48, "naranja", new Date(2020, 3, 23), 0.40f, 120, "Naranja Naturas", 0.25f, "FRUTA");
        final Articulo a5 = new Articulo(56, "manzana", new Date(2020, 3, 23), 0.23f, 120, "Manzana Naturas", 0.10f, "FRUTA");
        final Cesta cesta = new Cesta(0, 0, Estado.ACTUAL);
        
    }

}