<%-- 
    Document   : cuerpo_gestionar_tipo_actividades
    Created on : Nov 28, 2012, 4:50:40 PM
    Author     : germanleonz
--%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<h1>Gestionar Tipo de Actividades</h1>

<h2><html:link page="/Administrador/crear_tipo_actividad.do">Crear un Nuevo Tipo de Actividad</html:link></h2>

<h2>Buscar un Tipo de Actividad</h2>
<html:form action="/Administrador/gestionar_tipo_actividades">
	<table id="tabla_busqueda" border="0">
		<tbody>
			<tr>
				<td>Codigo de la actividad</td>
				<td><html:text property="codigo_ta"/></td>
				<td><html:submit value="Buscar"/></td> 
			</tr>
			<tr> </tr>
		</tbody>
	</table>
</html:form>
<h2>Resultados de la Búsqueda</h2>
<table border="1">
	<thead>
		<tr>
			<th>Código</th>
			<th>Nombre</th>
			<th>Descripción</th>
			<th>Coordinacion Validadora</th>
			<th>Realizable por:</th>
			<th>Tipo</th>
			<th>Número de Campos</th>
		</tr>
	</thead>
	<tbody>
		<logic:present name="tipos" scope="session">
			<logic:iterate id="tipo" name="tipos" scope="session">
				<tr>
					<td><bean:write name="tipo" property="id_tipo_act" /></td>
					<td><bean:write name="tipo" property="nombre_tipo_act"/> </td>
					<td><bean:write name="tipo" property="descripcion"/> </td>
					<td><bean:write name="tipo" property="id_validador"/> </td>
					<td><bean:write name="tipo" property="tipo_pr"/> </td>
					<td><bean:write name="tipo" property="num_campos"/> </td>
					<td></td>
				</tr>
			</logic:iterate>
		</logic:present>
		<logic:notEmpty name="tipo_consulta" scope="session">
			<tr>
				<td><bean:write name="tipo_consulta" scope="session" property="id_tipo_act" /></td>
				<td><bean:write name="tipo_consulta" scope="session" property="nombre_tipo_act"/> </td>
				<td><bean:write name="tipo_consulta" scope="session" property="descripcion"/> </td>
				<td><bean:write name="tipo_consulta" scope="session" property="id_validador"/> </td>
				<td><bean:write name="tipo_consulta" scope="session" property="tipo_pr"/> </td>
				<td><bean:write name="tipo_consulta" scope="session" property="num_campos"/> </td>
				<td></td>
			</tr>
		</logic:notEmpty>
	</tbody>
</table>