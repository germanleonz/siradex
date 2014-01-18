/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.PostgresqlDAO;

import BD.DAO.ValorDAO;
import BD.PostgresqlDAOFactory;
import infosis.siradex.clases.Valor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author germanleonz
 */
public class PostgresqlValorDAO implements ValorDAO {

	public PostgresqlValorDAO() {
	}

	@Override
	public int insertarValor(Valor nuevoValor) {
		PreparedStatement stmt = null;
		String queryInsercion = "INSERT INTO valor (id_cta, id_act, value) VALUES (?, ?, ?)";

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();

			System.out.println("id_cta" + nuevoValor.getId_cta());

			stmt = conexion.prepareStatement(queryInsercion);
			stmt.setInt(1, nuevoValor.getId_cta());
			stmt.setInt(2, nuevoValor.getId_act());
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
	public boolean actualizarValor(Valor nuevoValor) {
		PreparedStatement stmt = null;
		String queryInsercion = "UPDATE valor SET value=? WHERE id_valor=?";

		try {
			Connection conexion = PostgresqlDAOFactory.crearConexion();

			stmt = conexion.prepareStatement(queryInsercion);
			stmt.setString(1, nuevoValor.getValue());
			stmt.setInt(2, nuevoValor.getId_valor());
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
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
	public boolean borrarValor(int id_valor) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Valor buscarValor(int id_v) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public ArrayList<Valor> buscarTodos() {
		return null;
	}
}
