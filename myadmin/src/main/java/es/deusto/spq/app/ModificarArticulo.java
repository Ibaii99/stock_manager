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
import javax.swing.SpinnerListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import com.toedter.calendar.JCalendar;
import java.awt.Dimension;


public class ModificarArticulo extends JFrame {

	private JPanel contentPane;
	private JTextField tUrl;
	private JTextField toferta;
	private JTextField tdescripcion;
	private JTextField tstock;
	private JTextField tprecio;
	private JTextField tnombre;
	private JTextField tid;
	private Date date;
	private Client client;
	private JSpinner categoriaSpinner;
	private JCalendar calendar;

	/**
	 * Create the frame.
	 */
	public ModificarArticulo(final Articulo a) {
		setTitle("MODIFICAR ARTICULO");
		setMinimumSize(new Dimension(725, 527));
		client = ClientBuilder.newClient();
		final WebTarget appTarget = client.target("http://localhost:8080/stock_manager/api/");

		final WebTarget articuloTarget = appTarget.path("actualizarArticulo");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel caducidad = new JPanel();
		
		JLabel lnombre = new JLabel("Nombre:");
		
		JLabel lcaducidad = new JLabel("Fecha caducidad:");
		
		JLabel lprecio = new JLabel("Precio:");
		
		JLabel lstock = new JLabel("Stock:");
		
		JLabel ldescripcion = new JLabel("Descripcion:");
		
		JLabel loferta = new JLabel("Oferta:");
		
		JLabel lcategoria = new JLabel("Categoria:");
		
		JLabel lurl = new JLabel("URL Imagen:");
		
		
		tUrl = new JTextField(a.getImageUrl());
		tUrl.setColumns(10);
		
		toferta = new JTextField(Float.toString(a.getOferta()));
		toferta.setColumns(10);
		
		tdescripcion = new JTextField(a.getDescripcion());
		tdescripcion.setColumns(10);
		
		tstock = new JTextField(Integer.toString(a.getStock()));
		tstock.setColumns(10);
		
		tprecio = new JTextField(Float.toString(a.getPrecio()));
		tprecio.setColumns(10);
		
		tnombre = new JTextField(a.getNombre());
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
				String anyo = Integer.toString(calendar.getCalendar().get(java.util.Calendar.YEAR));
				System.out.println(anyo);
				String mes = Integer.toString(calendar.getCalendar().get(java.util.Calendar.MONTH) + 1);
				System.out.println(mes);
				String dia = Integer.toString(calendar.getCalendar().get(java.util.Calendar.DATE));
				System.out.println(dia);
				String cadu = dia +"/"+mes+"/"+anyo;
				System.out.println(cadu.toString());
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
			    String cat = (String) categoriaSpinner.getValue();
			    System.out.println(cat);
			    Categoria categoria = Categoria.valueOf(cat);
			    String image_url = tUrl.getText();
			 
			   
			    a.setNombre(nombre);
			    a.setCaducidad(caduci);
			    a.setPrecio(precio);
			    a.setStock(stock);
			    a.setDescripcion(descripcion);
			    a.setOferta(oferta);
			    a.setCategoria(categoria);
			    a.setImageUrl(image_url); 
			    System.out.println(a);
			    articuloTarget.request().post(Entity.entity(a, MediaType.APPLICATION_JSON));
			    System.out.println("Articulo modificado");

			}
		});
		
		SpinnerListModel model1 = null;
//		if(a.getCategoria().toString() == "FRUTAS") {
		String[] c = {"FRUTAS","FRUTOSSECOS","VERDURAS","ZUMOS"};
//		}else if
		model1 = new SpinnerListModel(c);
		
		categoriaSpinner = new JSpinner(model1);
		categoriaSpinner.setValue(a.getCategoria().toString());
		
		calendar = new JCalendar();
		Calendar fecha = Calendar.getInstance();
		fecha.setTime(a.getCaducidad());
		calendar.setCalendar(fecha);
		
		GroupLayout gl_caducidad = new GroupLayout(caducidad);
		gl_caducidad.setHorizontalGroup(
			gl_caducidad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_caducidad.createSequentialGroup()
					.addGroup(gl_caducidad.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_caducidad.createSequentialGroup()
							.addGap(10)
							.addComponent(lnombre, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(tnombre, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_caducidad.createSequentialGroup()
							.addGap(10)
							.addComponent(lcaducidad, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(calendar, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_caducidad.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_caducidad.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_caducidad.createSequentialGroup()
									.addComponent(lprecio, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(34)
									.addComponent(tprecio, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_caducidad.createSequentialGroup()
									.addComponent(lstock, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(34)
									.addComponent(tstock, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_caducidad.createSequentialGroup()
									.addComponent(ldescripcion, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(tdescripcion, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_caducidad.createSequentialGroup()
									.addComponent(loferta, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(34)
									.addComponent(toferta, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_caducidad.createSequentialGroup()
									.addComponent(lcategoria, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(categoriaSpinner, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_caducidad.createSequentialGroup()
									.addComponent(lurl)
									.addGap(18)
									.addComponent(tUrl, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_caducidad.createSequentialGroup()
									.addGap(497)
									.addComponent(btnaceptar)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btncancelar)))))
					.addContainerGap(149, Short.MAX_VALUE))
		);
		gl_caducidad.setVerticalGroup(
			gl_caducidad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_caducidad.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_caducidad.createSequentialGroup()
							.addGap(3)
							.addComponent(lnombre))
						.addComponent(tnombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.LEADING)
						.addComponent(lcaducidad)
						.addComponent(calendar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_caducidad.createSequentialGroup()
							.addGap(3)
							.addComponent(lprecio))
						.addComponent(tprecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_caducidad.createSequentialGroup()
							.addGap(3)
							.addComponent(lstock))
						.addComponent(tstock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_caducidad.createSequentialGroup()
							.addGap(3)
							.addComponent(ldescripcion))
						.addComponent(tdescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.BASELINE)
						.addComponent(toferta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(loferta))
					.addGap(11)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_caducidad.createSequentialGroup()
							.addGap(3)
							.addComponent(lcategoria))
						.addComponent(categoriaSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.BASELINE)
						.addComponent(tUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lurl))
					.addGap(27)
					.addGroup(gl_caducidad.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnaceptar)
						.addComponent(btncancelar))
					.addGap(207))
		);
		caducidad.setLayout(gl_caducidad);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(caducidad, GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(caducidad, GroupLayout.PREFERRED_SIZE, 469, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarArticulo frame = new ModificarArticulo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
