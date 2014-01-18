/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAO;

import infosis.siradex.clases.Elemento;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public interface ElementoDAO {
	 
    public int insertarElemento(int id_catalogo);
    
    public boolean borrarElemento(int id_act);
    
    public ArrayList<Elemento> buscarTodos();
    
    public ArrayList<Elemento> buscarPorCatalogo(int id_catalogo);
    
 
}
