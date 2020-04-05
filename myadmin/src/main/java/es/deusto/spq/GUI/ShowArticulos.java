
package es.deusto.spq.GUI;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;

import es.deusto.spq.*;
import es.deusto.spq.data.*;
import es.deusto.spq.data_access.*;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 

public class ShowArticulos extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JList articulos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowArticulos frame = new ShowArticulos();
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
	public ShowArticulos() {
		DAO dao = new DAO();
		List<Articulo> listaArticulos = dao.getArticulos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		DefaultTableModel modelotabla = new DefaultTableModel();
		Object columnas[] = {"Id", "Nombre", "Fecha caducidad", "Precio", "Stock", "Descripcion", "Oferta", "Categoria", "Vendedor"};
		for(int i=0;i<listaArticulos.size();i++){
		    modelotabla.addRow(new Object[] {listaArticulos.get(i).getId(), listaArticulos.get(i).getNombre(), listaArticulos.get(i).getCaducidad(), listaArticulos.get(i).getPrecio(),listaArticulos.get(i).getStock(),
		    		listaArticulos.get(i).getStock(), listaArticulos.get(i).getDescripcion(), listaArticulos.get(i).getOferta(), listaArticulos.get(i).getCategoria(), listaArticulos.get(i).getVendedor()});
		}
		modelotabla.addColumn(columnas);
		

		JLabel lblNewLabel = new JLabel("                                                        ARTICULOS");
		
	
		
		articulos = new JList();
		//Crear un objeto DefaultListModel
		DefaultListModel<String> listModel = new DefaultListModel();
		//Recorrer el contenido del ArrayList
		for(int i=0; i<listaArticulos.size(); i++) {
		    listModel.add(i, listaArticulos.get(i).getNombre());
		}
		//Asociar el modelo de lista al JList
		articulos.setModel(listModel);
		
		btnNewButton = new JButton("Eliminar articulo");
		if(btnNewButton.isSelected()) {
			listModel.remove(articulos.getSelectedIndex());
			listaArticulos.remove(articulos.getSelectedIndex());
		}
		
		btnNewButton_1 = new JButton("Anyadir articulo");
		if(btnNewButton_1.isSelected()) {
			CrearArticulo cr = new CrearArticulo();
			cr.setVisible(true);
		}
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(30))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(65, Short.MAX_VALUE)
					.addComponent(articulos, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(articulos, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
