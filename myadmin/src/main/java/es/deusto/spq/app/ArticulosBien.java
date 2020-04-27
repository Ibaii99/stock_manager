package es.deusto.spq.app;



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
import javax.ws.rs.ProcessingException;

import es.deusto.spq.app.*;
import es.deusto.spq.data.*;
import es.deusto.spq.data.Articulo.Categoria;

import java.util.Date;
import java.util.List;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.EventQueue;
import java.awt.Dimension;




public class ArticulosBien extends JFrame{

	private static final long serialVersionUID = 1L;
	private Client client;
	private Date date;
	private JTextField textField;
	
	public ArticulosBien() {
		setTitle("ARTICULOS");
		client = ClientBuilder.newClient();


		
		final WebTarget appTarget = client.target("http://localhost:8080/stock_manager/api/");
		final WebTarget articulosTarget = appTarget.path("getArticulos");

		final WebTarget articuloTarget = appTarget.path("eliminarArticulo");



		setSize(1000, 500);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel botonesPanel = new JPanel();
		
		JButton eliminarBoton = new JButton("Eliminar articulo");
		botonesPanel.add(eliminarBoton);
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
		
		JButton modificarBoton = new JButton("Modificar articulo");
		
		JButton btnNewButton = new JButton("Volver al menu");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					dispose();
				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});

		GroupLayout gl_botonesPanel = new GroupLayout(botonesPanel);
		gl_botonesPanel.setHorizontalGroup(
			gl_botonesPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_botonesPanel.createSequentialGroup()
					.addContainerGap(530, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(modificarBoton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
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
						.addComponent(eliminarBoton)
						.addComponent(modificarBoton)
						.addComponent(btnNewButton))
					.addContainerGap(36, Short.MAX_VALUE))
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
		
		modificarBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Articulo articulo = articulosLista.getSelectedValue();
				System.out.println(articulo);
				try {
					ModificarArticulo frame = new ModificarArticulo(articulo);
					frame.setVisible(true);
					dispose();
				} catch (Exception er) {
					er.printStackTrace();
				}

				
			}
		});
		setVisible(true);
		
	}

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ArticulosBien();
				
			}
		});
	}
	
}