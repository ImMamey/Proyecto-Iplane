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

public class VentanaPersonalAdmin extends JFrame {
	Modelo modelo = new Modelo();
	Controlador control = new Controlador(this, modelo);
	//variables declarations - do not modify
	private JPanel contentPane;
	private String nombre;
	private JButton btnAtras;
	private JButton btnVerDetalles;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JTextField textMostrarNombre;
	private JTextField textMostrarApellido;
	private JTextField textMostrarCedula;
	private JTextField textMostrarSexo;
	private JTextField textMostrarTelf;
	private JTextField textMostrarCorreo;
	private JTextField textMostrarDir;
	private JTextField textMostrarCargo;
	private JLabel lblMostrarNombre;
	private JLabel lblMostrarApellido;
	private JLabel lblMostrarCedula;
	private JLabel lblMostrarSexo;
	private JLabel lblMostrarTelf;
	private JLabel lblMostrarCorreo;
	private JLabel lblMostrarDir;
	private JLabel lblMostrarCargo;
	private JLabel lblDeEstado;
	private JButton btnAceptar;
	// end of variables declarations
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPersonalAdmin frame = new VentanaPersonalAdmin();
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
	public VentanaPersonalAdmin() {
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
		textMostrarNombre.setBounds(406, 105, 86, 20);
		contentPane.add(textMostrarNombre);
		textMostrarNombre.setColumns(10);
		
		textMostrarApellido = new JTextField();
		textMostrarApellido.setEditable(false);
		textMostrarApellido.setColumns(10);
		textMostrarApellido.setBounds(406, 136, 86, 20);
		contentPane.add(textMostrarApellido);
		
		textMostrarCedula = new JTextField();
		textMostrarCedula.setEditable(false);
		textMostrarCedula.setColumns(10);
		textMostrarCedula.setBounds(406, 167, 86, 20);
		contentPane.add(textMostrarCedula);
		
		textMostrarSexo = new JTextField();
		textMostrarSexo.setEditable(false);
		textMostrarSexo.setColumns(10);
		textMostrarSexo.setBounds(406, 198, 86, 20);
		contentPane.add(textMostrarSexo);
		
		textMostrarTelf = new JTextField();
		textMostrarTelf.setEditable(false);
		textMostrarTelf.setColumns(10);
		textMostrarTelf.setBounds(406, 229, 86, 20);
		contentPane.add(textMostrarTelf);
		
		textMostrarCorreo = new JTextField();
		textMostrarCorreo.setEditable(false);
		textMostrarCorreo.setColumns(10);
		textMostrarCorreo.setBounds(406, 260, 86, 20);
		contentPane.add(textMostrarCorreo);
		
		textMostrarDir = new JTextField();
		textMostrarDir.setEditable(false);
		textMostrarDir.setColumns(10);
		textMostrarDir.setBounds(406, 291, 86, 20);
		contentPane.add(textMostrarDir);
		
		textMostrarCargo = new JTextField();
		textMostrarCargo.setEditable(false);
		textMostrarCargo.setColumns(10);
		textMostrarCargo.setBounds(406, 324, 86, 20);
		contentPane.add(textMostrarCargo);
		
		lblMostrarNombre = new JLabel("Nombre:");
		lblMostrarNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarNombre.setBounds(320, 108, 76, 14);
		contentPane.add(lblMostrarNombre);
		
		lblMostrarApellido = new JLabel("Apellido:");
		lblMostrarApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarApellido.setBounds(320, 139, 76, 14);
		contentPane.add(lblMostrarApellido);
		
		lblMostrarCedula = new JLabel("Cedula:");
		lblMostrarCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarCedula.setBounds(320, 170, 76, 14);
		contentPane.add(lblMostrarCedula);
		
		lblMostrarSexo = new JLabel("Sexo:");
		lblMostrarSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarSexo.setBounds(349, 201, 46, 14);
		contentPane.add(lblMostrarSexo);
		
		lblMostrarTelf = new JLabel("Telf.:");
		lblMostrarTelf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarTelf.setBounds(350, 232, 46, 14);
		contentPane.add(lblMostrarTelf);
		
		lblMostrarCorreo = new JLabel("Correo:");
		lblMostrarCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarCorreo.setBounds(350, 263, 46, 14);
		contentPane.add(lblMostrarCorreo);
		
		lblMostrarDir = new JLabel("Dir.:");
		lblMostrarDir.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarDir.setBounds(350, 294, 46, 14);
		contentPane.add(lblMostrarDir);
		
		lblMostrarCargo = new JLabel("Cargo:");
		lblMostrarCargo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarCargo.setBounds(350, 327, 46, 14);
		contentPane.add(lblMostrarCargo);
		
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarActionPerformed(e);
			}
		});
		btnAgregar.setBounds(340, 424, 89, 23);
		contentPane.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elimianrAcionPerformed(e);
			}
		});
		btnEliminar.setBounds(439, 424, 89, 23);
		contentPane.add(btnEliminar);
		
		lblDeEstado = new JLabel("estado");
		lblDeEstado.setVisible(false);
		lblDeEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeEstado.setBounds(266, 372, 287, 14);
		contentPane.add(lblDeEstado);
		
		btnAceptar = new JButton(".");
		btnAceptar.setVisible(false);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(372, 390, 89, 23);
		contentPane.add(btnAceptar);
		
		//Para poder ver el desing hay que comentar estas lineas: ya que jre-6 no acepta el objeto JComboBox<> en el window builder
		String[] personal = control.llenarComboboxPersonal();
		JComboBox<String> personalCombo = new JComboBox<>(personal);
		personalCombo.setBounds(31, 46, 179, 20);
        contentPane.add(personalCombo);
		personalCombo.setSelectedItem(null);
				
		btnVerDetalles = new JButton("Ver Detalles");
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre =(String)personalCombo.getSelectedItem();
				detallesActionPerformed(e);
			}
		});
		btnVerDetalles.setBounds(403, 71, 89, 23);
		contentPane.add(btnVerDetalles);
	}
	//================================    Aceptar   =============================================
	private void aceptarActionPerformed(java.awt.event.ActionEvent e) {
		//=============  para agregar  ===============
		if(btnAceptar.getText().equals("Agregar empleado")) {
			if(control.vacio(textMostrarNombre,textMostrarApellido,textMostrarCedula,textMostrarSexo,textMostrarTelf,textMostrarCorreo,textMostrarDir,textMostrarCargo)) {
				lblDeEstado.setText("No pueden haber campos vacios");
				lblDeEstado.setVisible(false);
			}else {
				if(!control.verificarEmpleado(textMostrarNombre)) {
					control.agregarPersonal(textMostrarNombre,textMostrarApellido,textMostrarCedula,textMostrarSexo,textMostrarTelf,textMostrarCorreo,textMostrarDir,textMostrarCargo);
					VentanaPersonalAdmin ventana = new VentanaPersonalAdmin();
				    control.cambiarVentana(ventana, this);
				}else {
					lblDeEstado.setText("Usuario ya existe");
					lblDeEstado.setVisible(true);
				}
			}
		}
		//=============  para eliminar  ==============
		if(btnAceptar.getText().equals("Eliminar empleado")) {
			if(control.vacio(textMostrarNombre)) {
				lblDeEstado.setText("No pueden haber campos vacios");
				lblDeEstado.setVisible(false);
			}else {
				nombre=textMostrarNombre.getText();
				control.eliminarPersonal(nombre);
				VentanaPersonalAdmin ventana = new VentanaPersonalAdmin();
			    control.cambiarVentana(ventana, this);
			}
		}
	}
	
	//================================ Acciones Agregar/Modificar/elimiar==============================
	private void agregarActionPerformed(java.awt.event.ActionEvent e) {
		btnAceptar.setText("Agregar empleado");
		btnAceptar.setVisible(true);
		btnVerDetalles.setVisible(false);
		
		textMostrarNombre.setEditable(true);
		textMostrarApellido.setEditable(true);
		textMostrarCedula.setEditable(true);
		textMostrarSexo.setEditable(true);
		textMostrarTelf.setEditable(true);
		textMostrarCorreo.setEditable(true);
		textMostrarDir.setEditable(true);
		textMostrarCargo.setEditable(true);
		
		textMostrarNombre.setText("");
		textMostrarApellido.setText("");
		textMostrarCedula.setText("");
		textMostrarSexo.setText("");
		textMostrarTelf.setText("");
		textMostrarCorreo.setText("");
		textMostrarDir.setText("");
		textMostrarCargo.setText("");
	}
	private void elimianrAcionPerformed(java.awt.event.ActionEvent e) {
		btnAceptar.setText("Eliminar empleado");
		btnAceptar.setVisible(true);
		btnVerDetalles.setVisible(false);
	}
	//================================Action Detalles Performed===================================
	private void detallesActionPerformed(java.awt.event.ActionEvent e) {
		textMostrarNombre.setText(nombre);
		textMostrarApellido.setText(control.detallesPersonalApellido(nombre));
		textMostrarCedula.setText(control.detallesPersonalCedula(nombre));
		textMostrarSexo.setText(control.detallesPersonalSexo(nombre));
		textMostrarTelf.setText(control.detallesPersonalTelf(nombre));
		textMostrarCorreo.setText(control.detallesPersonalCorreo(nombre));
		textMostrarDir.setText(control.detallesPersonalDireccion(nombre));
		textMostrarCargo.setText(control.detallesPersonalCargo(nombre));
	}
	
	private void atrasActionPerformed(java.awt.event.ActionEvent e) {
		VentanaNominaAdmin ventana = new VentanaNominaAdmin();
	    control.cambiarVentana(ventana, this);
	}
}