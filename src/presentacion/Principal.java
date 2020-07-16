package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Principal {

	public static JFrame frameprincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					@SuppressWarnings("unused")
					Principal window = new Principal();
					Principal.frameprincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		Acceso_Usuario.main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameprincipal = new JFrame();
		frameprincipal.setEnabled(false);
		frameprincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frameprincipal.setBounds(100, 100, 450, 300);
		frameprincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
