/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex;

import BD.DAO.CampoCatalogoDAO;
import infosis.siradex.forms.GestionarCatalogosForm;
import BD.DAO.CatalogoDAO;
import BD.DAO.ValorCatalogoDAO;
import BD.DAOFactory;
import infosis.siradex.clases.CampoCatalogo;
import infosis.siradex.clases.Catalogo;
import infosis.siradex.clases.ValorCatalogo;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author germanleonz
 */
public class GestionarCatalogosAction extends org.apache.struts.action.Action {

	private static final String SUCCESS = "success";
	private static final String REFRESCAR = "refrescar";

	public ArrayList<Catalogo> conseguirCatalogos() {
		DAOFactory miDaoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		CatalogoDAO miCatalogoDAO = miDaoFactory.getCatalogoDAO();
		ArrayList<Catalogo> catalogos = miCatalogoDAO.buscarTodos();
		return catalogos;
	}

	/**
	 * This is the action called from the Struts framework.
	 *
	 * @param mapping The ActionMapping used to select this instance.
	 * @param form The optional ActionForm bean for this request.
	 * @param request The HTTP Request we are processing.
	 * @param response The HTTP Response we are processing.
	 * @throws java.lang.Exception
	 * @return
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		//	Conseguimos el id y nombre de los catalogos del sistema
		ArrayList<Catalogo> catalogos = conseguirCatalogos();
		request.setAttribute("catalogos", catalogos);

		if (request.getParameter("listar_catalogo") != null) {
			GestionarCatalogosForm formCatalogos = (GestionarCatalogosForm) form;
			int id_catalogo_sel = formCatalogos.getCatalogo_sel();

			DAOFactory miDaoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
			CampoCatalogoDAO miCampoCatalogoDAO = miDaoFactory.getCampoCatalogoDAO();
	
			ArrayList<CampoCatalogo> campos = miCampoCatalogoDAO.buscarCamposPorCatalogo(id_catalogo_sel);
			request.getSession().setAttribute("campos_catalogo", campos);

//			ValorCatalogoDAO miValorCatalogoDAO = miDaoFactory.getValorCatalogoDAO();
//			ArrayList<ValorCatalogo> valores = miValorCatalogoDAO.buscarValoresParaCampo(SUCCESS, SUCCESS);
			
			System.out.println("Se clickeo el boton listar para listar el catalogo: " + id_catalogo_sel);
		}

		return mapping.findForward(REFRESCAR);
	}
}