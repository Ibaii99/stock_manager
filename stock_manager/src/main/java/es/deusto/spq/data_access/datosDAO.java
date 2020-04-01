package es.deusto.spq.data_access;


import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import es.deusto.spq.data.Cesta;
import es.deusto.spq.data.Opinion;
import es.deusto.spq.data.Vendedor;
import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Cliente;

public class datosDAO {
    DAO dao = new DAO();
    @POST
	@Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Cliente> listaClientes() {
		ArrayList<Cliente> listaClientes= new ArrayList<Cliente>();
		Cliente a = new Cliente("mikel", "mikel@gmail.com", "1234", "Barakaldo");
		Cliente b = new Cliente("jokin", "jokin@gmail.com", "1234", "Universidad Deusto");
		Cliente c = new Cliente("ibai", "ibail@gmail.com", "1234", "Bilbao");
		Cliente d = new Cliente("izaia", "izai@gmail.com", "1234", "Universidad");
		Cliente e = new Cliente("Unai", "unai@gmail.com", "1234", "DeustoTech");
		listaClientes.add(a);
		listaClientes.add(b);
		listaClientes.add(c);
		listaClientes.add(d);
		listaClientes.add(e);
		dao.store(a);
		dao.store(b);
		dao.store(c);
		dao.store(d);
		dao.store(e);
		return listaClientes;
	}
	@GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getItClietnes() {
        return "Cliente devuelto!";
	}
	

	@POST
	@Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Vendedor> listaVendedores() {
		ArrayList<Vendedor> listaVendedores= new ArrayList<Vendedor>();
		Vendedor a = new Vendedor("MikelVendedor", "mikelVendedor@gmail.com");
		Vendedor b = new Vendedor("JokinVendedor", "jokinVendedor@gmail.com");
		Vendedor c = new Vendedor("IbaiVendedor", "ibailVendedor@gmail.com");
		Vendedor d = new Vendedor("IzaiVendedor", "izaiVendedor@gmail.com");
		Vendedor e = new Vendedor("UnaiVendedor", "unaiVendedor@gmail.com");
		listaVendedores.add(a);
		listaVendedores.add(b);
		listaVendedores.add(c);
		listaVendedores.add(d);
		listaVendedores.add(e);
		dao.store(a);
		dao.store(b);
		dao.store(c);
		dao.store(d);
		dao.store(e);
		return listaVendedores;
	}
	@GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getItVendedores() {
        return "Vendedores devuelto!";
    }

    

    @POST
	@Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Opinion> listaOpiniones() {
        ArrayList<Opinion> listaOpiniones= new ArrayList<Opinion>();
        Cliente mikel = new Cliente("mikel", "mikel@gmail.com", "1234", "Barakaldo");
		Cliente jokin = new Cliente("jokin", "jokin@gmail.com", "1234", "Universidad Deusto");
		Cliente ibai = new Cliente("ibai", "ibail@gmail.com", "1234", "Bilbao");
		Cliente izai = new Cliente("izaia", "izai@gmail.com", "1234", "Universidad");
		Cliente unai = new Cliente("Unai", "unai@gmail.com", "1234", "DeustoTech");
		Opinion a = new Opinion("Me ha encantado la lechuga", 7,mikel);
		Opinion b = new Opinion("No me ha gusatdo el pimiento",1,jokin);
		Opinion c = new Opinion("No estaba buena del todo la calabaza pero estaba fresca", 6, ibai);
		Opinion d = new Opinion("No estaban fresca del todo las fresas pero estaban buenas", 5, izai);
		Opinion e = new Opinion("Habeis hecho un excelente trabajo",10,unai);
		listaOpiniones.add(a);
		listaOpiniones.add(b);
		listaOpiniones.add(c);
		listaOpiniones.add(d);
		listaOpiniones.add(e);
		dao.store(a);
		dao.store(b);
		dao.store(c);
		dao.store(d);
		dao.store(e);
		return listaOpiniones;
	}
	@GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getItOpiniones() {
        return "Opiniones devuelto!";
    }





}