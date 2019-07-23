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
/**
 * Jframe para crear el jframe de usuarios
 * @author Victor
 *
 */
public class CambiarContrasenaUsuario extends JFrame {
	
	Controlador control; 
	Modelo modelo = new Modelo();
	//variables declarations - do not modify
	private JPanel contentPane;
	private JButton btnAtras;
	// end of variables declarations
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambiarContrasenaUsuario frame = new CambiarContrasenaUsuario();
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
	public CambiarContrasenaUsuario() {
		initComponents();
		control = new Controlador(this, modelo);
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
	}
	private void atrasActionPerformed(java.awt.event.ActionEvent e) {
	    VentanaIniciarSesion ventana = new VentanaIniciarSesion();
	    control.cambiarVentana(ventana, this);
	}

}
