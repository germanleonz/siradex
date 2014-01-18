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
public class RootLinks extends DispatchAction {

	private static final String GESTIONAR_CATALOGOS = "gestionar_catalogos";
	private static final String GESTIONAR_USUARIOS = "gestionar_usuarios";
	private static final String GESTIONAR_RESPALDOS = "gestionar_respaldos";
	private static final String REVISAR_LOGS = "revisar_logs";

	private static final String ESPECIFICAR_ROLES = "especificar_roles";
	private static final String ESPECIFICAR_FECHAS = "especificar_fechas";
	private static final String BUSQUEDAS_AVANZADAS = "busquedas_avanzadas";
	private static final String GESTIONAR_TIPO_ACTIVIDADES = "gestionar_tipo_actividades";
	private static final String GESTIONAR_ALERTAS = "gestionar_alertas";
	private static final String IMPORTAR_DATOS = "importar_datos";

	private static final String GESTIONAR_ACTIVIDADES = "gestionar_actividades";
	private static final String ACTUALIZAR_PERFIL = "actualizar_perfil";
	private static final String SOLICITAR_CONSTANCIA = "solicitar_constancia";
	private static final String LISTAR_OPCIONES = "listar_opciones";
	private static final String CERRAR_SESION = "cerrar_sesion";

	public ActionForward gestionar_catalogos(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		return mapping.findForward(GESTIONAR_CATALOGOS);
	}

	public ActionForward gestionar_respaldos(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		return mapping.findForward(GESTIONAR_RESPALDOS);
	}

	public ActionForward revisar_logs(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		return mapping.findForward(REVISAR_LOGS);
	}
	
	public ActionForward gestionar_usuarios(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		return mapping.findForward(GESTIONAR_USUARIOS);
	}

	public ActionForward especificar_roles(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		return mapping.findForward(ESPECIFICAR_ROLES);
	}

	public ActionForward especificar_fechas(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		return mapping.findForward(ESPECIFICAR_FECHAS);
	}

	public ActionForward busquedas_avanzadas(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		return mapping.findForward(BUSQUEDAS_AVANZADAS);
	}

	public ActionForward gestionar_tipo_actividades(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		return mapping.findForward(GESTIONAR_TIPO_ACTIVIDADES);
	}

	public ActionForward gestionar_alertas(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		return mapping.findForward(GESTIONAR_ALERTAS);
	}

	public ActionForward importar_datos(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		return mapping.findForward(IMPORTAR_DATOS);
	}

	public ActionForward gestionar_actividades(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		return mapping.findForward(GESTIONAR_ACTIVIDADES);
	}

	public ActionForward actualizar_perfil(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		return mapping.findForward(ACTUALIZAR_PERFIL);
	}

	public ActionForward solicitar_constancia(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		return mapping.findForward(SOLICITAR_CONSTANCIA);
	}

	public ActionForward listar_opciones(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		return mapping.findForward(LISTAR_OPCIONES);
	}

	public ActionForward cerrar_sesion(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		//	Destruir cookie de la sesion
		return mapping.findForward(CERRAR_SESION);
	}
}