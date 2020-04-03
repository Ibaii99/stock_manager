package es.deusto.spq;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;

import es.deusto.spq.data.Articulo;
import es.deusto.spq.data_access.DAO;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
 

public class Articulos extends JFrame {

	private JPanel contentPane;

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
		List<Articulo> listaArticulos = dao.getArticulos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JList list = new JList();
		list.setValueIsAdjusting(true);
		
		DefaultListModel listModel = new DefaultListModel();
		list.setModel(listModel);
		for(int i=0; i<listaArticulos.size(); i++) {
		    listModel.add(i, listaArticulos.get(i));
		    listModel.addElement(listaArticulos);
		}
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(260, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
	}
}