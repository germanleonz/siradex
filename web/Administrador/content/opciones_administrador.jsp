<%-- 
    Document   : opciones_administrador
    Created on : Oct 25, 2012, 3:31:53 AM
    Author     : germanleonz
--%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<ul class="menulinks">
  <li>
    SiraDEX
  </li>
  <li>
    <html:link page="/AdministradorLinks.do?method=gestionar_tipo_actividades">Gestionar Tipos de Actividades</html:link>
  </li>
  <li>
    Especificar Fechas
  </li>
  <li>
    Especificar Roles
  </li>	
  <li>
    <html:link page="/AdministradorLinks.do?method=gestionar_actividades">Gestionar Actividades</html:link>
  </li>
  <li>
    Realizar B�squedas Avanzadas
  </li>

  <li>
    Realizar B�squedas P�blicas
  </li>
  <li>
    Respaldar C�digo Fuente
  </li>
  <li>
    Respaldar Base de Datos
  </li>
  <li>
    <html:link page="/AdministradorLinks.do?method=actualizar_perfil">Actualizar Perfil</html:link>
  </li>
  <li>
    <html:link page="/AdministradorLinks.do?method=solicitar_constancia">Solicitar Constancia</html:link>
  </li>
  <li>
    <html:link page="/AdministradorLinks.do?method=cerrar_sesion">Cerrar Sesi�n</html:link>
  </li>
</ul>