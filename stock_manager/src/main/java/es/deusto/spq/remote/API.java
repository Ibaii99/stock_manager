package es.deusto.spq.remote;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

import com.fasterxml.jackson.core.JsonParser;

//import es.deusto.spq.data.Admin;
import es.deusto.spq.data.Articulo;

import es.deusto.spq.data.Cliente;
import es.deusto.spq.data.Usuario;
import es.deusto.spq.data.Opinion;
import es.deusto.spq.data.Vendedor;

import es.deusto.spq.data.Cesta;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data_access.DAO;

/**
 * Root resource (exposed at "api" path)
 */

@Path("api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class API {
	//
	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@POST
	@Path("log_in")
	public String log_in(JsonObject json) {
		String nombre = new Cliente().loggin(get_from_json(json, "email"), get_from_json(json, "password"));
		System.out.println(nombre);
		return "{ \"nombre\": \""+nombre + "\" }";
	}

	/*
	{
 	  "email": "izaianda@gmail.com",
  	  "password": "123"
	}
	*/	

	@POST
	@Path("register")
	public String register(JsonObject json) {
		Cliente cliente = new Cliente(get_from_json(json, "name"), get_from_json(json, "email"), get_from_json(json, "password"), 
		get_from_json(json, "address"));
		cliente.registrarme();

		return "{ \"nombre\": \""+cliente.getNombre_cliente() + "\" }";
	}

	/*
	{
	  "name": "Jon Joseba",
 	  "email": "izaianda@gmail.com",
  	  "password": "123",
	  "address": "Altzaga"
	}
	*/

	@POST
	@Path("ingresarArticulo")
	public String ingresarArticulo(JsonObject json) throws ParseException {
		
		System.out.println(json);

		String nombre = get_from_json(json, "nombre");

		Date caducidad = new SimpleDateFormat("dd/MM/yyyy").parse(get_from_json(json, "caducidad")); // "31/12/1998"

		Float precio = Float.parseFloat(get_from_json(json, "precio")); //13.2

		int stock = Integer.parseInt(get_from_json(json, "stock"));

		String descripcion = get_from_json(json, "descripcion");

		Float oferta = Float.parseFloat(get_from_json(json, "oferta")); //13.2

		Categoria categoria =  Categoria.valueOf(get_from_json(json, "categoria")); 
		//FRUTAS, FRUTOSSECOS, VERDURAS, ZUMOS
		
		String url_image = get_from_json(json, "image_url");
		
		Articulo c = new Articulo(nombre, caducidad, precio, stock, descripcion, oferta, categoria, url_image);

		c.storeMe();

		return "Done";
	}

	/*
		{
		"nombre": "Manzana",
		"caducidad": "02/03/2021",
		"precio": "0.46",
		"stock": "120",
		"descripcion" : "Manzana Ibiza",
		"oferta" : "0.23",
		"categoria" : "FRUTAS",
		"image_url": ""
		}
	*/ 
	
	@POST
	@Path("get_cliente")
	public Cliente get_cliente(JsonObject json) {
		System.out.println("Email: " + get_from_json(json, "email") + " Pass: "+  get_from_json(json, "password"));
		Cliente c = new DAO().getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.toString();
		return c;
	}
	/*
		{
		"email": "izaianda@gmail.com",
		"password": "123"
		}
	*/
	@GET
	@Path("get_articulos")
	public List<Articulo> get_articulos() {
		System.out.println("Mandando todos los articulos");
		DAO db = new DAO();
		return db.getArticulos();
	}
		
	@POST
	@Path("get_articulo")//por ID
	public Articulo get_articulos(JsonObject json) {
		System.out.println("Mandando un articulo");
		long l = Long.parseLong(get_from_json(json, "ID"));
		Articulo a = new DAO().getArticulo(l);
		return a;
	}
	/*
		{
		"ID": "1"
		}
	*/
	
	@POST
	@Path("add_carrito")//por ID
	public void anyadir_carrito(JsonObject json) {
		System.out.println("Añadiendo a la cesta de la compra");
		DAO db = new DAO();
		Articulo a = db.getArticulo( Long.parseLong(get_from_json(json, "id_articulo")));
		System.out.println("asbgdjgbadsjashdbuik");
		System.out.println("TOSTRING: " + a.toString());
		System.out.println("NOMBRE: " + a.getNombre());
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		
		c.get_compra().anyadirCesta(a, Integer.parseInt(get_from_json(json, "cantidad")));
		for (Articulo art : c.get_compra().getArticulos()) {
			System.out.println(art.toString());
		}
	}
	
	@POST
	@Path("add_favoritos")//por ID
	public void anyadir_favoritos(JsonObject json) {
		System.out.println("Añadiendo a la cesta de la compra");
		DAO db = new DAO();
		Articulo a = db.getArticulo( Long.parseLong(get_from_json(json, "id_articulo")));
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.get_favoritos().anyadirCesta(a, Integer.parseInt(get_from_json(json, "cantidad")));
	}
	
	
	//Conseguir administradores
//	@POST
//	@Path("get_admin")
//	public Admin get_admin(JsonObject json) {
//		System.out.println("Usuario: " + get_from_json(json, "usuario") + " Pass: "+  get_from_json(json, "password"));
//		Admin a = new DAO().getAdmin(get_from_json(json, "usuario"), get_from_json(json, "password"));
//		a.toString();
//		return a;
//	}
	
	
	@GET
	@Path("get_cestas")
	public List<Cesta> get_cestas() {
		System.out.println("Mandando todos los cestas");
		DAO db = new DAO();
		return db.getCestas();
	}


	@POST
	@Path("get_cesta")//por ID
	public Cesta get_cesta(JsonObject json) {
		System.out.println("Mandando la cesta");
		long l = Long.parseLong(get_from_json(json, "ID"));
		Cesta a = new DAO().getCesta(l);
		return a;
	}
	/*
		{
		"ID": "1"
		}
	*/
	

	
	@GET
	@Path("get_usuarios")
	public List<Usuario> get_usuarios() {
		System.out.println("Mandando todos los usuarios");
		DAO db = new DAO();
		return db.getUsuarios();
	}
	
	@POST
	@Path("get_usuario")
	public Usuario get_usuario(JsonObject json) {
		System.out.println("Nombre: " + get_from_json(json, "nombre") + " Pass: "+  get_from_json(json, "password"));
		Usuario u = new DAO().getUsuario(get_from_json(json, "nombre"), get_from_json(json, "password"));
		u.toString();
		return u;
	}

	@POST
	@Path("addCesta")
	public Cesta addToCesta(JsonObject json) {
		System.out.println("Aniadiendo a la cesta");
		long idCesta = Long.parseLong(get_from_json(json, "idCesta"));
		long idArticulo = Long.parseLong(get_from_json(json, "idArticulo"));
		int cantidad = Integer.parseInt(get_from_json(json, "cantidad"));
		Cesta a = new DAO().addCesta(idCesta, idArticulo, cantidad);
		return a;
	}
	/*
		{
			"idCesta": "1",
			"idArticulo": "2",
			"cantidad": "5"
		}
	*/
	
	@POST
	@Path("removeCesta")
	public Cesta removeToCesta(JsonObject json) {
		System.out.println("Aniadiendo a la cesta");
		long idCesta = Long.parseLong(get_from_json(json, "idCesta"));
		long idArticulo = Long.parseLong(get_from_json(json, "idArticulo"));
		int cantidad = Integer.parseInt(get_from_json(json, "cantidad"));
		Cesta a = new DAO().removeCesta(idCesta, idArticulo, cantidad);
		return a;
	}
	/*
		{
			"idCesta": "1",
			"idArticulo": "2",
			"cantidad": "5"
		}
	*/
	
	@GET
	@Path("get_Opiniones")
	public List<Opinion> get_Opiniones() {
		System.out.println("Mandando todos los cestas");
		DAO db = new DAO();
		return db.getOpiniones();
	}

	@POST
	@Path("get_Opinion")//por ID
	public Opinion get_Opinion(JsonObject json) {
		System.out.println("Mandando la cesta");
		long l = Long.parseLong(get_from_json(json, "ID"));
		Opinion a = new DAO().getOpinion(l);
		return a;
	}
	/*
		{
		"ID": "1"
		}
	*/

	@POST
	@Path("nuevaOpinion")
	public Opinion nuevaOpinion(JsonObject json) {

		String txt = get_from_json(json, "txt");
		int valoracion = Integer.parseInt(get_from_json(json, "valoracion"));
		long idCliente = Long.parseLong(get_from_json(json, "idCliente"));

		Opinion o = null ;//new DAO().nuevaOpinion(txt, valoracion, idCliente);

		return o;
	}

	/*
		{
		"idCliente": "1",
		"txt": "Venia pocha",
		"valoracion": "1"
		}
	*/

	@GET
	@Path("get_Vendedores")
	public List<Vendedor> get_Vendedores() {
		System.out.println("Mandando todos los cestas");
		DAO db = new DAO();
		return db.getVendedores();
	}

	@POST
	@Path("get_Vendedor")//por ID
	public Vendedor get_Vendedor(JsonObject json) {
		System.out.println("Mandando la cesta");
		Vendedor a = new DAO().getVendedor(get_from_json(json, "email"));
		return a;
	}
	/*
		{
		"email": "asier@gmail.com"
		}
	*/

	@POST
	@Path("nuevoVendedor")
	public String nuevoVendedor(JsonObject json) {

		Vendedor vendedor = new Vendedor(get_from_json(json, "name"), get_from_json(json, "email"), new ArrayList<Articulo>());
		vendedor.registrar();

		return "{ \"nombre\": \""+vendedor.getNombre_vendedor() + "\" }";
	}


	@GET
	@Path("meter_datos")
	public String api_meter_datos() {
		System.out.println("Metiendo datos a la base de datos ...");
		DAO db = new DAO();
		String respuesta = db.meter_datos();
		System.out.println("Terminado.");
		return respuesta;
	}
	
	/**
	 * @param json Json fuente
	 * @param attribute Atributo a obtener del json
	 * @return Devuelve el valor
	 */
	private String get_from_json(JsonObject json, String attribute) {
		return json.get(attribute).toString().replace("\"", "");
	}
	
//	
//	@POST
//	@Path("post")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public boolean register() {
//		DAO db = new DAO();
//		Cliente c = new Cliente("ibai", "asdnhujkasdnas", "adsasdsad", "sadaddas");
//		db.store(c);
//		return true;
//	}
//	
//    @GET
//    @Path("get")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getIt() {
//        return "Got it!";
//    }
    
}