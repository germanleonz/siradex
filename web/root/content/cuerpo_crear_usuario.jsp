<%-- 
    Document   : form_crear_usuario
    Created on : Nov 27, 2012, 1:35:36 AM
    Author     : germanleonz
--%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<h1>Crear nuevo usuario</h1>
<html:form action="/root/crear_usuario">
	<table id="tabla_datos_usuario" border="0">
		<tr>
			<td><bean:message key="label.crearUsuario.usbid"/></td>
			<td><html:text property="usbid"/></td>
			<td><html:errors property="usbid"/></td>
		</tr>
		<tr>
			<td><bean:message key="label.crearUsuario.contrasena"/></td>
			<td><html:password property="contrasena1"/></td>
			<td><html:errors property="contrasena1"/></td>
		</tr>
		<tr>
			<td><bean:message key="label.crearUsuario.repitaContrasena"/></td>
			<td><html:password property="contrasena2"/></td>
			<td><html:errors property="contrasena2"/></td>
		</tr>
		<tr>
			<td><bean:message key="label.crearUsuario.nombre"/></td>
			<td><html:text property="nombre"/></td>
			<td><html:errors property="nombre"/></td>
		</tr>
		<tr>
			<td><bean:message key="label.crearUsuario.apellido"/></td>
			<td><html:text property="apellido"/></td>
			<td><html:errors property="apellido"/></td>
		</tr>
		<tr>
			<td><bean:message key="label.crearUsuario.correo"/></td>
			<td><html:text property="email"/></td>
			<td><html:errors property="email"/></td>
		</tr>
		<tr>
			<td><bean:message key="label.crearUsuario.rol"/></td>
			<td><html:text property="rol"/></td>
			<td><html:errors property="rol"/></td>
		</tr>
		<tr>
			<td></td>
			<td><html:submit value="Crear"/></td> 
		</tr>
	</table>
</html:form>