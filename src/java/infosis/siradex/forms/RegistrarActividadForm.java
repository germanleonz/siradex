/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;


/**
 *
 * @author fx
 */
public class RegistrarActividadForm extends org.apache.struts.action.ActionForm {

	private String tipo;
	private String[] valor;
	private String[] id_cta;
    private String id_cta_file;
	private FormFile file;
    private String id_ta;

	/**
	 *
	 */
	public RegistrarActividadForm() {
		super();
		this.valor = null;
        file = null;
		// TODO Auto-generated constructor stub
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String[] getValor() {
		return valor;
	}

	public void setValor(String[] valor) {
		this.valor = valor;
	}

	public String[] getId_cta() {
		return id_cta;
	}

	public void setId_cta(String[] id_cta) {
		this.id_cta = id_cta;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

    public String getId_cta_file() {
        return id_cta_file;
    }

    public void setId_cta_file(String id_cta_file) {
        this.id_cta_file = id_cta_file;
    }

    public String getId_ta() {
        return id_ta;
    }

    public void setId_ta(String id_ta) {
        this.id_ta = id_ta;
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
		if (getTipo() == null || getTipo().length() < 1) {
			errors.add("name", new ActionMessage("error.name.required"));
			// TODO: add 'error.name.required' key to your resources
		}
		return errors;
	}
}
