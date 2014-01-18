/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex;

import BD.DAO.CampoCatalogoDAO;
import BD.DAO.CatalogoDAO;
import BD.DAOFactory;
import infosis.siradex.clases.CampoCatalogo;
import infosis.siradex.clases.Catalogo;
import infosis.siradex.forms.CrearCatalogoForm;
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
public class CrearCatalogoAction extends org.apache.struts.action.Action {

	private static final String SUCCESS = "creacion_catalogo_correcta";
	private static final String REFRESCAR = "agregar_campos";

	private int agregarCatalogo(CrearCatalogoForm form, DAOFactory dFactory) {
		System.out.println("Creando catalogo");
		String nombre_catalogo = form.getNombre_catalogo();
		int num_campos = form.getNum_campos_catalogo();

		//	Insertamos el tipo de actividad en la base de datos
		CatalogoDAO cDAO = dFactory.getCatalogoDAO();
		Catalogo c = new Catalogo(-1, nombre_catalogo, num_campos);
		System.out.println("Catalogo creado");
		return cDAO.insertarCatalogo(c);
	}

	private void agregarCampos(int num_campos, int id_catalogo, CrearCatalogoForm formBean, DAOFactory miDAOFactory) {
		System.out.println("Agregando campos del catalogo a la base de datos...");
		String[] nom_campos = formBean.getNom_campos();
		String[] tipo_campos = formBean.getTipo_campos();

		//	Insertamos la informacion de los distintos campos del catalogo
		ArrayList<CampoCatalogo> campos = new ArrayList<CampoCatalogo>(5);
		CampoCatalogo aux;
		for (int i = 0; i < num_campos; i++) {
			aux = new CampoCatalogo(-1, id_catalogo, nom_campos[i], tipo_campos[i]);
			campos.add(aux);
		}

		//	Insertamos la informacion de los distintos campos del catalogo
		CampoCatalogoDAO cDAO = miDAOFactory.getCampoCatalogoDAO();

		//	Agregamos los campos del catalogo
		for (CampoCatalogo campo : campos) {
			cDAO.insertarCampoCatalogo(campo);
		}
		System.out.println("Campos agregados");
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		CrearCatalogoForm formBean = (CrearCatalogoForm) form;

		String nombre = formBean.getNombre_catalogo();

		request.setAttribute("num_campos", 1);

		if (request.getParameter("agregar_campos") != null) {
			System.out.println("Se recargara la pagina cambiando el numero de campos del catalogo");
			request.setAttribute("num_campos", formBean.getNum_campos_catalogo());
			return mapping.findForward(REFRESCAR);
		} else if (request.getParameter("crear_catalogo") != null) {
			//	Procedemos a agregar un tipo de actividad a la base de datos
			int num_campos = formBean.getNum_campos_catalogo();
			System.out.println("Entramos a crear un catalogo nuevo");
			System.out.println("Numero de campos segun el usuario:" + num_campos);

			//	Conseguimos un factory para los DAO que usaremos para las inserciones
			DAOFactory miDAOFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

			//	Extraemos los dato del form que iran en la tabla tipo de actividad
			int id_catalogo = agregarCatalogo(formBean, miDAOFactory);
			System.out.println("ID del catalogo creado:" + id_catalogo);

			//	Insertamos en la bd los datos de los campos del tipo de actividad
			//	que acabamos de crear 
			agregarCampos(num_campos, id_catalogo, formBean, miDAOFactory);

			//	Cargamos la pagina de creacion exitosa de un tipo de actividad
			return mapping.findForward(SUCCESS);
		}
		//	Cargamos la pagina de crear_tipo_actividad 
		return mapping.findForward(REFRESCAR);
	}
}
