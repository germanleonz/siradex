/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.clases;

/**
 *
 * @author germanleonz
 */
public class Usuario {
	private String usbid;
	private String contrasena;
	private String nombre;
	private String apellido;
	private String email;
	private String rol;

	public Usuario(String usbid, String contrasena, String nombre, String apellido, String email, String rol) {
		this.usbid = usbid;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.rol = rol;
	}

	public String getUsbid() {
		return usbid;
	}

	public void setUsbid(String usbid) {
		this.usbid = usbid;
	}

	/**
	 *
	 * @return
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 *
	 * @param contrasena
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 *
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 *
	 * @param nombreCompleto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
