/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.clases;

/**
 *
 * @author fx
 */
public class Actividad {

	private int id_act;
	private int id_ta;
	private String usbid;

	public Actividad(int id_act, String usbid) {
		this.id_act = id_act;
		this.usbid = usbid;
	}

	public int getId_act() {
		return id_act;
	}

	public void setId_act(int id_act) {
		this.id_act = id_act;
	}

	public String getUsbid() {
		return usbid;
	}

	public void setUsbid(String usbid) {
		this.usbid = usbid;
	}

	public int getId_ta() {
		return id_ta;
	}

	public void setId_ta(int id_ta) {
		this.id_ta = id_ta;
	}
}
