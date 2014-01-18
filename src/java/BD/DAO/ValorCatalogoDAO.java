/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAO;

import infosis.siradex.clases.ValorCatalogo;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public interface ValorCatalogoDAO {
	public int insertarValor(ValorCatalogo nuevoValor);
	
	public boolean borrarValor(int id_valor);
	
	public boolean actualizarValor();
	
	public ValorCatalogo buscarValor(int id_valor);
	
	public ArrayList<ValorCatalogo> buscarTodos();

	public ArrayList<ValorCatalogo> buscarValoresParaCampo(String nombre_catalogo, String nombre_campo);

}
