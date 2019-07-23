package jdata;

import org.json.*;
import controller.Controlador;
import view.*;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComboBox;
/**
 * Clase para guardar todos los datos
 * @author Victor
 *
 */

public class DataModel {
	
	//==============================================ESTOS METODOS/FUNCTIONS SON LOS PRINCIPALES Y RESPONSABLES DEL MANEJO DE CADA JSON, NO TOCAR!===========================
	
	/**
	 * Metodo que Verifica si el archivo existe (o no)
	 * @returm el Stream
	 */
	public static InputStream inputStreamFromFile(String path) {
		
		try {
			InputStream inputStream = FileHandle.class.getResourceAsStream(path); //carga el contenido de json en "InputStream"
			return inputStream;
		}catch(Exception e) {
			e.printStackTrace(); //muestra el tracer de los errores si hay algun problema al usar el json
		}
		return null;
	}
	/**
	 * Metodo para obtener el json file
	 * @param path String con el path
	 * @return el objeto
	 */
	 public static String getJsonStringFromFile(String path) {
			Scanner scanner;
			InputStream in = inputStreamFromFile(path);             //obtiene el contenido del .JSON y lo guarda en la variable "in"
			scanner = new Scanner(in);								//crea el objeto scanner con lo valores del inputStream "in"
			String json= scanner.useDelimiter("\\Z").next();		//lee la totalidad del archivo .JSON y lo guarda en un string "json"
			scanner.close();										//cierra el scanner
			return json;											//retorna el String del JSON
		 }
	 /**
	  * Metodo para ver si el metodo existe o no
	  * @param jsonObject
	  * @param key
	  * @return si existe o no
	  */
	 public static boolean objectExists (JSONObject jsonObject, String key) { //verifica sin el nombre de un objeto existe en el JSON
		 Object o;
		 try {
			 o=jsonObject.get(key);
		 }catch(Exception e) {
			 return false;
		 }
		 return o!=null;
	 }
	 /**
	  * Metodo para obtener un json obj de un path
	  * @param path
	  * @return
	  */
	  public static JSONObject getJSONObjectFromFile(String path) {    //genera un JSONObject, dado al string path ingresado.
		 return new JSONObject(getJsonStringFromFile(path));
	 }
	  //========================================================FIN DE FUNCIONES DE MANEJO DE JSONS====================================================================
	  
	  
	  
	//variables declarations - do not modify
	  private String string1, string2, string3, string4, string5, string6, string7, string8;
	  String[]array1;
	  JSONObject obj = getJSONObjectFromFile("/obj.json");  //crea un JSONObject "obj" dado al string path ESTO ES PARTE DEL TUTORIAL!
	  JSONObject usuarios = getJSONObjectFromFile("/usuarios.json");
	  JSONObject agencias = getJSONObjectFromFile("/agencias.json");
	  JSONObject ciudades = getJSONObjectFromFile("/ciudades.json");
	  JSONObject rutas = getJSONObjectFromFile("/rutas.json");
	  JSONObject aerolineas = getJSONObjectFromFile("/aerolineas.json");
	  JSONObject personal =  getJSONObjectFromFile("/personal.json");
	
	  // end of variables declarations
	  
