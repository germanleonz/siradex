/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.clases;

/**
 *
 * @author germanleonz
 */
public class ValorCatalogo {
	private int id_valor;
	private int id_catalogo;
	private int id_campo_catalogo;
	private String value;
	private int id_elemento;

	public ValorCatalogo(int id_valor, int id_catalogo, int id_campo_catalogo, String value, int id_elemento) {
		this.id_valor = id_valor;
		this.id_catalogo = id_catalogo;
		this.id_campo_catalogo = id_campo_catalogo;
		this.value = value;
		this.id_elemento = id_elemento;
	}

	public int getId_valor() {
		return id_valor;
	}

	public void setId_valor(int id_valor) {
		this.id_valor = id_valor;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getId_elemento() {
		return id_elemento;
	}

	public void setId_elemento(int id_elemento) {
		this.id_elemento = id_elemento;
	}

	
}
