/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import BD.DAO.ActividadDAO;
import BD.DAO.CampoCatalogoDAO;
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

/**
 *
 * @author germanleonz
 */
public abstract class DAOFactory {

	// Lista de tipos de DAO soportados por la factory
	public static final int POSTGRESQL = 1;
	public static final int XML = 2;
	public static final int EXCEL = 3;

	// Habra un metodo para cada tipo de DAO que pueda ser creado
	/**
	 *
	 * @return
	 */
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract TipoActividadDAO getTipoActividadDAO();
	public abstract CampoTipoActDAO getCampoTipoActDAO();
	public abstract ValorDAO getValorDAO();
	public abstract CatalogoDAO getCatalogoDAO();
	public abstract CampoCatalogoDAO getCampoCatalogoDAO();
	public abstract ValorCatalogoDAO getValorCatalogoDAO();
	public abstract CoordinacionDAO getCoordinacionDAO();
	public abstract ConsultasDAO getConsultasDAO();
	public abstract ActividadDAO getActividadDAO();
	public abstract ProgramaDAO getProgramaDAO();
	public abstract ElementoDAO getElementoDAO();

	/**
	 *
	 * @param idFactory
	 * @return
	 */
	public static DAOFactory getDAOFactory(int idFactory) {
		switch (idFactory) {
			case POSTGRESQL:
				return new PostgresqlDAOFactory();
			case XML:
				return new XMLDAOFactory();
			case EXCEL:
				return new XLSDAOFactory();
			default:
				return null;

		}
	}
	
}
