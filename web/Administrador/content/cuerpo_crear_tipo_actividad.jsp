<%-- 
    Document   : cuerpo_crear_tipo_actividad
    Created on : Nov 27, 2012, 2:11:11 AM
    Author     : germanleonz
--%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<h1>Crear Nuevo Tipo de Actividad</h1>
<html:form action="/Administrador/crear_tipo_actividad">
	<table>
		<tr>
			<td><bean:message key="label.crear_tipo_act.nombre"/></td>
		</tr>
		<tr>
			<td><html:text property="nombre_ta" value=""/></td>
		</tr>
		<tr>
			<td><bean:message key="label.crear_tipo_act.descripcion"/></td>
		</tr>
		<tr>
			<td><html:text property="descripcion" value=""/></td>
		</tr>
		<tr>
			<td><bean:message key="label.crear_tipo_act.tipo"/></td>
		</tr>
		<tr>
			<td>
				<html:select property="tipopr_ta">
					<html:option value="P">Tipo P</html:option>
					<html:option value="R">Tipo R</html:option>
				</html:select>
			</td>
		</tr>
		<tr>
			<td>Programa del tipo de actividad</td>
		</tr>
		<tr>
			<td>
                            <html:select property="id_programa" styleId="styleSelect">
					<html:option value="">Seleccione un programa...</html:option>
					<html:options
						collection="programas"
						property="id_programa"
						labelProperty="nombre_programa"/>
				</html:select>
			</td>
		</tr>
		<tr>
			<td>Coordinación a validar</td>
		</tr>
		<tr>
			<td>
				<html:select property="id_validador_ta">
					<html:option value="">Seleccione una coordinación...</html:option>
					<html:options
						collection="coordinaciones"
						property="id_coordinacion"
						labelProperty="nombre_coordinacion"/>
				</html:select>
			</td>
		</tr>
		<tr>
			<td>
				<p>Puede ser realizado por:</p>
                                <ul>
                                    <li>
				<html:multibox property="realizable_por">Administrativos</html:multibox>
				Administrativos

				<html:multibox property="realizable_por">Estudiantes</html:multibox>
				Estudiante
                                    </li>
                                    <li>
				<html:multibox property="realizable_por">Profesores</html:multibox>
				Profesores
				<html:multibox property="realizable_por">Obreros</html:multibox>
				Obreros
                                    </li>
                                </ul>
			</td>
		</tr>
		<tr>
			<td>Número de campos adicionales:</td>
		</tr>
		<tr>
			<td>
				<html:text
					size="2"
					maxlength="2"
					property="num_campos_ta">
				</html:text>
			</td>
		</tr>
		<tr>
			<td rowspan="2">
			<html:submit value="Agregar campos" property="agregar_campos"/>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td>Nombre del campo</td>
			<td>Tipo del Campo</td>
			<td>Longitud</td>
			<td>Obligatorio</td>
			<td>Lista</td>
		</tr>
		<html:hidden value="Nombre de la actividad" property="nom_campos"/>
		<html:hidden value="TEXTO" property="tipo_campos"/>
		<html:hidden property="longitud" value="30"/>
		<html:hidden property="obligatorio" value="true"/>
		<html:hidden property="id_catalogo" value="No aplica"/>
		<tr>
			<td>Nombre de la actividad</td>
			<td>TEXTO</td>
			<td>30</td>
			<td>true</td>
			<td>No Aplica</td>
		</tr>
		<%
			Integer n = (Integer) request.getAttribute("num_campos");
			for (int i = 0; i < n.intValue(); i++) {
		%>
		<tr>
			<td><html:text property="nom_campos" value="" size="13px"/></td>
			<td>
				<html:select property="tipo_campos">
					<html:option value="TEXTO">TEXTO</html:option>
					<html:option value="NUMERICO">NUMERICO</html:option>
					<html:option value="FECHA">FECHA</html:option>
					<html:option value="ARCHIVO">ARCHIVO</html:option>
					<html:option value="LISTA">LISTA</html:option>
				</html:select>
			</td>
			<td><html:text property="longitud" value="" size="13px"/></td>
			<td>
				<html:select property="obligatorio">
					<html:option value="true">Si</html:option>
					<html:option value="false">No</html:option>
				</html:select>
			</td>
			<td>
				<html:select property="id_catalogo">
					<html:option value="No aplica">No aplica</html:option>
					<html:options
						collection="catalogos"
						property="id_catalogo"
						labelProperty="nombre_catalogo"/>
				</html:select>
			</td>
		</tr>
		<% }%>
	</table>
	<html:submit value="Crear tipo de actividad" property="crear_tipo_actividad"/>
</html:form>