
package src.main.java.es.deusto.spq.app;



import static javax.swing.JOptionPane.ERROR_MESSAGE;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.swing.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import src.main.java.es.deusto.spq.app.Articulo.Categoria;

import java.util.Date;
import java.util.List;



public class Articulos_bien extends JFrame{

	private static final long serialVersionUID = 1L;
	private Client client;
	private Date date;
	
	public Articulos_bien() {
		client = ClientBuilder.newClient();
		final WebTarget appTarget = client.target("http://localhost:8080/stock_manager/api/");
		final WebTarget articulosTarget = appTarget.path("get_articulos");
		GenericType<List<Articulo>> genericType = new GenericType<List<Articulo>>() {};

		WebTarget allArticulosTarget = articulosTarget.path("get_articulos");
		List<Articulo> articulos = allArticulosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
	
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel botonesPanel = new JPanel();
		
		JButton eliminarBoton = new JButton("Eliminar articulo");
		JButton anyadirBoton = new JButton("Anyadir articulo");
		botonesPanel.add(eliminarBoton);
		botonesPanel.add(eliminarBoton);
		add(botonesPanel, BorderLayout.SOUTH);
		
		final DefaultListModel<Articulo> articulosListModel = new DefaultListModel<>();
		JList<Articulo> articulosLista = new JList<>(articulosListModel);
		articulosListModel.clear();
		for(Articulo articulo: articulos) {
			articulosListModel.addElement(articulo);
		}
		
		JPanel derecha = new JPanel();
		add(derecha,BorderLayout.EAST);
		
		final JTextField nombreText = new JTextField("", 10);
		final JTextField caducidadText = new JTextField("", 10);
		final JTextField precioText = new JTextField("", 4);
		final JTextField stockText = new JTextField("", 5);
		final JTextField descripcionText = new JTextField("", 50);
		final JTextField ofertaText = new JTextField("", 4);
		final JTextField categoriaText = new JTextField("", 40);
		final JTextField imagenText = new JTextField("", 50);//Duda
		
		
		derecha.add(nombreText);
		derecha.add(caducidadText);
		derecha.add(precioText);
		derecha.add(stockText);
		derecha.add(descripcionText);
		derecha.add(ofertaText);
		derecha.add(categoriaText);
		derecha.add(imagenText);
		
		anyadirBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String cat = categoriaText.getText();
				Categoria c = Categoria.valueOf(cat);//???
				
				String cad = caducidadText.getText();
                SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
                try {
                    date = formatter1.parse(cad);
                } catch (ParseException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
				Articulo articulo = new Articulo(nombreText.getText(), date, Float.parseFloat(precioText.getText()),
						Integer.parseInt(stockText.getText()), descripcionText.getText(), Integer.parseInt(ofertaText.getText()),
						c, imagenText.getText());
				articulosTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(articulo, MediaType.APPLICATION_JSON));
				
			}
		});
		
		eliminarBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				WebTarget deleteTarget = articulosTarget.path(nombreText.getText());//Aqui meto un nombre, pero funciona con id ?
				Response response = deleteTarget.request().delete();
				if(response.getStatus() == Status.OK.getStatusCode()) {
					JOptionPane.showMessageDialog(Articulos_bien.this, "Articulo eliminado", "Message", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(Articulos_bien.this, "No se pudo eliminar al usuario", "Message", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Articulos_bien();
				
			}
		});
	}
	
	
}
