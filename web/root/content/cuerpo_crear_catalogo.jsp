<%-- 
    Document   : cuerpo_crear_catalogo
    Created on : Nov 29, 2012, 1:02:15 AM
    Author     : germanleonz
--%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<h1>Crear nuevo catalogo</h1>
<html:form action="/root/crear_catalogo">
	<table id="tabla_datos_catalogo" border="0">
		<tr>
			<td><bean:message key="label.crear_catalogo.nombre"/></td>
			<td><html:text property="nombre_catalogo"/></td>
			<td><html:errors property="nombre_catalogo"/></td>
		</tr>
		<tr>
			<td>Número de campos adicionales:</td>
			<td>
				<html:text
					size="2"
					maxlength="2"
					property="num_campos_catalogo">
				</html:text>
			</td>
		</tr>
		<tr>
			<td>
			<html:submit value="Agregar campos" property="agregar_campos"/>
			</td>
		</tr>
		<tr>
			<td>Nombre del campo</td>
			<td>Tipo del Campo</td>
		</tr>
		<%
			Integer n = (Integer) request.getAttribute("num_campos");
			for (int i = 0; i < n.intValue(); i++) {
		%>
		<tr>
			<td><html:text property="nom_campos" value=""/></td>
			<td>
				<html:select property="tipo_campos">
					<html:option value="TEXTO">TEXTO</html:option>
					<html:option value="NUMERICO">NUMERICO</html:option>
					<html:option value="FECHA">FECHA</html:option>
				</html:select>
			</td>
		</tr>
		<% }%>
	</table>
	<html:submit value="Crear catalogo" property="crear_catalogo"/>
</html:form>