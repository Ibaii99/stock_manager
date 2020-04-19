package src.main.java.es.deusto.spq.app;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response.Status;

import src.main.java.es.deusto.spq.data.Articulo;
import src.main.java.es.deusto.spq.data.Articulo.Categoria;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.ProcessingException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CrearArticulo extends JFrame {

	private JPanel contentPane;
	private JTextField tUrl;
	private JTextField tcategoria;
	private JTextField toferta;
	private JTextField tdescripcion;
	private JTextField tstock;
	private JTextField tprecio;
	private JTextField tnombre;
	private JTextField tcaducidad;
	private JTextField tid;
	private Date date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearArticulo frame = new CrearArticulo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private Client client;

	/**
	 * Create the frame.
	 */
	public CrearArticulo() {
		client = ClientBuilder.newClient();
		final WebTarget appTarget = client.target("http://localhost:8080/stock_manager/api/");

		final WebTarget articuloTarget = appTarget.path("ingresarArticulo");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel caducidad = new JPanel();
		contentPane.add(caducidad, BorderLayout.NORTH);
		
		JLabel lnombre = new JLabel("Nombre:");
		
		JLabel lcaducidad = new JLabel("Fecha caducidad:");
		
		JLabel lprecio = new JLabel("Precio:");
		
		JLabel lstock = new JLabel("Stock:");
		
		JLabel ldescripcion = new JLabel("Descripcion:");
		
		JLabel loferta = new JLabel("Oferta:");
		
		JLabel lcategoria = new JLabel("Categoria:");
		
		JLabel lurl = new JLabel("URL Imagen:");
		
		tUrl = new JTextField();
		tUrl.setColumns(10);
		
		tcategoria = new JTextField();
		tcategoria.setColumns(10);
		
		toferta = new JTextField();
		toferta.setColumns(10);
		
		tdescripcion = new JTextField();
		tdescripcion.setColumns(10);
		
		tstock = new JTextField();
		tstock.setColumns(10);
		
		tprecio = new JTextField();
		tprecio.setColumns(10);
		
		tcaducidad = new JTextField();
		tcaducidad.setColumns(10);
		
		tnombre = new JTextField();
		tnombre.setColumns(10);
		
		JButton btncancelar = new JButton("Cancelar");
		btncancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					System.out.println("Ha pulsaod cancelar, volver a pagina anterior");
					Articulos_bien frame = new Articulos_bien();
					frame.setVisible(true);
					dispose();
				} catch (Exception es) {
					es.printStackTrace();
				}
			}
		});
		
		JButton btnaceptar = new JButton("Aceptar");
		btnaceptar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = tnombre.getText();
				String cadu = tcaducidad.getText();
				Date caduci = null;
				 SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
	                try {
	                	 caduci = formatter1.parse(cadu);
	                } catch (ParseException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                }
			    String pre = tprecio.getText();
			    float precio = Float.parseFloat(pre);
			    String s = tstock.getText();
			    int stock = Integer.parseInt(s);
			    String descripcion = tdescripcion.getText();
			    String of = toferta.getText();
			    float oferta=Float.parseFloat(of);
			    String cat = tcategoria.getText();
			    Categoria categoria = Categoria.valueOf(cat);
			    String image_url = tUrl.getText();
			    
			    Articulo articulo = new Articulo(nombre, caduci, precio, stock, descripcion, oferta,categoria, image_url);
			    System.out.println(articulo);
			    articuloTarget.request().post(Entity.entity(articulo, MediaType.APPLICATION_JSON));
			    System.out.println("Articulo anadido");

			}
		});

		GroupLayout gl_caducidad = new GroupLayout(caducidad);
		gl_caducidad.setHorizontalGroup(
			gl_caducidad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_caducidad.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_caducidad.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_caducidad.createSequentialGroup()
							.addGroup(gl_caducidad.createParallelGroup(Alignment.LEADING)
								.addComponent(lnombre, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(lcaducidad, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_caducidad.createParallelGroup(Alignment.LEADING)
								.addComponent(tcaducidad, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
								.addComponent(tnombre, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)))
						.addGroup(gl_caducidad.createSequentialGroup()
							.addGroup(gl_caducidad.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lprecio, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(lstock, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(loferta, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(ldescripcion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lcategoria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lurl))
							.addGap(18)
							.addGroup(gl_caducidad.createParallelGroup(Alignment.LEADING)
								.addComponent(tcategoria, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
								.addComponent(tUrl, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
								.addComponent(toferta, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
								.addComponent(tdescripcion, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
								.addComponent(tstock, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
								.addComponent(tprecio, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_caducidad.createSequentialGroup()
							.addComponent(btnaceptar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btncancelar)))
					.addContainerGap())
		);
		gl_caducidad.setVerticalGroup(
			gl_caducidad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_caducidad.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_caducidad.createParallelGroup(Alignment.BASELINE)
						.addComponent(lnombre)
						.addComponent(tnombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.TRAILING)
						.addComponent(tcaducidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lcaducidad))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.BASELINE)
						.addComponent(lprecio)
						.addComponent(tprecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.BASELINE)
						.addComponent(lstock)
						.addComponent(tstock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.BASELINE)
						.addComponent(ldescripcion)
						.addComponent(tdescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.BASELINE)
						.addComponent(loferta)
						.addComponent(toferta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.BASELINE)
						.addComponent(lcategoria)
						.addComponent(tcategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.BASELINE)
						.addComponent(lurl)
						.addComponent(tUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.BASELINE)
						.addComponent(btncancelar)
						.addComponent(btnaceptar))
					.addContainerGap())
		);
		caducidad.setLayout(gl_caducidad);
	}
}
