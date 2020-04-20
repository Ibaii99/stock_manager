package es.deusto.spq.data;


import es.deusto.spq.data.Cesta;

import es.deusto.spq.data.Cesta.Estado;
import es.deusto.spq.data.Cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Articulo;

import es.deusto.spq.data.Articulo.Categoria;

public class CestaTest{
	Cesta c;
	Articulo a1;
	Articulo a2;
	List<Articulo> listaArticulos;
	List<Integer> listaCantidades;
	Integer cantidad1;
	Integer cantidad2;
	
	@Before
	public void setUp() {
		listaArticulos = new ArrayList<Articulo>();
		listaCantidades = new ArrayList<Integer>();
		a1 = new Articulo("coliflor", new Date(21/03/2020), 1.20f, 400, "rica coliflor", 1.05f,
				Categoria.FRUTAS,
				"https://gastronomiaycia.republica.com/wp-content/uploads/2013/04/quitar_manchas_coliflor.jpg");
		a2 = new Articulo("pan", new Date(22/04/2020), 1.20f, 400, "rica pan", 1.05f,
				Categoria.FRUTOSSECOS,
				"https://s1.eestatic.com/2015/03/24/cocinillas/Cocinillas_20507999_115826466_1024x576.jpg");
		cantidad1 = 400;
		cantidad2 = 500;
		listaArticulos.add(a1);listaArticulos.add(a2);
		listaCantidades.add(cantidad1);listaCantidades.add(cantidad2);
		c = new Cesta(listaArticulos, listaCantidades, Estado.ENTREGADO);
	}
	
	@Test
	public void getListaArticulos() {
		List<Articulo> listaArticulosActual = new ArrayList<Articulo>();
		List<Integer> listaCantidadesActual = new ArrayList<Integer>();
		Articulo a3 = new Articulo("coliflor", new Date(21/03/2020), 1.20f, 400, "rica coliflor", 1.05f,
				Categoria.FRUTAS,
				"https://gastronomiaycia.republica.com/wp-content/uploads/2013/04/quitar_manchas_coliflor.jpg");
		Articulo a4 = new Articulo("pan", new Date(22/04/2020), 1.20f, 400, "rica pan", 1.05f,
				Categoria.FRUTOSSECOS,
				"https://s1.eestatic.com/2015/03/24/cocinillas/Cocinillas_20507999_115826466_1024x576.jpg");
		Integer cantidad3 = 400;
		Integer cantidad4 = 500;
		listaArticulosActual.add(a3);listaArticulosActual.add(a4);
		listaCantidadesActual.add(cantidad3);listaCantidadesActual.add(cantidad4);
		Estado estadoActual = Estado.ENTREGADO;
		
		Cesta actual = new Cesta(listaArticulosActual, listaCantidadesActual, estadoActual);
		assertNotEquals(c.getArticulos(),actual.getArticulos());//son distintos articulos
	}
	@Test
	public void getListaCantidades() {
		List<Articulo> listaArticulosActual = new ArrayList<Articulo>();
		List<Integer> listaCantidadesActual = new ArrayList<Integer>();
		Articulo a3 = new Articulo("coliflor", new Date(21/03/2020), 1.20f, 400, "rica coliflor", 1.05f,
				Categoria.FRUTAS,
				"https://gastronomiaycia.republica.com/wp-content/uploads/2013/04/quitar_manchas_coliflor.jpg");
		Articulo a4 = new Articulo("pan", new Date(22/04/2020), 1.20f, 400, "rica pan", 1.05f,
				Categoria.FRUTOSSECOS,
				"https://s1.eestatic.com/2015/03/24/cocinillas/Cocinillas_20507999_115826466_1024x576.jpg");
		Integer cantidad3 = 400;
		Integer cantidad4 = 500;
		listaArticulosActual.add(a3);listaArticulosActual.add(a4);
		listaCantidadesActual.add(cantidad3);listaCantidadesActual.add(cantidad4);
		Estado estadoActual = Estado.ENTREGADO;
		
		Cesta actual = new Cesta(listaArticulosActual, listaCantidadesActual, estadoActual);
		assertEquals(c.getCantidades(), actual.getCantidades());
	}
	@Test
	public void getEstado() {
		List<Articulo> listaArticulosActual = new ArrayList<Articulo>();
		List<Integer> listaCantidadesActual = new ArrayList<Integer>();
		Articulo a3 = new Articulo("coliflor", new Date(21/03/2020), 1.20f, 400, "rica coliflor", 1.05f,
				Categoria.FRUTAS,
				"https://gastronomiaycia.republica.com/wp-content/uploads/2013/04/quitar_manchas_coliflor.jpg");
		Articulo a4 = new Articulo("pan", new Date(22/04/2020), 1.20f, 400, "rica pan", 1.05f,
				Categoria.FRUTOSSECOS,
				"https://s1.eestatic.com/2015/03/24/cocinillas/Cocinillas_20507999_115826466_1024x576.jpg");
		Integer cantidad3 = 400;
		Integer cantidad4 = 500;
		listaArticulosActual.add(a3);listaArticulosActual.add(a4);
		listaCantidadesActual.add(cantidad3);listaCantidadesActual.add(cantidad4);
		Estado estadoActual = Estado.ENTREGADO;
		
		Cesta actual = new Cesta(listaArticulosActual, listaCantidadesActual, estadoActual);
		assertEquals(c.getEstado(), actual.getEstado());
	}
	
}