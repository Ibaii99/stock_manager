//package src.main.java.es.deusto.spq.app;
//
//
//
//import static javax.swing.JOptionPane.ERROR_MESSAGE;
//
//import java.awt.BorderLayout;
//import java.awt.event.*;
//import java.text.SimpleDateFormat;
//import java.text.ParseException;
//
//import javax.swing.*;
//import javax.swing.JScrollPane;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.GenericType;
//import javax.ws.rs.core.Response.Status;
//
//import src.main.java.es.deusto.spq.data.Articulo;
//import src.main.java.es.deusto.spq.app.ModificarArticulo;
//
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.ProcessingException;
//
////import src.main.java.es.deusto.spq.data.Articulo;
////import src.main.java.es.deusto.spq.data.Articulo.Categoria;
//
//import java.util.Date;
//import java.util.List;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.LayoutStyle.ComponentPlacement;
//import java.awt.EventQueue;
//import java.awt.Dimension;
//
//
//
//
//public class ArticulosLista extends JFrame{
//
//	private static final long serialVersionUID = 1L;
//	private Client client;
//	private Date date;
//	private JTextField textField;
//	
//	public ArticulosLista() {
//		setTitle("ARTICULOS");
//		client = ClientBuilder.newClient();
//		final WebTarget appTarget = client.target("http://localhost:8080/stock_manager/api/");
//		final WebTarget articulosTarget = appTarget.path("getArticulos");
//		final WebTarget eliminarTarget = appTarget.path("code");
//		final WebTarget modificarTarget = appTarget.path("modificarArticulos");
//
//
//		setSize(1200, 500);
//
//		
////
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		
//		
//		JPanel botonesPanel = new JPanel();
//		
//		JButton eliminarBoton = new JButton("Eliminar articulo");
//
//		JButton anyadirBoton = new JButton("Anyadir articulo");
//		JButton modificarBoton = new JButton("Modificar articulo");
//		botonesPanel.add(eliminarBoton);
//		botonesPanel.add(anyadirBoton);
//		botonesPanel.add(modificarBoton);
//		
//		getContentPane().add(botonesPanel, BorderLayout.SOUTH);
//
//		getContentPane().add(botonesPanel, BorderLayout.SOUTH);
//		
//		JButton btnanyadir = new JButton("Anyadir Articulo");
//		btnanyadir.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				try {
//					CrearArticulo frame = new CrearArticulo();
//					frame.setVisible(true);
//				} catch (Exception er) {
//					er.printStackTrace();
//				}
//			}
//		});
//		GroupLayout gl_botonesPanel = new GroupLayout(botonesPanel);
//		gl_botonesPanel.setHorizontalGroup(
//			gl_botonesPanel.createParallelGroup(Alignment.LEADING)
//				.addGroup(Alignment.TRAILING, gl_botonesPanel.createSequentialGroup()
//					.addContainerGap(278, Short.MAX_VALUE)
//					.addComponent(eliminarBoton)
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addComponent(btnanyadir)
//					.addComponent(modificarBoton)
//					.addContainerGap())
//		);
//		gl_botonesPanel.setVerticalGroup(
//			gl_botonesPanel.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_botonesPanel.createSequentialGroup()
//					.addGap(5)
//					.addGroup(gl_botonesPanel.createParallelGroup(Alignment.BASELINE)
//						.addComponent(btnanyadir)
//						.addComponent(eliminarBoton)
//						.addComponent(modificarBoton)))
//		);
//		botonesPanel.setLayout(gl_botonesPanel);
//		
//		final DefaultListModel<Articulo> articulosListModel = new DefaultListModel<>();
//
//
//		final JList<Articulo> articulosLista = new JList<>(articulosListModel);
//		
//		JScrollPane listScrollPane = new JScrollPane(articulosLista);
//		getContentPane().add(listScrollPane, BorderLayout.WEST);
//		
//		GenericType<List<Articulo>> genericType = new GenericType<List<Articulo>>() {};
//		final List<Articulo> articulos = articulosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
//		articulosListModel.clear();
//		for(Articulo articulo: articulos) {
//			articulosListModel.addElement(articulo);
//			
//		}
//		
//		JPanel derecha = new JPanel();
//		getContentPane().add(derecha,BorderLayout.EAST);
//		
//		final JTextField codeTextField = new JTextField("",2);
//		derecha.add(codeTextField);
//		
//		textField = new JTextField("",2);
//		getContentPane().add(textField, BorderLayout.CENTER);
//		textField.setColumns(2);
//
//		
//		eliminarBoton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				
//				WebTarget deleteTarget = eliminarTarget.path(textField.getText());
//				Response response = deleteTarget.request().delete();
//				if(response.getStatus() == Status.OK.getStatusCode()) {
//					JOptionPane.showMessageDialog(ArticulosLista.this, "Articulo eliminado", "Message", JOptionPane.INFORMATION_MESSAGE);
//				}else {
//					JOptionPane.showMessageDialog(ArticulosLista.this, "No se pudo eliminar al usuario", "Message", JOptionPane.ERROR_MESSAGE);
//				}
//				
//			}
//		});
//		
//		modificarBoton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					ModificarArticulo frame = new ModificarArticulo();
//					frame.setVisible(true);
//				} catch (Exception er) {
//					er.printStackTrace();
//				} 
//				
//			}
//		});
//		setVisible(true);
//		
//	}
//	
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			
//			@Override
//			public void run() {
//				new ArticulosLista();
//				
//			}
//		});
//	}
//	
//	
//}