/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex;

import infosis.siradex.forms.RegistrarActividadForm;
import BD.DAO.ActividadDAO;
import BD.DAO.CampoTipoActDAO;
import BD.DAO.TipoActividadDAO;
import BD.DAO.ValorDAO;
import BD.DAOFactory;
import infosis.siradex.clases.CampoTipoAct;
import infosis.siradex.clases.TipoActividad;
import infosis.siradex.clases.Valor;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
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
public class RegistrarActividadAction extends org.apache.struts.action.Action {

	/* forward name="success" path="" */
	private static final String ELEGIDO = "tipo_elegido";
	private static final String SUCCESS = "creacion_actividad_correcta";

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

		RegistrarActividadForm formbean = (RegistrarActividadForm) form;
		DAOFactory miDAOFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		TipoActividadDAO taDAO = miDAOFactory.getTipoActividadDAO();
		CampoTipoActDAO caDAO = miDAOFactory.getCampoTipoActDAO();
		ActividadDAO actDAO = miDAOFactory.getActividadDAO();
		ValorDAO vaDAO = miDAOFactory.getValorDAO();

		ArrayList<TipoActividad> listatipos = null;
		ArrayList<CampoTipoAct> listacampos = null;
		int tipo = 0;
		int id_act;
		String path = "";
		FileOutputStream outputStream = null;
		FormFile formFile = null;


		//Si se eleigio un tipo de actividad, se guarda en la variable tipo
		if (formbean.getTipo() != null && formbean.getTipo().compareTo("") != 0) {
			tipo = Integer.parseInt(formbean.getTipo());
			request.setAttribute("id_ta", Integer.toString(tipo));
		}

		//Se buscan todos los tipos de actividades para poder listarlos
		listatipos = taDAO.buscarTodos();
		request.setAttribute("listatipos", listatipos);

		//Si ya se eligio un tipo de actividad, se buscan los campos correspondientes
		if (listacampos == null && tipo != 0) {
			listacampos = caDAO.buscarCamposPorTA(tipo);
			request.setAttribute("listacampos", listacampos);
		}

		//Si se registraron valores, se guarda la actividad en la base de datos
		if (formbean.getValor() != null) {
			String usbid = (String) request.getSession().getAttribute("usbid");
			//Se registra la actividad
			id_act = actDAO.insertarActividad(usbid, Integer.parseInt(formbean.getId_ta()));

			//Se guardan los valores para cada campo
			for (int i = 0; i < formbean.getValor().length; i++) {
				vaDAO.insertarValor(new Valor(0, Integer.parseInt(formbean.getId_cta()[i]), id_act, formbean.getValor()[i]));
			}

			//Subimos el archivo en caso de que exista
			if (formbean.getFile() != null) {
				try {
					formFile = formbean.getFile();
					path = getServlet().getServletContext().getRealPath("") + "/Uploads/" + formFile.getFileName();
					outputStream = new FileOutputStream(new File(path));
					outputStream.write(formFile.getFileData());
					path = formFile.getFileName();
				} finally {
					if (outputStream != null) {
						vaDAO.insertarValor(new Valor(0, Integer.parseInt(formbean.getId_cta_file()), id_act, path));
						outputStream.close();
					}
				}
			}
			return mapping.findForward(SUCCESS);
		}

		return mapping.findForward(ELEGIDO);
	}
}
