/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAO;

import infosis.siradex.clases.Catalogo;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public interface CatalogoDAO {
	public int insertarCatalogo(Catalogo nuevoCatalogo);

	public boolean borrarCatalogo(int id_catalogo);

	public Catalogo buscarCatalogo(int id_catalogo);

	public boolean actualizarCatalogo();

	public ArrayList<Catalogo> buscarTodos();
}
