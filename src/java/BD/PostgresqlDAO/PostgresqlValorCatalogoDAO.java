/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.PostgresqlDAO;

import BD.DAO.ValorCatalogoDAO;
import BD.PostgresqlDAOFactory;
import infosis.siradex.clases.ValorCatalogo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public class PostgresqlValorCatalogoDAO implements ValorCatalogoDAO {

	public PostgresqlValorCatalogoDAO() {
	}

	@Override
	public int insertarValor(ValorCatalogo nuevoValor) {
		PreparedStatement stmt = null;
		String queryInsercion = "INSERT INTO valor_catalogo (id_campo_catalogo, id_catalogo, value) VALUES (?, ?, ?)";

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();

			System.out.println("id_campo_catalogo" + nuevoValor.getId_campo_catalogo());

			stmt = conexion.prepareStatement(queryInsercion);
			stmt.setInt(1, nuevoValor.getId_campo_catalogo());
			stmt.setInt(2, nuevoValor.getId_catalogo());
			stmt.setString(3, nuevoValor.getValue());
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
		return nuevoValor.getId_valor();
	}

	@Override
	public boolean actualizarValor() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean borrarValor(int id_valor) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public ValorCatalogo buscarValor(int id_v) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public ArrayList<ValorCatalogo> buscarTodos() {
		return null;
	}

	@Override
	public ArrayList<ValorCatalogo> buscarValoresParaCampo(String nombre_catalogo, String nombre_campo) {
		PreparedStatement stmt = null;
		String queryBusqueda = "SELECT value, id_valor, id_catalogo, id_campo_catalogo, id_elemento " 
			+ "FROM valor_catalogo NATURAL JOIN campos_catalogo NATURAL JOIN catalogo "
			+ "WHERE nombre_catalogo = ? and nombre_campo = ?";
		ArrayList<ValorCatalogo> valores = new ArrayList<ValorCatalogo>(30);

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();
			ResultSet rs = null;

			stmt = conexion.prepareStatement(queryBusqueda);
			stmt.setString(1, nombre_catalogo);
			stmt.setString(2, nombre_campo);
			rs = stmt.executeQuery();

			while (rs.next()) {
				// Se encontraron los valor deseados
				valores.add(new ValorCatalogo(rs.getInt("id_valor"), rs.getInt("id_catalogo"),
					rs.getInt("id_campo_catalogo"), rs.getString("value"), rs.getInt("id_elemento")));
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

		return valores;
	}
}
