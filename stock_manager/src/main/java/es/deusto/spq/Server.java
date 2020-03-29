package es.deusto.spq;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;


@Path("server")
public class Server {
    private Usuario u;

    public Server(){

    }

    @POST
    @Path("set_usuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Usuario setUsuario(Usuario user){
        System.out.println("Request");
        this.u = user;
        System.out.println("New user: "+ user.getNombre());
        this.u.setNombre(user.getNombre());
        System.out.println("User: " + this.u.getNombre());
        
        System.out.println("User: " + this.u.getDireccion());
        //this.u = new Usuario(_nombre, _email, _contrasenya, _direccion);
        return this.u;
    }

}
