package es.deusto.spq.GUIADMIN;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
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
import javax.swing.ListModel;
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
		Label lblNewLabel = new Label("              Articulos");
		 JList articulos = new JList();
        DefaultListModel<String> listModel = new DefaultListModel();
        for(int i=0; i<listaArticulos.size(); i++) {
            listModel.add(i, listaArticulos.get(i).getNombre());
        }
        //Asociar el modelo de lista al JList
        articulos.setModel(listModel);
        
        
		btnNewButton = new JButton("Eliminar articulo");
		int fila = articulos.getSelectedIndex();
		if(btnNewButton.isSelected()) {
			articulos.remove(fila);
			
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
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(30))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(articulos, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(234, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(articulos, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}



