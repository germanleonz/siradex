<%-- 
    Document   : cuerpo_gestionar_catalogos
    Created on : Nov 27, 2012, 1:52:25 AM
    Author     : germanleonz
--%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<h1>Gestionar Catalogos</h1>
<h2><html:link page="/root/crear_catalogo.do">Crear nuevo catalogo</html:link></h2>
<html:form action="/root/gestionar_catalogos">
	Seleccione el catalogo que desea gestionar
	<html:select property="catalogo_sel" styleId="catalogo_sel">
		<html:option value="">Seleccione un catalogo...</html:option>
		<html:options
			collection="catalogos"
			property="id_catalogo"
			labelProperty="nombre_catalogo"/>
	</html:select>
	<html:submit property="listar_catalogo" value="Listar"/> 
</html:form>
<table border="1">
	<tbody>
		<logic:present name="campos_catalogo" scope="session">
		<tr>
			<logic:iterate id="campo" name="campos_catalogo" scope="session">
				<th><bean:write name="campo" property="nombre_campo"/></th>
			</logic:iterate>
		</tr>
		</logic:present>
		<logic:present name="valores_catalogo" scope="session">
		<tr>
			<logic:iterate id="campo" name="campos_catalogo" scope="session">
				<td><bean:write name="campo" property="nombre_campo"/></td>
			</logic:iterate>
		</tr>
		</logic:present>

	</tbody>
</table>
