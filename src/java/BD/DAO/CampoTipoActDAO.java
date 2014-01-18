/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAO;

import infosis.siradex.clases.CampoTipoAct;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public interface CampoTipoActDAO {
	public int insertarCampo(CampoTipoAct nuevoCampo);

	public CampoTipoAct buscarCampo(int id_cta);

	public ArrayList<CampoTipoAct> buscarTodos();

	public ArrayList<CampoTipoAct> buscarCamposPorTA(int id_ta);

	public boolean actualizarCampo();

	public boolean borrarCampo(int id_cta);
}
