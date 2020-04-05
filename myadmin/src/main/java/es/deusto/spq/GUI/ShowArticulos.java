
package es.deusto.spq.GUI;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.*;

import javax.ws.rs.core.MediaType;

import es.deusto.spq.data.Articulo;

import javax.ws.rs.core.GenericType;
import javax.swing.JPanel;

public class ShowArticulos extends JFrame {
	private Client client;
	private DefaultListModel<Articulo>articuloListModel = new DefaultListModel<>();
	
	public ShowArticulos() {
		client = ClientBuilder.newClient();
		WebTarget appTarget = client.target("http://localhost:8080/stock_manager/");
		WebTarget articulosTarget = appTarget.path("Articulo");
		GenericType<List<Articulo>> genericType = new GenericType<List<Articulo>>() {};

		WebTarget allArticulosTarget = articulosTarget.path("get_articulos");
		List<Articulo> articulos = allArticulosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
	
		
		JList<Articulo> listArticulos = new JList<>(articuloListModel);
		
		articuloListModel.clear();
		for(Articulo articulo:articulos) {
			articuloListModel.addElement(articulo);
		}
		
		JButton anyadirBoton = new JButton("Anyadir articulo\r\n");
		if(anyadirBoton.isSelected()) {
			CrearArticulo cr = new CrearArticulo();
			cr.setVisible(true);
		}
		
		JButton eliminarBoton = new JButton("Eliminar articulo");
		if(eliminarBoton.isSelected()) {
			int fila = listArticulos.getSelectedIndex();
			articuloListModel.remove(fila);
			articulos.remove(fila);
		}
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addComponent(anyadirBoton)
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
					.addComponent(eliminarBoton)
					.addGap(55))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(217, Short.MAX_VALUE)
					.addComponent(listArticulos)
					.addGap(217))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(listArticulos)
					.addGap(215)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(anyadirBoton)
						.addComponent(eliminarBoton))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
}
