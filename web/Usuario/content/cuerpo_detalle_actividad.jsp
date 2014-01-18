<%-- 
    Document   : cuerpo_detalle_actividad
    Created on : Nov 30, 2012, 5:21:20 AM
    Author     : germanleonz
--%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html:form action="/Usuario/gestionar_actividades">
        <table>
		<% boolean x = false;%>
		<logic:iterate id="act" name="lista">
			<% if (x == false) {%>
			<tr>
				<bean:write name="act" property="apellido" />,
				<bean:write name="act" property="nombre"/>.
				<html:hidden name="act" property="id_act" />
			</tr>
			<br />
			<% }
		    x = true;%>
			<tr><td>
					<bean:write name="act" property="nombre_campo" />:
				</td>
				<td>
					<logic:equal name="act" property="tipo_campo" value="ARCHIVO">
						<a  href="/Siradex/Uploads/<bean:write name="act" property="value"/>">Descargar archivo</a>
					</logic:equal>
					<logic:notEqual name="act" property="tipo_campo" value="ARCHIVO">
						<bean:write name="act" property="value"/>
					</logic:notEqual>
				</td>
			</tr>
			<br />
		</logic:iterate>
        </table>

	<html:submit value="Modificar" property="modificar"/>
	<html:submit value="Eliminar" property="eliminar"/>
</html:form>
