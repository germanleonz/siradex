/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex;

import infosis.siradex.forms.EliminarTipoActividadForm;
import BD.DAO.TipoActividadDAO;
import BD.DAOFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author germanleonz
 */
public class EliminarTipoActividadAction extends org.apache.struts.action.Action {

	/* forward name="success" path="" */
	private static final String SUCCESS = "eliminacion_tipo_actividad_correcta";

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
		EliminarTipoActividadForm formBean = (EliminarTipoActividadForm) form;
		int codigo_ta = formBean.getCodigo_ta();

		// Hacer la validacion de la data 
		// Nota: Esta es la unica linea que deberia cambiar en caso de que
		// cambie el sistema de almacenamiento de datos
		DAOFactory miDAOFactory =
			DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

		// Creamos un DAO
		TipoActividadDAO taDAO = miDAOFactory.getTipoActividadDAO();

		taDAO.borrarTipoActividad(codigo_ta);

		return mapping.findForward(SUCCESS);
	}
}
