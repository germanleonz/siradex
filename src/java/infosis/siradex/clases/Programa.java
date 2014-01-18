/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.clases;

/**
 *
 * @author germanleonz
 */
public class Programa {
	private int id_programa;
	private String nombre_programa;

	public Programa(int id_programa, String nombre_programa) {
		this.id_programa = id_programa;
		this.nombre_programa = nombre_programa;
	}

	public int getId_programa() {
		return id_programa;
	}

	public void setId_programa(int id_programa) {
		this.id_programa = id_programa;
	}

	public String getNombre_programa() {
		return nombre_programa;
	}

	public void setNombre_programa(String nombre_programa) {
		this.nombre_programa = nombre_programa;
	}
}
