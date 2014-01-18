/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex;

import infosis.siradex.forms.GestionarUsuariosForm;
import infosis.siradex.clases.Usuario;
import BD.DAO.UsuarioDAO;
import BD.DAOFactory;
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
public class GestionarUsuariosAction extends org.apache.struts.action.Action {

	/* forward name="success" path="" */
	private static final String SUCCESS = "buscar_usuario";
	private static final String MODIFICAR_USUARIO = "modificar_usuario";
	private static final String CONSULTA_HECHA = "consulta_hecha";

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

		GestionarUsuariosForm formBean = (GestionarUsuariosForm) form;
		String usbid = formBean.getUsbid();
		System.out.print("Buscando:" + usbid);

		DAOFactory miDAOFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		UsuarioDAO uDAO = miDAOFactory.getUsuarioDAO();

		Usuario u = null;
		ArrayList<Usuario> usuarios = null;

		if (request.getParameter("buscar") != null) {
			//	Queremos hacer una busqueda
			if (usbid == null || (usbid.compareTo("") == 0)) {
				System.out.println("Imprimiendo todos los usuarios");
				usuarios = uDAO.buscarTodos();
//			formBean.setUsuarios(usuarios);
//			formBean.setUsuario_consultado(null);
				request.getSession().setAttribute("usuarios", usuarios);
				request.getSession().setAttribute("usuario_consultado", null);

				System.out.println("Antes del forward");
				System.out.println("Usuarios:" + usuarios);
				System.out.println("Usuario consultado:" + u);
			} else {
				System.out.println("Imprimiendo un solo usuario");
				u = uDAO.buscarUsuario(usbid);

				System.out.println("Consulta satisfactoria de:" + usbid);
//			formBean.setUsuario_consultado(hashUsuario);
//			formBean.setUsuarios(null);
				request.getSession().setAttribute("usuario_consulta", u);
				request.getSession().setAttribute("usuarios", null);

				System.out.println("Antes del forward");
				System.out.println("Usuarios:" + usuarios);
				System.out.println("Usuario consultado:" + u);
			}
			return mapping.findForward(CONSULTA_HECHA);
		} else if (request.getParameter("modificar_usuario") != null) {
			Usuario aux = uDAO.buscarUsuario(usbid);
			request.getSession().setAttribute("usbid_modificar", usbid);
			request.getSession().setAttribute("nombre_modificar", aux.getNombre());
			request.getSession().setAttribute("apellido_modificar", aux.getApellido());
			request.getSession().setAttribute("correo_modificar", aux.getEmail());
			request.getSession().setAttribute("rol_modificar", aux.getRol());
			System.out.println("Modificaremos " + usbid);
			System.out.println("Nombre a modificar" + aux.getNombre());
			System.out.println("Apellido a modificar" + aux.getApellido());
			System.out.println("Correo a modificar" + aux.getEmail());
			System.out.println("Rol a modificar" + aux.getRol());

			return mapping.findForward(MODIFICAR_USUARIO);
		} else if (request.getParameter("eliminar_usuario") != null) {
			uDAO.borrarUsuario(usbid);
			form.reset(mapping, request);
			System.out.println("Eliminaremos un usuario " + usbid);
		}

		System.out.println("Primera vez que se carga la pagina de gestion de usuarios");
		return mapping.findForward(CONSULTA_HECHA);
	}
}
