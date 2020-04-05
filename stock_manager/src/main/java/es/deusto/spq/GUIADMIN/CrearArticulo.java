package es.deusto.spq.GUIADMIN;

import java.awt.BorderLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data_access.DAO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

public class CrearArticulo extends JFrame {

	private JPanel contentPane;
	private JTextField tnombre;
	private JTextField tcaducidad;
	private JTextField tstock;
	private JTextField tdescripcion;
	private JTextField toferta;
	private JTextField tcategoria;
	private JTextField tprecio;
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

	/**
	 * Create the frame.
	 */
	public CrearArticulo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel tvendedor = new JPanel();
		contentPane.add(tvendedor, BorderLayout.CENTER);
		
		JLabel nombre = new JLabel("Nombre:");
		
		JLabel caducidad = new JLabel("Caducidad:");
		
		JLabel stock = new JLabel("Stock:");
		
		JLabel descripcion = new JLabel("Descripcon:");
		
		JLabel oferta = new JLabel("Oferta:");
		
		JLabel categoria = new JLabel("Categoria:");
		
		tnombre = new JTextField();
		tnombre.setColumns(10);
		
		tcaducidad = new JTextField();
		tcaducidad.setColumns(10);
		
		tstock = new JTextField();
		tstock.setColumns(10);
		
		tdescripcion = new JTextField();
		tdescripcion.setColumns(10);
		
		toferta = new JTextField();
		toferta.setColumns(10);
		
		tcategoria = new JTextField();
		tcategoria.setColumns(10);
		
		JLabel titulo = new JLabel("Crear Articulo");
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

					try {
						ShowArticulos frame = new ShowArticulos();
						frame.setVisible(true);
					} catch (Exception es) {
						es.printStackTrace();
					}
				
			}
		});
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nom = tnombre.getText();
				String cad = tcaducidad.getText();
				SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
				try {
					date = formatter1.parse(cad);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String pre = tprecio.getText();
				int p = Integer.parseInt(pre);
				String st = tstock.getText();
				int s = Integer.parseInt(st);
				String des = tdescripcion.getText();
				String ofer = toferta.getText();
				int o = Integer.parseInt(ofer);
				String cat = tcategoria.getText();
				Categoria c = Categoria.valueOf(cat);
//				
				Articulo a = new Articulo(nom, date, p, s, des, o, c);
				DAO dao = new DAO();
				dao.store(a);
				System.out.println("GUARDADO!!!");
				
			}
		});
		
		JLabel precio = new JLabel("Precio:");
		
		tprecio = new JTextField();
		tprecio.setColumns(10);
		GroupLayout gl_tvendedor = new GroupLayout(tvendedor);
		gl_tvendedor.setHorizontalGroup(
			gl_tvendedor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tvendedor.createSequentialGroup()
					.addGap(176)
					.addComponent(titulo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(251, Short.MAX_VALUE))
				.addGroup(gl_tvendedor.createSequentialGroup()
					.addGroup(gl_tvendedor.createParallelGroup(Alignment.LEADING)
						.addComponent(caducidad)
						.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tvendedor.createParallelGroup(Alignment.LEADING)
						.addComponent(tnombre, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
						.addComponent(tcaducidad, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_tvendedor.createSequentialGroup()
					.addComponent(precio, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tprecio, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_tvendedor.createSequentialGroup()
					.addGroup(gl_tvendedor.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tvendedor.createSequentialGroup()
							.addGap(218)
							.addComponent(aceptar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cancelar))
						.addGroup(gl_tvendedor.createSequentialGroup()
							.addGroup(gl_tvendedor.createParallelGroup(Alignment.LEADING)
								.addComponent(stock, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(descripcion)
								.addComponent(oferta, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(categoria))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_tvendedor.createParallelGroup(Alignment.LEADING)
								.addComponent(tcategoria, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
								.addComponent(toferta, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
								.addComponent(tdescripcion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
								.addGroup(gl_tvendedor.createSequentialGroup()
									.addComponent(tstock, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGap(20))
		);
		gl_tvendedor.setVerticalGroup(
			gl_tvendedor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tvendedor.createSequentialGroup()
					.addComponent(titulo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tvendedor.createParallelGroup(Alignment.BASELINE)
						.addComponent(nombre)
						.addComponent(tnombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tvendedor.createParallelGroup(Alignment.BASELINE)
						.addComponent(caducidad)
						.addComponent(tcaducidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tvendedor.createParallelGroup(Alignment.BASELINE)
						.addComponent(precio)
						.addComponent(tprecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tvendedor.createParallelGroup(Alignment.BASELINE)
						.addComponent(stock)
						.addComponent(tstock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tvendedor.createParallelGroup(Alignment.BASELINE)
						.addComponent(descripcion)
						.addComponent(tdescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tvendedor.createParallelGroup(Alignment.BASELINE)
						.addComponent(oferta)
						.addComponent(toferta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tvendedor.createParallelGroup(Alignment.BASELINE)
						.addComponent(categoria)
						.addComponent(tcategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
					.addGroup(gl_tvendedor.createParallelGroup(Alignment.BASELINE)
						.addComponent(cancelar)
						.addComponent(aceptar))
					.addContainerGap())
		);
		tvendedor.setLayout(gl_tvendedor);
	}
}
