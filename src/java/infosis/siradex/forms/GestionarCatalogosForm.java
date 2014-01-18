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
public class GestionarCatalogosForm extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 7403728678369985647L;
	private int catalogo_sel;

	public int getCatalogo_sel() {
		return catalogo_sel;
	}

	public void setCatalogo_sel(int catalogo_sel) {
		this.catalogo_sel = catalogo_sel;
	}

	/**
	 *
	 */
	public GestionarCatalogosForm() {
		super();
		// TODO Auto-generated constructor stub
	}
}
