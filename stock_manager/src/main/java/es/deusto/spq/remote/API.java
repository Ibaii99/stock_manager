package es.deusto.spq.remote;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.JsonObject;
import javax.json.bind.annotation.JsonbTransient;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonParser;

import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Cesta;
import es.deusto.spq.data.Cesta.Estado;
import es.deusto.spq.data.Cliente;
import es.deusto.spq.data.Usuario;
import es.deusto.spq.data.Opinion;
import es.deusto.spq.data.Vendedor;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data_access.DAO;

//import es.deusto.spq.data.Admin;


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
	@Path("logIn")
	public String logIn(JsonObject json) {
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

		return "{ \"nombre\": \""+cliente.getNombreCliente() + "\" }";
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
		DAO dao = new DAO();
		
		System.out.println(json);

		String nombre = get_from_json(json, "nombre");

		Date caducidad = new SimpleDateFormat("dd/MM/yyyy").parse(get_from_json(json, "caducidad")); // "31/12/1998"

		Float precio = Float.parseFloat(get_from_json(json, "precio")); //13.2

		int stock = Integer.parseInt(get_from_json(json, "stock"));

		String descripcion = get_from_json(json, "descripcion");

		Float oferta = Float.parseFloat(get_from_json(json, "oferta")); //13.2

		Categoria categoria =  Categoria.valueOf(get_from_json(json, "categoria")); 
		//FRUTAS, FRUTOSSECOS, VERDURAS, ZUMOS
		
		String urlImage = get_from_json(json, "imageUrl");
		
		
		System.out.println(nombre);
		System.out.println(caducidad);
		System.out.println(precio);
		System.out.println(stock);
		System.out.println(descripcion);
		System.out.println(oferta);
		System.out.println(categoria);
		System.out.println(urlImage);
		
		Articulo c = new Articulo(nombre, caducidad, precio, stock, descripcion, oferta, categoria, url_image);
		
		
		
		System.out.println(c.toString());
		dao.store(c);
		

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
	@Path("getCliente")
	public Cliente getCliente(JsonObject json) {
		System.out.println("Email: " + get_from_json(json, "email") + " Pass: "+  get_from_json(json, "password"));
		Cliente c = new DAO().getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		
		return c;
	}

	@POST
	@Path("getCarrito")
	public Cesta getCarrito(JsonObject json) {
		System.out.println("Email: " + get_from_json(json, "email") + " Pass: "+  get_from_json(json, "password"));
		Cliente c = new DAO().getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		return c.getCarrito();
	}
	
	@POST
	@Path("getFavoritos")
	public Cesta getFavoritos(JsonObject json) {
		System.out.println("Email: " + get_from_json(json, "email") + " Pass: "+  get_from_json(json, "password"));
		Cliente c = new DAO().getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		return c.getFavoritos();
	}
	
	@POST
	@Path("addCarrito")//por ID
	public void anyadirCarrito(JsonObject json) {
		System.out.println("Añadiendo a la cesta de la compra");
		DAO db = new DAO();
		Articulo a = db.getArticulo( Long.parseLong(get_from_json(json, "id_articulo")));
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.getCarrito().addCesta(a, Integer.parseInt(get_from_json(json,"cantidad")));
	}

	@POST
	@Path("modifyCarrito")//por ID
	public void modifyCarrito(JsonObject json) {
		System.out.println("Modificando la cesta de la compra");
		DAO db = new DAO();
		Articulo a = db.getArticulo( Long.parseLong(get_from_json(json, "id_articulo")));
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.getCarrito().modifyCesta(a, Integer.parseInt(get_from_json(json,"cantidad")));
	}
	
	@POST
	@Path("tamanyoCarrito")//por ID
	public int tamanyoCarrito(JsonObject json) {
		System.out.println("Obteniendo tamaño de la cesta de la compra");
		DAO db = new DAO();
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		return c.getCarrito().getArticulos().size();
	}

	@POST
	@Path("VaciarCarrito")//por ID
	public void VaciarCarrito(JsonObject json) {
		System.out.println("Limpiando a la cesta de la compra");
		DAO db = new DAO();
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.getCarrito().vaciarCesta();
	}

	@POST
	@Path("addFavoritos")//por ID
	public void anyadirFavoritos(JsonObject json) {
		System.out.println("Añadiendo a la cesta de favoritos");
		DAO db = new DAO();
		Articulo a = db.getArticulo( Long.parseLong(get_from_json(json, "id_articulo")));
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.getFavoritos().addCesta(a, 1);
	}
	
	@POST
	@Path("modifyFavoritos")//por ID
	public void modifyFavoritos(JsonObject json) {
		System.out.println("Añadiendo a la cesta de favoritos");
		DAO db = new DAO();
		Articulo a = db.getArticulo( Long.parseLong(get_from_json(json, "id_articulo")));
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.getFavoritos().modifyCesta(a, 1);
	}

	@POST
	@Path("tamanyoFavoritos")//por ID
	public int tamanyoFavoritos(JsonObject json) {
		System.out.println("Obteniendo tamaño de la cesta de favoritos");
		DAO db = new DAO();
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		return c.getCarrito().getArticulos().size();
	}
	
	@POST
	@Path("VaciarFavoritos")//por ID
	public void VaciarFavoritos(JsonObject json) {
		System.out.println("Limpiando a la cesta de la compra");
		DAO db = new DAO();
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.getCarrito().vaciarCesta();
	}

	@GET
	@Path("getArticulos")
	public List<Articulo> getArticulos() {
		System.out.println("Mandando todos los articulos");
		DAO db = new DAO();
		return db.getArticulos();
	}
		
	@POST
	@Path("getArticulo")//por ID
	public Articulo getArticulos(JsonObject json) {
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
	@Path("getCestas")
	public List<Cesta> getCestas() {
		System.out.println("Mandando todos los cestas");
		DAO db = new DAO();
		return db.getCestas();
	}

	@POST
	@Path("getCesta")//por ID
	public Cesta getCesta(JsonObject json) {
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
	@Path("getUsuarios")
	public List<Usuario> getUsuarios() {
		System.out.println("Mandando todos los usuarios");
		DAO db = new DAO();
		return db.getUsuarios();
	}
	
	@GET
	@Path("getUsuario")
	public Usuario getUsuario(JsonObject json) {
		System.out.println("Nombre: " + get_from_json(json, "nombre") + " Pass: "+  get_from_json(json, "contrasenya"));
		Usuario u = new DAO().getUsuario(get_from_json(json, "nombre"), get_from_json(json, "contrasenya"));
		u.toString();
		return u;
	}
	
	@GET
	@Path("getOpiniones")
	public List<Opinion> getOpiniones() {
		System.out.println("Mandando todos los cestas");
		DAO db = new DAO();
		return db.getOpiniones();
	}

	@POST
	@Path("get_Opinion")//por ID
	public Opinion getOpinion(JsonObject json) {
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
	@Path("getVendedores")
	public List<Vendedor> getVendedores() {
		System.out.println("Mandando todos los cestas");
		DAO db = new DAO();
		return db.getVendedores();
	}

	@POST
	@Path("getVendedor")//por ID
	public Vendedor getVendedor(JsonObject json) {
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

		return "{ \"nombre\": \""+vendedor.getNombreVendedor() + "\" }";
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