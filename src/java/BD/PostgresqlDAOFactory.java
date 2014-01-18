/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import BD.DAO.ActividadDAO;
import BD.DAO.CampoCatalogoDAO;
import BD.PostgresqlDAO.PostgresqlTipoActividadDAO;
import BD.PostgresqlDAO.PostgresqlCampoTipoActDAO;
import BD.PostgresqlDAO.PostgresqlValorDAO;
import BD.PostgresqlDAO.PostgresqlUsuarioDAO;
import BD.DAO.CampoTipoActDAO;
import BD.DAO.CatalogoDAO;
import BD.DAO.ConsultasDAO;
import BD.DAO.CoordinacionDAO;
import BD.DAO.ElementoDAO;
import BD.DAO.ProgramaDAO;
import BD.DAO.TipoActividadDAO;
import BD.DAO.UsuarioDAO;
import BD.DAO.ValorCatalogoDAO;
import BD.DAO.ValorDAO;
import BD.PostgresqlDAO.PostgresqlActividadDAO;
import BD.PostgresqlDAO.PostgresqlCampoCatalogoDAO;
import BD.PostgresqlDAO.PostgresqlCatalogoDAO;
import BD.PostgresqlDAO.PostgresqlConsultasDAO;
import BD.PostgresqlDAO.PostgresqlCoordinacionDAO;
import BD.PostgresqlDAO.PostgresqlElementoDAO;
import BD.PostgresqlDAO.PostgresqlProgramaDAO;
import BD.PostgresqlDAO.PostgresqlValorCatalogoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author germanleonz
 */
public class PostgresqlDAOFactory extends DAOFactory {

	/**
	 *
	 */
	public static final String DRIVER =
		"org.postgresql.Driver";
	/**
	 *
	 */
	public static final String DBURL =
		"jdbc:postgresql://localhost:5432/siradex";
	/**
	 *
	 */
	public static final String USUARIO = "siradex";
	/**
	 *
	 */
	public static final String CONTRASENA = "siradex";

	// Metodo para crear conexiones con PostgreSQL
	/**
	 *
	 * @return
	 * @throws SQLException
	 */
	public static Connection crearConexion() throws SQLException {
		// Usar el driver y el url para crear la conexion
		// Ver connection pool implemetation/ usage
		try {
			Connection conexion = null;

			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(DBURL, USUARIO, CONTRASENA);
			return conexion;
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		return null;
	}

	// Metodo para conseguir DAO de cada elemento de la base de datos
	
	/**
	 *
	 * @return
	 */
	@Override
	public UsuarioDAO getUsuarioDAO() {
		// PostgresqlUsuarioDAO implementa la interfaz UsuarioDAO
		return new PostgresqlUsuarioDAO();
	}

	public TipoActividadDAO getTipoActividadDAO() {
		return new PostgresqlTipoActividadDAO();
	}
	
	public ValorDAO getValorDAO() {
		return new PostgresqlValorDAO();
	}

	public CampoTipoActDAO getCampoTipoActDAO() {
		return new PostgresqlCampoTipoActDAO();
	}

	public CoordinacionDAO getCoordinacionDAO() {
		return new PostgresqlCoordinacionDAO();
	}


	@Override
	public ActividadDAO getActividadDAO() {
		return new PostgresqlActividadDAO();
	}

	@Override
	public ConsultasDAO getConsultasDAO() {
		return new PostgresqlConsultasDAO();
	}

	@Override
	public ProgramaDAO getProgramaDAO() {
		return new PostgresqlProgramaDAO();
	}

	@Override
	public CatalogoDAO getCatalogoDAO() {
		return new PostgresqlCatalogoDAO();
	}

	@Override
	public CampoCatalogoDAO getCampoCatalogoDAO() {
		return new PostgresqlCampoCatalogoDAO();
	}

	@Override
	public ValorCatalogoDAO getValorCatalogoDAO() {
		return new PostgresqlValorCatalogoDAO();
	}

	@Override
	public ElementoDAO getElementoDAO() {
		return new PostgresqlElementoDAO();
	}

	
}
