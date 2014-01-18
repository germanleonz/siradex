<%-- 
    Document   : cuerpo_modificar_usuario
    Created on : Nov 29, 2012, 11:06:46 AM
    Author     : germanleonz
--%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<h1>Modificar Usuario</h1>
<html:form action="/root/modificar_usuario">
	<table id="tabla_datos_usuario" border="0">
		<tr>
			<td><bean:message key="label.usbid"/></td>
			<td><html:text property="usbid"/></td>
			<td><html:errors property="usbid"/></td>
		</tr>
		<tr>
			<td><bean:message key="label.nombre"/></td>
			<td><html:text property="nombre" value='<%=(String)session.getAttribute("nombre_modificar")%>'/></td>
			<td><html:errors property="nombre"/></td>
		</tr>
		<tr>
			<td><bean:message key="label.apellido"/></td>
			<td><html:text property="apellido" value='<%=(String)session.getAttribute("apellido_modificar")%>'/></td>
			<td><html:errors property="apellido"/></td>
		</tr>
		<tr>
			<td><bean:message key="label.correo"/></td>
			<td><html:text property="email" value='<%=(String)session.getAttribute("correo_modificar")%>'/></td>
			<td><html:errors property="email"/></td>
		</tr>
		<tr>
			<td><bean:message key="label.rol"/></td>
			<td><html:text property="rol" value='<%=(String)session.getAttribute("rol_modificar")%>'/></td>
			<td><html:errors property="rol"/></td>
		</tr>

		<tr>
			<td></td>
			<td><html:submit value="Modificar" property="guardar_cambios"/></td> 
		</tr>
	</table>
</html:form>