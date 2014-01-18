/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.clases;

/**
 *
 * @author germanleonz
 */
public class Coordinacion {
	private int id_coordinacion; 
	private String nombre_coordinacion;
	private String id_coordinador;

	public Coordinacion(int id_coordinacion, String nombre_coordinacion, String id_coordinador) {
		this.id_coordinacion = id_coordinacion;
		this.nombre_coordinacion = nombre_coordinacion;
		this.id_coordinador = id_coordinador;
	}

	public int getId_coordinacion() {
		return id_coordinacion;
	}

	public void setId_coordinacion(int id_coordinacion) {
		this.id_coordinacion = id_coordinacion;
	}

	public String getNombre_coordinacion() {
		return nombre_coordinacion;
	}

	public void setNombre_coordinacion(String nombre_coordinacion) {
		this.nombre_coordinacion = nombre_coordinacion;
	}

	public String getId_coordinador() {
		return id_coordinador;
	}

	public void setId_coordinador(String id_coordinador) {
		this.id_coordinador = id_coordinador;
	}
}
