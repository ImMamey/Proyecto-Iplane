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

public class VentanaPrincipalAdmin extends JFrame {
	Controlador control; 
	Modelo modelo = new Modelo();
	//variables declarations - do not modify
	private JPanel contentPane;
	private JButton btnCerrarSesion;
	private JButton btnAgencias;
	private JButton btnVuelos;
	private JButton btnNomina;
	private JButton btnRutas;
	private JButton btnCiudades;
	private JButton btnReservaciones;
	private JButton btnAerolneas;
	// end of variables declarations

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalAdmin frame = new VentanaPrincipalAdmin();
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
	public VentanaPrincipalAdmin() {
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
		
		btnAgencias = new JButton("Agencias");
		btnAgencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agenciasActionPerformed(e);
			}
		});
		btnAgencias.setBounds(153, 69, 131, 111);
		contentPane.add(btnAgencias);
		
		btnVuelos = new JButton("Vuelos");
		btnVuelos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vuelosActionPerformed(e);
			}
		});
		btnVuelos.setBounds(153, 277, 131, 111);
		contentPane.add(btnVuelos);
		
		btnNomina = new JButton("Nomina");
		btnNomina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nominaActionPerformed(e);
			}
		});
		btnNomina.setBounds(326, 277, 131, 111);
		contentPane.add(btnNomina);
		
		btnRutas = new JButton("Rutas");
		btnRutas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rutasActionPerformed(e);
			}
		});
		btnRutas.setBounds(494, 69, 131, 111);
		contentPane.add(btnRutas);
		
		btnCiudades = new JButton("Ciudades");
		btnCiudades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ciudadesActionPerformed(e);
			}
		});
		btnCiudades.setBounds(494, 277, 131, 111);
		contentPane.add(btnCiudades);
		
		btnReservaciones = new JButton("Reservaciones");
		btnReservaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservacionesActionPerformed(e);
			}
		});
		btnReservaciones.setBounds(666, 69, 131, 111);
		contentPane.add(btnReservaciones);
		
		btnAerolneas = new JButton("Aerolíneas");
		btnAerolneas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aerolineasActionPerformed(e);
			}
		});
		btnAerolneas.setBounds(326, 69, 131, 111);
		contentPane.add(btnAerolneas);
	}
	//Ventanas
	private void atrasActionPerformed(java.awt.event.ActionEvent e) {
	    VentanaIniciarSesion ventana = new VentanaIniciarSesion();
	    control.cambiarVentana(ventana, this);
	}
	private void agenciasActionPerformed(java.awt.event.ActionEvent e){
		VentanaAgenciasAdmin ventana = new VentanaAgenciasAdmin();
	    control.cambiarVentana(ventana, this);
	}
	private void vuelosActionPerformed(java.awt.event.ActionEvent e) {
		VentanaVuelosAdmin ventana = new VentanaVuelosAdmin();
		control.cambiarVentana(ventana, this);
	}
	private void aerolineasActionPerformed(java.awt.event.ActionEvent e) {
		VentanaAerolineasAdmin ventana = new VentanaAerolineasAdmin();
		control.cambiarVentana(ventana, this);
	}
	private void nominaActionPerformed(java.awt.event.ActionEvent e) {
		VentanaNominaAdmin ventana = new VentanaNominaAdmin();
		control.cambiarVentana(ventana, this);
	}
	private void rutasActionPerformed(java.awt.event.ActionEvent e) {
		VentanaRutasAdmin ventana = new VentanaRutasAdmin();
		control.cambiarVentana(ventana, this);
	}
	private void ciudadesActionPerformed(java.awt.event.ActionEvent e) {
		VentanaCiudadesAdmin ventana = new VentanaCiudadesAdmin();
		control.cambiarVentana(ventana, this);
	}
	private void reservacionesActionPerformed(java.awt.event.ActionEvent e) {
		VentanaReservacionesAdmin ventana = new VentanaReservacionesAdmin();
		control.cambiarVentana(ventana, this);
	}

}
