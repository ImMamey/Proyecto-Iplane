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

public class VentanaCiudadesAdmin extends JFrame {
	Modelo modelo = new Modelo();
	Controlador control = new Controlador(this, modelo); 
	//variables declarations - do not modify
	private JPanel contentPane;
	private JButton btnAtras;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JComboBox<String> ciudadesCombo;
	private JTextField textIntroducirCiudad;
	private JLabel lblNombre;
	private JLabel lblDeEstado;
	
	// end of variables declarations
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCiudadesAdmin frame = new VentanaCiudadesAdmin();
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
	public VentanaCiudadesAdmin() {
		
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
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarActionPerformed(e);
			}
		});
		btnAgregar.setBounds(24, 509, 89, 23);
		contentPane.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarActionPerformed(e);
			}
		});
		btnEliminar.setBounds(123, 509, 89, 23);
		contentPane.add(btnEliminar);
		
		//Comentar estas lineas para poder ver el windowdesing
		String[] ciudades = control.llenarComboboxCiudades();
		JComboBox<String> ciudadesCombo = new JComboBox<>(ciudades);
		ciudadesCombo.setBounds(31, 46, 179, 20);
		contentPane.add(ciudadesCombo);
		ciudadesCombo.setSelectedItem(null);
		
		
		btnAceptar = new JButton(".");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptarActionPerformed(e);
			}
		});
		btnAceptar.setVisible(false);
		btnAceptar.setBounds(587, 219, 184, 23);
		contentPane.add(btnAceptar);
		
		textIntroducirCiudad = new JTextField();
		textIntroducirCiudad.setEditable(false);
		textIntroducirCiudad.setBounds(643, 158, 108, 20);
		contentPane.add(textIntroducirCiudad);
		textIntroducirCiudad.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(587, 161, 46, 14);
		contentPane.add(lblNombre);
		
		lblDeEstado = new JLabel("Estado");
		lblDeEstado.setVisible(false);
		lblDeEstado.setBounds(587, 189, 184, 14);
		contentPane.add(lblDeEstado);
	}
	
	private void aceptarActionPerformed(java.awt.event.ActionEvent e) {
		if(control.vacio(textIntroducirCiudad)) {
			lblDeEstado.setVisible(true);
			lblDeEstado.setText("No puede estar el campo vacío");
		}else {
			//Agregar Ciudad
			if(btnAceptar.getText().equals("Agregar Ciudad")) {
				if(!control.vericarCiudad(textIntroducirCiudad)) {
					control.agregarCiudad(textIntroducirCiudad);
					VentanaCiudadesAdmin ventana = new VentanaCiudadesAdmin();
					control.cambiarVentana(ventana, this);
				}else {
					lblDeEstado.setVisible(true);
					lblDeEstado.setText("La ciudad ya existe");
				}
			}
			//Eliminar Ciudad
			if(btnAceptar.getText().equals("Eliminar Ciudad")) {
				if(!control.vericarCiudad(textIntroducirCiudad)) {
					control.eliminarCiudad(textIntroducirCiudad);
					VentanaCiudadesAdmin ventana = new VentanaCiudadesAdmin();
					control.cambiarVentana(ventana, this);
				}else {
					lblDeEstado.setVisible(true);
					lblDeEstado.setText("La ciudad no existe");
				}
			}
		}
	}
	
	private void agregarActionPerformed(java.awt.event.ActionEvent e){
		btnAceptar.setText("Agregar Ciudad");
		btnAceptar.setVisible(true);
		textIntroducirCiudad.setEditable(true);
	}
	private void eliminarActionPerformed(java.awt.event.ActionEvent e) {
		btnAceptar.setText("Eliminar Ciudad");
		btnAceptar.setVisible(true);
		textIntroducirCiudad.setEditable(true);
	}
	
	private void atrasActionPerformed(java.awt.event.ActionEvent e) {
	    VentanaPrincipalAdmin ventana = new VentanaPrincipalAdmin();
	    control.cambiarVentana(ventana, this);
	}
}