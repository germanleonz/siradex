/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.PostgresqlDAO;

import BD.DAO.ProgramaDAO;
import BD.PostgresqlDAOFactory;
import infosis.siradex.clases.Catalogo;
import infosis.siradex.clases.Programa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public class PostgresqlProgramaDAO implements ProgramaDAO {
	
	public PostgresqlProgramaDAO() {
		//	Inicializacion
	}

	@Override
	public int insertarPrograma(Programa nuevoPrograma) {
		PreparedStatement stmt = null;
		String queryInsercion = "INSERT INTO programa (nombre_programa) VALUES (?)";

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();

			stmt = conexion.prepareStatement(queryInsercion);
			stmt.setString(1, nuevoPrograma.getNombre_programa());
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
		return nuevoPrograma.getId_programa();
	}

	@Override
	public Programa buscarPrograma(int id_programa) {
		PreparedStatement stmt = null;
		String queryBusqueda = "SELECT * FROM programa WHERE id_programa = ?";
		Programa programa = null;

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();
			ResultSet rs = null;

			stmt = conexion.prepareStatement(queryBusqueda);
			stmt.setInt(1, id_programa);
			rs = stmt.executeQuery();

			if (rs.next()) {
				// Se encontro el tipo de actividad deseada
				programa = new Programa(rs.getInt("id_programa"), rs.getString("nombre_programa"));
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

		return programa;
	}

	@Override
	public ArrayList<Programa> buscarTodos() {
		PreparedStatement stmt = null;
		String queryBusqueda = "SELECT * FROM programa";
		ArrayList<Programa> programas = new ArrayList<Programa>();

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();
			ResultSet rs = null;

			stmt = conexion.prepareStatement(queryBusqueda);
			rs = stmt.executeQuery();

			while (rs.next()) {
				// Se encontro el usuario deseado
				programas.add(new Programa(rs.getInt("id_programa"), rs.getString("nombre_programa")));
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

		return programas;
	}

	@Override
	public boolean actualizarPrograma() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean borrarPrograma(int id_programa) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
