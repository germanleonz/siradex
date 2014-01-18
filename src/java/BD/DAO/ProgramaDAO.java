/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAO;

import infosis.siradex.clases.Programa;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public interface ProgramaDAO {
	public int insertarPrograma(Programa nuevoPrograma);

	public boolean borrarPrograma(int id_programa);

	public boolean actualizarPrograma();

	public Programa buscarPrograma(int id_programa);

	public ArrayList<Programa> buscarTodos();

}
