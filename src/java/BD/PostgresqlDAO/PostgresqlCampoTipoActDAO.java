/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.PostgresqlDAO;

import BD.DAO.CampoTipoActDAO;
import BD.PostgresqlDAOFactory;
import infosis.siradex.clases.CampoTipoAct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public class PostgresqlCampoTipoActDAO implements CampoTipoActDAO {

	@Override
	public int insertarCampo(CampoTipoAct nuevoCampo) {
		PreparedStatement stmt = null;
		String queryInsercion = "INSERT INTO campos_tipo_actividad (id_ta, nombre_campo,"
			+ " tipo_campo, obligatorio, longitud, id_catalogo) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();

			stmt = conexion.prepareStatement(queryInsercion);
			stmt.setInt(1, nuevoCampo.getId_ta());
			stmt.setString(2, nuevoCampo.getNombre_campo());
			stmt.setString(3, nuevoCampo.getTipo_campo());
			stmt.setBoolean(4, nuevoCampo.getObligatorio());
			stmt.setInt(5, nuevoCampo.getLongitud());
			stmt.setInt(6, nuevoCampo.getId_catalogo());
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
		return nuevoCampo.getId_cta();
	}

	@Override
	public CampoTipoAct buscarCampo(int id_cta) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean actualizarCampo() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean borrarCampo(int id_cta) {
		PreparedStatement stmt = null;
		String queryEliminacion = "DELETE FROM campos_tipo_actividad WHERE id_cta = ?";

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();

			stmt = conexion.prepareStatement(queryEliminacion);
			stmt.setInt(1, id_cta);
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

	@Override
	public ArrayList<CampoTipoAct> buscarTodos() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public ArrayList<CampoTipoAct> buscarCamposPorTA(int id_ta) {
		PreparedStatement stmt = null;
		String queryBusqueda = "SELECT * FROM campos_tipo_actividad WHERE id_ta = ?";
		ArrayList<CampoTipoAct> campos = new ArrayList<CampoTipoAct>();

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();
			ResultSet rs = null;

			stmt = conexion.prepareStatement(queryBusqueda);
			stmt.setInt(1, id_ta);
			rs = stmt.executeQuery();

			while (rs.next()) {
				// Se encontro el usuario deseado
				campos.add(new CampoTipoAct(rs.getInt("id_cta"), rs.getInt("id_ta"),
					rs.getString("nombre_campo"), rs.getString("tipo_campo"), rs.getBoolean("obligatorio"),
					rs.getInt("longitud"), rs.getInt("id_catalogo")));
			}
		} catch (SQLException sqle) {
			System.out.print("acaaaa");
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

		return campos;
	}
}
