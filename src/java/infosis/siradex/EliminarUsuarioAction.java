/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex;

import infosis.siradex.forms.EliminarUsuarioForm;
import BD.DAOFactory;
import BD.DAO.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author germanleonz
 */
public class EliminarUsuarioAction extends org.apache.struts.action.Action {

	/* forward name="success" path="" */
	private static final String SUCCESS = "eliminacion_usuario_correcta";

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
		EliminarUsuarioForm formBean = (EliminarUsuarioForm) form;
		String usbid = formBean.getUsbid();

		// Hacer la validacion de la data 
		// Nota: Esta es la unica linea que deberia cambiar en caso de que
		// cambie el sistema de almacenamiento de datos
		DAOFactory miDAOFactory =
			DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

		// Creamos un DAO
		UsuarioDAO uDAO = miDAOFactory.getUsuarioDAO();

		uDAO.borrarUsuario(usbid);

		return mapping.findForward(SUCCESS);
	}
}
