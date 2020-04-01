package deusto.spq.data;


import es.deusto.spq.data.Cesta;
import es.deusto.spq.data.Cesta.Estado;
import es.deusto.spq.data.Cliente;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Articulo.Categoria;

public class Cesta_test{
	Cliente c1 = new Cliente("jokin", "jokin@gmail.com", "hola", "Deusto kalea 1");
	Date f1 = new Date(120,04,12);
	Articulo a1 = new Articulo("manzana",f1, 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTA);
	Articulo a2 = new Articulo("pan",f1, 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTA);
	List<Articulo>listaArticulos = new ArrayList<Articulo>();
	List<Integer> listaCantidades = new ArrayList<Integer>();
	listaArticulos.add(a1);
	listaArticulos.add(a2);
	Integer cantidad1 = 400;
	Integer cantidad2 = 500;
	listaCantidades.add(cantidad1);
	listaCantidades.add(cantidad2);
	Cesta c = new Cesta(1, c1, listaArticulos, listaCantidades, Estado.ACTUAL);
	
	
	@Test
	public void testId() {
		assertEquals(c.getId(), 1);
	}
	@Test
	public void testCliente() {
		assertEquals(c.getCliente(), c1);
	}
	@Test
	public void testArticulos() {
		assertEquals(c.getArticulos(), listaArticulos);
	}
	@Test
	public void testCantidades() {
		assertEquals(c.getCantidades(), listaCantidades);
	}
	
	
}