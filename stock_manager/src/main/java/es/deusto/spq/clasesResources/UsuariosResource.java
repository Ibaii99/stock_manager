/* package es.deusto.spq.clasesResources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import java.util.List;
import java.util.ArrayList;

@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuariosResource{

    @GET
    public Usuario getUsuario(){
        final Usuario u = new Usuario(0, "izai", "correo", "123", "chapela 22");
        return u;   
    }
    @GET
    @Path("all")
    public List<Usuario> getAllUsuarios(){
        List<Usuario> lista = new ArrayList<>();

        lista.add(new Usuario(3,"","","",""));
        lista.add(new Usuario(5,"","","",""));
      lista.add(new Usuario(8,"","","",""));

        return lista;
    }
    @POST
    public void addUsuario(Usuario u){
        System.out.println(u.getID()+u.getNombre());
    }
    @DELETE
    @Path("/{code}")
    public Response deleteUsuario(@PathParam("code") int code){
        if (code == 10) {
            System.out.println("Borrando el usuario");
            return Response.status(Response.Status.OK).build();
        }else{
            System.out.println("Usuario no borrado");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
} */