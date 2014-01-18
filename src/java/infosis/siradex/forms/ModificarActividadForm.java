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
public class ModificarActividadForm extends org.apache.struts.action.ActionForm {
    
    private String[] value;
    private String[] id_valor;
    private String[] tipo_campo;
    private FormFile file;
    
    /**
     *
     */
    public ModificarActividadForm() {
        super();
        this.file = null;
        // TODO Auto-generated constructor stub
    }

    public String[] getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }

    public FormFile getFile() {
        return file;
    }

    public void setFile(FormFile file) {
        this.file = file;
    }

    public String[] getId_valor() {
        return id_valor;
    }

    public void setId_valor(String[] id_valor) {
        this.id_valor = id_valor;
    }

    public String[] getTipo_campo() {
        return tipo_campo;
    }

    public void setTipo_campo(String[] tipo_campo) {
        this.tipo_campo = tipo_campo;
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
            // TODO: add 'error.name.required' key to your resources
        
        return errors;
    }
}
