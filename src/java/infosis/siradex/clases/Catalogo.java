/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.clases;

/**
 *
 * @author germanleonz
 */
public class Catalogo {
	private int id_catalogo;
	private String nombre_catalogo;
	private int num_campos;

	public Catalogo(int id_catalogo, String nombre_catalogo, int num_campos) {
		this.id_catalogo = id_catalogo;
		this.nombre_catalogo = nombre_catalogo;
		this.num_campos = num_campos;
	}

	public int getId_catalogo() {
		return id_catalogo;
	}

	public void setId_catalogo(int id_catalogo) {
		this.id_catalogo = id_catalogo;
	}

	public String getNombre_catalogo() {
		return nombre_catalogo;
	}

	public void setNombre_catalogo(String nombre_catalogo) {
		this.nombre_catalogo = nombre_catalogo;
	}

	public int getNum_campos() {
		return num_campos;
	}

	public void setNum_campos(int num_campos) {
		this.num_campos = num_campos;
	}
}
