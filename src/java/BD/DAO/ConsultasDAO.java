/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAO;

import infosis.siradex.clases.ConsultaAct;
import java.util.ArrayList;

/**
 *
 * @author fx
 */
public interface ConsultasDAO {
    public ArrayList<ConsultaAct> buscarTodas();
    
    public ArrayList<ConsultaAct> buscarActDetalle(int id_act);
}
