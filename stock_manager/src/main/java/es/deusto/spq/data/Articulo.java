package es.deusto.spq.data;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.spq.data_access.DAO;
//
@PersistenceCapable(detachable = "true")
public class Articulo implements Serializable{

	/**
	 * 
	 */
	public enum Categoria {
		FRUTAS,
		FRUTOSSECOS, 
		VERDURAS,
		ZUMOS
	}
	
	final double THRESHOLD = .0001;

	private static final long serialVersionUID = 1L;
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT, primaryKey="true")
    private long ID;
    private String nombre;
    private Date caducidad;
    private float precio;
    private int stock;
    private String descripcion;
    private float oferta;
    private Categoria categoria;
    private byte [] image;
    
    private String imageUrl;
    
    private Vendedor vendedor;
    
    @Join
    private  List<Cesta> cestas =  new ArrayList<>();
    
	public Articulo() {
	}

	/** Constructor de un articulo
	 * @param nombre Nombre del articulo
	 * @param caducidad Fecha de caducidad del articulo
	 * @param precio Precio original del articulo
	 * @param stock Cantidad de stock disponible
	 * @param descripcion Descripcion breve
	 * @param oferta Precio del articulo en promocion, si no esta en promocion poner el mismo
	 * @param categoria Categoria a la que pertenece el articulo, 
	 * FRUTAS,
	 * FRUTOSSECOS, 
	 * VERDURAS,
	 * ZUMOS
	 * 
	 * @param imageUrl Url de google de la imagen
	 */
	public Articulo(String nombre, Date caducidad, float precio, int stock, String descripcion, float oferta,
			Categoria categoria, String imageUrl) {
        super();
		this.nombre = nombre;
		this.caducidad = caducidad;
		this.precio = precio;
		this.stock = stock;
		this.descripcion = descripcion;
		this.oferta = oferta;
		this.categoria = categoria;
		this.imageUrl = imageUrl;
    }
    
	/** Metodo para saber la categoria del articulo
	 * @return Devuelve como Categoria el tipo de articulo
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	
    /** Devuelve el id del articulo
     * @return devuelve un long como id
     */
    public long getId() {
		return ID;
	}


	/** Establece el id del articulo
	 * @param id requiere de un long
	 */
	public void setId(long id) {
		this.ID = id;
	}

	/** Devuelve el nombre del articulo
	 * @return Devuelve un string con el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/** Establece el nombre del articulo
	 * @param nombre Requiere de un string como nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** Devuelve la fecha de caducidad
	 * @return Date objeto
	 */
	public Date getCaducidad() {
		return caducidad;
	}

	public static long getSerialVersionUid() {
		return serialVersionUID;
	}

	
	/**Devuelve las cestas a las que pertenece el articulo
	 * @return Devuelve una List de cestas
	 */
	public List<Cesta> getCestas() {
		return cestas;
	}

	/** Establece la lista de cestas a las que pertenece
	 * @param pedidos Cestas de pedidos a las que pertenece
	 */
	public void setCestas(List<Cesta> pedidos) {
		this.cestas = pedidos;
	}

	/** Establece la fecha de caducidad 
	 * @param caducidad Requiere de un objeto Date
	 */
	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}

	/** 
	 * @return Devuelve el precio en float
	 */
	public float getPrecio() {
		return precio;
	}

	/** 
	 * @param precio Establece el float del precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * @return Devuelve la cantidad de stock que queda
	 */
	public int getStock() {
		return stock;
	}

	/** Establece la cantidad de stock que queda
	 * @param stock int
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/** Devuelve la descripcion del articulo
	 * @return String de la descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**Establece la descripcion del articulo
	 * @param descripcion String 
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/** Devuelve el precio de oferta del articulo
	 * @return decuelve un float
	 */
	public float getOferta() {
		return oferta;
	}

	/** Establece el precio de oferta
	 * @param oferta Requiere de un float de precio
	 */
	public void setOferta(float oferta) {
		this.oferta = oferta;
	}

	/** Devuelve el vendedor del articulo
	 * @return Devuelve un Vendedor
	 */
	public Vendedor getVendedor() {
		return vendedor;
	}

	/**Establece el vendedor del articulo
	 * @param vendedor Recibe un objeto Vendedor
	 */
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	/**Establece la categoria del articulo
	 * @param categoria Category objeto
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	
	/** Devuelve el link de la imagen
	 * @return Devuelve un string
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/** Establece la url de la imagen  
	 * @param imageUrl String de la dirección
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/** Almacena el articulo en la base de datos
	 * 
	 */
	public void storeMe() {
		DAO dao = new DAO();
		dao.store(this);
	}


	@Override
	public String toString() {

        return "Articulo [Id=" + this.ID + "Nombre=" + this.nombre + ", Caducidad=" + this.caducidad + ", Precio" + this.precio +

        ", Stock" + this.stock + ", Descrpción" + this.descripcion + ", Oferta" + this.oferta + ", Categoria" + this.categoria +     "]";
	}



	@Override
	public int hashCode() {
		final int prime = 1;
		int result = 1;
		result = prime * result + (int) (ID ^ (ID >>> 32));
		return result;
	}

	

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub

		Articulo a = (Articulo) obj;
		
		if(a.getId()==this.ID) 
			return true;

		return false;

	}
    
	
	
    
  


}