/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.PostgresqlDAO;

import BD.DAO.CoordinacionDAO;
import BD.PostgresqlDAOFactory;
import infosis.siradex.clases.Coordinacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public class PostgresqlCoordinacionDAO implements CoordinacionDAO {

	@Override
	public int insertarCoordinacion(Coordinacion nuevaCoordinacion) {
		PreparedStatement stmt = null;
		String queryInsercion = "INSERT INTO coordinacion (nombre_coordinacion, id_coordinador) VALUES (?, ?)";

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();

			stmt = conexion.prepareStatement(queryInsercion);
			stmt.setString(1, nuevaCoordinacion.getNombre_coordinacion());
			stmt.setString(2, nuevaCoordinacion.getId_coordinador());
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
		return nuevaCoordinacion.getId_coordinacion();
	}

	@Override
	public ArrayList<Coordinacion> buscarTodos() {
		PreparedStatement stmt = null;
		String queryBusqueda = "SELECT * FROM coordinacion";
		ArrayList<Coordinacion> coordinaciones = new ArrayList<Coordinacion>(10);

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();
			ResultSet rs = null;

			stmt = conexion.prepareStatement(queryBusqueda);
			rs = stmt.executeQuery();

			while (rs.next()) {
				// Se encontro el usuario deseado
				coordinaciones.add(new Coordinacion(rs.getInt("id_coordinacion"), rs.getString("nombre_coordinacion"),
					rs.getString("id_coordinador")));
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

		return coordinaciones;
	}

	@Override
	public Coordinacion buscarCoordinacion(int id_coordinacion) {
		PreparedStatement stmt = null;
		String queryBusqueda = "SELECT * FROM coordinacion WHERE id_coordinacion = ?";
		Coordinacion coordinacion = null;

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();
			ResultSet rs = null;

			stmt = conexion.prepareStatement(queryBusqueda);
			stmt.setInt(1, id_coordinacion);
			rs = stmt.executeQuery();

			if (rs.next()) {
				// Se encontro el tipo de actividad deseada
				coordinacion = new Coordinacion(rs.getInt("id_coordinacion"), rs.getString("nombre_coordinacion"),
					rs.getString("id_coordinador"));
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

		return coordinacion;
	}

	@Override
	public boolean actualizarCoordinacion() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean borrarCoordinacion(int id_coordinacion) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
