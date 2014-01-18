/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAO;

import infosis.siradex.clases.CampoCatalogo;
import infosis.siradex.clases.Catalogo;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public interface CampoCatalogoDAO {
	public int insertarCampoCatalogo(CampoCatalogo nuevoCampo);

	public CampoCatalogo buscarCampoCatalogo(int id_campo_catalogo);

	public ArrayList<CampoCatalogo> buscarTodos();

	public ArrayList<CampoCatalogo> buscarCamposPorCatalogo(int id_catalogo);

	public boolean actualizarCampoCatalogo();

	public boolean borrarCampoCatalogo(int id_campo_catalogo);
}