	 //===============================================Llenado y lectura de Usuarios==============================================
	 /**
	  * Metodo pra llenar combobox usuario
	  * @return array con los datos de ususario
	  */
	  public String[] llenarComboboxUsuarios() {
		 
		 JSONArray listaUsuarios = usuarios.getJSONArray("Usuarios");
		 String[] array1 = new String[listaUsuarios.length()];
		 for(int j=0;j<listaUsuarios.length();j++) {
			 JSONObject usuario = listaUsuarios.getJSONObject(j);
			 this.string1=usuario.getString("nombre");
			 array1[j]=usuario.getString("nombre");
		 }
		 return array1;
	 }
	  /**
	   * Metodo para returnar el apellido de un ususario
	   * @param nombre
	   * @return apellido
	   */
	 public String retornarUsuarioApellido(String nombre) {
		 this.string1="No existe Usuario";
		 JSONArray listaUsuarios = usuarios.getJSONArray("Usuarios");
		 for(int j=0;j<listaUsuarios.length();j++) {
			 JSONObject usuario = listaUsuarios.getJSONObject(j);
			 if(usuario.getString("nombre").equals(nombre)) {
				 this.string1=usuario.getString("apellido");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para retornar el username de un usario
	  * @param nombre
	  * @return usarname
	  */
	 public String retornarUsuarioUser(String nombre) {
		 this.string1="No existe Usuario";
		 JSONArray listaUsuarios = usuarios.getJSONArray("Usuarios");
		 for(int j=0;j<listaUsuarios.length();j++) {
			 JSONObject usuario = listaUsuarios.getJSONObject(j);
			 if(usuario.getString("nombre").equals(nombre)) {
				 this.string1=usuario.getString("username");
			 }
		 }
		 return this.string1; 
	 }
	 /**
	  * Metodo para retornar el correo de un usario
	  * @param nombre
	  * @return correo
	  */
	 public String retornarUsuarioCorreo(String nombre) {
		 this.string1="No existe Usuario";
		 JSONArray listaUsuarios = usuarios.getJSONArray("Usuarios");
		 for(int j=0;j<listaUsuarios.length();j++) {
			 JSONObject usuario = listaUsuarios.getJSONObject(j);
			 if(usuario.getString("nombre").equals(nombre)) {
				 this.string1=usuario.getString("correo");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para verificar la existencia de un susario
	  * @param incomeUsername
	  * @return true si es cierto, false si no
	  */
	 public boolean verificarExistenciaDeUsuario(String incomeUsername) { 
		 JSONArray listaUsuario = usuarios.getJSONArray("Usuarios");
		 for(int j=0;j<listaUsuario.length();j++) {
			 JSONObject user = listaUsuario.getJSONObject(j);
			 if(user.getString("username").equals(incomeUsername)) {
				 return true;
			 }
		 }
		 	return false; 
	 }
	 /**
	  * Metodo para verificar el inicis de sesion de un usuario correctamente
	  * @param incomeUsername
	  * @param incomePassword
	  * @return true si es asi, false si no
	  */
	 public boolean verificarInicioDeUsuario(String incomeUsername,String incomePassword) {
		 JSONArray listaUsuario = usuarios.getJSONArray("Usuarios"); 
		 for(int j=0;j<listaUsuario.length();j++) {					
			JSONObject user = listaUsuario.getJSONObject(j);		
			if((user.getString("username").equals(incomeUsername))&&(user.getString("password").equals(incomePassword))) { 
				return true;    
			}
		 }
		 return false; //if not, returns false
	 }
	 /**
	  * Metodo para verificar que esta iniciando sesion un admin
	  * @param incomeUsername
	  * @return
	  */
	 public boolean verificarInicioDeAdmin(String incomeUsername) {
		 if(incomeUsername.equals("admin")) {
			 return true;
		 }else {
			 return false;
		 }
	 }
	 /**
	  * Metodo para agregar Los atributos de usuario al JSON cono un nuevo usario
	  * @param nombre
	  * @param apellido
	  * @param direccion
	  * @param telefono
	  * @param correo
	  * @param username
	  * @param password
	  */
	 public void agregarUsuario(String nombre, String apellido, String direccion, String telefono, String correo, String username, String password) {
		try {
			String jsonString = usuarios.toString();
			
			JSONObject usuarios = getJSONObjectFromFile("/usuarios.json"); 
			JSONArray listaUsuario = usuarios.getJSONArray("Usuarios");     
			JSONObject newObject = new JSONObject();						
			newObject.put("nombre", nombre);
			newObject.put("apellido", apellido);
			newObject.put("direccion", direccion);
			newObject.put("telefono", telefono);
			newObject.put("correo", correo);
			newObject.put("username",username);
			newObject.put("password", password);
																			
			listaUsuario.put(newObject);									
			usuarios.put("Usuarios",listaUsuario);
			
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Victor\\eclipse-workspace\\Iplane\\assets\\usuarios.json"));
			outputStreamWriter.write(usuarios.toString());
			outputStreamWriter.close();
			System.out.println("Se ha añadido un usuario nuevo");
		}catch(JSONException e) {
			e.printStackTrace();
		}catch(Exception e) {
			System.err.println("Error writting json: " + e);
		}
	 }
	 /**
	  * Metodo para eliminar un usario dado un nombre
	  * @param nombre
	  */
	 public void eliminarUsuario(String nombre) {
		 try {
			 JSONArray listaUsuarios = usuarios.getJSONArray("Usuarios");
			 JSONArray listaUsuariosAux = new JSONArray();
			 for(int j=0;j<listaUsuarios.length();j++) {
				 JSONObject usuario = listaUsuarios.getJSONObject(j);
				 if(usuario.getString("nombre").equals(nombre)) {
					 
				 }else {
					 listaUsuariosAux.put(listaUsuarios.getJSONObject(j));
				 }
			 }
			 usuarios.remove("Usuarios");
			 listaUsuarios=listaUsuariosAux;
			 usuarios.put("Usuarios", listaUsuarios);
			 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Victor\\eclipse-workspace\\Iplane\\assets\\usuarios.json"));
			 outputStreamWriter.write(usuarios.toString());
			 outputStreamWriter.close();
			 }catch(JSONException e) {
				 e.printStackTrace();
			 }catch(Exception e) {
				 System.err.println("Error writing json: " + e);
			 }
	 }
	 //===============================================    Personal    =================================================
	 /**
	  * Metodo para verificar la existencia de un empleado
	  * @param nombre
	  * @return true si existe, false si no
	  */
	 public boolean verificarExistenciaDeEmpleado(String nombre) {
		 JSONArray listaPersonal = personal.getJSONArray("Empleados");
		 for(int j=0;j<listaPersonal.length();j++) {
			 JSONObject ciudad = listaPersonal.getJSONObject(j);
			 if(ciudad.getString("nombre").equals(nombre)) {
				 return true;
			 }
		 }
		 return false;
	 } 
	 /**
	  * Metodo para eliminar personal dado un nombre
	  * @param nombre
	  */
	 public void eliminarPersonal(String nombre) {
		 try {
		 JSONArray listaPersonal = personal.getJSONArray("Empleados");
		 JSONArray listaPersonalAux = new JSONArray();
		 for(int j=0;j<listaPersonal.length();j++) {
			 JSONObject empleado = listaPersonal.getJSONObject(j);
			 if(empleado.getString("nombre").equals(nombre)) {
				 
			 }else {
				 listaPersonalAux.put(listaPersonal.getJSONObject(j));
			 }
		 }
		 personal.remove("Empleados");
		 listaPersonal=listaPersonalAux;
		 personal.put("Empleados", listaPersonal);
		 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Victor\\eclipse-workspace\\Iplane\\assets\\personal.json"));
		 outputStreamWriter.write(personal.toString());
		 outputStreamWriter.close();
		 }catch(JSONException e) {
			 e.printStackTrace();
		 }catch(Exception e) {
			 System.err.println("Error writing json: " + e);
		 }
	 }
	 /**
	  * Metodo para agregar el personal dado a los atributos en el JSON
	  * @param nombre
	  * @param apellido
	  * @param cedula
	  * @param sexo
	  * @param telf
	  * @param correo
	  * @param dir
	  * @param cargo
	  */
	 public void agregarPersonal(String nombre, String apellido, String cedula, String sexo, String telf, String correo, String dir, String cargo) {
		 try {
			 String jsonString = personal.toString();
			 JSONObject personal = getJSONObjectFromFile("/personal.json");
			 JSONArray listaPersonal = personal.getJSONArray("Empleados");
			 JSONObject newObject = new JSONObject();
			 newObject.put("nombre", nombre);
			 newObject.put("apellido", apellido);
			 newObject.put("cedula", cedula);
			 newObject.put("sexo", sexo);
			 newObject.put("telefono", telf);
			 newObject.put("correo", correo);
			 newObject.put("direccion", dir);
			 newObject.put("cargo", cargo);
			 
			 listaPersonal.put(newObject);
			 personal.put("Empleados",listaPersonal);
			 
			 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Victor\\eclipse-workspace\\Iplane\\assets\\personal.json"));
			 outputStreamWriter.write(personal.toString());
			 outputStreamWriter.close();
		 }catch(JSONException e) {
			 e.printStackTrace();
		 }catch(Exception e) {
			 System.err.println("Error writing json: " + e);
		 }
	 }
	 /**
	  * Metodo para retornar el apellido de un personal
	  * @param nombre
	  * @return apellido
	  */
	 public String retornarPersonalApellido(String nombre) {
		 this.string1="No existe Apellido";
		 JSONArray listaPersonal = personal.getJSONArray("Empleados");
		 for(int j=0;j<listaPersonal.length();j++) {
			 JSONObject empleado = listaPersonal.getJSONObject(j);
			 if(empleado.getString("nombre").equals(nombre)) {
				 this.string1=empleado.getString("apellido");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para retornar la cedula de una persona
	  * @param nombre
	  * @return la cedula
	  */
	 public String retornarPersonalCedula(String nombre) {
		 this.string1="No existe Cedula";
		 JSONArray listaPersonal = personal.getJSONArray("Empleados");
		 for(int j=0;j<listaPersonal.length();j++) {
			 JSONObject empleado = listaPersonal.getJSONObject(j);
			 if(empleado.getString("nombre").equals(nombre)) {
				 this.string1=empleado.getString("cedula");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para retornar El sexo de una persona
	  * @param nombre
	  * @return String con el sexo
	  */
	 public String retornarPersonalSexo(String nombre) {
		 this.string1="No existe Sexo";
		 JSONArray listaPersonal = personal.getJSONArray("Empleados");
		 for(int j=0;j<listaPersonal.length();j++) {
			 JSONObject empleado = listaPersonal.getJSONObject(j);
			 if(empleado.getString("nombre").equals(nombre)) {
				 this.string1=empleado.getString("sexo");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para retonrar el tlf de un empleado
	  * @param nombre
	  * @return string con el tlf
	  */
	 public String retornarPersonalTelf(String nombre) {
		 this.string1="No existe Telefono";
		 JSONArray listaPersonal = personal.getJSONArray("Empleados");
		 for(int j=0;j<listaPersonal.length();j++) {
			 JSONObject empleado = listaPersonal.getJSONObject(j);
			 if(empleado.getString("nombre").equals(nombre)) {
				 this.string1=empleado.getString("telefono");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para retornar el correo de un empleado
	  * @param nombre
	  * @return el correo
	  */
	 public String retornarPersonalCorreo(String nombre) {
		 this.string1="No existe correo";
		 JSONArray listaPersonal = personal.getJSONArray("Empleados");
		 for(int j=0;j<listaPersonal.length();j++) {
			 JSONObject empleado = listaPersonal.getJSONObject(j);
			 if(empleado.getString("nombre").equals(nombre)) {
				 this.string1=empleado.getString("correo");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para retonrar la direccion de un empleado
	  * @param nombre
	  * @return string con la direccion
	  */
	 public String retornarPersonalDireccion(String nombre) {
		 this.string1="No existe direccion";
		 JSONArray listaPersonal = personal.getJSONArray("Empleados");
		 for(int j=0;j<listaPersonal.length();j++) {
			 JSONObject empleado = listaPersonal.getJSONObject(j);
			 if(empleado.getString("nombre").equals(nombre)) {
				 this.string1=empleado.getString("direccion");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para retornar el cargo de un personal
	  * @param nombre
	  * @return string con el cargo
	  */
	 public String retornarPersonalCargo(String nombre) {
		 this.string1="No existe cargo";
		 JSONArray listaPersonal = personal.getJSONArray("Empleados");
		 for(int j=0;j<listaPersonal.length();j++) {
			 JSONObject empleado = listaPersonal.getJSONObject(j);
			 if(empleado.getString("nombre").equals(nombre)) {
				 this.string1=empleado.getString("cargo");
			 }
		 }
		 return this.string1;
	 }
	 
	 //===============================================    Ciudades    =================================================
	 /**
	  * Metodo para verificar existencia de una ciudad
	  * @param nombre
	  * @return true si existe false si no
	  */
	 public boolean verificarCiudad(String nombre) {
		 JSONArray listaCiudades = ciudades.getJSONArray("Ciudades");
		 for(int j=0;j<listaCiudades.length();j++) {
			 JSONObject ciudad = listaCiudades.getJSONObject(j);
			 if(ciudad.getString("nombre").equals(nombre)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 /**
	  * Metodo para agregar una ciudad al JSON de ciudades
	  * @param nombre
	  */
	 public void agregarCiudad(String nombre) {
		 try {
		 JSONObject ciudades = getJSONObjectFromFile("/ciudades.json");
		 JSONArray listaCiudades = ciudades.getJSONArray("Ciudades");
		 JSONObject newObject = new JSONObject();
		 newObject.put("nombre",nombre);
		 listaCiudades.put(newObject);
		 ciudades.put("Ciudades", listaCiudades);
		 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Victor\\eclipse-workspace\\Iplane\\assets\\ciudades.json"));
		 outputStreamWriter.write(ciudades.toString());
		 outputStreamWriter.close();
		 }catch(JSONException e) {
			 e.printStackTrace();
		 }catch(Exception e) {
			 System.err.print("Error writing json: " + e);
		 }
	 }
	 /**
	  * Metodo para eliminr una ciudad con su nombre
	  * @param nombre
	  */
	 public void eliminarCiudad(String nombre) {
		 try {
		 JSONArray listaCiudades = ciudades.getJSONArray("Ciudades");
		 JSONArray listaCiudadesAux = new JSONArray();
		 for(int j=0;j<listaCiudades.length();j++) {
			 JSONObject ciudad = listaCiudades.getJSONObject(j);
			 if(ciudad.getString("nombre").equals(nombre)) {
				 
			 }else {
				 listaCiudadesAux.put(listaCiudades.getJSONObject(j));
			 }
		 }
		 ciudades.remove("Usuarios");
		 listaCiudades=listaCiudadesAux;
		 ciudades.put("Ciudades", listaCiudades);
		 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Victor\\eclipse-workspace\\Iplane\\assets\\ciudades.json"));
		 outputStreamWriter.write(ciudades.toString());
		 outputStreamWriter.close();
		 }catch(JSONException e) {
			 e.printStackTrace();
		 }catch(Exception e) {
			 System.err.println("Error writing json: " + e);
		 }
	 }
	 //===============================================    Rutas    =============================================
	 public String retornarRutaId(String nombre) {
		 this.string1="No existe ID";
		 JSONArray listaRutas = rutas.getJSONArray("Rutas");
		 for(int j=0;j<listaRutas.length();j++) {
			 JSONObject ruta = listaRutas.getJSONObject(j);
			 if(ruta.getString("nombre").equals(nombre)) {
				 this.string1=ruta.getString("id");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para retornar la ciudad de entrada 
	  * @param nombre
	  * @return ciudad de entrada
	  */
	 public String retornarCiudadEntrada(String nombre) {
		 this.string1="No existe ID";
		 JSONArray listaRutas = rutas.getJSONArray("Rutas");
		 for(int j=0;j<listaRutas.length();j++) {
			 JSONObject ruta = listaRutas.getJSONObject(j);
			 if(ruta.getString("nombre").equals(nombre)) {
				 this.string1=ruta.getString("Ciudad de Entrada");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para retornar la ciudad de salida
	  * @param nombre
	  * @return string con el nombre
	  */
	 public String retornarCiudadSalida(String nombre) {
		 this.string1="No existe ID";
		 JSONArray listaRutas = rutas.getJSONArray("Rutas");
		 for(int j=0;j<listaRutas.length();j++) {
			 JSONObject ruta = listaRutas.getJSONObject(j);
			 if(ruta.getString("nombre").equals(nombre)) {
				 this.string1=ruta.getString("Ciudad de Salida");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para verificar si una ruta existe
	  * @param nombre
	  * @return true si existe, false si no
	  */
	 public boolean verificarRuta(String nombre) {
		 JSONArray listaRutas = rutas.getJSONArray("Rutas");
		 for(int j=0;j<listaRutas.length();j++) {
			 JSONObject ruta = listaRutas.getJSONObject(j);
			 if(ruta.getString("nombre").equals(nombre)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 /**
	  * Metodo para eliminar una ruta dado el nombre
	  * @param oldname
	  */
	 public void eliminarRuta(String oldname) {
		 try {
			 JSONArray listaRutas = rutas.getJSONArray("Rutas");
			 JSONArray listaRutasAux = new JSONArray();
			 for(int j=0;j<listaRutas.length();j++) {
				 JSONObject ruta = listaRutas.getJSONObject(j);
				 if(ruta.getString("nombre").equals(oldname)) {
					 //
				 }else {
					 listaRutasAux.put(listaRutas.get(j));
				 }
			 rutas.remove("Agencias");
			 listaRutas=listaRutasAux;
			 rutas.put("Rutas", listaRutas);
			 
			 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Victor\\eclipse-workspace\\Iplane\\assets\\rutas.json"));
			 outputStreamWriter.write(rutas.toString());
			 outputStreamWriter.close();
			 }
		 }catch(JSONException e) {
			 e.printStackTrace();
		 }catch(Exception e) {
			 System.err.println("Error writing json: " + e);
		 }
	 }
	 /**
	  * Metodo para eliminar una nueva rut con sus atributos
	  * @param nombre
	  * @param id
	  * @param ciudadEntrada
	  * @param ciudadSalida
	  */
	 public void agregarRuta(String nombre, String id, String ciudadEntrada, String ciudadSalida) {
		 try {
			 JSONObject rutas = getJSONObjectFromFile("/rutas.json");
			 JSONArray listaRutas = rutas.getJSONArray("Rutas");
			 JSONObject newObject = new JSONObject();
			 newObject.put("nombre", nombre);
			 newObject.put("id",id);
			 newObject.put("Ciudad de Entrada", ciudadEntrada);
			 newObject.put("Ciudad de Salida", ciudadSalida);
			 listaRutas.put(newObject);
			 rutas.put("Rutas",listaRutas);
			 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Victor\\eclipse-workspace\\Iplane\\assets\\rutas.json"));
			 outputStreamWriter.write(rutas.toString());
			 outputStreamWriter.close();
		 }catch(JSONException e) {
			 e.printStackTrace();
		 }catch(Exception e) {
			 System.err.print("Error writing json: " + e);
		 }
	 }
	 //===============================================     Aerolineas   =================================================
	 /**
	  * Metodo para retornar la direccion de una aerolinea
	  * @param nombre
	  * @return nombre de la direccion
	  */
	 public String retornarAerolineaDir(String nombre) {
		 this.string1="No existe direccion";
		 JSONArray listaAerolineas = aerolineas.getJSONArray("Aerolineas");
		 for(int j=0;j<listaAerolineas.length();j++) {
			 JSONObject aerolinea = listaAerolineas.getJSONObject(j);
			 if(aerolinea.getString("nombre").equals(nombre)) {
				 this.string1=aerolinea.getString("direccion");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para retornar el telf de una aerolinea
	  * @param nombre
	  * @return
	  */
	 public String retornarAerolineaTelf(String nombre) {
		 this.string1="No existe Telf";
		 JSONArray listaAerolineas = aerolineas.getJSONArray("Aerolineas");
		 for(int j=0;j<listaAerolineas.length();j++) {
			 JSONObject aerolinea = listaAerolineas.getJSONObject(j);
			 if(aerolinea.getString("nombre").equals(nombre)) {
				 this.string1=aerolinea.getString("telefono");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para verificar si una aerolinea existe dado un nombre
	  * @param nombre
	  * @return true si existe false si no
	  */
	 public boolean verificarAerolinea(String nombre) {
		 JSONArray listaAerolineas = aerolineas.getJSONArray("Aerolineas");
		 for(int j=0;j<listaAerolineas.length();j++) {
			 JSONObject aerolinea =listaAerolineas.getJSONObject(j);
			 if(aerolinea.getString("nombre").equals(nombre)) {
				 return true;
			 }
		 }
		 return false; 
	 }
	 /**
	  * Metodo para eliminar una aerolinea dado un nombre
	  * @param nombre
	  */
	 public void eliminarAerolinea(String nombre) {
		 try {
			 JSONArray listaAerolineas=aerolineas.getJSONArray("Aerolineas"); 
			 JSONArray listaAerolineasAux = new JSONArray();				
			 for(int j=0;j<listaAerolineas.length();j++) {				
				 JSONObject aerolinea = listaAerolineas.getJSONObject(j);	
				 if(aerolinea.getString("nombre").equals(nombre)) {		
					 
				 }else {
					 listaAerolineasAux.put(listaAerolineas.get(j));
				 }
			 }
			 aerolineas.remove("Aerolineas");
			 listaAerolineas=listaAerolineasAux; 
			 aerolineas.put("Aerolineas",listaAerolineas);
			 //rewrite my .JSON file
			 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Victor\\eclipse-workspace\\Iplane\\assets\\aerolineas.json"));
			 outputStreamWriter.write(aerolineas.toString());
			 outputStreamWriter.close();
		 }catch(JSONException e) {
			 e.printStackTrace();
		 }catch(Exception e) {
			 System.err.println("Error writtin json: " + e);
		 }
	 }
	 /**
	  * Metodo para agregar una aerolinea con sus atributos
	  * @param nombre
	  * @param dir
	  * @param telf
	  */
	 public void agregarAerolinea(String nombre,String dir,String telf) {
		 try {
			 String jsonString = aerolineas.toString();
			 JSONObject aerolineas = getJSONObjectFromFile("/aerolineas.json");
			 JSONArray listaAerolineas = aerolineas.getJSONArray("Aerolineas");
			 JSONObject newObject = new JSONObject();
			 newObject.put("nombre", nombre);
			 newObject.put("direccion", dir);
			 newObject.put("telefono", telf);
			 listaAerolineas.put(newObject);
			 aerolineas.put("Aerolineas",listaAerolineas);	
			 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Victor\\eclipse-workspace\\Iplane\\assets\\aerolineas.json"));
			 outputStreamWriter.write(aerolineas.toString());
			 outputStreamWriter.close();
		 }catch(JSONException e) {
			 e.printStackTrace();
		 }catch(Exception e) {
			 System.err.println("Error writtin json: " + e);
		 }
	 }
	 //===============================================     Agencias    =================================================
	 /**
	  * Metodo para retornar la direccion de una agencia dada
	  * @param nombre
	  * @return string con su direccion
	  */
	 public String retornarAgenciaDir(String nombre) {
		 this.string1="No existe dirección";
		 JSONArray listaAgencias = agencias.getJSONArray("Agencias");
		 for(int j=0;j<listaAgencias.length();j++) {
			 JSONObject agencia = listaAgencias.getJSONObject(j);
			 if(agencia.getString("nombre").equals(nombre)) {
				 this.string1= agencia.getString("agenciaDir");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para retornar el Telf de una agencia
	  * @param nombre
	  * @return el telefono en un string
	  */
	 public String retornarAgenciaTelf(String nombre) {
		 this.string1="No existe Telefono";
		 JSONArray listaAgencias = agencias.getJSONArray("Agencias");
		 for(int j=0;j<listaAgencias.length();j++) {
			 JSONObject agencia = listaAgencias.getJSONObject(j);
			 if(agencia.getString("nombre").equals(nombre)) {
				 this.string1=agencia.getString("telefono");
			 } 
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para retornar el nombre de contacto de una agencia
	  * @param nombre
	  * @return string con el nombre
	  */
	 public String retornarAgenciaContacto(String nombre) {
		 this.string1="No existe Contacto";
		 JSONArray listaAgencias = agencias.getJSONArray("Agencias");
		 for(int j=0;j<listaAgencias.length();j++) {
			 JSONObject agencia = listaAgencias.getJSONObject(j);
			 if(agencia.getString("nombre").equals(nombre)) {
				 this.string1=agencia.getString("nombreContacto");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para retornar el telefono del contacto de una agencia
	  * @param nombre
	  * @return string con el telefono
	  */
	 public String retornarAgenciaTelfContacto(String nombre) {
		 this.string1="No existe telefono del contacto";
		 JSONArray listaAgencias = agencias.getJSONArray("Agencias");
		 for(int j=0;j<listaAgencias.length();j++) {
			 JSONObject agencia = listaAgencias.getJSONObject(j);
			 if(agencia.getString("nombre").equals(nombre)) {
				 this.string1=agencia.getString("telefonoContacto");
			 }
		 }
		 return this.string1;
	 }
	 /**
	  * Metodo para verificar si una agencia existe
	  * @param nombre
	  * @return true si existe false si no
	  */
	 public boolean verificarAgencia(String nombre) {
		 JSONArray listaAgencias = agencias.getJSONArray("Agencias");
		 for(int j=0;j<listaAgencias.length();j++) {
			 JSONObject agencia = listaAgencias.getJSONObject(j);
			 if(agencia.getString("nombre").equals(nombre)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 /**
	  * Metodo para eliminar una agencia dado un nombre
	  * @param nombre
	  */
	 public void eliminarAgencia(String nombre) {
		 try {
		 JSONArray listaAgencias=agencias.getJSONArray("Agencias"); //starts my JSONArray "Agencias"
		 JSONArray listaAgenciasAux = new JSONArray();				//I create i new empy JSONArray
		 for(int j=0;j<listaAgencias.length();j++) {				//start reading my filled JSONArray
			 JSONObject agencia = listaAgencias.getJSONObject(j);	//take the object in the position of my filled jsonarray
			 if(agencia.getString("nombre").equals(nombre)) {		//If my JSONObject "nombre"(name) equals my income string it will not do anything
				 
			 }else {
				 //If my JSONObject "nombre" attribute doesn't equals my income string it'll put the object in my new array
				 listaAgenciasAux.put(listaAgencias.get(j));
			 }
		 }
		 //after the for loop, ill remove in my "agencias" mainJSON the JSONArray "Agencias"
		 agencias.remove("Agencias");
		 listaAgencias=listaAgenciasAux; //My old array get the values of my new array without the selected object
		 agencias.put("Agencias",listaAgencias);//i put in my main JSON the new array without the "deleted" object
		 //rewrite my .JSON file
		 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Victor\\eclipse-workspace\\Iplane\\assets\\agencias.json"));
		 outputStreamWriter.write(agencias.toString());
		 outputStreamWriter.close();
		 
	 }catch(JSONException e) {
		 e.printStackTrace();
	 }catch(Exception e) {
		 System.err.println("Error writtin json: " + e);
	 }
	 }
	 /**
	  * Metodo para cerar una agencia nueva dado a los atributos dados
	  * @param nombre
	  * @param dir
	  * @param telf
	  * @param nombreContacto
	  * @param telfContacto
	  */
	 public void agregarAgencia(String nombre, String dir, String telf, String nombreContacto, String telfContacto) {
		 try {
			 String jsonString = agencias.toString();
			 JSONObject agencias = getJSONObjectFromFile("/agencias.json");
			 JSONArray listaAgencias = agencias.getJSONArray("Agencias");
			 JSONObject newObject = new JSONObject();
			 newObject.put("nombre", nombre);
			 newObject.put("agenciaDir", dir);
			 newObject.put("telefono", telf);
			 newObject.put("nombreContacto", nombreContacto);
			 newObject.put("telefonoContacto", telfContacto);
			 listaAgencias.put(newObject);
			 agencias.put("Agencias",listaAgencias);	
			 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Victor\\eclipse-workspace\\Iplane\\assets\\agencias.json"));
			 outputStreamWriter.write(agencias.toString());
			 outputStreamWriter.close();
		 }catch(JSONException e) {
			 e.printStackTrace();
		 }catch(Exception e) {
			 System.err.println("Error writtin json: " + e);
		 }
	 }
	 //===============================================Llenado de Combobox==============================================
	 /**
	  * Metodo para llenar l comboboxAerolineas
	  * @return Array con los nombres de las aerolineas
	  */
	 public String[] llenarComboboxAerolineas() {
		 JSONArray listaAerolineas = aerolineas.getJSONArray("Aerolineas");
		 String[] array1 = new String[listaAerolineas.length()];
		 for(int j=0;j<listaAerolineas.length();j++) {
			 JSONObject aerolinea = listaAerolineas.getJSONObject(j);
			 this.string1=aerolinea.getString("nombre");
			 array1[j]=aerolinea.getString("nombre");
		 }
		 return array1;
	 }
	 
	 /**
	  * Metodo para llenar el combobox Agencias
	  * @return Array con los nombres de las agencias
	  */
	 public String[] llenarComboboxAgencias() {
											
		 JSONArray listaAgencias = agencias.getJSONArray("Agencias");  
		String[] array1 = new String[listaAgencias.length()]; 
		 for(int j=0;j<listaAgencias.length();j++) {				   
			 JSONObject agencia = listaAgencias.getJSONObject(j);		
			 this.string1=agencia.getString("nombre");                  									
			 array1[j]=agencia.getString("nombre");										 
		} 
		 return array1; 												
	 }
	 /**
	  * Metodo para llenar el combobox ciudades
	  * @return array con los nombres de las ciudades
	  */
	 public String[] llenarComboboxCiudades() {
		 
		 JSONArray listaCiudades = ciudades.getJSONArray("Ciudades");
		 String[] array1 = new String[listaCiudades.length()];
		 for(int j=0;j<listaCiudades.length();j++) {
			 JSONObject ciudad = listaCiudades.getJSONObject(j);
			 this.string1=ciudad.getString("nombre");
			 array1[j]=ciudad.getString("nombre");
		 }
		 return array1; 
	 }
	 /**
	  * Metodo para llenar comboboxRutas
	  * @return String[] con los nombres
	  */
	 public String[] llenarComboboxRutas() {
		 
		 JSONArray listaRutas = rutas.getJSONArray("Rutas");
		 String[] array1 = new String[listaRutas.length()];
		 for(int j=0;j<listaRutas.length();j++) {
			 JSONObject ruta = listaRutas.getJSONObject(j);
			 this.string1=ruta.getString("nombre");
			 array1[j]=ruta.getString("nombre");
		 }
		 return array1;
	 }
	 /**
	  * Metodo para llenar combobox personal
	  * @return String[] con los nombres de estos
	  */
	 public String[] llenarComboboxPersonal() {
		 
		 JSONArray listaPersonal = personal.getJSONArray("Empleados");
		 String[] array1 = new String[listaPersonal.length()];
		 for(int j=0;j<listaPersonal.length();j++) {
			 JSONObject empleado = listaPersonal.getJSONObject(j);
			 this.string1=empleado.getString("nombre");
			 array1[j]=empleado.getString("nombre");
		 }
		 return array1;
	 }
}



