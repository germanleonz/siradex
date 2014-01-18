/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author germanleonz
 */
public class CrearUsuarioForm extends ValidatorForm {

	private String usbid;
	private String contrasena;
	private String nombre;
	private String apellido;
	private String email;
	private String rol;

	public CrearUsuarioForm() {
		super();
	}

	public String getUsbid() {
		return usbid;
	}

	public void setUsbid(String usbid) {
		this.usbid = usbid;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

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

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
	}

	/**
	 * This is the action called from the Struts framework.
	 *
	 * @param mapping The ActionMapping used to select this instance.
	 * @param request The HTTP Request we are processing.
	 * @return
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (getUsbid() == null || getUsbid().length() < 1) {
			errors.add("usbid", new ActionMessage("error.usbid.required"));
			// TODO: add 'error.name.required' key to your resources
		}
		if (getContrasena() == null || getContrasena().length() < 1) {
			errors.add("contrasena", new ActionMessage("error.contrasena.required"));
			// TODO: add 'error.name.required' key to your resources
		}
		if (getNombre() == null || getNombre().length() < 1) {
			errors.add("nombre", new ActionMessage("error.nombre.required"));
			// TODO: add 'error.name.required' key to your resources
		}
		if (getApellido() == null || getApellido().length() < 1) {
			errors.add("apellido", new ActionMessage("error.apellido.required"));
			// TODO: add 'error.name.required' key to your resources
		}
		if (getEmail() == null || getEmail().length() < 1) {
			errors.add("email", new ActionMessage("error.email.required"));
			// TODO: add 'error.name.required' key to your resources
		} else if (getEmail().indexOf("@") == -1) {
			errors.add("email", new ActionMessage("error.email.incorrecto"));
		}
		if (getRol() == null || getRol().length() < 1) {
			errors.add("rol", new ActionMessage("error.rol.required"));
			// TODO: add 'error.name.required' key to your resources
		}

		return errors;
	}
}
