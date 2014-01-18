/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex;

import infosis.siradex.clases.Usuario;
import BD.DAOFactory;
import BD.DAO.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

/**
 *
 * @author germanleonz
 */
public class LoginAction extends org.apache.struts.action.Action {

	private static final String LOGIN_FALLIDO = "failure";
	// Roles de usuarios
	private static final String DEX = "administrador";
	private static final String USUARIO = "usuario";
	private static final String COORDINADOR_DEX = "coordinador";
	private static final String ROOT = "root";

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
		// Extraer la data del  usuario
		DynaValidatorForm formBean = (DynaValidatorForm) form;
		String usbid = formBean.get("usbid").toString();
		String contrasena = formBean.get("contrasena").toString();

		// Hacer la validacion de la data 
		// Nota: Esta es la unica linea que deberia cambiar en caso de que
		// cambie el sistema de almacenamiento de datos
		DAOFactory miDAOFactory =
			DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

		// Creamos un DAO para los usuarios
		UsuarioDAO uDAO = miDAOFactory.getUsuarioDAO();

		Usuario u = uDAO.buscarUsuario(usbid);

		if (u != null) {
			if (u.getContrasena().compareTo(contrasena) == 0) {
				// Usuario registrado, redirigir de acuerdo al rol
				request.getSession().setAttribute("usbid", usbid);

				switch (u.getRol().toLowerCase()) {
					case DEX:
						return mapping.findForward(DEX);
					case COORDINADOR_DEX:
						return mapping.findForward(COORDINADOR_DEX);
					case ROOT:
						return mapping.findForward(ROOT);
					default:
						return mapping.findForward(USUARIO);
				}
			}
		}

		// Usuario no existe
		return mapping.findForward(LOGIN_FALLIDO);
	}
}