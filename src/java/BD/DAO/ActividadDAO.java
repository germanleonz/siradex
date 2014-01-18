/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAO;

import infosis.siradex.clases.Actividad;
import java.util.ArrayList;

/**
 *
 * @author fx
 */
public interface ActividadDAO {
    
    public int insertarActividad(String usbid, int id_ta);
    
    public boolean borrarActividad(int id_act);
    
    public ArrayList<Actividad> buscarTodos();
    
    public ArrayList<Actividad> buscarPorUSBID(String usbid);
    
    
}
