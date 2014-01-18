/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author germanleonz
 */
public class UsuarioLinks extends DispatchAction {

	private final static String GESTIONAR_ACTIVIDADES = "gestionar_actividades";
	private final static String ACTUALIZAR_PERFIL = "actualizar_perfil";
	private final static String SOLICITAR_CONSTANCIA = "solicitar_constancia";
	private static final String LISTAR_OPCIONES = "listar_opciones";
	private static final String CERRAR_SESION = "cerrar_sesion";

	/**
	 * This is the Struts action method called on
	 * http://.../actionPath?method=myAction1, where "method" is the value
	 * specified in <action> element : ( <action parameter="method" .../> )
	 */
	public ActionForward gestionar_actividades(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		return mapping.findForward(GESTIONAR_ACTIVIDADES);
	}

	/**
	 * This is the Struts action method called on
	 * http://.../actionPath?method=myAction2, where "method" is the value
	 * specified in <action> element : ( <action parameter="method" .../> )
	 */
	public ActionForward actualizar_perfil(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		return mapping.findForward(ACTUALIZAR_PERFIL);
	}

	/**
	 * This is the Struts action method called on
	 * http://.../actionPath?method=myAction2, where "method" is the value
	 * specified in <action> element : ( <action parameter="method" .../> )
	 */
	public ActionForward solicitar_constancia(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		return mapping.findForward(SOLICITAR_CONSTANCIA);
	}

	/**
	 * This is the Struts action method called on
	 * http://.../actionPath?method=myAction2, where "method" is the value
	 * specified in <action> element : ( <action parameter="method" .../> )
	 */
	public ActionForward listar_opciones(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		return mapping.findForward(LISTAR_OPCIONES);
	}

	/**
	 * This is the Struts action method called on
	 * http://.../actionPath?method=myAction2, where "method" is the value
	 * specified in <action> element : ( <action parameter="method" .../> )
	 */
	public ActionForward cerrar_sesion(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		return mapping.findForward(CERRAR_SESION);
	}
}
