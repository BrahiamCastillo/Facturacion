package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.border.Border;

import dominio.Contenedor;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Agregar_Cliente {

	private JFrame frmAgregarCliente;
	private JTextField textnombre;
	private JTextField textapellido;
	private JTextField textcedula;
	private JTextField textdireccion;
	private JTextField texttelefono;

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
		frmAgregarCliente.setResizable(false);
		frmAgregarCliente.setTitle("Agregar Cliente");
		frmAgregarCliente.setBounds(550, 250, 600, 250);
		frmAgregarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Border blackline=BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
		JLabel lblAgregarNuevoCliente = new JLabel("                                              Agregar nuevo cliente:");
		lblAgregarNuevoCliente.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAgregarNuevoCliente.setBorder(blackline);
		frmAgregarCliente.getContentPane().add(lblAgregarNuevoCliente, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		frmAgregarCliente.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(10, 10, 10, 10);
		panel_1.setBorder(blackline);
		gbc_panel_1.anchor=GridBagConstraints.NORTHWEST;
		gbc_panel_1.fill=GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_1.add(panel_3);
		
		JLabel lblNombre = new JLabel("Nombre:");
		panel_3.add(lblNombre);
		
		textnombre = new JTextField();
		panel_3.add(textnombre);
		textnombre.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_1.add(panel_4);
		
		JLabel lblApellido = new JLabel("Apellido:");
		panel_4.add(lblApellido);
		
		textapellido = new JTextField();
		panel_4.add(textapellido);
		textapellido.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.GRAY);
		panel_1.add(panel_5);
		
		JLabel lblCedula = new JLabel("Cedula:");
		panel_5.add(lblCedula);
		
		textcedula = new JTextField();
		panel_5.add(textcedula);
		textcedula.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.GRAY);
		panel_1.add(panel_6);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		panel_6.add(lblDireccin);
		
		textdireccion = new JTextField();
		panel_6.add(textdireccion);
		textdireccion.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.GRAY);
		panel_1.add(panel_7);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		panel_7.add(lblTelefono);
		
		texttelefono = new JTextField();
		panel_7.add(texttelefono);
		texttelefono.setColumns(10);
		
		JSeparator separator = new JSeparator();
		frmAgregarCliente.getContentPane().add(separator, BorderLayout.SOUTH);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.GRAY);
		panel_8.setBorder(blackline);
		frmAgregarCliente.getContentPane().add(panel_8, BorderLayout.WEST);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
		
		JLabel lblreservado = new JLabel("    Brahianny's Mueblería.");
		lblreservado.setFont(new Font("Dyuthi", Font.BOLD, 12));
		lblreservado.setForeground(Color.RED);
		panel_8.add(lblreservado);
		
		JLabel lblComedor = new JLabel();
		ImageIcon comedor=new ImageIcon(new ImageIcon("src/images/comedor.png").getImage().getScaledInstance(160, 200, Image.SCALE_DEFAULT));
		lblComedor.setIcon(comedor);
		panel_8.add(lblComedor);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.GRAY);
		panel_9.setBorder(blackline);
		frmAgregarCliente.getContentPane().add(panel_9, BorderLayout.EAST);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{0, 0};
		gbl_panel_9.rowHeights = new int[]{0, 0, 0};
		gbl_panel_9.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{0.0, Double.MIN_VALUE, 0.0};
		panel_9.setLayout(gbl_panel_9);
		
		JButton btnAgregar = new JButton();
		btnAgregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int res=JOptionPane.showConfirmDialog(null, "¿ Desea ingresar los datos ?","Confirmación",JOptionPane.YES_NO_CANCEL_OPTION);
				if(JOptionPane.YES_OPTION==res) {
					String insert="INSERT INTO persona(nombre,apellido,cedula,direccion,telefono,idusuario) VALUES ('"+textnombre.getText()+"','"+textapellido.getText()+"','"+textcedula.getText()+"','"+textdireccion.getText()+"','"+texttelefono.getText()+"','"+Acceso_Usuario.idingreso+"')";
					try {
						Contenedor.Insercion(insert);
						Contenedor.st.close();
						JOptionPane.showMessageDialog(null, "¡Datos ingresados","Notificación",JOptionPane.INFORMATION_MESSAGE);
						textnombre.setText("");
						textapellido.setText("");
						textcedula.setText("");
						textdireccion.setText("");
						texttelefono.setText("");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if(JOptionPane.CANCEL_OPTION==res) {
					textnombre.setText("");
					textapellido.setText("");
					textcedula.setText("");
					textdireccion.setText("");
					texttelefono.setText("");
				}
			}
			
		});
		ImageIcon guardar=new ImageIcon(new ImageIcon("src/images/guardar.png").getImage().getScaledInstance(60, 200, Image.SCALE_DEFAULT));
		btnAgregar.setIcon(guardar);
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.insets = new Insets(5, 5, 5, 5);
		gbc_btnAgregar.fill=GridBagConstraints.BOTH;
		gbc_btnAgregar.gridx = 0;
		gbc_btnAgregar.gridy = 0;
		gbc_btnAgregar.gridheight=2;
		gbc_btnAgregar.gridwidth=2;
		panel_9.add(btnAgregar, gbc_btnAgregar);
		
		JButton btnSalir = new JButton();
		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frmAgregarCliente.dispose();
			}
			
		});
		ImageIcon exit=new ImageIcon(new ImageIcon("src/images/exit.png").getImage().getScaledInstance(60, 200, Image.SCALE_DEFAULT));
		btnSalir.setIcon(exit);
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.insets = new Insets(5, 5, 5, 5);
		gbc_btnSalir.fill=GridBagConstraints.BOTH;
		gbc_btnSalir.gridx = 2;
		gbc_btnSalir.gridy = 0;
		gbc_btnSalir.gridheight=2;
		gbc_btnSalir.gridwidth=2;
		panel_9.add(btnSalir, gbc_btnSalir);
	}
}
