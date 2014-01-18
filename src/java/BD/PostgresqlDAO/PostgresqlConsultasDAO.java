/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.PostgresqlDAO;

import BD.DAO.ConsultasDAO;
import BD.PostgresqlDAOFactory;
import infosis.siradex.clases.ConsultaAct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fx
 */
public class PostgresqlConsultasDAO implements ConsultasDAO{

    @Override
    public ArrayList<ConsultaAct> buscarTodas() {
        PreparedStatement stmt = null;
        String queryBusqueda = "SELECT * FROM actividad NATURAL JOIN valor NATURAL JOIN campos_tipo_actividad NATURAL JOIN usuario WHERE nombre_campo = 'Nombre de la actividad'";
        ArrayList<ConsultaAct> consulta = new ArrayList<ConsultaAct>();

        try {
            Connection conexion = PostgresqlDAOFactory.crearConexion();
            ResultSet rs = null;

            System.out.println("Buscando todos");

            stmt = conexion.prepareStatement(queryBusqueda);
            rs = stmt.executeQuery();

            while (rs.next()) {
                consulta.add(new ConsultaAct(rs.getString("nombre"), rs.getString("apellido"), rs.getString("nombre_campo"), rs.getString("tipo_campo"), rs.getInt("id_valor"), rs.getString("value"), rs.getInt("id_act")));

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

        return consulta;
    }

    @Override
    public ArrayList<ConsultaAct> buscarActDetalle(int id_act) {
        PreparedStatement stmt = null;
        String queryBusqueda = "SELECT * FROM actividad NATURAL JOIN valor NATURAL JOIN campos_tipo_actividad NATURAL JOIN usuario WHERE id_act = ?";
        ArrayList<ConsultaAct> consulta = new ArrayList<ConsultaAct>();

        try {
            Connection conexion = PostgresqlDAOFactory.crearConexion();
            ResultSet rs = null;

            System.out.println("Buscando todos");

            stmt = conexion.prepareStatement(queryBusqueda);
            stmt.setInt(1, id_act);
            rs = stmt.executeQuery();

            while (rs.next()) {
                consulta.add(new ConsultaAct(rs.getString("nombre"), rs.getString("apellido"), rs.getString("nombre_campo"), rs.getString("tipo_campo"), rs.getInt("id_valor"), rs.getString("value"), id_act));

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

        return consulta;
    }
    
}
