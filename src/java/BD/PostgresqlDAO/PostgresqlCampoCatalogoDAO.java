/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.PostgresqlDAO;

import BD.DAO.CampoCatalogoDAO;
import BD.PostgresqlDAOFactory;
import infosis.siradex.clases.CampoCatalogo;
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
public class PostgresqlCampoCatalogoDAO implements CampoCatalogoDAO {
	
	@Override
	public int insertarCampoCatalogo(CampoCatalogo nuevoCampo) {
		PreparedStatement stmt = null;
		String queryInsercion = "INSERT INTO campos_catalogo (id_catalogo, nombre_campo,"
			+ " tipo_campo) VALUES (?, ?, ?)";

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();

			stmt = conexion.prepareStatement(queryInsercion);
			stmt.setInt(1, nuevoCampo.getId_catalogo());
			stmt.setString(2, nuevoCampo.getNombre_campo());
			stmt.setString(3, nuevoCampo.getTipo_campo());
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
		return nuevoCampo.getId_campo_catalogo();
	}

	@Override
	public CampoCatalogo buscarCampoCatalogo(int id_campo_catalogo) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean actualizarCampoCatalogo() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean borrarCampoCatalogo(int id_campo_catalogo) {
		PreparedStatement stmt = null;
		String queryEliminacion = "DELETE FROM campo_catalogo WHERE id_campo_catalogo = ?";

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();

			stmt = conexion.prepareStatement(queryEliminacion);
			stmt.setInt(1, id_campo_catalogo);
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
	public ArrayList<CampoCatalogo> buscarTodos() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public ArrayList<CampoCatalogo> buscarCamposPorCatalogo(int id_catalogo) {
		PreparedStatement stmt = null;
		String queryBusqueda = "SELECT * FROM campos_catalogo WHERE id_catalogo = ?";
		ArrayList<CampoCatalogo> campos = new ArrayList<CampoCatalogo>();

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();
			ResultSet rs = null;

			stmt = conexion.prepareStatement(queryBusqueda);
			stmt.setInt(1, id_catalogo);
			rs = stmt.executeQuery();

			while (rs.next()) {
				// Se encontro el usuario deseado
				campos.add(new CampoCatalogo(rs.getInt("id_campo_catalogo"), rs.getInt("id_catalogo"),
					rs.getString("nombre_campo"), rs.getString("tipo_campo")));
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
		return campos;
	}

}
