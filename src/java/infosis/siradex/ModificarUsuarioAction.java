/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex;

import BD.DAO.UsuarioDAO;
import BD.DAOFactory;
import infosis.siradex.clases.Usuario;
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
public class ModificarUsuarioAction extends org.apache.struts.action.Action {

	/* forward name="success" path="" */
	private static final String CARGAR_PAGINA = "cargar_pagina";
	private static final String MODIFICACION_EXITOSA = "modificacion_usuario_correcta";

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
		String usbid = request.getSession().getAttribute("usbid_modificar").toString();
		DynaValidatorForm formBean = (DynaValidatorForm) form;

		//	Conseguimos el DAO para usuarios
		DAOFactory miDAOFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		UsuarioDAO uDAO = miDAOFactory.getUsuarioDAO();

		System.out.println("Cuerpo de modificar " + usbid);

		if (request.getParameter("guardar_cambios") != null) {
			System.out.println("Guardando cambios de modificar");
			String nombreUsuario = (String) formBean.get("usbid");
			String nombre = (String) formBean.get("nombre");
			String apellido = (String) formBean.get("apellido");
			String email = (String) formBean.get("email");
			String rol = (String) formBean.get("rol");
			boolean status = uDAO.actualizarUsuario(nombreUsuario, nombre, apellido, email, rol);
			return mapping.findForward(MODIFICACION_EXITOSA);
		}

		return mapping.findForward(CARGAR_PAGINA);
	}
}
