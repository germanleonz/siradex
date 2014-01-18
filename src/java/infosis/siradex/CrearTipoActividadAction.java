/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infosis.siradex;

import infosis.siradex.forms.CrearTipoActividadForm;
import BD.DAO.CampoTipoActDAO;
import BD.DAO.CatalogoDAO;
import BD.DAO.ProgramaDAO;
import BD.DAOFactory;
import BD.DAO.TipoActividadDAO;
import BD.DAO.ValorCatalogoDAO;
import infosis.siradex.clases.CampoTipoAct;
import infosis.siradex.clases.Catalogo;
import infosis.siradex.clases.Coordinacion;
import infosis.siradex.clases.Programa;
import infosis.siradex.clases.TipoActividad;
import infosis.siradex.clases.ValorCatalogo;
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
public class CrearTipoActividadAction extends org.apache.struts.action.Action {

	/* forward name="success" path="" */
	private static final String SUCCESS = "creacion_tipo_act_correcta";
	private static final String REFRESH = "agregar_campos";
	private static int contador = 1;		//TEMPORAL

	/*
	 * 
	 */
	private int agregarTipoActividad(CrearTipoActividadForm datos, DAOFactory miDAOFactory) {
		System.out.print("Agregando el tipo de actividad...");
		String nombreTA = datos.getNombre_ta();
		int num_campos = datos.getNum_campos_ta();
		String tipoprTA = datos.getTipopr_ta();
		String id_validador = datos.getId_validador_ta();
		String id_programa = datos.getId_programa();
		String descripcion = datos.getDescripcion();
		String[] realizable_por = datos.getRealizable_por();

		for (String s : realizable_por) {
			System.out.println("Realizable por:" + s);
		}

		//	Insertamos el tipo de actividad en la base de datos
		TipoActividadDAO taDAO = miDAOFactory.getTipoActividadDAO();
		TipoActividad ta = new TipoActividad(-1, nombreTA, num_campos, tipoprTA, id_validador, id_programa, descripcion, realizable_por);
		System.out.println("Tipo de actividad agregada");
		return taDAO.insertarTipoActividad(ta);
	}

	/*
	 * 
	 */
	private void agregarCampos(int num_campos, int id_tipo_act, CrearTipoActividadForm datos, DAOFactory miDAOFactory) {
		//	Conseguimos la informacion de los campos del tipo de actividad
		System.out.println("Agregando los campos del tipo de actividad ...");
		String[] nom_campos = datos.getNom_campos();
		String[] tipo_campos = datos.getTipo_campos();
		String[] longitud = datos.getLongitud();
		String[] obligatorio = datos.getObligatorio();
		String[] id_catalogo = datos.getId_catalogo();

		//	Insertamos la informacion de los distintos campos del tipo de actividad
		ArrayList<CampoTipoAct> campos = new ArrayList<CampoTipoAct>();
		CampoTipoAct aux;
		boolean oblig;
		int id_catalogo_aux;
		int longitud_aux;
		for (int i = 0; i < num_campos + 1; i++) {
			System.out.println("AAAAA");
			System.out.println("id_cahtalogohh: " + id_catalogo[i]);
			id_catalogo_aux = (id_catalogo[i].compareTo("No aplica") == 0) ? -1 : Integer.parseInt(id_catalogo[i]);
			longitud_aux = Integer.parseInt(longitud[i]);
			oblig = Boolean.parseBoolean(obligatorio[i]);

			aux = new CampoTipoAct(-1, id_tipo_act, nom_campos[i],
				tipo_campos[i], oblig , longitud_aux, id_catalogo_aux);
			campos.add(aux);
		}

		//	Insertamos la informacion de los distintos campos del tipo de actividad
		CampoTipoActDAO ctaDAO = miDAOFactory.getCampoTipoActDAO();

		//	Agregamos los campos del tipo de actividad
		for (CampoTipoAct campo : campos) {
			ctaDAO.insertarCampo(campo);
		}
		System.out.println("Campos agregados ...");
	}

