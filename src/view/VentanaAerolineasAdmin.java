package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controlador;
import model.Modelo;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
/**
 * Jframe para agregar eliminar o editar aerolineas
 * @author Victor
 *
 */
public class VentanaAerolineasAdmin extends JFrame {
	
	Modelo modelo = new Modelo();
	Controlador control = new Controlador(this, modelo);
	
	//variables declarations - do not modify
	private JPanel contentPane;
	private String nombre;
	private String oldname;
	private JButton btnAtras;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnDetalles;
	private JTextField textMostrarNombre;
	private JTextField textMostrarDir;
	private JTextField textMostrarTelf;
	private JTextField textNombre;
	private JTextField textDir;
	private JTextField textTelf;
	private JLabel lblNombre;
	private JLabel lblDir;
	private JLabel lblTelf;
	private JLabel lblDeEstado;
	private JLabel lblMostrarNombre;
	private JLabel lblMostrarTelf;
	private JLabel lblMostrarDir;
	private JButton btnAceptar;
	// end of variables declarations

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAerolineasAdmin frame = new VentanaAerolineasAdmin();
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
	public VentanaAerolineasAdmin() {
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
		btnAgregar.setBounds(10, 527, 89, 23);
		contentPane.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarActionPerformed(e);
			}
		});
		btnModificar.setBounds(109, 527, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarActionPerformed(e);
			}
		});
		btnEliminar.setBounds(208, 527, 89, 23);
		contentPane.add(btnEliminar);
		
		//Comentar para poder usar el desing
		String[] aerolineas = control.llenarComboboxAerolineas();
		JComboBox<String> aerolineasCombo = new JComboBox<>(aerolineas);
		aerolineasCombo.setBounds(31, 46, 179, 20);
		contentPane.add(aerolineasCombo);
		aerolineasCombo.setSelectedItem(null);
		
		btnDetalles = new JButton("Detalles");
		btnDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre=(String)aerolineasCombo.getSelectedItem();
				detallesActionPerformed(e);
			}
		});
		btnDetalles.setBounds(306, 40, 89, 23);
		contentPane.add(btnDetalles);
		
		textMostrarNombre = new JTextField();
		textMostrarNombre.setEditable(false);
		textMostrarNombre.setBounds(306, 85, 89, 20);
		contentPane.add(textMostrarNombre);
		textMostrarNombre.setColumns(10);
		
		textMostrarDir = new JTextField();
		textMostrarDir.setEditable(false);
		textMostrarDir.setColumns(10);
		textMostrarDir.setBounds(306, 116, 89, 20);
		contentPane.add(textMostrarDir);
		
		textMostrarTelf = new JTextField();
		textMostrarTelf.setEditable(false);
		textMostrarTelf.setColumns(10);
		textMostrarTelf.setBounds(306, 147, 89, 20);
		contentPane.add(textMostrarTelf);
		
		lblMostrarNombre = new JLabel("Nombre:");
		lblMostrarNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarNombre.setBounds(231, 88, 66, 14);
		contentPane.add(lblMostrarNombre);
		
		lblMostrarDir = new JLabel("Direccion:");
		lblMostrarDir.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarDir.setBounds(231, 119, 66, 14);
		contentPane.add(lblMostrarDir);
		
	    lblMostrarTelf = new JLabel("Telf.:");
		lblMostrarTelf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarTelf.setBounds(251, 150, 46, 14);
		contentPane.add(lblMostrarTelf);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(520, 113, 89, 20);
		contentPane.add(textNombre);
		
		textDir = new JTextField();
		textDir.setEditable(false);
		textDir.setColumns(10);
		textDir.setBounds(726, 116, 89, 20);
		contentPane.add(textDir);
		
		textTelf = new JTextField();
		textTelf.setEditable(false);
		textTelf.setColumns(10);
		textTelf.setBounds(622, 147, 89, 20);
		contentPane.add(textTelf);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(444, 119, 66, 14);
		contentPane.add(lblNombre);
		
		lblDir = new JLabel("Direccion:");
		lblDir.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDir.setBounds(650, 119, 66, 14);
		contentPane.add(lblDir);
		
		lblTelf = new JLabel("Telf.:");
		lblTelf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelf.setBounds(563, 150, 46, 14);
		contentPane.add(lblTelf);
		
		lblDeEstado = new JLabel("lblDeEstado");
		lblDeEstado.setVisible(false);
		lblDeEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeEstado.setBounds(520, 188, 295, 14);
		contentPane.add(lblDeEstado);
		
		btnAceptar = new JButton("");
		btnAceptar.setVisible(false);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(582, 213, 169, 23);
		contentPane.add(btnAceptar);
		

	}
	//=================================Action performed=====================
	/**
	 * ActionPerformed para Elimianr Editar o agregar Aerolineas
	 * @param e
	 */
	private void aceptarActionPerformed(java.awt.event.ActionEvent e) {
		//==============En el caso de que sea Agregar una aerolinea==============
		if(btnAceptar.getText().equals("Agregar Aerolinea")) {
			if(control.vacio(textNombre,textDir,textTelf)) {
				lblDeEstado.setText("No pueden existir campos vacios");
				lblDeEstado.setVisible(true);
			}else {
				if(!control.verificarAerolinea(textNombre)) {
					textNombre.setEditable(false);
					textDir.setEditable(false);
					textTelf.setEditable(false);	
					control.agregarAerolinea(textNombre,textDir,textTelf);
					VentanaAerolineasAdmin ventana = new VentanaAerolineasAdmin();
					control.cambiarVentana(ventana, this);
				}else {
					lblDeEstado.setText("La Aerolinea ya existe");
					lblDeEstado.setVisible(true);
				}
			}	
		}
		//==============En el caso de que sea modificar una aerolinea=============
		if(btnAceptar.getText().equals("Modificar Aerolinea")) {
			if(control.vacio(textNombre)) {
				lblDeEstado.setText("Campo Vacio");
				lblDeEstado.setVisible(true);
			}else {
				if(control.verificarAerolinea(textNombre)) {
					control.modificarAerolinea(oldname,textNombre,textDir,textTelf);
				}else {
					lblDeEstado.setText("Nombre no existe");
					lblDeEstado.setVisible(true);
				}
			}
		}
		//==============En el caso de que sea eliminar una aerolinea============
		if(btnAceptar.getText().equals("Eliminar Aerolinea")) {
			if(control.vacio(textNombre)) {
				lblDeEstado.setText("Campo Vacio");
				lblDeEstado.setVisible(true);
			}else {
				if(control.verificarAerolinea(textNombre)) {
					control.eliminarAerolinea(textNombre);
					VentanaAerolineasAdmin ventana = new VentanaAerolineasAdmin();
					control.cambiarVentana(ventana, this);
				}else {
					lblDeEstado.setText("Nombre no existe");
					lblDeEstado.setVisible(true);
				}
			}
		}
	}
	private void agregarActionPerformed(java.awt.event.ActionEvent e) {
		btnAceptar.setText("Agregar Aerolinea");
		btnAceptar.setVisible(true);
		textNombre.setEditable(true);
		textDir.setEditable(true);
		textTelf.setEditable(true);
	}
	private void modificarActionPerformed(java.awt.event.ActionEvent e) {
		btnAceptar.setText("Modificar Aerolinea");
		btnAceptar.setVisible(true);
		textNombre.setEditable(true);
		textDir.setEditable(true);
		textTelf.setEditable(true);
		
		textNombre.setText(textMostrarNombre.getText());
		textDir.setText(textMostrarDir.getText());
		textTelf.setText(textMostrarTelf.getText());
		
		oldname=textNombre.getText();
		//otra logica
	}
	private void eliminarActionPerformed(java.awt.event.ActionEvent e) {
		btnAceptar.setText("Eliminar Aerolinea");
		btnAceptar.setVisible(true);
		textNombre.setEditable(true);
		textDir.setEditable(false);
		textTelf.setEditable(false);
	}
	//=======================Boton para ver los detalles de la Aerolinea
		private void detallesActionPerformed(java.awt.event.ActionEvent e) {
			textMostrarNombre.setText(nombre);
			textMostrarDir.setText(control.detallesAerolineaDir(nombre));
			textMostrarTelf.setText(control.detallesAerolineaTelf(nombre));	
		}
	private void atrasActionPerformed(java.awt.event.ActionEvent e) {
	    VentanaPrincipalAdmin ventana = new VentanaPrincipalAdmin();
	    control.cambiarVentana(ventana, this);
	}
}