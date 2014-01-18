/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.PostgresqlDAO;

import BD.DAO.UsuarioDAO;
import BD.PostgresqlDAOFactory;
import infosis.siradex.clases.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public class PostgresqlUsuarioDAO implements UsuarioDAO {

	/**
	 *
	 */
	public PostgresqlUsuarioDAO() {
		// Inicializacion
	}

	/**
	 *
	 * @param nuevoUsuario
	 * @return
	 */
	@Override
	public String insertarUsuario(Usuario nuevoUsuario) {
		PreparedStatement stmt = null;
		String queryInsercion = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?)";

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();

			stmt = conexion.prepareStatement(queryInsercion);
			stmt.setString(1, nuevoUsuario.getUsbid());
			stmt.setString(2, nuevoUsuario.getContrasena());
			stmt.setString(3, nuevoUsuario.getNombre());
			stmt.setString(4, nuevoUsuario.getApellido());
			stmt.setString(5, nuevoUsuario.getEmail());
			stmt.setString(6, nuevoUsuario.getRol());
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (SQLException sqle2) {
				System.out.println(sqle2.getMessage());
			}
		}
		return nuevoUsuario.getUsbid();
	}

	/**
	 *
	 * @param nombreUsuario
	 * @return
	 */
	@Override
	public Usuario buscarUsuario(String usbid) {
		PreparedStatement stmt = null;
		String queryBusqueda = "SELECT * FROM usuario WHERE usbid = ?";
		Usuario usuario = null;

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();
			ResultSet rs = null;

			stmt = conexion.prepareStatement(queryBusqueda);
			stmt.setString(1, usbid);
			rs = stmt.executeQuery();

			if (rs.next()) {
				// Se encontro el usuario deseado
				usuario = new Usuario(rs.getString("usbid"), rs.getString("contrasena"),
					rs.getString("nombre"), rs.getString("apellido"),
					rs.getString("email"), rs.getString("rol"));
			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqle2) {
					System.out.println(sqle2.getMessage());
				}
			}
		}

		return usuario;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public boolean actualizarUsuario(String nombreUsuario, String nombre, String apellido, String email, String rol) {
		PreparedStatement stmt = null;
		String queryActualizacion = "UPDATE usuario SET usbid = ?,"
			+ " nombre = ?, apellido = ?, email = ?, rol = ? WHERE usbid = ?";
		boolean actualizado = false;

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();
			ResultSet rs = null;

			stmt = conexion.prepareStatement(queryActualizacion);
			stmt.setString(1, nombreUsuario);
			stmt.setString(2, nombre);
			stmt.setString(3, apellido);
			stmt.setString(4, email);
			stmt.setString(5, rol);
			stmt.setString(6, nombreUsuario);
			rs = stmt.executeQuery();

			actualizado = true;
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqle2) {
					System.out.println(sqle2.getMessage());
				}
			}
		}

		return actualizado;
	}

	/**
	 *
	 * @param nombre
	 * @return
	 */
	@Override
	public boolean borrarUsuario(String usbid) {
		PreparedStatement stmt = null;
		String queryEliminacion = "DELETE FROM usuario WHERE usbid = ?";

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();

			stmt = conexion.prepareStatement(queryEliminacion);
			stmt.setString(1, usbid);
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
			return false;
		} finally {
			try {
				stmt.close();
			} catch (SQLException sqle2) {
				System.out.println(sqle2.getMessage());
				return false;
			}
		}
		return true;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public ArrayList<Usuario> buscarTodos() {
		PreparedStatement stmt = null;
		String queryBusqueda = "SELECT * FROM usuario";
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>(20);

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();
			ResultSet rs = null;

			System.out.println("Buscando todos");

			stmt = conexion.prepareStatement(queryBusqueda);
			rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println("Agregando a:" + rs.getString("usbid"));
				usuarios.add(new Usuario(rs.getString("usbid"), rs.getString("contrasena"),
					rs.getString("nombre"), rs.getString("apellido"),
					rs.getString("email"), rs.getString("rol")));

			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqle2) {
					System.out.println(sqle2.getMessage());
				}
			}
		}

		return usuarios;
	}
}
