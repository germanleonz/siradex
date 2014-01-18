/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.PostgresqlDAO;

import BD.DAO.CatalogoDAO;
import BD.PostgresqlDAOFactory;
import infosis.siradex.clases.Catalogo;
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
public class PostgresqlCatalogoDAO implements CatalogoDAO {

	public PostgresqlCatalogoDAO() {
		//	Inicializacion
	}

	@Override
	public int insertarCatalogo(Catalogo nuevoCatalogo) {
		PreparedStatement stmt = null;
		String queryInsercion = "INSERT INTO catalogo (nombre_catalogo, num_campos) VALUES (?, ?)";

		ResultSet generatedKeys;
		Integer id_catalogo = null;
		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();

			stmt = conexion.prepareStatement(queryInsercion, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nuevoCatalogo.getNombre_catalogo());
			stmt.setInt(2, nuevoCatalogo.getNum_campos());
			stmt.executeUpdate();

			generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				id_catalogo = generatedKeys.getInt(1);
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
		return id_catalogo;
	}

	@Override
	public Catalogo buscarCatalogo(int id_catalogo) {
		PreparedStatement stmt = null;
		String queryBusqueda = "SELECT * FROM catalogo WHERE id_catalogo = ?";
		Catalogo catalogo = null;

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();
			ResultSet rs = null;

			stmt = conexion.prepareStatement(queryBusqueda);
			stmt.setInt(1, id_catalogo);
			rs = stmt.executeQuery();

			if (rs.next()) {
				// Se encontro el tipo de actividad deseada
				catalogo = new Catalogo(rs.getInt("id_catalogo"), rs.getString("nombre_catalogo"), rs.getInt("num_campos"));
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

		return catalogo;
	}

	@Override
	public ArrayList<Catalogo> buscarTodos() {
		PreparedStatement stmt = null;
		String queryBusqueda = "SELECT * FROM catalogo";
		ArrayList<Catalogo> catalogos = new ArrayList<Catalogo>();

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();
			ResultSet rs = null;

			stmt = conexion.prepareStatement(queryBusqueda);
			rs = stmt.executeQuery();

			while (rs.next()) {
				// Se encontro el usuario deseado
				catalogos.add(new Catalogo(rs.getInt("id_catalogo"), rs.getString("nombre_catalogo"), rs.getInt("num_campos")));
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

		return catalogos;
	}

	@Override
	public boolean actualizarCatalogo() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean borrarCatalogo(int id_catalogo) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
