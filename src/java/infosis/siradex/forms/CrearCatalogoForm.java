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
public class CrearCatalogoForm extends org.apache.struts.action.ActionForm {
	
	//	Atributos que van en la tabla de catalogo
	private String nombre_catalogo;
	private int num_campos_catalogo;

	//	Campos que van en la table campos de catalogo
	private String[] nom_campos;
	private String[] tipo_campos;

	public CrearCatalogoForm() {
		super();
	}

	public String getNombre_catalogo() {
		return nombre_catalogo;
	}

	public void setNombre_catalogo(String nombre_catalogo) {
		this.nombre_catalogo = nombre_catalogo;
	}

	public String[] getNom_campos() {
		return nom_campos;
	}

	public void setNom_campos(String[] nom_campos) {
		this.nom_campos = nom_campos;
	}

	public String[] getTipo_campos() {
		return tipo_campos;
	}

	public void setTipo_campos(String[] tipo_campos) {
		this.tipo_campos = tipo_campos;
	}

	public int getNum_campos_catalogo() {
		return num_campos_catalogo;
	}

	public void setNum_campos_catalogo(int num_campos_catalogo) {
		this.num_campos_catalogo = num_campos_catalogo;
	}
}
