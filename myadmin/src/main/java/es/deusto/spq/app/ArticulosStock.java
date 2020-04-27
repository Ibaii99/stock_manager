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
import java.util.Calendar;

public class ArticulosStock extends JFrame {

	private JPanel contentPane;
	private Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArticulosStock frame = new ArticulosStock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ArticulosStock() {
		setTitle("ARTICULOS BAJOS EN STOCK");
		client = ClientBuilder.newClient();


		
		final WebTarget appTarget = client.target("http://localhost:8080/stock_manager/api/");
		final WebTarget articulosTarget = appTarget.path("getArticulos");

		


		setSize(1000, 500);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel botonesPanel = new JPanel();
		getContentPane().add(botonesPanel, BorderLayout.SOUTH);

		getContentPane().add(botonesPanel, BorderLayout.SOUTH);
		
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
					.addContainerGap(514, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(367))
		);
		gl_botonesPanel.setVerticalGroup(
			gl_botonesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_botonesPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(btnNewButton)
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
			if (articulo.getStock()<100) {
				articulosListModel.addElement(articulo);
			}
		}
		setVisible(true);
		
	}

}
