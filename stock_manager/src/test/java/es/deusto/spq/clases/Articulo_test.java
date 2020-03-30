package es.deusto.spq.clases;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class Articulo_test {
	private static Articulo articulo= new Articulo(1, "manzana", new Date(120,4,15) , 1.20f, 50, "verde", 0.85f, "fruta");;
	
	@BeforeClass
	public static void inicializarClase() {
		articulo = new Articulo();
	}
	
	@Test
	public void testgetCategoria() {
		assertEquals(articulo.getID(), 1);
	}
}
