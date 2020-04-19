package src.main.java.es.deusto.spq.app;



import static javax.swing.JOptionPane.ERROR_MESSAGE;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.ProcessingException;

import src.main.java.es.deusto.spq.app.*;
import src.main.java.es.deusto.spq.data.Articulo;
import src.main.java.es.deusto.spq.data.Articulo.Categoria;

import java.util.Date;
import java.util.List;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.EventQueue;
import java.awt.Dimension;




public class Articulos_bien extends JFrame{

	private static final long serialVersionUID = 1L;
	private Client client;
	private Date date;
	
	public Articulos_bien() {
		setTitle("ARTICULOS");
		client = ClientBuilder.newClient();


		
		final WebTarget appTarget = client.target("http://localhost:8080/stock_manager/api/");
		final WebTarget articulosTarget = appTarget.path("getArticulos");
		final WebTarget articuloTarget = appTarget.path("eliminarArticulo");
		


		setSize(1000, 500);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel botonesPanel = new JPanel();
		
		JButton eliminarBoton = new JButton("Eliminar articulo");

		JButton anyadirBoton = new JButton("Anyadir articulo");
		botonesPanel.add(eliminarBoton);
		botonesPanel.add(anyadirBoton);
		getContentPane().add(botonesPanel, BorderLayout.SOUTH);

		getContentPane().add(botonesPanel, BorderLayout.SOUTH);
		
		JButton btnanyadir = new JButton("Anyadir Articulo");
		btnanyadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					CrearArticulo frame = new CrearArticulo();
					frame.setVisible(true);
					dispose();
				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
		GroupLayout gl_botonesPanel = new GroupLayout(botonesPanel);
		gl_botonesPanel.setHorizontalGroup(
			gl_botonesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_botonesPanel.createSequentialGroup()
					.addContainerGap(278, Short.MAX_VALUE)
					.addComponent(eliminarBoton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnanyadir)
					.addContainerGap())
		);
		gl_botonesPanel.setVerticalGroup(
			gl_botonesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_botonesPanel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_botonesPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnanyadir)
						.addComponent(eliminarBoton)))
		);
		botonesPanel.setLayout(gl_botonesPanel);
		
		final DefaultListModel<Articulo> articulosListModel = new DefaultListModel<>();


		final JList<Articulo> articulosLista = new JList<>(articulosListModel);
		
		JScrollPane listScrollPane = new JScrollPane(articulosLista);
		getContentPane().add(listScrollPane, BorderLayout.WEST);
		
		GenericType<List<Articulo>> genericType = new GenericType<List<Articulo>>() {};
		List<Articulo> articulos = articulosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
	
		articulosListModel.clear();
		for(Articulo articulo: articulos) {
			articulosListModel.addElement(articulo);
		}
		
		JPanel derecha = new JPanel();
		getContentPane().add(derecha,BorderLayout.EAST);
		

		
		eliminarBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Articulo a = articulosLista.getSelectedValue();
				System.out.println(a);
				articuloTarget.request().post(Entity.entity(a, MediaType.APPLICATION_JSON));
			   
				
//				long l = a.getId();
//				String m = ""+l ;
//				System.out.println(m);
//				WebTarget deleteTarget = articuloTarget.path(m);
//                Response response = deleteTarget.request().delete();
//                response.getStatus() = Status.OK.getStatusCode();
                System.out.println("Articulo Eliminado");
//                if(response.getStatus() == Status.OK.getStatusCode()) {
//                 JOptionPane.showMessageDialog(Articulos_bien.this, "Articulo eliminado", "Message", JOptionPane.INFORMATION_MESSAGE);
//                }else {
//                    JOptionPane.showMessageDialog(Articulos_bien.this, "No se pudo eliminar al usuario", "Message", JOptionPane.ERROR_MESSAGE);
//                }
				
				
				
				
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