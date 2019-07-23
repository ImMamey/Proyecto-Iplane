package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controlador;
import model.Modelo;

public class VentanaRutasAdmin extends JFrame {
	//Controlador control;
		Modelo modelo = new Modelo();
		Controlador control = new Controlador(this, modelo);
		
		//variables declarations - do not modify
		private JPanel contentPane;
		//private JComboBox agenciasCombo = new JComboBox();
		private String nombre;
		private String oldName;
		private String nombreCiudadSal;
		private String nombreCiudadEnt;
		private JButton btnAtras;
		private JButton btnAceptar;
		private JButton btnAgregar;
		private JButton btnEliminar;
		private JButton btnSelcCiudadEntr;
		private JButton btnSelcCiudadSal;
		private JTextField textNombre;
		private JTextField textId;
		private JTextField textCiudadEntrada;
		private JTextField textCiudadSalida;
		private JTextField textMostrarNombre;
		private JTextField textMostrarId;
		private JTextField textMostrarCiudadEntrada;
		private JTextField textMostrarCiudadSalida;
		private JLabel lblMostrarCiudadSalida;
		private JLabel lblNombre;
		private JLabel lblDir;
		private JLabel lblCiudadEntrada;
		private JLabel lblCiudadSalida;
		private JLabel lblDatosDeLaRuta;
		private JLabel lblLabelDeEstado;
		private JLabel lblMostrarNombre;
		private JLabel lblMostrarId;
		private JLabel lblMostrarCiudadEntrada;
		private JComboBox<String> ciudadesCombo;
		private JComboBox<String> rutasCombo;
		
