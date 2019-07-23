package data;

public class Usuario {
	String nombre;
	String apellido;
	String direccion;
	String telefono;
	String correo;
	String username;
	String clave;
	
	public void setUsuarioDatos(String nombre, String apellido, String direccion, String telefono, String correo, String username, String clave) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.direccion=direccion;
		this.telefono=telefono;
		this.correo=correo;
		this.username=username;
		this.clave=clave;	
	}
	
	public String getNombreUsuario() {
		return this.nombre;
	}
	public String getApellidoUsuario() {
		return this.apellido;
	}
	public String getDireccionUsuario() {
		return this.direccion;
	}
	public String getTelefonoUsuario() {
		return this.telefono;
	}
	public String getCorreoUsuario() {
		return this.correo;
	}
	public String getUsernameUsuario() {
		return this.username;
	}
	public String getClaveUsuario() {
		return this.clave;
	}
}