	/*
	 *
	 */
	public ArrayList<Coordinacion> conseguirCoordinaciones() {
		DAOFactory miDaoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		ValorCatalogoDAO miValorCatalogoDAO = miDaoFactory.getValorCatalogoDAO();
		ArrayList<ValorCatalogo> nombresCoordinaciones = miValorCatalogoDAO.buscarValoresParaCampo("Coordinaciones", "Nombre coordinacion");
		ArrayList<ValorCatalogo> valoresCoordinaciones = miValorCatalogoDAO.buscarValoresParaCampo("Coordinaciones", "Id coordinador");
		ArrayList<Coordinacion> coordinaciones = new ArrayList<Coordinacion>(10);
		for (int i = 0; i < nombresCoordinaciones.size(); i++) {
			System.out.println("coordinacion " + nombresCoordinaciones.get(i).getValue());
			System.out.println("coordinador " + valoresCoordinaciones.get(i).getValue());
			coordinaciones.add(new Coordinacion(-1,
				nombresCoordinaciones.get(i).getValue(), valoresCoordinaciones.get(i).getValue()));
		}
		return coordinaciones;
	}

	public ArrayList<Programa> conseguirProgramas() {
		DAOFactory miDaoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		ValorCatalogoDAO miValorCatalogoDAO = miDaoFactory.getValorCatalogoDAO();
		ArrayList<ValorCatalogo> nombresProgramas = miValorCatalogoDAO.buscarValoresParaCampo("Programas", "Nombre programa");
		ArrayList<Programa> programas = new ArrayList<Programa>(10);
		for (int i = 0; i < nombresProgramas.size(); i++) {
			programas.add(new Programa(-1, nombresProgramas.get(i).getValue()));
		}
		return programas;

	}

	public ArrayList<Catalogo> conseguirCatalogos() {
		DAOFactory miDaoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		CatalogoDAO miCatalogoDAO = miDaoFactory.getCatalogoDAO();
		ArrayList<Catalogo> catalogos = miCatalogoDAO.buscarTodos();
		return catalogos;
	}

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

		CrearTipoActividadForm formBean = (CrearTipoActividadForm) form;

		System.out.println("Entrando a CrearTipoDeActividad Action..." + (contador++));
		System.out.println("- Num_campos:" + formBean.getNum_campos_ta());
		System.out.println("- Nombre tipo actividad:" + formBean.getNombre_ta());

		//	En un principio se quiere que haya un solo campo extra
		request.setAttribute("num_campos", 1);

		ArrayList<Coordinacion> coordinaciones = conseguirCoordinaciones();
		request.setAttribute("coordinaciones", coordinaciones);
		ArrayList<Catalogo> catalogos = conseguirCatalogos();
		request.setAttribute("catalogos", catalogos);
		ArrayList<Programa> programas = conseguirProgramas();
		request.setAttribute("programas", programas);

		//	No es la primera vez que se carga la pagina
		//	verificamos si se clickeo el boton de agregarCampos o el de crearActividad
		if (request.getParameter("agregar_campos") != null) {
			System.out.println("Se recargara la pagina cambiando el numero de campos del TA");
			request.setAttribute("num_campos", formBean.getNum_campos_ta());
			return mapping.findForward(REFRESH);
		} else if (request.getParameter("crear_tipo_actividad") != null) {
			//	Procedemos a agregar un tipo de actividad a la base de datos
			int num_campos = formBean.getNum_campos_ta();
			System.out.println("Entramos a crear un tipo de actividad nuevo");
			System.out.println("Numero de campos segun el usuario:" + num_campos);

			//	Conseguimos un factory para los DAO que usaremos para las inserciones
			DAOFactory miDAOFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

			//	Extraemos los dato del form que iran en la tabla tipo de actividad
			int id_tipo_act = agregarTipoActividad(formBean, miDAOFactory);
			System.out.println("ID del tipo de actividad creado:" + id_tipo_act);

			//	Insertamos en la bd los datos de los campos del tipo de actividad
			//	que acabamos de crear 
			agregarCampos(num_campos, id_tipo_act, formBean, miDAOFactory);

			//	Cargamos la pagina de creacion exitosa de un tipo de actividad
			return mapping.findForward(SUCCESS);
		}
		//	Cargamos la pagina de crear_tipo_actividad 
		return mapping.findForward(REFRESH);
	}
}