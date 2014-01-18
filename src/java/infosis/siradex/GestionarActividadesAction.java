/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex;

import BD.DAO.ConsultasDAO;
import BD.DAOFactory;
import infosis.siradex.clases.ConsultaAct;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author fx
 */
public class GestionarActividadesAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "listar_actividades";
    private static final String DETALLE = "detalle_actividad";
    private static final String MODIFICAR = "modificar_actividad";

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
        
        DynaActionForm formbean = (DynaActionForm) form;
        DAOFactory miDAOFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
        ConsultasDAO coDAO = miDAOFactory.getConsultasDAO();
        ArrayList<ConsultaAct> lista = null;
        
        if (request.getParameter("detalle") == null && request.getParameter("modificar") == null && request.getParameter("eliminar") == null) {
        lista = coDAO.buscarTodas();
        request.setAttribute("lista", lista);
        }

        if (request.getParameter("modificar") != null) {
            lista = coDAO.buscarActDetalle(Integer.parseInt(formbean.getString("id_act")));
            request.setAttribute("lista", lista);
            return mapping.findForward(MODIFICAR);
        }
        
        if (request.getParameter("detalle") != null && request.getParameter("modificar") == null) {
            lista = coDAO.buscarActDetalle(Integer.parseInt(formbean.getString("id_act")));
            request.setAttribute("lista", lista);
            return mapping.findForward(DETALLE);
        }

        return mapping.findForward(SUCCESS);
    }
}
