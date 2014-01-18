/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.forms;

import BD.DAO.CoordinacionDAO;
import BD.DAOFactory;
import infosis.siradex.clases.Coordinacion;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public class CrearTipoActividadForm extends org.apache.struts.action.ActionForm {

	//	Campos de la tabla tipo_actividad
	private String nombre_ta;
	private String tipopr_ta;
	private String id_validador_ta;
	private String id_programa;
	private int num_campos_ta;
	private String descripcion;
	private String[] realizable_por;

	//	Campos que van en la tabla campos_tipo_actividad
	private String[] nom_campos;
	private String[] tipo_campos;
	private String[] obligatorio;
	private String[] longitud;
	private String[] id_catalogo;

	/**
	 *
	 */
	public CrearTipoActividadForm() {
		super();
		this.num_campos_ta = 1;
	}

	public String getNombre_ta() {
		return nombre_ta;
	}

	public void setNombre_ta(String nombre_ta) {
		this.nombre_ta = nombre_ta;
	}

	public String getTipopr_ta() {
		return tipopr_ta;
	}

	public void setTipopr_ta(String tipopr_ta) {
		this.tipopr_ta = tipopr_ta;
	}

	public String getId_validador_ta() {
		return id_validador_ta;
	}

	public void setId_validador_ta(String id_validador_ta) {
		this.id_validador_ta = id_validador_ta;
	}

	public int getNum_campos_ta() {
		return num_campos_ta;
	}

	public void setNum_campos_ta(int num_campos_ta) {
		this.num_campos_ta = num_campos_ta;
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

	public String[] getLongitud() {
		return longitud;
	}

	public void setLongitud(String[] longitud) {
		this.longitud = longitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String[] getRealizable_por() {
		return realizable_por;
	}

	public void setRealizable_por(String[] realizable_por) {
		this.realizable_por = realizable_por;
	}

	public String[] getId_catalogo() {
		return id_catalogo;
	}

	public void setId_catalogo(String[] id_catalogo) {
		this.id_catalogo = id_catalogo;
	}

	public String[] getObligatorio() {
		return obligatorio;
	}

	public void setObligatorio(String[] obligatorio) {
		this.obligatorio = obligatorio;
	}

	public String getId_programa() {
		return id_programa;
	}

	public void setId_programa(String id_programa) {
		this.id_programa = id_programa;
	}
}