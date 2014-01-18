/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAO;

import infosis.siradex.clases.TipoActividad;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public interface TipoActividadDAO {
	public int insertarTipoActividad(TipoActividad nuevoTA);

	public boolean borrarTipoActividad(int codigoTA);

	public boolean actualizarTipoActividad();

	public TipoActividad buscarTipoActividad(int codigoTA);

	public ArrayList<TipoActividad> buscarTodos();
}
