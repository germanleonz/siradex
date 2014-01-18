/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAO;

import infosis.siradex.clases.Usuario;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public interface UsuarioDAO {
	/**
	 *
	 * @param nuevoUsuario
	 * @return
	 */
	public String insertarUsuario(Usuario nuevoUsuario);

	/**
	 *
	 * @param nombre
	 * @return
	 */
	public boolean borrarUsuario(String usbid);

	/**
	 *
	 * @return
	 */
	public boolean actualizarUsuario(String nombreUsuario, String nombre, String apellido, String email, String rol);

	/**
	 *
	 * @param nombreUsuario
	 * @return
	 */
	public Usuario buscarUsuario(String usbid);

	/**
	 *
	 * @return
	 */
	public ArrayList<Usuario> buscarTodos();
}
