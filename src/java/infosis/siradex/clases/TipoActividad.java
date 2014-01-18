/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.clases;

/**
 *
 * @author germanleonz
 */
public class TipoActividad {

	private int id_tipo_act;
	private String nombre_tipo_act;
	private int num_campos;
	private String tipo_pr;
	private String id_validador;
	private String id_programa;
	private String descripcion;
	private String[] realizable_por;

	public TipoActividad(int id_tipo_act, String nombre_tipo_act, int num_campos, String tipo_pr, String id_validador, String id_programa, String descripcion, String[] realizable_por) {
		this.id_tipo_act = id_tipo_act;
		this.nombre_tipo_act = nombre_tipo_act;
		this.num_campos = num_campos;
		this.tipo_pr = tipo_pr;
		this.id_validador = id_validador;
		this.id_programa = id_programa;
		this.descripcion = descripcion;
		this.realizable_por = realizable_por;
	}

	public int getId_tipo_act() {
		return id_tipo_act;
	}

	public void setId_tipo_act(int id_tipo_act) {
		this.id_tipo_act = id_tipo_act;
	}

	public String getNombre_tipo_act() {
		return nombre_tipo_act;
	}

	public void setNombre_tipo_act(String nombre_tipo_act) {
		this.nombre_tipo_act = nombre_tipo_act;
	}

	public int getNum_campos() {
		return num_campos;
	}

	public void setNum_campos(int num_campos) {
		this.num_campos = num_campos;
	}

	public String getTipo_pr() {
		return tipo_pr;
	}

	public void setTipo_pr(String tipo_pr) {
		this.tipo_pr = tipo_pr;
	}

	public String getId_validador() {
		return id_validador;
	}

	public void setId_validador(String id_validador) {
		this.id_validador = id_validador;
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

	public String getId_programa() {
		return id_programa;
	}

	public void setId_programa(String id_programa) {
		this.id_programa = id_programa;
	}
}
