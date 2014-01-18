<%-- 
    Document   : opciones_usuario
    Created on : Nov 26, 2012, 11:25:54 PM
    Author     : germanleonz
--%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<ul class="menulinks">
    <li>
                SiraDEX
	</li>
	<li>
		<html:link page="/UsuarioLinks.do?method=gestionar_actividades">Gestionar actividades</html:link>
	</li>
	<li>
		<html:link page="/UsuarioLinks.do?method=actualizar_perfil">Actualizar Perfil</html:link>
	</li>
	<li>
		<html:link page="/UsuarioLinks.do?method=solicitar_constancia">Solicitar Constancia</html:link>
	</li>
	<li>
		<html:link page="/UsuarioLinks.do?method=cerrar_sesion">Cerrar Sesión</html:link>
	</li>
</ul>