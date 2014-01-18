/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAO;

import infosis.siradex.clases.Coordinacion;
import infosis.siradex.clases.TipoActividad;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public interface CoordinacionDAO {
	public int insertarCoordinacion(Coordinacion nuevaCoordinacion);

	public boolean borrarCoordinacion(int id_coordinacion);

	public boolean actualizarCoordinacion();

	public Coordinacion buscarCoordinacion(int id_coordinacion);

	public ArrayList<Coordinacion> buscarTodos();
}
