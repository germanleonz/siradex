<%-- 
    Document   : cuerpo_index_root
    Created on : Nov 28, 2012, 3:27:56 PM
    Author     : germanleonz
--%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<ul class="menulinks">
	<li>
		SiraDEX
	</li>
	<li>
		<html:link page="/RootLinks.do?method=gestionar_catalogos">Gestionar Catalogos</html:link>
	</li>
	<li>
		<html:link page="/RootLinks.do?method=gestionar_usuarios">Gestionar Usuarios</html:link>
	</li>
	<li>
		Gestionar Respaldos
	</li>
	<li>
		Revisar Logs
	</li>
	<li>
		Especificar Roles
	</li>
	<li>
		Especificar Fechas
	</li>
	<li>
		Realizar Búsquedas Avanzadas
	</li>
	<li>
		<html:link page="/RootLinks.do?method=gestionar_tipo_actividades">Gestionar tipos de actividades</html:link>
	</li>
	<li>
		Gestionar alertas
	</li>
	<li>
		Importar datos de otros sistemas
	</li>
	<li>
		Respaldar Base de Datos
	</li>
	<li>
		<html:link page="/RootLinks.do?method=gestionar_actividades">Gestionar actividades</html:link>
	</li>
	<li>
		<html:link page="/RootLinks.do?method=actualizar_perfil">Actualizar Perfil</html:link>
	</li>
	<li>
		<html:link page="/RootLinks.do?method=solicitar_constancia">Solicitar Constancia</html:link>
	</li>
	<li>
		<html:link page="/RootLinks.do?method=cerrar_sesion">Cerrar Sesion</html:link>
	</li>
</ul>