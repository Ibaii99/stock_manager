
package src.main.java.es.deusto.spq.app;

import java.awt.BorderLayout;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.GenericType;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class InicioSesion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField contrasenya_;

	
	  //Launch the application.
	 
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Client client;
	private final WebTarget usuariosTarget;
	
	 // Create the frame.
	 
	public InicioSesion() {
		client = ClientBuilder.newClient();
		final WebTarget appTarget = client.target("http://localhost:8080/stock_manager/api/");
		usuariosTarget = appTarget.path("get_usuarios");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel _contrasenya = new JPanel();
		contentPane.add(_contrasenya, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		
		JLabel lblNewLabel_1 = new JLabel("Contrasenya");
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usuario.setText("");
				contrasenya_.setText("");
			
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Aceptar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String usuarioCogido = usuario.getText();
				char[] c = contrasenya_.getPassword();
				String contrasenya = c.toString();
				GenericType<List<Usuario>> genericType = new GenericType<List<Usuario>>() {};
				
				List<Usuario> usuarios = usuariosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
				for(Usuario u: usuarios) {
					System.out.println(u.toString());
					System.out.println(u.getUser());
					if(usuarioCogido.equals(u.getUser()) && usuarioCogido.equals(u.getContrasenya())) {
						try {
							System.out.println("Correcto");
							Articulos_bien frame = new Articulos_bien();
							frame.setVisible(true);
						} catch (Exception es) {
							es.printStackTrace();
						}
					}
					
					
				}
			}
		});
		
		usuario = new JTextField();
		usuario.setColumns(10);
		
		contrasenya_ = new JPasswordField();
		contrasenya_.setEchoChar('*');
		contrasenya_.setColumns(10);
		
		GroupLayout gl__contrasenya = new GroupLayout(_contrasenya);
		gl__contrasenya.setHorizontalGroup(
			gl__contrasenya.createParallelGroup(Alignment.LEADING)
				.addGroup(gl__contrasenya.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl__contrasenya.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl__contrasenya.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(18)
							.addComponent(btnNewButton))
						.addGroup(gl__contrasenya.createSequentialGroup()
							.addGroup(gl__contrasenya.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addGap(15)
							.addGroup(gl__contrasenya.createParallelGroup(Alignment.TRAILING)
								.addComponent(contrasenya_, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
								.addComponent(usuario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl__contrasenya.setVerticalGroup(
			gl__contrasenya.createParallelGroup(Alignment.LEADING)
				.addGroup(gl__contrasenya.createSequentialGroup()
					.addGap(77)
					.addGroup(gl__contrasenya.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl__contrasenya.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(contrasenya_, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
					.addGroup(gl__contrasenya.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		_contrasenya.setLayout(gl__contrasenya);
	}

}