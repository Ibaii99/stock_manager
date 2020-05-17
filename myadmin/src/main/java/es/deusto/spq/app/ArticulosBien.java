package es.deusto.spq.app;



import static javax.swing.JOptionPane.ERROR_MESSAGE;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.IOException;
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

import java.util.Collections;
import java.util.Comparator;
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
	private WebTarget appTarget;
	private WebTarget articulosTarget; 
	private WebTarget articuloTarget;
	private DefaultListModel<Articulo> articulosListModel; 
	private JPanel botonesPanel ;
	private JList<Articulo> articulosLista; 
	private JScrollPane listScrollPane ;
	private GenericType<List<Articulo>> genericType;
	private List<Articulo> articulos ;
	private JButton eliminarBoton; 
	private JButton ordenarNombreBtn ;
	private JButton modificarBoton; 
	private JButton btnanyadir; 
	private JButton btnNewButton ;
	private JButton ordenarIDBtn ;
	private JButton ordenarStockBtn;
	private JButton ordenarCaduBtn ;
	private GroupLayout gl_botonesPanel;
	
	
	
//	/**
//	 * Método que refresca el frame 
//	 * @return Frame de articulos actualizado
//	 */
	public void dibujar() {
		articulosListModel.clear();
		for(Articulo articulo: articulos) {
			articulosListModel.addElement(articulo);
		}
//		articulosLista.repaint();
//		articulosLista.revalidate();
		listScrollPane.revalidate();
		listScrollPane.repaint();
	}
	
//	/**
//	 * Método con toda la lista de articulos.
//	 * @return Frame de articulos
//	 */
	public ArticulosBien() {
		setTitle("ARTICULOS");
		client = ClientBuilder.newClient();


		
		appTarget = client.target("http://localhost:8080/stock_manager/api/");
		articulosTarget = appTarget.path("getArticulos");

		articuloTarget = appTarget.path("eliminarArticulo");



		setSize(1000, 500);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		botonesPanel = new JPanel();
		articulosListModel = new DefaultListModel<>();


		articulosLista = new JList<>(articulosListModel);
		
		listScrollPane = new JScrollPane(articulosLista);
		getContentPane().add(listScrollPane, BorderLayout.WEST);
		
		
		genericType = new GenericType<List<Articulo>>() {};
		articulos = articulosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
	
		articulosListModel.clear();
		for(Articulo articulo: articulos) {
			articulosListModel.addElement(articulo);
		}

		

		eliminarBoton = new JButton("Eliminar articulo");
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
				
				dibujar();
			}

				
		});
		ordenarNombreBtn = new JButton("Ordenar por nombre");
		ordenarNombreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				articulos.sort(new Comparator<Articulo>(){
		            public int compare(Articulo o1, Articulo o2) {
		                return o1.getNombre().compareToIgnoreCase(o2.getNombre());
		        		}
		            
				});
				dibujar();
				
			}	
		});
		modificarBoton = new JButton("Modificar articulo");
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
		
		botonesPanel.add(eliminarBoton);
		getContentPane().add(botonesPanel, BorderLayout.SOUTH);

		getContentPane().add(botonesPanel, BorderLayout.SOUTH);
		
		btnanyadir = new JButton("Anyadir Articulo");
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
		
		
		btnNewButton = new JButton("Volver atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		
		ordenarIDBtn = new JButton("Ordenar por ID");
		ordenarIDBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				articulos.sort(new Comparator<Articulo>() {

					@Override
					public int compare(Articulo o1, Articulo o2) {
		                return Long.toString(o1.getId()).compareToIgnoreCase(Long.toString(o2.getId()));
					}
					
				});
				dibujar();
				
			}
		});
		
//		ordenarStockBtn = new JButton("Ordenar por stock");
//		ordenarStockBtn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				articulos.sort(new Comparator<Articulo>() {
//
//					@Override
//					public int compare(Articulo o1, Articulo o2) {
//		                return Integer.toString(o1.getStock()).compareToIgnoreCase(Integer.toString(o2.getStock()));
//					}
//				});
//				dibujar();
//				
//			}
//		});
		
		ordenarCaduBtn = new JButton("Ordenar por caducidad");
		ordenarCaduBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				articulos.sort(new Comparator<Articulo>() {

					@Override
					public int compare(Articulo o1, Articulo o2) {
		                return o1.getCaducidad().toString().compareToIgnoreCase(o2.getCaducidad().toString());
					}
				});
				dibujar();
				
			}
		});
		
		

		gl_botonesPanel = new GroupLayout(botonesPanel);
		gl_botonesPanel.setHorizontalGroup(
			gl_botonesPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_botonesPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_botonesPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(ordenarNombreBtn)
						.addComponent(ordenarIDBtn, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_botonesPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ordenarCaduBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ordenarStockBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(72)
					.addComponent(modificarBoton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(eliminarBoton)
					.addGap(18)
					.addComponent(btnanyadir)
					.addGap(51)
					.addComponent(btnNewButton)
					.addGap(120))
		);
		gl_botonesPanel.setVerticalGroup(
			gl_botonesPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_botonesPanel.createSequentialGroup()
					.addGroup(gl_botonesPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_botonesPanel.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_botonesPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(ordenarNombreBtn, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(ordenarStockBtn, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
							.addGroup(gl_botonesPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(ordenarIDBtn, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(ordenarCaduBtn, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, gl_botonesPanel.createSequentialGroup()
							.addContainerGap(19, Short.MAX_VALUE)
							.addGroup(gl_botonesPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(modificarBoton)
								.addComponent(eliminarBoton)
								.addComponent(btnanyadir)
								.addComponent(btnNewButton))))
					.addContainerGap())
		);
		botonesPanel.setLayout(gl_botonesPanel);
		

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
