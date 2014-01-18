/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.PostgresqlDAO;

import BD.DAO.ActividadDAO;
import BD.PostgresqlDAOFactory;
import infosis.siradex.clases.Actividad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author fx
 */
public class PostgresqlActividadDAO implements ActividadDAO {

    @Override
    public int insertarActividad(String usbid, int id_ta) {
        PreparedStatement stmt = null;
        String queryInsercion = "INSERT INTO actividad (id_ta, usbid) VALUES (?, ?)";

        ResultSet generatedKeys;
        Integer id_act = null;
        try {
            Connection conexion = PostgresqlDAOFactory.crearConexion();

            stmt = conexion.prepareStatement(queryInsercion, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id_ta);
            stmt.setString(2, usbid);
            stmt.executeUpdate();
            
            generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                id_act = generatedKeys.getInt(1);
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
        return id_act;
    }

    @Override
    public boolean borrarActividad(int id_act) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Actividad> buscarTodos() {
        PreparedStatement stmt = null;
        String queryBusqueda = "SELECT * FROM actividad";
        ArrayList<Actividad> actividades = new ArrayList<Actividad>();

        try {
            Connection conexion = PostgresqlDAOFactory.crearConexion();
            ResultSet rs = null;

            System.out.println("Buscando todos");

            stmt = conexion.prepareStatement(queryBusqueda);
            rs = stmt.executeQuery();

            while (rs.next()) {
                actividades.add(new Actividad(rs.getInt("id_act"), rs.getString("usbid")));
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

        return actividades;
    }

    @Override
    public ArrayList<Actividad> buscarPorUSBID(String usbid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
