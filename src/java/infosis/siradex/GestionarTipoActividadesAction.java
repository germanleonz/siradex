/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex;

import infosis.siradex.forms.GestionarTipoActividadesForm;
import infosis.siradex.clases.TipoActividad;
import BD.DAO.TipoActividadDAO;
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
public class GestionarTipoActividadesAction extends org.apache.struts.action.Action {

	/* forward name="success" path="" */
	private static final String SUCCESS = "buscar_tipo_actividad";
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

		GestionarTipoActividadesForm formBean = (GestionarTipoActividadesForm) form;
		Integer codigo_ta = new Integer(formBean.getCodigo_ta());
		System.out.print("Buscando:" + codigo_ta);

		DAOFactory miDAOFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		TipoActividadDAO taDAO = miDAOFactory.getTipoActividadDAO();

		TipoActividad ta = null;
		ArrayList<TipoActividad> tipos = null;

		if (codigo_ta == null || (codigo_ta.intValue() == 0)) {
			System.out.println("Imprimiendo todos los tipos de actividades");
			tipos = taDAO.buscarTodos();
//			formBean.setUsuarios(usuarios);
//			formBean.setUsuario_consultado(null);
			request.getSession().setAttribute("tipos", tipos);
			request.getSession().setAttribute("tipo_consultado", null);

			System.out.println("Antes del forward");
			System.out.println("Tipos Actividades:" + tipos);
			System.out.println("Tipo consultado:" + ta);
		} else {
			System.out.println("Imprimiendo un solo tipo de actividad");
			ta = taDAO.buscarTipoActividad(codigo_ta);

			System.out.println("Consulta satisfactoria de:" + codigo_ta);
//			formBean.setUsuario_consultado(hashUsuario);
//			formBean.setUsuarios(null);
			request.getSession().setAttribute("tipo_consulta", ta);
			request.getSession().setAttribute("tipos", null);

			System.out.println("Antes del forward");
			System.out.println("Tipos Actividades:" + tipos);
			System.out.println("Tipo consultado:" + ta);
		}

		return mapping.findForward(CONSULTA_HECHA);
	}
}
