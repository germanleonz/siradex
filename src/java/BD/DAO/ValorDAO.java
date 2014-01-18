/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAO;

import infosis.siradex.clases.Valor;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public interface ValorDAO {
	public int insertarValor(Valor nuevoValor);
	
	public boolean borrarValor(int id_valor);
	
	public boolean actualizarValor(Valor nuevoValor);
	
	public Valor buscarValor(int id_valor);
	
	public ArrayList<Valor> buscarTodos();
}
