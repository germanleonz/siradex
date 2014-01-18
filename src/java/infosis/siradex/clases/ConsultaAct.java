/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex.clases;

/**
 *
 * @author fx
 */
public class ConsultaAct {
    private String nombre;
    private String apellido;
    private String nombre_campo;
    private String tipo_campo;
    private String value;
    private int id_valor;
    private int id_act;

    public ConsultaAct(String nombre, String apellido, String nombre_campo, String tipo_campo, int id_valor, String value, int id_act) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombre_campo = nombre_campo;
        this.tipo_campo = tipo_campo;
        this.id_valor = id_valor;
        this.value = value;
        this.id_act = id_act;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre_campo() {
        return nombre_campo;
    }

    public void setNombre_campo(String nombre_campo) {
        this.nombre_campo = nombre_campo;
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

    public int getId_valor() {
        return id_valor;
    }

    public void setId_valor(int id_valor) {
        this.id_valor = id_valor;
    }

    public String getTipo_campo() {
        return tipo_campo;
    }

    public void setTipo_campo(String tipo_campo) {
        this.tipo_campo = tipo_campo;
    }
        
}
