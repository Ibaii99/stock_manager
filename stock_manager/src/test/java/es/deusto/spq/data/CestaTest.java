package es.deusto.spq.data;


import es.deusto.spq.data.Cesta;

import es.deusto.spq.data.Cesta.Estado;
import es.deusto.spq.data.Cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

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
		assertEquals(c.getArticulos(),actual.getArticulos());//son distintos articulos
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
	
	@Test
	public void testAddArticulo() {

		c.addArticulo(a1, cantidad2);

		int i = c.getCantidades().get(0);

		assertEquals(500, i );

		Articulo a3 = new Articulo("Trufa", new Date(22/04/2020), 1.20f, 400, "rica pan", 1.05f,
				Categoria.FRUTOSSECOS,
				"https://s1.eestatic.com/2015/03/24/cocinillas/Cocinillas_20507999_115826466_1024x576.jpg");
		Integer cantidad3 = 400;
		
		c.addArticulo(a3, cantidad3);

		assertEquals(3, c.getArticulos().size());
		assertEquals(3, c.getCantidades().size());
	}

	@Test
	public void testGetRecibo() {

		assertEquals(945.0f, c.getRecibo(), 0.002);

	}

	@Test
	public void testVaciarCesta() {
		
		c.vaciarCesta();

		assertEquals(0, c.getArticulos().size());
		assertEquals(0, c.getCantidades().size());

	}

	@Test
	public void testModifyCesta() {
		c.modifyCesta(a1, cantidad2);

		int i = c.getCantidades().get(0);

		assertEquals(500, i );

		Articulo a3 = new Articulo("Trufa", new Date(22/04/2020), 1.20f, 400, "rica pan", 1.05f,
			Categoria.FRUTOSSECOS,
			"https://s1.eestatic.com/2015/03/24/cocinillas/Cocinillas_20507999_115826466_1024x576.jpg");
		Integer cantidad3 = 400;
		
		c.modifyCesta(a3, cantidad3);

		assertEquals(3, c.getArticulos().size());
		assertEquals(3, c.getCantidades().size());

		c.modifyCesta(a3, 0);

		assertEquals(2, c.getArticulos().size());
		assertEquals(2, c.getCantidades().size());

	}

	@Test
	public void testAddCesta() {

		c.addCesta(a1, cantidad2);

		int i = c.getCantidades().get(0);

		assertEquals(900, i );

		Articulo a3 = new Articulo("Trufa", new Date(22/04/2020), 1.20f, 400, "rica pan", 1.05f,
				Categoria.FRUTOSSECOS,
				"https://s1.eestatic.com/2015/03/24/cocinillas/Cocinillas_20507999_115826466_1024x576.jpg");
		Integer cantidad3 = 400;
		
		c.addCesta(a3, cantidad3);

		assertEquals(3, c.getArticulos().size());
		assertEquals(3, c.getCantidades().size());
	}

	@Test
	public void testRemoveArticuloCesta() {

		c.removeArticuloCesta(a1);

		assertEquals(1, c.getArticulos().size());
		assertEquals(1, c.getCantidades().size());
	}

}