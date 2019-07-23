package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controlador;
import jdata.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

import model.Modelo;
/**
 * @author Victor
 * */


public class VentanaCrearUsuario extends JFrame {
	Controlador control; 
	Modelo modelo = new Modelo();
	//variables declarations - do not modify
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textCorreo;
	private JTextField textClave;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblTelefono;
	private JLabel lblCorreo;
	private JLabel lblDireccion;
	private JLabel lblPassword;
	private JButton btnAtras;
	private JButton btnContinuar;
	private JLabel lblNombreDeUsuario;
	private JTextField textUser;
	private JTextField textClave2;
	private JLabel lblVerificarClave;
	private JLabel lblDeEstado;
	private boolean verificado;
	// end of variables declarations
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearUsuario frame = new VentanaCrearUsuario();
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
	public VentanaCrearUsuario() {
		initComponents();
		control = new Controlador(this, modelo);
		control.iniciaVentana(this);
	}
	
	public void initComponents(){	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(70, 67, 85, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(165, 64, 132, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(70, 115, 85, 14);
		contentPane.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(165, 112, 132, 20);
		contentPane.add(textApellido);
		
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(70, 167, 85, 14);
		contentPane.add(lblDireccion);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(165, 164, 132, 20);
		contentPane.add(textDireccion);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(70, 223, 85, 14);
		contentPane.add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(165, 220, 132, 20);
		contentPane.add(textTelefono);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(70, 276, 85, 14);
		contentPane.add(lblCorreo);
		
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(165, 273, 132, 20);
		contentPane.add(textCorreo);
		
		lblPassword = new JLabel("Clave:");
		lblPassword.setBounds(406, 115, 85, 14);
		contentPane.add(lblPassword);
		
		textClave = new JTextField();
		textClave.setColumns(10);
		textClave.setBounds(445, 112, 132, 20);
		contentPane.add(textClave);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atrasActionPerformed(e);
			}
		});
		btnAtras.setBounds(34, 386, 89, 23);
		contentPane.add(btnAtras);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				continuarActionPerformed(e);
			}
		});
		btnContinuar.setBounds(490, 386, 105, 23);
		contentPane.add(btnContinuar);
		
		lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setBounds(330, 67, 132, 14);
		contentPane.add(lblNombreDeUsuario);
		
		textUser = new JTextField();
		textUser.setColumns(10);
		textUser.setBounds(445, 64, 132, 20);
		contentPane.add(textUser);
		
		textClave2 = new JTextField();
		textClave2.setColumns(10);
		textClave2.setBounds(445, 164, 132, 20);
		contentPane.add(textClave2);
		
		lblVerificarClave = new JLabel("Verificar clave:");
		lblVerificarClave.setBounds(358, 167, 85, 14);
		contentPane.add(lblVerificarClave);
		
		lblDeEstado = new JLabel("Lbl de estado");
		lblDeEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeEstado.setForeground(Color.RED);
		lblDeEstado.setEnabled(true);
		lblDeEstado.setVisible(false);
		lblDeEstado.setBounds(335, 257, 278, 33);
		contentPane.add(lblDeEstado);
	}
	private void atrasActionPerformed(java.awt.event.ActionEvent e) {
	    VentanaIniciarSesion ventana = new VentanaIniciarSesion();
	    control.cambiarVentana(ventana, this);
	}
	private void continuarActionPerformed(java.awt.event.ActionEvent e) {
		verificado=true;
		//Verifica que no hayan campos vacios
		if(control.vacio(textNombre, textApellido, textDireccion, textTelefono, textCorreo, textUser, textClave, textClave2)==true) {
			lblDeEstado.setText("Hay campos vacios, porfavor rellenar todos los datos.");
			lblDeEstado.setVisible(true);
			verificado=false;
		}
		//Verifica que la clave puesta y su verificacion coincidan
		if((!textClave.getText().equals(textClave2.getText()))&&(verificado==true)) {
			lblDeEstado.setText("La contraseña no coincide.");
			lblDeEstado.setVisible(true);
			control.limpia(textClave, textClave2);
		verificado=false;
		}
		//Verifica que el usuario colocado no exista
		
		if(control.verificarNombreUsuario(textUser)) {
			lblDeEstado.setText("El nombre de usuario ya está en uso, introduzca otro");
			lblDeEstado.setVisible(true);
			verificado=false;
		}
		//Si no hubo problemas al rellenar datos agrega los datos al JSON y regresa a la ventana de inicio de sesion
		if(verificado==true) {
			control.agregarUsuario(textNombre, textApellido, textDireccion, textTelefono, textCorreo, textUser, textClave, textClave2);
			VentanaIniciarSesion ventana = new VentanaIniciarSesion();
		    control.cambiarVentana(ventana, this);
		}	
		
	}
}
