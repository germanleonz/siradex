/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.clases;

/**
 *
 * @author germanleonz
 */
public class Valor {
	int id_valor;
	int id_cta;
	int id_act;
	String value;

	public Valor(int id_valor, int id_cta, int id_act, String value) {
		this.id_valor = id_valor;
		this.id_cta = id_cta;
		this.id_act = id_act;
		this.value = value;
	}

	public int getId_valor() {
		return id_valor;
	}

	public void setId_valor(int id_valor) {
		this.id_valor = id_valor;
	}

	public int getId_cta() {
		return id_cta;
	}

	public void setId_cta(int id_cta) {
		this.id_cta = id_cta;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getId_act() {
		return id_act;
	}

	public void setId_act(int id_act) {
		this.id_act = id_act;
	}
}
