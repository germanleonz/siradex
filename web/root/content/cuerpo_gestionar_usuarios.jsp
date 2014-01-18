<%-- 
    Document   : cuerpo_buscar_usuario
    Created on : Nov 27, 2012, 1:37:23 AM
    Author     : germanleonz
--%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<h1>Gestionar Usuarios</h1>

<h2><html:link page="/root/crear_usuario.jsp">Crear usuario</html:link></h2>

	<h2>Buscar un usuario</h2>
<html:form action="/root/gestionar_usuarios">
	<table id="tabla_busqueda" border="0">
		<tbody>
			<tr>
				<td>USBID del usuario</td>
				<td><html:text property="usbid"/></td>
				<td><html:submit value="Buscar" property="buscar"/></td> 
			</tr>
			<tr> </tr>
		</tbody>
	</table>
</html:form>
<h2>Resultados de la busqueda</h2>
<table border="1">
	<thead>
		<tr>
			<th>USBID</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Email</th>
			<th>Rol</th>
			<th>Modificar</th>
			<th>Eliminar</th>
		</tr>
	</thead>
	<tbody>
		<logic:present name="usuarios" scope="session">
			<logic:iterate id="usuario" name="usuarios" scope="session">
				<tr>
					<td><bean:write name="usuario" property="usbid" /></td>
					<td><bean:write name="usuario" property="nombre"/> </td>
					<td><bean:write name="usuario" property="apellido"/> </td>
					<td><bean:write name="usuario" property="email"/> </td>
					<td><bean:write name="usuario" property="rol"/> </td>
					<html:form action="/root/gestionar_usuarios">
						<html:hidden name="usuario" property="usbid"></html:hidden>
						<td><html:submit value="Modificar" property ="modificar_usuario"/></td>
						<td><html:submit value="Eliminar" property ="eliminar_usuario" onclick="confirmar(this.form);"/></td>
					</html:form>
				</tr>
			</logic:iterate>
		</logic:present>
		<logic:notEmpty name="usuario_consulta" scope="session">
			<tr>
				<td><bean:write name="usuario_consulta" scope="session" property="usbid" /></td>
				<td><bean:write name="usuario_consulta" scope="session" property="nombre"/> </td>
				<td><bean:write name="usuario_consulta" scope="session" property="apellido"/> </td>
				<td><bean:write name="usuario_consulta" scope="session" property="email"/> </td>
				<td><bean:write name="usuario_consulta" scope="session" property="rol"/> </td>
				<html:form action="/root/gestionar_usuarios">
					<td><html:submit value="Modificar" property ="modificar_usuario"/></td>
					<td><html:submit value="Eliminar" property ="eliminar_usuario"/></td>
				</html:form>
			</tr>
		</logic:notEmpty>
	</tbody>
</table>
