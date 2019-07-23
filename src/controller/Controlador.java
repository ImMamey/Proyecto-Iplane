package controller;


import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import jdata.*;
import model.*;
import view.*;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import java.awt.event.ActionEvent;
/**
 * Extrae la informacion de todos los Jframes, y los filtra hacia el modelo, para su respectivo almacenamiento prolongado
 * @author Victor
 * @author Eric
 * @version beta 0.34
 * @since alpha 0.02
 */

public class Controlador{
	
	DataModel modeloJSON = new DataModel();
	VentanaIniciarSesion ventanaIniciarSesion;
	JFrame ventana;
	
	Modelo modelo;
	JTextField JTextField1, JTextField2;
	String[] array1;
	String string1, string2, string3, string4, string5, string6, string7, string8;

	/**
	 *Metodo para crear y vincular esta clase en el jframe, vincula la ventana y el modelo para poder pasar datos a los mismos
	 *@since apha 0.02
	 *@param ventana, modelo el JFrame y el Class a vincular 
	 */
	
	public Controlador(JFrame ventana, Modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;
	}
	/**
	 *Metodo para crear y vincular esta clase en el jframe, vincula la ventana y el modelo para poder pasar datos a los mismos
	 *@since alpha 0.02 
	 *@param ventana JFrame a vincular
	 *@param JTextField1 JTextField a vincular
	 *@param JTextField2 JTextField a vincular
	 */
	public Controlador(JFrame ventana, JTextField JTextField1,JTextField JTextField2) {
		this.ventana = ventana;
		this.JTextField1 = JTextField1;
		this.JTextField2 = JTextField2;
	}
	
	/**
	 * Metodo para limpiar una casilla tipo JTextField en cualquier JFrame
	 * @since alpha 0.05
	 * @param usuario JTextField el cual se va a vaciar su contenido
	 */
	
	public void limpia(JTextField usuario) {
		usuario.setText("");
		usuario.requestFocus();
	}
	/**
	 * Metodo para limpiar dos casillas de tipo JTextField en cualquier JFrame
	 * @since alpha 0.05
	 * @param usuario JTextField el cual se va  a vaciar
	 * @param password JTextField el cual se va a vaciar
	 */
	
	public void limpia (JTextField usuario,JTextField password) {
		usuario.setText("");
		password.setText("");
		usuario.requestFocus();
	}
	//===============================Verificadores de JTextFields vacios=================================
	/**
	 * Metodo que va a revisar que sus JTextField's no esten vacio
	 * @param JTextField1 
	 * @param JTextField2
	 * @param JTextField3
	 * @param JTextField4
	 * @param JTextField5
	 * @param JTextField6
	 * @param JTextField7
	 * @param JTextField8
	 * @return true si todos los textFields estan vacios false si no es asi
	 */
	
	public boolean vacio(JTextField JTextField1, JTextField JTextField2, JTextField JTextField3, JTextField JTextField4,
			JTextField JTextField5, JTextField JTextField6, JTextField JTextField7, JTextField JTextField8) {
		
			if((JTextField1.getText().equals(""))||(JTextField2.getText().equals(""))||(JTextField3.getText().equals(""))||
					(JTextField4.getText().equals(""))||(JTextField5.getText().equals(""))||(JTextField6.getText().equals(""))||
					(JTextField7.getText().equals(""))||(JTextField8.getText().equals(""))) {
				return true;
			}else {
				return false;
			}
	}
	/**
	 *  Metodo que va a revisar que sus JTextField's no esten vacio
	 * @param JTextField1
	 * @param JTextField2
	 * @param JTextField3
	 * @param JTextField4
	 * @param JTextField5
	 * @param JTextField6
	 * @param JTextField7
	 * @return true si todos los textFields estan vacios false si no es asi
	 */
	
