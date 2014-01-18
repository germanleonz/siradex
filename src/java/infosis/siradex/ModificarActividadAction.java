/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex;

import BD.DAO.ValorDAO;
import BD.DAOFactory;
import infosis.siradex.clases.Valor;
import infosis.siradex.forms.ModificarActividadForm;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author fx
 */
public class ModificarActividadAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "modificacion_hecha";

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
        ModificarActividadForm formbean = (ModificarActividadForm) form;
        DAOFactory miDAOFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
        ValorDAO vaDAO = miDAOFactory.getValorDAO();
        String path = "";
        FileOutputStream outputStream = null;
        FormFile formFile = null;

        for (int i = 0; i < formbean.getValue().length; i++) {
            if (formbean.getTipo_campo()[i].compareTo("ARCHIVO") != 0) {
                vaDAO.actualizarValor(new Valor(Integer.parseInt(formbean.getId_valor()[i]), 0, 0, formbean.getValue()[i]));
            } else {
                System.out.println("SUBIENDO ARCHIVO MODIFICADO");
                if (formbean.getFile() != null) {
                    try {
                        formFile = formbean.getFile();
                        path = getServlet().getServletContext().getRealPath("") + "/Uploads/" + formFile.getFileName();
                        outputStream = new FileOutputStream(new File(path));
                        outputStream.write(formFile.getFileData());
                        path = formFile.getFileName();
                    } finally {
                        if (outputStream != null) {
                            vaDAO.actualizarValor(new Valor(Integer.parseInt(formbean.getId_valor()[i]), 0, 0, path));
                            outputStream.close();
                        }
                    }
                }
            }
        }




        return mapping.findForward(SUCCESS);
    }
}
