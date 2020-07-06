package presentacion;

import java.awt.EventQueue;
import dominio.*;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Acceso_Usuario extends Acceso {

	private JFrame frmAcceso;
	private JTextField textusuario;
	private JPasswordField passwordclave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceso_Usuario window = new Acceso_Usuario();
					window.frmAcceso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Acceso_Usuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAcceso = new JFrame();
		frmAcceso.setResizable(false);
		frmAcceso.setTitle("Acceso");
		frmAcceso.setBounds(100, 100, 381, 202);
		frmAcceso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAcceso.getContentPane().setLayout(new BoxLayout(frmAcceso.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		frmAcceso.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(31, 21, 69, 14);
		panel.add(lblNewLabel);
		
		textusuario = new JTextField();
		textusuario.setBounds(84, 18, 130, 20);
		panel.add(textusuario);
		textusuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(31, 61, 69, 14);
		panel.add(lblNewLabel_1);
		
		JButton buttoningresar = new JButton("Aceptar");
		buttoningresar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				char[] arrayclave=passwordclave.getPassword();
				String clave=new String(arrayclave);
					for(int f=0;f<x;f++) {
						if(textusuario.getText().equals(usuario[f]) && clave.equals(contraseña[f])) {
							Agregar_Cliente.main(null);
							frmAcceso.dispose();
						}else if(textusuario.getText().equals("") || clave.equals("")) {
							JOptionPane.showMessageDialog(null, "Llene los campos vacíos.");
						}else {
							JOptionPane.showMessageDialog(null, "Datos incorrectos");
						}
					}
					
			}
		});
		
		buttoningresar.setBounds(33, 115, 89, 23);
		panel.add(buttoningresar);
		
		JButton buttonsalir = new JButton("Salir");
		buttonsalir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				frmAcceso.dispose();
			}
		});
		buttonsalir.setBounds(194, 115, 89, 23);
		panel.add(buttonsalir);
		
		passwordclave = new JPasswordField();
		passwordclave.setBounds(104, 58, 111, 20);
		panel.add(passwordclave);
	}
}