	public boolean vacio(JTextField JTextField1, JTextField JTextField2, JTextField JTextField3, JTextField JTextField4,
			JTextField JTextField5, JTextField JTextField6, JTextField JTextField7) {
		if((JTextField1.getText().equals(""))||(JTextField2.getText().equals(""))||(JTextField3.getText().equals(""))||
				(JTextField4.getText().equals(""))||(JTextField5.getText().equals(""))||(JTextField6.getText().equals(""))||
				(JTextField7.getText().equals(""))) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 *  Metodo que va a revisar que sus JTextField's no esten vacio
	 * @param JTextField1
	 * @param JTextField2
	 * @param JTextField3
	 * @param JTextField4
	 * @param JTextField5
	 * @return true si todos los textFields estan vacios false si no es asi
	 */
	public boolean vacio(JTextField JTextField1, JTextField JTextField2, JTextField JTextField3,JTextField JTextField4, JTextField JTextField5) {
		if((JTextField1.getText().equals(""))||(JTextField2.getText().equals(""))||(JTextField3.getText().equals(""))||(JTextField4.getText().equals(""))||
				(JTextField5.getText().equals(""))) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 *  Metodo que va a revisar que sus JTextField's no esten vacio
	 * @param JTextField1
	 * @param JTextField2
	 * @param JTextField3
	 * @param JTextField4
	 * @return true si todos los textFields estan vacios false si no es asi
	 */
	public boolean vacio(JTextField JTextField1, JTextField JTextField2, JTextField JTextField3, JTextField JTextField4) {
		if((JTextField1.getText().equals(""))||(JTextField2.getText().equals(""))||(JTextField3.getText().equals(""))||(JTextField4.getText().equals(""))) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Metodo que va a revisar que sus JTextField's no esten vacio
	 * @param JTextField1
	 * @param JTextField2
	 * @param JTextField3
	 * @return true si todos los textFields estan vacios false si no es asi
	 */
	public boolean vacio(JTextField JTextField1, JTextField JTextField2, JTextField JTextField3) {
		if((JTextField1.getText().equals(""))||(JTextField2.getText().equals(""))||(JTextField3.getText().equals(""))) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 *  Metodo que va a revisar que sus JTextField's no esten vacio
	 * @param JTextField1
	 * @param JTextField2
	 * @return true si todos los textFields estan vacios false si no es asi
	 */
	public boolean vacio(JTextField JTextField1, JTextField JTextField2) {
		if((JTextField1.getText().equals(""))||(JTextField2.getText().equals(""))) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 *  Metodo que va a revisar que su JTextField no esté vacío
	 * @param JTextField1
	 * @return  true si el textField está vacío, false si no es asi
	 */
	public boolean vacio(JTextField JTextField1) {
		if(JTextField1.getText().equals("")) {
			return true;
		}else {
			return false;
		}
	}
	//===========================Administradores de Aerolineas========================================
	/**
	 * Metodo para enviar datos al DataModel para su GuardadoInmediato
	 * @param JTextField1
	 * @param JTextField2
	 * @param JTextField3
	 */
	public void agregarAerolinea(JTextField JTextField1, JTextField JTextField2, JTextField JTextField3) {
		this.string1=JTextField1.getText();
		this.string2=JTextField2.getText();
		this.string3=JTextField3.getText();
		modeloJSON.agregarAerolinea(this.string1,this.string2,this.string3);
	}
	/**
	 * Metodo para enviar al DataModel la solicitud de eliminar los datos de una aerolinea
	 * @param JTextField1
	 */
	public void eliminarAerolinea(JTextField JTextField1) {
		this.string1=JTextField1.getText();
		modeloJSON.eliminarAerolinea(string1);
	}
	/**
	 * Metodo para poder modificar los datos de una aerolinea. Tecnicamente, elimina la aerolinea con el mismo nombre, y crea una nueva aerolinea con los datos nuevos
	 * @param oldname
	 * @param JTextField1
	 * @param JTextField2
	 * @param JTextField3
	 */
	public void modificarAerolinea(String oldname, JTextField JTextField1, JTextField JTextField2, JTextField JTextField3) {
		this.string1=JTextField1.getText();
		this.string2=JTextField2.getText();
		this.string3=JTextField3.getText();
		modeloJSON.eliminarAerolinea(oldname);
		modeloJSON.agregarAerolinea(this.string1, this.string2, this.string3);
	}
	/**
	 * Metodo para obtener los Nombres en una aerolinea
	 * @return String[] con los nombres de las aerolineas
	 */
	public String[] llenarComboboxAerolineas() {
		return modeloJSON.llenarComboboxAerolineas();
	}
	/**
	 * Metodo para verificar que una aerolina exista
	 * @param JTextField1 con el nombre a verificar
	 * @return true si la aerolinea existe false si no es asi
	 */
	public boolean verificarAerolinea(JTextField JTextField1){
		this.string1=JTextField1.getText();
		if(!modeloJSON.verificarAerolinea(this.string1)) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * Metodo para obtener la direccion de una aerolinea especifica
	 * @param nombre String con el nombre de la aerolinea a revisar
	 * @return String con el nombr de la aerolinea
	 */
	public String detallesAerolineaDir(String nombre) {
		return modeloJSON.retornarAerolineaDir(nombre);
	}
	/**
	 * Metodo para obtener el telefono de una aerolinea especifica
	 * @param nombre
	 * @return String con el telefono de la aerolinea
	 */
	public String detallesAerolineaTelf(String nombre) {
		return modeloJSON.retornarAerolineaTelf(nombre);
	}
	//===========================Administradores de Personal en el JSON's=============================
	/**
	 * Metodo para obtener los nombres del Personal para llenar un comobobox
	 * @return un String[] con los nombres del personal
	 */
	public String[] llenarComboboxPersonal() {
		return modeloJSON.llenarComboboxPersonal();
	}
	/**
	 * Metodo para obtener el apellido de un personal
	 * @param nombre
	 * @return String con el apellido de un personal
	 */
	public String detallesPersonalApellido(String nombre) {
		return modeloJSON.retornarPersonalApellido(nombre);
	}
	/**
	 * Metodo para obtener la cedula de un personal
	 * @param nombre
	 * @return String con la cedula del personal
	 */
	public String detallesPersonalCedula(String nombre) {
		return modeloJSON.retornarPersonalCedula(nombre);
	}
	/**
	 * Metodo para obtener el Sexo de un personal
	 * @param nombre
	 * @return sexo del empleado
	 */
	public String detallesPersonalSexo(String nombre) {
		return modeloJSON.retornarPersonalSexo(nombre);
	}
	/**
	 * Metodo para obtener l telefono de un empleado
	 * @param nombre
	 * @return String con el telefono de un empleado
	 */
	public String detallesPersonalTelf(String nombre) {
		return modeloJSON.retornarPersonalTelf(nombre);
	}
	/**
	 * Metodo para obtener el correo de un empleado
	 * @param nombre
	 * @return string con el telefono de un empleado
	 */
	public String detallesPersonalCorreo(String nombre) {
		return modeloJSON.retornarPersonalCorreo(nombre);
	}
	/**
	 * Metodo para obtener la direccion de residencia de un empleado
	 * @param nombre
	 * @return la direccion del empleado
	 */
	public String detallesPersonalDireccion(String nombre) {
		return modeloJSON.retornarPersonalDireccion(nombre);
	}
	/**
	 * Metodo para obtener el cargo de un empleado
	 * @param nombre
	 * @return String con el cargo del empleado
	 */
	public String detallesPersonalCargo(String nombre) {
		return modeloJSON.retornarPersonalCargo(nombre);
	}
	/**
	 * Metodo para verificar que un empleado exista
	 * @param JTextField1 con el nombre de un empleado
	 * @return boolean true si el nombre existe, false si no es asi
	 */
	public boolean verificarEmpleado(JTextField JTextField1) {
		this.string1=JTextField1.getText();
		if(! modeloJSON.verificarExistenciaDeEmpleado(string1)) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * Metodo para eliminar a un empleado
	 * @param nombre
	 */
	public void eliminarPersonal(String nombre){
		modeloJSON.eliminarPersonal(nombre);
	}
	/**
	 * Metodo para agrear a un empleado con todos sus atributos
	 * @param JTextField1
	 * @param JTextField2
	 * @param JTextField3
	 * @param JTextField4
	 * @param JTextField5
	 * @param JTextField6
	 * @param JTextField7
	 * @param JTextField8
	 */
	public void agregarPersonal(JTextField JTextField1, JTextField JTextField2, JTextField JTextField3, JTextField JTextField4,
			JTextField JTextField5, JTextField JTextField6, JTextField JTextField7, JTextField JTextField8) {
		this.string1=JTextField1.getText();
		this.string2=JTextField2.getText();
		this.string3=JTextField3.getText();
		this.string4=JTextField4.getText();
		this.string5=JTextField5.getText();
		this.string6=JTextField6.getText();
		this.string7=JTextField7.getText();
		this.string8=JTextField8.getText();
		modeloJSON.agregarPersonal(string1, string2, string3,string4, string5, string6, string7,string8);
	}
	
	//===========================Administradores de Usuarios en el JSON's=============================
	/**
	 * Metodo para obtener el apellido de un usuario
	 * @param nombre
	 * @return String con el apellido
	 */
	public String detallesUsuarioApellido(String nombre) {
		return modeloJSON.retornarUsuarioApellido(nombre);
	}
	/**
	 * Metodo para obtener el correo de un usuario
	 * @param nombre
	 * @return String  con el correo del usuario
	 */
	public String detallesUsuarioCorreo(String nombre) {
		return modeloJSON.retornarUsuarioCorreo(nombre);
	}
	/**
	 * Metodo para obtener el user de un usuario
	 * @param nombre
	 * @return String con el user
	 */
	public String detallesUsuarioUser(String nombre) {
		return modeloJSON.retornarUsuarioUser(nombre);
	}
	/**
	 * Metodo para agregar al un usuario con todos sus atributos
	 * @param JTextField1
	 * @param JTextField2
	 * @param JTextField3
	 * @param JTextField4
	 * @param JTextField5
	 * @param JTextField6
	 * @param JTextField7
	 * @param JTextField8
	 */
	public void agregarUsuario(JTextField JTextField1, JTextField JTextField2, JTextField JTextField3, JTextField JTextField4,
			JTextField JTextField5, JTextField JTextField6, JTextField JTextField7, JTextField JTextField8) {
		this.string1=JTextField1.getText();
		this.string2=JTextField2.getText();
		this.string3=JTextField3.getText();
		this.string4=JTextField4.getText();
		this.string5=JTextField5.getText();
		this.string6=JTextField6.getText();
		this.string7=JTextField7.getText();
		this.string8=JTextField8.getText();
		modeloJSON.agregarUsuario(string1, string2, string3,string4, string5, string6, string7);
	}
	/**
	 * Metodo para eliminar un usuario por un nombre dado
	 * @param nombre
	 */
	public void eliminarUsuario(String nombre){
		modeloJSON.eliminarUsuario(nombre);
	}
	/**
	 * Metodo para verificar que el nombre de usuario esté en uso
	 * @param JTextField1 con el nombre de usuario
	 * @return false si no existe true si existe
	 */
	public boolean verificarNombreUsuario(JTextField JTextField1) {
		this.string1=JTextField1.getText();
		if(! modeloJSON.verificarExistenciaDeUsuario(string1)) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * Metodo para verificar que el nombre de usuario y su respectivo password coincidan
	 * @param JTextField1 nombre
	 * @param JTextField2 pasword
	 * @return true si coinciden false si no es asi
	 */
	public boolean verificarUsuario(JTextField JTextField1,JTextField JTextField2) {
		this.string1=JTextField1.getText();
		this.string2=JTextField2.getText();
		if(!modeloJSON.verificarInicioDeUsuario(string1,string2)) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * Metodo para verificar el nombre de usuario de Administrador 
	 * @param JTextField1
	 * @return true si es asi, false si no es asi
	 */
	public boolean verificarAdmin(JTextField JTextField1) {
		this.string1=JTextField1.getText();
		if(!modeloJSON.verificarInicioDeAdmin(string1)) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * Metodo para obtener los nombres de los usuario registrados en un String[]
	 * @return String[] con los nombres de usuarios
	 */
	public String[] llenarComboboxUsuarios() {
		return modeloJSON.llenarComboboxUsuarios();
	}
	//==========================Administradores de Rutas===============================
	/**
	 * Metodo para obtener el id del nombre de una ruta
	 * @param nombre
	 * @return String con el id
	 */
	public String detallesRutaId(String nombre) {
		return modeloJSON.retornarRutaId(nombre);
	}
	/**
	 * Metodo para obtener la ciudad de entrada de una ruta
	 * @param nombre
	 * @return String con el nombre de la ciudad
	 */
	public String detallesCiudadEntrada(String nombre) {
		return modeloJSON.retornarCiudadEntrada(nombre);
	}
	/**
	 * Metodo para obtener la ciudad de Salida de una ruta por un nombre
	 * @param nombre
	 * @return String con el nombre de la ciudad de salida
	 */
	public String detallesCiudadSalida(String nombre) {
		return modeloJSON.retornarCiudadSalida(nombre);
	}
	public String[] llenarComboboxRutas() {
		return modeloJSON.llenarComboboxRutas();
	}
	/**
	 * Metodo para verificar la existncia de una ruta por un nombre
	 * @param JTextField1
	 * @return true si existe, false si no es asi
	 */
	public boolean verificarRuta(JTextField JTextField1) {
		this.string1=JTextField1.getText();
		if(!modeloJSON.verificarRuta(string1)) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * Metodo para eliminar la existencia de una rut por un nombre dado
	 * @param JTextField1
	 */
	public void eliminarRuta(JTextField JTextField1){
		this.string1=JTextField1.getText();
		modeloJSON.eliminarRuta(string1);
	}
	/**
	 * Metodo para modificar una ruta. Elimina la ruta con el nombre anterior, y crea una nueva con los nuevos atributos
	 * @param oldname
	 * @param JTextField1
	 * @param JTextField2
	 * @param JTextField3
	 * @param JTextField4
	 */
	public void modificarRuta(String oldname,JTextField JTextField1,JTextField JTextField2, JTextField JTextField3,JTextField JTextField4) {
		this.string1=JTextField1.getText();
		this.string2=JTextField2.getText();
		this.string3=JTextField3.getText();
		this.string4=JTextField4.getText();
		modeloJSON.eliminarRuta(oldname);
		modeloJSON.agregarRuta(string1, string2, string3, string4);
	}
	/**
	 * Metodo para agregar una ruta con todos sus atributos
	 * @param JTextField1
	 * @param JTextField2
	 * @param JTextField3
	 * @param JTextField4
	 */
	public void agregarRuta(JTextField JTextField1,JTextField JTextField2, JTextField JTextField3,JTextField JTextField4) {
		this.string1=JTextField1.getText();
		this.string2=JTextField2.getText();
		this.string3=JTextField3.getText();
		this.string4=JTextField4.getText();
		modeloJSON.agregarRuta(string1, string2, string3, string4);
	}
	//==========================Administradores de Ciudades===========================
	/**
	 * Metodo para obtener todos los nombres de Ciudades en un String[]
	 * @return String[] con los nombres e ciudades
	 */
	public String[] llenarComboboxCiudades(){
		return modeloJSON.llenarComboboxCiudades();
	}
	/**
	 * Metodo para verificar la existencia de una ciudad
	 * @param JTextField1 nombre
	 * @return true si existe, flase si no es asi
	 */
	public boolean vericarCiudad(JTextField JTextField1){
		this.string1=JTextField1.getText();
		if(modeloJSON.verificarCiudad(this.string1)) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Metodo para agregar una ciudad
	 * @param JTextField1 nombre
	 */
	public void agregarCiudad(JTextField JTextField1) {
		this.string1=JTextField1.getText();
		modeloJSON.agregarCiudad(this.string1);
	}
	/**
	 * Metodo para eliminar una ciudad
	 * @param JTextField1 nombre
	 */
	public void eliminarCiudad(JTextField JTextField1) {
		this.string1=JTextField1.getText();
		modeloJSON.eliminarCiudad(this.string1);
	}
	//==========================Administradores de JAgencias============================
	/**
	 * Metodo para obtener un String[] con los nombres de las Agencias
	 * @return String[] con lso nombres de las agencias
	 */
	public String[] llenarComboboxAgencias() {
		return modeloJSON.llenarComboboxAgencias();
	}
	/**
	 * Metodo para obtener la dir de una agencias especifca
	 * @param nombre
	 * @return la direccion de esta
	 */
	public String detallesAgenciaDir(String nombre) {
		return modeloJSON.retornarAgenciaDir(nombre);
	}
	/**
	 * Metodo para obtener el telefono de una agencia
	 * @param nombre
	 * @return el telefono de una agencia
	 */
	public String detallesAgenciaTelf(String nombre) {
		return modeloJSON.retornarAgenciaTelf(nombre);
	}
	/**
	 * Metodo para obtener el nombre del contacto de la agencia
	 * @param nombre
	 * @return String con el nombre
	 */
	public String detallesAgenciaContacto(String nombre) {
		return modeloJSON.retornarAgenciaContacto(nombre);
	}
	/**
	 * Metodo para obtener el tlf del contacto de la agencia
	 * @param nombre
	 * @return string con el tlf
	 */
	public String detallesAgenciaTlfContacto(String nombre) {
		return modeloJSON.retornarAgenciaTelfContacto(nombre);
	}
	/**
	 * Metodo para verificar que la agencia exista o no
	 * @param JTextField1 nombre
	 * @return true si existe false si no
	 */
	public boolean verificarAgencia(JTextField JTextField1) {
		this.string1=JTextField1.getText();
		if(!modeloJSON.verificarAgencia(string1)) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * Metodo para eliminar una agencia dado un nombre
	 * @param JTextField1 nombre
	 */
	public void eliminarAgencia(JTextField JTextField1) {
		this.string1=JTextField1.getText();
		modeloJSON.eliminarAgencia(string1);
	}
	/**
	 * Metodo para modificar los atributos de una agencia. Elimina los datos anteriores y los remplaza por los atributos nuevos
	 * @param oldname
	 * @param JTextField1
	 * @param JTextField2
	 * @param JTextField3
	 * @param JTextField4
	 * @param JTextField5
	 */
	public void modificarAgencia(String oldname,JTextField JTextField1,JTextField JTextField2, JTextField JTextField3,JTextField JTextField4, JTextField JTextField5) {
		this.string1=JTextField1.getText();
		this.string2=JTextField2.getText();
		this.string3=JTextField3.getText();
		this.string4=JTextField4.getText();
		this.string5=JTextField5.getText();
		modeloJSON.eliminarAgencia(oldname);
		modeloJSON.agregarAgencia(string1, string2, string3, string4, string5);
	}
	/**
	 * Metodo para agregar una agencia nueva con todos sus atributos
	 * @param JTextField1
	 * @param JTextField2
	 * @param JTextField3
	 * @param JTextField4
	 * @param JTextField5
	 */
	public void agregarAgencia(JTextField JTextField1,JTextField JTextField2, JTextField JTextField3,JTextField JTextField4, JTextField JTextField5) {
		this.string1=JTextField1.getText();
		this.string2=JTextField2.getText();
		this.string3=JTextField3.getText();
		this.string4=JTextField4.getText();
		this.string5=JTextField5.getText();
		modeloJSON.agregarAgencia(string1, string2, string3, string4, string5);
	}
	//===========================Administradores de ventanas============================
	//Elimina la ventana de la memoria
	//garantiza que no se dejen ventas ejecutandose
	/**
	 * Metodo para cambiar de ventanas
	 * @param ventana ventana actual,
	 * @param ventana2 ventana nueva
	 */
	  public void cambiarVentana(JFrame ventana,JFrame ventana2) {
	        ventana.setLocationRelativeTo(null);
	        ventana.setVisible(true);
	        ventana2.dispose();
	  }
	  /**
	   * Metoo para inicar la ventana, y eliminar la opcionde la x de cierre
	   * @param ventana
	   */
	     public void iniciaVentana(JFrame ventana){
	         ventana.setLocationRelativeTo(null);
	         ventana.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	         ventana.setResizable(false);
	      }
	  
}