		// end of variables declarations
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRutasAdmin frame = new VentanaRutasAdmin();
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
	public VentanaRutasAdmin() {
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
		
		btnAceptar = new JButton("");
		btnAceptar.setVisible(false);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(624, 323, 117, 23);
		contentPane.add(btnAceptar);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(524, 154, 117, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(456, 157, 58, 14);
		contentPane.add(lblNombre);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setColumns(10);
		textId.setBounds(751, 154, 117, 20);
		contentPane.add(textId);
		
		lblDir = new JLabel("Id.:");
		lblDir.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDir.setBounds(695, 157, 46, 14);
		contentPane.add(lblDir);
		
		textCiudadEntrada = new JTextField();
		textCiudadEntrada.setEditable(false);
		textCiudadEntrada.setColumns(10);
		textCiudadEntrada.setBounds(751, 229, 117, 20);
		contentPane.add(textCiudadEntrada);
		
		lblCiudadEntrada = new JLabel("Ciudad de Entrada:");
		lblCiudadEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCiudadEntrada.setBounds(643, 232, 98, 14);
		contentPane.add(lblCiudadEntrada);
		
		lblCiudadSalida = new JLabel("Ciudad de Salida");
		lblCiudadSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCiudadSalida.setBounds(416, 232, 98, 14);
		contentPane.add(lblCiudadSalida);
		
		textCiudadSalida = new JTextField();
		textCiudadSalida.setEditable(false);
		textCiudadSalida.setColumns(10);
		textCiudadSalida.setBounds(524, 229, 117, 20);
		contentPane.add(textCiudadSalida);
		
		lblDatosDeLaRuta = new JLabel("Datos de la Ruta:");
		lblDatosDeLaRuta.setBounds(608, 129, 133, 14);
		contentPane.add(lblDatosDeLaRuta);
		
		lblLabelDeEstado = new JLabel("Label de Opcion:");
		lblLabelDeEstado.setVisible(false);
		lblLabelDeEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabelDeEstado.setBounds(497, 296, 117, 14);
		contentPane.add(lblLabelDeEstado);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarActionPerformed(e);
			}
		});
		btnAgregar.setBounds(31, 492, 153, 23);
		contentPane.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarActionPerformed(e);
			}
		});
		btnEliminar.setBounds(194, 492, 153, 23);
		contentPane.add(btnEliminar);
		
		//Para poder ver el desing hay que comentar estas lineas: ya que jre-6 no acepta el objeto JComboBox<> en el window builder
		String[] rutas = control.llenarComboboxRutas();
		JComboBox<String> rutasCombo = new JComboBox<>(rutas);
		rutasCombo.setBounds(31, 46, 179, 20);
		contentPane.add(rutasCombo);
		rutasCombo.setSelectedItem(null);
		
		//para poder ver el desing hay que comentar estas lineas: ya que jre-6 no acepta el objeto JComboBox<> en el window builder
		String[] ciudades = control.llenarComboboxCiudades();
		JComboBox<String> ciudadesCombo = new JComboBox(ciudades);
		ciudadesCombo.setBounds(31, 70, 179, 20);
		contentPane.add(ciudadesCombo);
		ciudadesCombo.setSelectedItem(null);
		
		textMostrarNombre = new JTextField();
		textMostrarNombre.setColumns(10);
		textMostrarNombre.setEditable(false);
		textMostrarNombre.setBounds(302, 77, 117, 20);
		contentPane.add(textMostrarNombre);
		
		textMostrarId = new JTextField();
		textMostrarId.setColumns(10);
		textMostrarId.setEditable(false);
		textMostrarId.setBounds(302, 108, 117, 20);
		contentPane.add(textMostrarId);
		
		textMostrarCiudadEntrada = new JTextField();
		textMostrarCiudadEntrada.setColumns(10);
		textMostrarCiudadEntrada.setEditable(false);
		textMostrarCiudadEntrada.setBounds(302, 139, 117, 20);
		contentPane.add(textMostrarCiudadEntrada);
		
		textMostrarCiudadSalida = new JTextField();
		textMostrarCiudadSalida.setColumns(10);
		textMostrarCiudadSalida.setEditable(false);
		textMostrarCiudadSalida.setBounds(302, 170, 117, 20);
		contentPane.add(textMostrarCiudadSalida);
		
		lblMostrarNombre = new JLabel("Nombre:");
		lblMostrarNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarNombre.setBounds(240, 80, 52, 14);
		contentPane.add(lblMostrarNombre);
		
		lblMostrarId = new JLabel("Id.:");
		lblMostrarId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarId.setBounds(246, 111, 46, 14);
		contentPane.add(lblMostrarId);
		
		lblMostrarCiudadEntrada = new JLabel("Ciudad de Entrada:");
		lblMostrarCiudadEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarCiudadEntrada.setBounds(194, 142, 98, 14);
		contentPane.add(lblMostrarCiudadEntrada);
		
		lblMostrarCiudadSalida = new JLabel("Ciudad de Salida:");
		lblMostrarCiudadSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarCiudadSalida.setBounds(194, 173, 98, 14);
		contentPane.add(lblMostrarCiudadSalida);
		
		JButton btnDetalles = new JButton("Detalles:");
		btnDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre =(String)rutasCombo.getSelectedItem();
				detallesActionPerformed(e);
			}
		});
		btnDetalles.setBounds(312, 45, 89, 23);
		contentPane.add(btnDetalles);
		
		btnSelcCiudadSal = new JButton("Selc. Ciudad");
		btnSelcCiudadSal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombreCiudadSal =(String)ciudadesCombo.getSelectedItem();
				selcCiudadSalActionPerformed(e);
			}
		});
		btnSelcCiudadSal.setEnabled(false);
		btnSelcCiudadSal.setBounds(524, 249, 117, 23);
		contentPane.add(btnSelcCiudadSal);
		
		btnSelcCiudadEntr = new JButton("Selc. Ciudad");
		btnSelcCiudadEntr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombreCiudadEnt =(String)ciudadesCombo.getSelectedItem();
				selcCiudadEntrActionPerformed(e);
			}
		});
		btnSelcCiudadEntr.setEnabled(false);
		btnSelcCiudadEntr.setBounds(751, 249, 117, 23);
		contentPane.add(btnSelcCiudadEntr);
	}
	//=======================ACTIONS PERFORMED!============================
	private void selcCiudadSalActionPerformed(java.awt.event.ActionEvent e) {
		textCiudadSalida.setText(nombreCiudadSal);
		if(!control.vacio(textCiudadSalida)) {
			btnSelcCiudadEntr.setEnabled(true);
		}
	}
	private void selcCiudadEntrActionPerformed(java.awt.event.ActionEvent e) {
		textCiudadEntrada.setText(nombreCiudadEnt);
		if(textCiudadEntrada.getText().equals(textCiudadSalida.getText())) {
			lblLabelDeEstado.setText("No puede ser la misma ciudad");
		}else {
			btnAceptar.setVisible(true);
			textNombre.setText(textCiudadSalida.getText() + " a " + textCiudadEntrada.getText());
		}
	}
	
	private void aceptarActionPerformed(java.awt.event.ActionEvent e) {
		//===========En el caso que sea agregar ruta=========
		if(btnAceptar.getText().equals("Agregar ruta")) {
			if(control.vacio(textNombre, textId, textCiudadEntrada, textCiudadSalida)) {
				
			}else {
				if(!control.verificarRuta(textNombre)) {
					textId.setEditable(false);
					//Logica de agregar va aqui:
						control.agregarRuta(textNombre, textId, textCiudadEntrada, textCiudadSalida);
					//refrescar:
						String[] rutas = control.llenarComboboxRutas();
						VentanaRutasAdmin ventana = new VentanaRutasAdmin();
					    control.cambiarVentana(ventana, this);
				}else {
					lblLabelDeEstado.setText("Nombre ya existe");
					lblLabelDeEstado.setVisible(true);
				}
				
			}
		}
		//=============En el caso de que sea eliminar ruta
		if(btnAceptar.getText().equals("Eliminar ruta")) {
			if(control.vacio(textNombre)) {
				lblLabelDeEstado.setText("Campo vacío");
			}else {
				if(control.verificarRuta(textNombre)) {
					textId.setEditable(false);
					//Logica de eliminar va aqui:
					if(control.verificarRuta(textNombre)) {
						control.eliminarRuta(textNombre);
					}else {
						lblLabelDeEstado.setText("La ruta no exite");
						lblLabelDeEstado.setVisible(true);
					}
					//refrescar:
					String[] rutas = control.llenarComboboxRutas();
					VentanaRutasAdmin ventana = new VentanaRutasAdmin();
				    control.cambiarVentana(ventana, this);
				}else {
					lblLabelDeEstado.setText("Nombre no existe");
					lblLabelDeEstado.setVisible(true);
				}
			}
		}
	}
	//=================Acciones de los botones Agregar/Modificar/Eliminar================
	private void agregarActionPerformed(java.awt.event.ActionEvent e) {
		
		btnAceptar.setText("Agregar ruta");
		btnSelcCiudadSal.setEnabled(true);
		lblLabelDeEstado.setText("Agrege las ciudades con los botones, escriba un id");
		textId.setEditable(true);
	}
	private void eliminarActionPerformed(java.awt.event.ActionEvent e) {
		btnAceptar.setText("Eliminar ruta");
		btnAceptar.setVisible(true);
		textNombre.setEditable(true);
	}
	//================Botón para ver los detalles de la ruta====================
	private void detallesActionPerformed(java.awt.event.ActionEvent e) {
		textMostrarNombre.setText(nombre);
		textMostrarId.setText(control.detallesRutaId(nombre));
		textMostrarCiudadEntrada.setText(control.detallesCiudadEntrada(nombre));
		textMostrarCiudadSalida.setText(control.detallesCiudadSalida(nombre));
	}
	private void atrasActionPerformed(java.awt.event.ActionEvent e) {
	    VentanaPrincipalAdmin ventana = new VentanaPrincipalAdmin();
	    control.cambiarVentana(ventana, this);
	}
}