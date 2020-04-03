package es.deusto.spq.remote;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import es.deusto.spq.data.Articulo;

import es.deusto.spq.data.Cliente;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data_access.DAO;

/**
 * Root resource (exposed at "api" path)
 */

@Path("api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class API {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@POST
	@Path("log_in")
	public String log_in(JsonObject json) {
		System.out.println(json);
		System.out.println("Email: " + get_from_json(json, "email") + " Pass: " + get_from_json(json, "password"));
		String nombre = new Cliente().loggin(get_from_json(json, "email"), get_from_json(json, "password"));
		System.out.println(nombre);
		return "{ \"nombre\": \""+nombre + "\" }";
	}

	@POST
	@Path("register")
	public String register(JsonObject json) {
		DAO db = new DAO();
		System.out.println(json);

		Cliente cliente = new Cliente(get_from_json(json, "nombre"), get_from_json(json, "email"),
				get_from_json(json, "password"),

				get_from_json(json, "direccion"));

		cliente.registrarme();

		return "Done";
	}

	@POST
	@Path("ingresarArticulo")
	public String ingresarArticulo(JsonObject json) throws ParseException {
		DAO db = new DAO();
		System.out.println(json);

		String nombre = get_from_json(json, "nombre");

		Date caducidad = new SimpleDateFormat("dd/MM/yyyy").parse(get_from_json(json, "caducidad")); // "31/12/1998"

		Float precio = Float.parseFloat(get_from_json(json, "precio")); //13.2

		int stock = Integer.parseInt(get_from_json(json, "stock"));

		String descripcion = get_from_json(json, "descripcion");

		Float oferta = Float.parseFloat(get_from_json(json, "oferta")); //13.2

		Categoria categoria =  Categoria.valueOf(get_from_json(json, "categoria")); 
		//FRUTA, VEGETAL, CARNICERIA, PESCADERIA, BEBIDA, DULCE
		
		Articulo c = new Articulo(nombre, caducidad, precio, stock, descripcion, oferta, categoria);

		return "Done";
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