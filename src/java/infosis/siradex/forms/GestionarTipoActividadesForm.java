/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.forms;

import infosis.siradex.clases.TipoActividad;
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
public class GestionarTipoActividadesForm extends org.apache.struts.action.ActionForm {
	
	private int codigo_ta;
	private ArrayList<TipoActividad> tiposActividad;
	private HashMap tipoConsultado;

	public int getCodigo_ta() {
		return codigo_ta;
	}

	public void setCodigo_ta(int codigo_ta) {
		this.codigo_ta = codigo_ta;
	}

	public ArrayList<TipoActividad> getTiposActividad() {
		return tiposActividad;
	}

	public void setTiposActividad(ArrayList<TipoActividad> tiposActividad) {
		this.tiposActividad = tiposActividad;
	}

	public HashMap getTipoConsultado() {
		return tipoConsultado;
	}

	public void setTipoConsultado(HashMap tipoConsultado) {
		this.tipoConsultado = tipoConsultado;
	}

	/**
	 *
	 */
	public GestionarTipoActividadesForm() {
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
		return null;
	}
}
