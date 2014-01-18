/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.clases;

/**
 *
 * @author germanleonz
 */
public class CampoCatalogo {
	private int id_campo_catalogo;
	private int id_catalogo;
	String nombre_campo;
	String tipo_campo;

	public CampoCatalogo(int id_campo_catalogo, int id_catalogo, String nombre_campo, String tipo_campo) {
		this.id_campo_catalogo = id_campo_catalogo;
		this.id_catalogo = id_catalogo;
		this.nombre_campo = nombre_campo;
		this.tipo_campo = tipo_campo;
	}

	public int getId_campo_catalogo() {
		return id_campo_catalogo;
	}

	public void setId_campo_catalogo(int id_campo_catalogo) {
		this.id_campo_catalogo = id_campo_catalogo;
	}

	public int getId_catalogo() {
		return id_catalogo;
	}

	public void setId_catalogo(int id_catalogo) {
		this.id_catalogo = id_catalogo;
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
}
