package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controlador;
import model.Modelo;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaUsuariosAdmin extends JFrame {
	Modelo modelo = new Modelo();
	Controlador control = new Controlador(this, modelo);
	//variables declarations - do not modify
	private JPanel contentPane;
	private String nombre;
	private JButton btnAtras;
	private JButton btnEliminar;
	private JButton btnDetalles;
	private JTextField textMostrarNombre;
	private JTextField textMostrarApellido;
	private JTextField textMostrarUsuario;
	private JTextField textMostrarCorreo;
	private JTextField textMostrarDireccion;
	private JTextField textMostrarTelefono;
	private JTextField textMostrarClave;
	private JLabel lblClave;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblUser;
	private JLabel lblCorreo;
	private JLabel lblDir;
	private JLabel lblTelefono;
	private JLabel lblDeEstado;
	
	// end of variables declarations
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuariosAdmin frame = new VentanaUsuariosAdmin();
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
	public VentanaUsuariosAdmin() {
		initComponents();
		control.iniciaVentana(this);
	}
	
	public void initComponents(){	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atrasActionPerformed(e);
			}
		});
		btnAtras.setBounds(785, 11, 89, 23);
		contentPane.add(btnAtras);
		
		
		textMostrarNombre = new JTextField();
		textMostrarNombre.setEditable(false);
		textMostrarNombre.setBounds(281, 79, 119, 20);
		contentPane.add(textMostrarNombre);
		textMostrarNombre.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(211, 82, 62, 14);
		contentPane.add(lblNombre);
		
		textMostrarApellido = new JTextField();
		textMostrarApellido.setEditable(false);
		textMostrarApellido.setColumns(10);
		textMostrarApellido.setBounds(281, 110, 119, 20);
		contentPane.add(textMostrarApellido);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setBounds(211, 113, 62, 14);
		contentPane.add(lblApellido);
		
		textMostrarUsuario = new JTextField();
		textMostrarUsuario.setEditable(false);
		textMostrarUsuario.setColumns(10);
		textMostrarUsuario.setBounds(281, 141, 119, 20);
		contentPane.add(textMostrarUsuario);
		
		lblUser = new JLabel("User:");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(227, 144, 46, 14);
		contentPane.add(lblUser);
		
		textMostrarCorreo = new JTextField();
		textMostrarCorreo.setEditable(false);
		textMostrarCorreo.setColumns(10);
		textMostrarCorreo.setBounds(281, 172, 119, 20);
		contentPane.add(textMostrarCorreo);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreo.setBounds(211, 175, 62, 14);
		contentPane.add(lblCorreo);
		
		textMostrarDireccion = new JTextField();
		textMostrarDireccion.setEditable(false);
		textMostrarDireccion.setColumns(10);
		textMostrarDireccion.setBounds(281, 203, 119, 20);
		contentPane.add(textMostrarDireccion);
		
		lblDir = new JLabel("Dir.:");
		lblDir.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDir.setBounds(211, 206, 62, 14);
		contentPane.add(lblDir);
		
		textMostrarTelefono = new JTextField();
		textMostrarTelefono.setEditable(false);
		textMostrarDireccion.setEditable(false);
		textMostrarTelefono.setColumns(10);
		textMostrarTelefono.setBounds(281, 234, 119, 20);
		contentPane.add(textMostrarTelefono);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setBounds(211, 237, 62, 14);
		contentPane.add(lblTelefono);
		
		textMostrarClave = new JTextField();
		textMostrarClave.setEditable(false);
		textMostrarClave.setColumns(10);
		textMostrarClave.setBounds(281, 265, 119, 20);
		contentPane.add(textMostrarClave);
		
		lblClave = new JLabel("Clave:");
		lblClave.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClave.setBounds(211, 268, 62, 14);
		contentPane.add(lblClave);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarActionPerformed(e);
			}
		});
		btnEliminar.setBounds(281, 322, 89, 23);
		contentPane.add(btnEliminar);
		
		String[] usuarios = control.llenarComboboxUsuarios();
		JComboBox<String> usuariosCombo = new JComboBox<>(usuarios);
		usuariosCombo.setBounds(31, 46, 179, 20);
		contentPane.add(usuariosCombo);
		usuariosCombo.setSelectedItem(null);
		
		btnDetalles = new JButton("Detalles");
		btnDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detallesActionPerformed(e);
				nombre=(String)usuariosCombo.getSelectedItem();
			}
		});
		btnDetalles.setBounds(281, 45, 89, 23);
		contentPane.add(btnDetalles);
		
		lblDeEstado = new JLabel("lblDeEstado");
		lblDeEstado.setVisible(false);
		lblDeEstado.setBounds(281, 296, 210, 14);
		contentPane.add(lblDeEstado);
	}
	//==================================Actions Performed==========================
	private void eliminarActionPerformed(java.awt.event.ActionEvent e) {
		if(control.vacio(textMostrarNombre, textMostrarApellido, textMostrarUsuario, textMostrarCorreo, textMostrarDireccion, textMostrarTelefono, textMostrarClave)) {
			lblDeEstado.setText("Seleccione un usuario para elimniar");
			lblDeEstado.setVisible(true);
		}else {
			if(textMostrarNombre.getText().equals("Admin")) {
				lblDeEstado.setText("No puede eliminar al admin");
				lblDeEstado.setVisible(true);
			}
			control.eliminarUsuario(nombre);
		}
	}
	private void detallesActionPerformed(java.awt.event.ActionEvent e) {
		textMostrarNombre.setText(nombre);
		textMostrarApellido.setText(control.detallesUsuarioApellido(nombre));
		textMostrarTelefono.setText("Datos personales");
		textMostrarCorreo.setText(control.detallesUsuarioCorreo(nombre));
		textMostrarDireccion.setText("Datos personales");
		textMostrarClave.setText("Datos personales");
		textMostrarUsuario.setText(control.detallesUsuarioUser(nombre));
	}
	
	private void atrasActionPerformed(java.awt.event.ActionEvent e) {
	    VentanaNominaAdmin ventana = new VentanaNominaAdmin();
	    control.cambiarVentana(ventana, this);
	}

}
