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
public class CrearUsuarioAction extends org.apache.struts.action.Action {

	/* forward name="success" path="" */
	private static final String SUCCESS = "creacion_usuario_correcta";

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
		String contrasena = formBean.get("contrasena1").toString();
		String nombre = formBean.get("nombre").toString();
		String apellido = formBean.get("apellido").toString();
		String email = formBean.get("email").toString();
		String rol = formBean.get("rol").toString();

		// Hacer la validacion de la data 
		// Nota: Esta es la unica linea que deberia cambiar en caso de que
		// cambie el sistema de almacenamiento de datos
		DAOFactory miDAOFactory =
			DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

		// Creamos un DAO de Usuarios
		UsuarioDAO uDAO = miDAOFactory.getUsuarioDAO();

		Usuario u = new Usuario(usbid, contrasena, nombre, apellido, email, rol);
		
		uDAO.insertarUsuario(u);

		form.reset(mapping, request);
		return mapping.findForward(SUCCESS);
	}
}