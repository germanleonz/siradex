/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author germanleonz
 */
public class EliminarTipoActividadForm extends org.apache.struts.action.ActionForm {
	
	private String name;
	private int codigo_ta;

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	public int getCodigo_ta() {
		return codigo_ta;
	}

	public void setCodigo_ta(int codigo_ta) {
		this.codigo_ta = codigo_ta;
	}

	/**
	 *
	 */
	public EliminarTipoActividadForm() {
		super();
		// TODO Auto-generated constructor stub
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
		if (getName() == null || getName().length() < 1) {
			errors.add("name", new ActionMessage("error.name.required"));
			// TODO: add 'error.name.required' key to your resources
		}
		return errors;
	}
}
