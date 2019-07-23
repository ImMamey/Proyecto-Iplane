package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controlador;
import model.Modelo;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
/**
 * @author Victor
 * */
public class VentanaIniciarSesion extends JFrame {
	Controlador control;
	Modelo modelo = new Modelo();
	
	//variables declarations - do not modify
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPass;
	private JButton btnIniciarSesion;
	private JButton btnCrearUnUsuario;
	private JLabel lblNombreDeUsuario;
	private JLabel lblContrasena;
	private JLabel lblEstado;
	private JButton btnSalir;
	private JButton btnNewButton;
	private JButton btnForget;
	// end of variables declarations
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIniciarSesion frame = new VentanaIniciarSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *=====================================================================
	 */
	public VentanaIniciarSesion() {
	initComponents();
	control = new Controlador(this, modelo);
	control.iniciaVentana(this);
}
public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		btnSalir.setBounds(571, 11, 89, 23);
		contentPane.add(btnSalir);
		
		lblEstado = new JLabel("asdfasf");
		lblEstado.setEnabled(true);
		lblEstado.setVisible(false);
		lblEstado.setForeground(Color.RED);
		lblEstado.setBounds(196, 223, 221, 14);
		contentPane.add(lblEstado);
		
		textUser = new JTextField();
		textUser.setBounds(208, 138, 182, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		textPass = new JTextField();
		textPass.setBounds(208, 192, 182, 20);
		contentPane.add(textPass);
		textPass.setColumns(10);
		
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//boleano para no repetir verificaciones:
				boolean sesion=true;
				//verificador para no vacio:
				if(control.vacio(textUser, textPass)) {
					lblEstado.setText("Hay campo(s) vacio(s)");
					lblEstado.setVisible(true);
					sesion=false;
				}
				//inicio de sesion para usuarios
				if((control.verificarUsuario(textUser,textPass))&&(sesion==true)) {
					if(!control.verificarAdmin(textUser)) {
						iniciarUsuariosActionPerformed(e);
					}else {
						iniciarAdminActionPerformed(e);				
					}
				}else {
					lblEstado.setText("Datos incorrectos.");
					lblEstado.setVisible(true);
					control.limpia(textPass);
				}
			}
		});
		btnIniciarSesion.setBounds(153, 248, 128, 23);
		contentPane.add(btnIniciarSesion);
		 
		lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setBounds(169, 117, 221, 14);
		contentPane.add(lblNombreDeUsuario);
		
		lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setBounds(169, 169, 221, 14);
		contentPane.add(lblContrasena);
		
		btnCrearUnUsuario = new JButton("Crear un Usuario");
		btnCrearUnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearUsuarioActionPerformed(e);
			}
		});
		btnCrearUnUsuario.setBounds(314, 248, 140, 23);
		contentPane.add(btnCrearUnUsuario);
		
		JLabel lblO = new JLabel("o");
		lblO.setBounds(297, 252, 12, 14);
		contentPane.add(lblO);
		
		btnForget = new JButton("¿Olvidaste tu contraseña?");
		btnForget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forgetActionPerformed(e);
			}
		});
		btnForget.setBounds(483, 407, 177, 23);
		contentPane.add(btnForget);
	}
	
//getters & setters
public JButton getbtnCrearUnUsuario() {
	return btnCrearUnUsuario;
}
public JButton getbtnIniciarSesion() {
	return btnIniciarSesion;
}
public JTextField getTextUser() {
	return textUser;
}

public void setTextUser(JTextField textUser) {
	this.textUser = textUser;
}

public JTextField getTextPass() {
	return textPass;
}

public void setTextPass(JTextField textPass) {
	this.textPass = textPass;
}
private void forgetActionPerformed(java.awt.event.ActionEvent e){
	CambiarContrasenaUsuario ventana = new CambiarContrasenaUsuario();
	control.cambiarVentana(ventana, this);
}

private void crearUsuarioActionPerformed(java.awt.event.ActionEvent e) {
    VentanaCrearUsuario ventana = new VentanaCrearUsuario();
    control.cambiarVentana(ventana, this);
}
private void iniciarAdminActionPerformed(java.awt.event.ActionEvent e) {
	VentanaPrincipalAdmin ventana = new VentanaPrincipalAdmin();
	control.cambiarVentana(ventana, this);
}
private void iniciarUsuariosActionPerformed(java.awt.event.ActionEvent e) {
	VentanaPrincipalUsuario ventana = new VentanaPrincipalUsuario();
	control.cambiarVentana(ventana, this);
}
}
