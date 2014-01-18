/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.forms;

import infosis.siradex.clases.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author germanleonz
 */
public class GestionarUsuariosForm extends org.apache.struts.action.ActionForm {
	
	private ArrayList<Usuario> usuarios;
	private HashMap usuario_consultado;
	private String usbid;

	public String getUsbid() {
		return usbid;
	}

	public void setUsbid(String usbid) {
		this.usbid = usbid;
	}

	public HashMap getUsuario_consultado() {
		return usuario_consultado;
	}

	public void setUsuario_consultado(HashMap usuario_consultado) {
		this.usuario_consultado = usuario_consultado;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 *
	 */
	public GestionarUsuariosForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.usbid = null;
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
		return errors;
	}
}
