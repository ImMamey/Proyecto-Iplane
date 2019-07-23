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
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class VentanaAgenciasAdmin extends JFrame {
	//Controlador control;
	Modelo modelo = new Modelo();
	Controlador control = new Controlador(this, modelo);
	
	//variables declarations - do not modify
	private JPanel contentPane;
	//private JComboBox agenciasCombo = new JComboBox();
	private String nombre;
	private String oldName;
	private JButton btnAtras;
	private JButton btnAceptar;
	private JButton btnModificar;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JTextField textNombre;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textNombreContacto;
	private JTextField textTelefonoContacto;
	private JTextField textMostrarNombre;
	private JTextField textMostrarDir;
	private JTextField textMostrarTelf;
	private JTextField textMostrarContacto;
	private JTextField textMostrarTelfContacto;
	private JLabel lblMostrarContacto;
	private JLabel lblNombre;
	private JLabel lblDir;
	private JLabel lblTelefono;
	private JLabel lblNombreDeContacto;
	private JLabel lblTelefonoDeContacto;
	private JLabel lblDatosDeLaAgencia;
	private JLabel lblDatosDelContacto;
	private JLabel lblLabelDeEstado;
	private JLabel lblMostrarNombre;
	private JLabel lblMostrarDir;
	private JLabel lblMostrarTelf;
	private JLabel lblMostrarTlfContacto;
	
	// end of variables declarations
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgenciasAdmin frame = new VentanaAgenciasAdmin();
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
	public VentanaAgenciasAdmin() {
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
		btnAceptar.setBounds(624, 342, 117, 23);
		contentPane.add(btnAceptar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarActionPerformed(e);
			}
		});
		btnModificar.setBounds(194, 492, 153, 23);
		contentPane.add(btnModificar);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(539, 154, 117, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(471, 157, 58, 14);
		contentPane.add(lblNombre);
		
		textDireccion = new JTextField();
		textDireccion.setEditable(false);
		textDireccion.setColumns(10);
		textDireccion.setBounds(539, 185, 117, 20);
		contentPane.add(textDireccion);
		
		lblDir = new JLabel("Dir.:");
		lblDir.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDir.setBounds(483, 188, 46, 14);
		contentPane.add(lblDir);
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setColumns(10);
		textTelefono.setBounds(751, 154, 117, 20);
		contentPane.add(textTelefono);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setBounds(689, 157, 52, 14);
		contentPane.add(lblTelefono);
		
		lblNombreDeContacto = new JLabel("Nombre de Contacto:");
		lblNombreDeContacto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreDeContacto.setBounds(471, 254, 109, 14);
		contentPane.add(lblNombreDeContacto);
		
		textNombreContacto = new JTextField();
		textNombreContacto.setEditable(false);
		textNombreContacto.setColumns(10);
		textNombreContacto.setBounds(590, 251, 117, 20);
		contentPane.add(textNombreContacto);
		
		lblTelefonoDeContacto = new JLabel("Telefono de Contacto:");
		lblTelefonoDeContacto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoDeContacto.setBounds(471, 292, 109, 14);
		contentPane.add(lblTelefonoDeContacto);
		
		textTelefonoContacto = new JTextField();
		textTelefonoContacto.setEditable(false);
		textTelefonoContacto.setColumns(10);
		textTelefonoContacto.setBounds(590, 289, 117, 20);
		contentPane.add(textTelefonoContacto);
		
		lblDatosDeLaAgencia = new JLabel("Datos de la Agencia:");
		lblDatosDeLaAgencia.setBounds(459, 129, 133, 14);
		contentPane.add(lblDatosDeLaAgencia);
		
		lblDatosDelContacto = new JLabel("Datos del Contacto:");
		lblDatosDelContacto.setBounds(459, 216, 133, 14);
		contentPane.add(lblDatosDelContacto);
		
		lblLabelDeEstado = new JLabel("Label de Opcion:");
		lblLabelDeEstado.setVisible(false);
		lblLabelDeEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabelDeEstado.setBounds(624, 317, 117, 14);
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
		btnEliminar.setBounds(357, 492, 153, 23);
		contentPane.add(btnEliminar);
		
		//Para poder ver el desing hay que comentar estas lineas: ya que jre-6 no acepta el objeto JComboBox<> en el window builder
		String[] agencias = control.llenarComboboxAgencias();
		JComboBox<String> agenciasCombo = new JComboBox<>(agencias);
		agenciasCombo.setBounds(31, 46, 179, 20);
		contentPane.add(agenciasCombo);
		agenciasCombo.setSelectedItem(null);
		
		
		textMostrarNombre = new JTextField();
		textMostrarNombre.setColumns(10);
		textMostrarNombre.setEditable(false);
		textMostrarNombre.setBounds(302, 77, 117, 20);
		contentPane.add(textMostrarNombre);
		
		textMostrarDir = new JTextField();
		textMostrarDir.setColumns(10);
		textMostrarDir.setEditable(false);
		textMostrarDir.setBounds(302, 108, 117, 20);
		contentPane.add(textMostrarDir);
		
		textMostrarTelf = new JTextField();
		textMostrarTelf.setColumns(10);
		textMostrarTelf.setEditable(false);
		textMostrarTelf.setBounds(302, 139, 117, 20);
		contentPane.add(textMostrarTelf);
		
		textMostrarContacto = new JTextField();
		textMostrarContacto.setColumns(10);
		textMostrarContacto.setEditable(false);
		textMostrarContacto.setBounds(302, 170, 117, 20);
		contentPane.add(textMostrarContacto);
		
		lblMostrarNombre = new JLabel("Nombre:");
		lblMostrarNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarNombre.setBounds(240, 80, 52, 14);
		contentPane.add(lblMostrarNombre);
		
		lblMostrarDir = new JLabel("Dir.:");
		lblMostrarDir.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarDir.setBounds(246, 111, 46, 14);
		contentPane.add(lblMostrarDir);
		
		lblMostrarTelf = new JLabel("Telefono:");
		lblMostrarTelf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarTelf.setBounds(240, 142, 52, 14);
		contentPane.add(lblMostrarTelf);
		
		lblMostrarContacto = new JLabel("Contacto:");
		lblMostrarContacto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarContacto.setBounds(233, 173, 59, 14);
		contentPane.add(lblMostrarContacto);
		
		lblMostrarTlfContacto = new JLabel("Tlf Contacto:");
		lblMostrarTlfContacto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarTlfContacto.setBounds(219, 204, 73, 14);
		contentPane.add(lblMostrarTlfContacto);
		
		textMostrarTelfContacto = new JTextField();
		textMostrarTelfContacto.setColumns(10);
		textMostrarTelfContacto.setEditable(false);
		textMostrarTelfContacto.setBounds(302, 201, 117, 20);
		contentPane.add(textMostrarTelfContacto);
		
		JButton btnDetalles = new JButton("Detalles:");
		btnDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre =(String)agenciasCombo.getSelectedItem();
				detallesActionPerformed(e);
			}
		});
		btnDetalles.setBounds(312, 45, 89, 23);
		contentPane.add(btnDetalles);
	}
	private void aceptarActionPerformed(java.awt.event.ActionEvent e) {
		//===========En el caso que sea agregar agencia=========
		if(btnAceptar.getText().equals("Agregar agencia")) {
			if(control.vacio(textNombre, textDireccion, textTelefono, textNombreContacto, textTelefonoContacto)) {
				
			}else {
				textNombre.setEditable(false);
				textDireccion.setEditable(false);
				textTelefono.setEditable(false);
				textNombreContacto.setEditable(false);
				textTelefonoContacto.setEditable(false);
				//Logica de agregar va aqui:
					control.agregarAgencia(textNombre, textDireccion, textTelefono, textNombreContacto, textTelefonoContacto);
				//refrescar:
					String[] agencias = control.llenarComboboxAgencias();
					VentanaAgenciasAdmin ventana = new VentanaAgenciasAdmin();
				    control.cambiarVentana(ventana, this);
			}
		}
		//============En el caso que sea modificar agencia=======
		if(btnAceptar.getText().equals("Modificar agencia")) {
			if(control.vacio(textNombre, textDireccion, textTelefono, textNombreContacto, textTelefonoContacto)) {
				
			}else {
				textNombre.setEditable(false);
				textDireccion.setEditable(false);
				textTelefono.setEditable(false);
				textNombreContacto.setEditable(false);
				textTelefonoContacto.setEditable(false);
				//Logica de modificar va aqui:
				if(control.verificarAgencia(textNombre)) {
					control.modificarAgencia(oldName,textNombre,textDireccion,textTelefono,textNombreContacto,textTelefonoContacto);
				}else {
					lblLabelDeEstado.setText("La agencia no existe");
					lblLabelDeEstado.setVisible(true);
				}
				//refrescar:
				String[] agencias = control.llenarComboboxAgencias();
				VentanaAgenciasAdmin ventana = new VentanaAgenciasAdmin();
			    control.cambiarVentana(ventana, this);
			}
		}
		//=============En el caso que sea eliminar agencia=======
		if(btnAceptar.getText().equals("Eliminar agencia")) {
			if(control.vacio(textNombre)) {
				
			}else {
				textNombre.setEditable(false);
				//Logica de eliminar va aqui:
				if(control.verificarAgencia(textNombre)) {
					control.eliminarAgencia(textNombre);
				}else {
					lblLabelDeEstado.setText("La agencia no exite");
					lblLabelDeEstado.setVisible(true);
				}
				//refrescar:
				String[] agencias = control.llenarComboboxAgencias();
				VentanaAgenciasAdmin ventana = new VentanaAgenciasAdmin();
			    control.cambiarVentana(ventana, this);
			}
		}
	}
	//=================Acciones de los botones Agregar/Modificar/Eliminar================
	private void agregarActionPerformed(java.awt.event.ActionEvent e) {
		btnAceptar.setText("Agregar agencia");
		btnAceptar.setVisible(true);
		textNombre.setEditable(true);
		textDireccion.setEditable(true);
		textTelefono.setEditable(true);
		textNombreContacto.setEditable(true);
		textTelefonoContacto.setEditable(true);
	}
	private void modificarActionPerformed(java.awt.event.ActionEvent e) {
			btnAceptar.setText("Modificar agencia");
			btnAceptar.setVisible(true);
			
			oldName=textNombre.getText();
			
			textNombre.setEditable(true);
			textDireccion.setEditable(true);
			textTelefono.setEditable(true);
			textNombreContacto.setEditable(true);
			textTelefonoContacto.setEditable(true);
		
			textNombre.setText(textMostrarNombre.getText());
			textDireccion.setText(textMostrarDir.getText());
			textTelefono.setText(textMostrarTelf.getText());
			textNombreContacto.setText(textMostrarContacto.getText());
			textTelefonoContacto.setText(textMostrarTelfContacto.getText());
	}
	private void eliminarActionPerformed(java.awt.event.ActionEvent e) {
		btnAceptar.setText("Eliminar agencia");
		btnAceptar.setVisible(true);
		textNombre.setEditable(true);
	}
	//================Botón para ver los detalles de la agencia====================
	private void detallesActionPerformed(java.awt.event.ActionEvent e) {
		textMostrarNombre.setText(nombre);
		textMostrarDir.setText(control.detallesAgenciaDir(nombre));
		textMostrarTelf.setText(control.detallesAgenciaTelf(nombre));
		textMostrarContacto.setText(control.detallesAgenciaContacto(nombre));
		textMostrarTelfContacto.setText(control.detallesAgenciaTlfContacto(nombre));
	}
	private void atrasActionPerformed(java.awt.event.ActionEvent e) {
	    VentanaPrincipalAdmin ventana = new VentanaPrincipalAdmin();
	    control.cambiarVentana(ventana, this);
	}
}
