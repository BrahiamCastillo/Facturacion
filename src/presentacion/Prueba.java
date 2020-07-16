package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.Cliente;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Prueba extends Cliente {

	private JFrame frame;
	private JTextField textfiltro;
	private JTable table;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba window = new Prueba();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textfiltro = new JTextField();
		modelo=new DefaultTableModel();
		textfiltro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				for(int f=0;f<x;f++) {
					if(nombre[f].equals(textfiltro.getText())) {
						Object[] fila= {nombre[f],apellido[f],codigo[f]};
						modelo.addRow(fila);
					}
				}
			}
		});
		frame.getContentPane().add(textfiltro, BorderLayout.NORTH);
		textfiltro.setColumns(10);
		
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Còdigo");
		table = new JTable(modelo);
		JScrollPane pane=new JScrollPane(table);
		frame.getContentPane().add(pane, BorderLayout.CENTER);
	}

}
