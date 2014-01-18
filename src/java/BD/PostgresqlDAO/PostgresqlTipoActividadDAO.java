/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.PostgresqlDAO;

import BD.DAO.TipoActividadDAO;
import BD.PostgresqlDAOFactory;
import infosis.siradex.clases.TipoActividad;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public class PostgresqlTipoActividadDAO implements TipoActividadDAO {

	public PostgresqlTipoActividadDAO() {
		//	Inicializacion
	}

	@Override
	public int insertarTipoActividad(TipoActividad nuevoTA) {
		PreparedStatement stmt = null;
		String queryInsercion = "INSERT INTO tipo_actividad (nombre_tipo_act, num_campos,"
			+ " tipo_pr, id_validador, id_programa, descripcion, realizable_por) VALUES (?, ?, ?, ?, ?, ?, ?)";

		ResultSet generatedKeys;
		Integer id_tipo_act = null;
		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();

			stmt = conexion.prepareStatement(queryInsercion, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nuevoTA.getNombre_tipo_act());
                        stmt.setInt(2, nuevoTA.getNum_campos());
			stmt.setString(3, nuevoTA.getTipo_pr());
			stmt.setString(4, nuevoTA.getId_validador());
			stmt.setString(5, nuevoTA.getId_programa());
			stmt.setString(6, nuevoTA.getDescripcion());
			stmt.setArray(7, conexion.createArrayOf("varchar", nuevoTA.getRealizable_por()));
			stmt.executeUpdate();

			generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				id_tipo_act = generatedKeys.getInt(1);
			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (SQLException sqle2) {
				System.out.println(sqle2.getMessage());
			}
		}
//		return String.valueOf(id_tipo_act.longValue());
		return id_tipo_act;
	}

	@Override
	public boolean borrarTipoActividad(int codigoTA) {
		PreparedStatement stmt = null;
		String queryEliminacion = "DELETE FROM tipo_actividad WHERE id_tipo_act = ?";

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();

			stmt = conexion.prepareStatement(queryEliminacion);
			stmt.setInt(1, codigoTA);
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

	public boolean actualizarTipoActividad() {
		return true;
	}

	public TipoActividad buscarTipoActividad(int codigoTA) {
		PreparedStatement stmt = null;
		String queryBusqueda = "SELECT * FROM tipo_actividad WHERE id_tipo_act = ?";
		TipoActividad tipoAct = null;

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();
			ResultSet rs = null;

			stmt = conexion.prepareStatement(queryBusqueda);
			stmt.setInt(1, codigoTA);
			rs = stmt.executeQuery();

			if (rs.next()) {
				// Se encontro el tipo de actividad deseada
				tipoAct = new TipoActividad(rs.getInt("id_tipo_act"), rs.getString("nombre_tipo_act"),
					rs.getInt("num_campos"), rs.getString("tipo_pr"), rs.getString("id_validador"),
					rs.getString("id_programa"), rs.getString("descripcion"), (String[]) rs.getArray("realizable_por").getArray());
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

		return tipoAct;
	}

	public ArrayList<TipoActividad> buscarTodos() {
		PreparedStatement stmt = null;
		String queryBusqueda = "SELECT * FROM tipo_actividad";
		ArrayList<TipoActividad> tiposActividad = new ArrayList<TipoActividad>(20);

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();
			ResultSet rs = null;

			stmt = conexion.prepareStatement(queryBusqueda);
			rs = stmt.executeQuery();

			while (rs.next()) {
				// Se encontro el usuario deseado
				tiposActividad.add(new TipoActividad(rs.getInt("id_tipo_act"), rs.getString("nombre_tipo_act"),
					rs.getInt("num_campos"), rs.getString("tipo_pr"), rs.getString("id_validador"),
					rs.getString("id_programa"),rs.getString("descripcion"), (String[]) rs.getArray("realizable_por").getArray()));
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

		return tiposActividad;
	}
}
