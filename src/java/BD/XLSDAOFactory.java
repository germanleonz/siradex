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
public class XLSDAOFactory extends DAOFactory {

	public XLSDAOFactory() {
	}

	// Variables estaticas especificas para la lectura de archivos XLS

	@Override
	public UsuarioDAO getUsuarioDAO() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public TipoActividadDAO getTipoActividadDAO() {
		throw new UnsupportedOperationException("Not supported yet");
	} 

	@Override
	public CampoTipoActDAO getCampoTipoActDAO() {
		throw new UnsupportedOperationException("Not supported yet");
	} 

	@Override
	public ValorDAO getValorDAO() {
		throw new UnsupportedOperationException("Not supported yet");
	} 

	@Override
	public CoordinacionDAO getCoordinacionDAO() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public CatalogoDAO getCatalogoDAO() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public ActividadDAO getActividadDAO() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public ConsultasDAO getConsultasDAO() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public ProgramaDAO getProgramaDAO() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public CampoCatalogoDAO getCampoCatalogoDAO() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public ValorCatalogoDAO getValorCatalogoDAO() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public ElementoDAO getElementoDAO() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
