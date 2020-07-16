package presentacion;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.border.Border;

import dominio.Acceso;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Acceso_Usuario extends Acceso {

	private JFrame frmAccesoUsuario;
	private JTextField textusuario;
	private JPasswordField passwordclave;
	public static int idingreso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceso_Usuario window = new Acceso_Usuario();
					window.frmAccesoUsuario.setVisible(true);
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
		frmAccesoUsuario = new JFrame();
		frmAccesoUsuario.setResizable(false);
		frmAccesoUsuario.setForeground(Color.DARK_GRAY);
		frmAccesoUsuario.setBackground(Color.DARK_GRAY);
		frmAccesoUsuario.setTitle("Acceso Usuario");
		frmAccesoUsuario.setBounds(550, 300, 352, 189);
		frmAccesoUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Credenciales del usuario:");
		frmAccesoUsuario.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		Border blackline=BorderFactory.createLineBorder(Color.BLACK);
		frmAccesoUsuario.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setBorder(blackline);
		panel.setLayout(gbl_panel);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 0;
		panel.add(lblUsuario, gbc_lblUsuario);
		
		textusuario = new JTextField();
		GridBagConstraints gbc_textusuario = new GridBagConstraints();
		gbc_textusuario.insets = new Insets(0, 0, 5, 0);
		gbc_textusuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textusuario.gridx = 1;
		gbc_textusuario.gridy = 0;
		panel.add(textusuario, gbc_textusuario);
		textusuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 0, 5);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 1;
		panel.add(lblContrasea, gbc_lblContrasea);
		
		passwordclave = new JPasswordField();
		GridBagConstraints gbc_passwordclave = new GridBagConstraints();
		gbc_passwordclave.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordclave.gridx = 1;
		gbc_passwordclave.gridy = 1;
		panel.add(passwordclave, gbc_passwordclave);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		frmAccesoUsuario.getContentPane().add(panel1, BorderLayout.SOUTH);
		panel1.setBorder(blackline);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			private String usuariolocal;
			private String clavelocal;

			public void actionPerformed(ActionEvent arg0) {
				char[] arrayclave=passwordclave.getPassword();
				String clave=new String(arrayclave);
				for(int f=0;f<x;f++) {
					if(textusuario.getText().equals(usuario[f]) && clave.equals(contraseña[f])) {
						usuariolocal=usuario[f];
						clavelocal=contraseña[f];
						JOptionPane.showMessageDialog(null, "Credenciales correctas.");
					}
				}
				
				if(textusuario.getText().equals(usuariolocal) && clavelocal.equals(clave)) {
					Principal.frameprincipal.setEnabled(true);
					frmAccesoUsuario.dispose();
				}else if(textusuario.getText().equals("") || clave.equals("")) {
					JOptionPane.showMessageDialog(null, "Llene los espacios en blanco.");
				}else {
					JOptionPane.showMessageDialog(null, "Datos incorrectos.");
				}
				
			}
		});
		panel1.add(btnIngresar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAccesoUsuario.dispose();
			}
		});
		panel1.add(btnSalir);
	}

}
