package main.java.es.deusto.spq.GUI;

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

import clases_stock_manager.*;

import main.java.es.deusto.spq.dataAdmin.Admin;

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
 

public class Articulos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Articulos frame = new Articulos();
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
	public Articulos() {
		DAO dao = new DAO();
		Admin admin = new Admin();
		List<Articulo> listaArticulos = dao.getArticulos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(100, 0, 0)));
		DefaultTableModel modelotabla = new DefaultTableModel();
		Object columnas[] = {"Id", "Nombre", "Fecha caducidad", "Precio", "Stock", "Descripcion", "Oferta", "Categoria", "Vendedor"};
		for(int i=0;i<listaArticulos.size();i++){
		    modelotabla.addRow(new Object[] {listaArticulos.get(i).getId(), listaArticulos.get(i).getNombre(), listaArticulos.get(i).getCaducidad(), listaArticulos.get(i).getPrecio(),listaArticulos.get(i).getStock(),
		    		listaArticulos.get(i).getStock(), listaArticulos.get(i).getDescripcion(), listaArticulos.get(i).getOferta(), listaArticulos.get(i).getCategoria(), listaArticulos.get(i).getVendedor()});
		}
		modelotabla.addColumn(columnas);
		
		
		table.setModel(modelotabla);//
		

		JLabel lblNewLabel = new JLabel("                                                        ARTICULOS");
		
		btnNewButton = new JButton("Eliminar articulo");
		int fila = table.getSelectedRow();
		if(btnNewButton.isSelected()) {
			modelotabla.removeRow(fila);
			
		}
		
		btnNewButton_1 = new JButton("Anyadir articulo");
		if(btnNewButton_1.isSelected()) {
			Articulo articulo1 = new Articulo();
			modelotabla.addRow(new Object[] {articulo1.getId(), articulo1.getNombre(), articulo1.getCaducidad(), articulo1.getPrecio(),articulo1.getStock()
					, articulo1.getDescripcion(), articulo1.getOferta(), articulo1.getVendedor()});
			admin.anyadirArticulo(articulo1);
			
		}

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(173)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(30))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(63)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(151)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}