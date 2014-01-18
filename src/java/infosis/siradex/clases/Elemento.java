/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.clases;

/**
 *
 * @author germanleonz
 */
public class Elemento {
private int id_elemento;
private int id_catalogo;

	public Elemento(int id_elemento, int id_catalogo) {
		this.id_elemento = id_elemento;
		this.id_catalogo = id_catalogo;
	}

	public int getId_catalogo() {
		return id_catalogo;
	}

	public void setId_catalogo(int id_catalogo) {
		this.id_catalogo = id_catalogo;
	}

	public int getId_elemento() {
		return id_elemento;
	}

	public void setId_elemento(int id_elemento) {
		this.id_elemento = id_elemento;
	}

 
}
