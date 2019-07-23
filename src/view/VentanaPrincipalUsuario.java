package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controlador;
import model.Modelo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipalUsuario extends JFrame {
	Controlador control; 
	Modelo modelo = new Modelo();
	//variables declarations - do not modify
	private JPanel contentPane;
	private JButton btnCerrarSesion;
	private JButton btnVuelos;
	private JButton btnReservaciones;
	// end of variables declarations

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalUsuario frame = new VentanaPrincipalUsuario();
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
	public VentanaPrincipalUsuario() {
		initComponents();
		control = new Controlador(this, modelo);
		control.iniciaVentana(this);
	}
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atrasActionPerformed(e);
			}
		});
		btnCerrarSesion.setBounds(761, 11, 119, 23);
		contentPane.add(btnCerrarSesion);
		
		btnVuelos = new JButton("Vuelos");
		btnVuelos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vuelosActionPerformed(e);
			}
		});
		btnVuelos.setBounds(245, 197, 131, 111);
		contentPane.add(btnVuelos);
		
		btnReservaciones = new JButton("Mis Reservaciones");
		btnReservaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservacionesActionPerformed(e);
			}
		});
		btnReservaciones.setBounds(466, 197, 131, 111);
		contentPane.add(btnReservaciones);
	}
	//Ventanas
	private void atrasActionPerformed(java.awt.event.ActionEvent e) {
	    VentanaIniciarSesion ventana = new VentanaIniciarSesion();
	    control.cambiarVentana(ventana, this);
	}
	private void vuelosActionPerformed(java.awt.event.ActionEvent e) {
		VentanaVuelosUsuario ventana = new VentanaVuelosUsuario();
		control.cambiarVentana(ventana, this);
	}
	private void reservacionesActionPerformed(java.awt.event.ActionEvent e) {
		VentanaReservacionesUsuario ventana = new VentanaReservacionesUsuario();
		control.cambiarVentana(ventana, this);
	}

}
