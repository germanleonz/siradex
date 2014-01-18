/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.clases;

/**
 *
 * @author germanleonz
 */
public class CampoTipoAct {
	int id_cta;
	int id_ta;
	String nombre_campo;
	String tipo_campo;
	boolean obligatorio; 
	int longitud;
	int id_catalogo;

	public CampoTipoAct(int id_cta, int id_ta, String nombre_campo, String tipo_campo, boolean obligatorio, int longitud, int id_catalogo) {
		this.id_cta = id_cta;
		this.id_ta = id_ta;
		this.nombre_campo = nombre_campo;
		this.tipo_campo = tipo_campo;
		this.obligatorio = obligatorio;
		this.longitud = longitud;
		this.id_catalogo = id_catalogo;
	}

	public int getId_cta() {
		return id_cta;
	}

	public void setId_cta(int id_cta) {
		this.id_cta = id_cta;
	}

	public int getId_ta() {
		return id_ta;
	}

	public void setId_ta(int id_ta) {
		this.id_ta = id_ta;
	}

	public String getNombre_campo() {
		return nombre_campo;
	}

	public void setNombre_campo(String nombre_campo) {
		this.nombre_campo = nombre_campo;
	}

	public String getTipo_campo() {
		return tipo_campo;
	}

	public void setTipo_campo(String tipo_campo) {
		this.tipo_campo = tipo_campo;
	}

	public boolean getObligatorio() {
		return obligatorio;
	}

	public void setObligatorio(boolean obligatorio) {
		this.obligatorio = obligatorio;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public int getId_catalogo() {
		return id_catalogo;
	}

	public void setId_catalogo(int id_catalogo) {
		this.id_catalogo = id_catalogo;
	}
}
