package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Agregar_Cliente {

	private JFrame frmAgregarCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agregar_Cliente window = new Agregar_Cliente();
					window.frmAgregarCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Agregar_Cliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarCliente = new JFrame();
		frmAgregarCliente.setTitle("Agregar Cliente");
		frmAgregarCliente.setBounds(100, 100, 450, 300);
		frmAgregarCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
