/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.PostgresqlDAO;

import BD.DAO.ElementoDAO;
import BD.PostgresqlDAOFactory;
import infosis.siradex.clases.Actividad;
import infosis.siradex.clases.Elemento;
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
public class PostgresqlElementoDAO implements ElementoDAO{

    @Override
    public int insertarElemento(int id_catalogo) {
        PreparedStatement stmt = null;
        String queryInsercion = "INSERT INTO elemento_catalogo (id_catalogo) VALUES ?";

        ResultSet generatedKeys;
        Integer id_elemento = null;
        try {
            Connection conexion = PostgresqlDAOFactory.crearConexion();

            stmt = conexion.prepareStatement(queryInsercion, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id_catalogo);
            stmt.executeUpdate();
            
            generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                id_elemento = generatedKeys.getInt(1);
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
        return id_elemento;
    }

	@Override
	public boolean borrarElemento(int id_act) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public ArrayList<Elemento> buscarTodos() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

    @Override
    public ArrayList<Elemento> buscarPorCatalogo(int id_catalogo) {
        PreparedStatement stmt = null;
        String queryBusqueda = "SELECT id_elemento FROM elemento_catalogo";
        ArrayList<Elemento> elementos = new ArrayList<Elemento>();

        try {
            Connection conexion = PostgresqlDAOFactory.crearConexion();
            ResultSet rs = null;

            System.out.println("Buscando todos");

            stmt = conexion.prepareStatement(queryBusqueda);
            rs = stmt.executeQuery();

            while (rs.next()) {
                elementos.add(new Elemento(rs.getInt("id_elemento"), rs.getInt("id_catalogo")));
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

        return elementos;

    }

	
}
