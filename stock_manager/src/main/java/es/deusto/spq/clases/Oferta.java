package es.deusto.spq.clases;

public class Oferta{

    private int codigo_oferta;
    private String nombre_oferta;
    private Articulo articulo_oferta;

    public Oferta(int codigo, String nombre, Articulo articulo){
        this.codigo_oferta = codigo;
        this.nombre_oferta = nombre;
        this.articulo_oferta = articulo;
    }

	public int getCodigo_oferta() {
		return codigo_oferta;
	}

	public void setCodigo_oferta(int codigo_oferta) {
		this.codigo_oferta = codigo_oferta;
	}

	public String getNombre_Oferta() {
		return nombre_oferta;
	}

	public void setNombre_nombre(String nombre_nombre) {
		this.nombre_oferta = nombre_nombre;
	}

	public Articulo getArticulo_oferta() {
		return articulo_oferta;
	}

	public void setArticulo_oferta(Articulo articulo_oferta) {
		this.articulo_oferta = articulo_oferta;
	}

  

}