<%-- 
    Document   : cuerpo_gestionar_actividades
    Created on : Nov 27, 2012, 2:00:53 AM
    Author     : germanleonz
--%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<h1>Lista de actividades registradas</h1>

<h1>Gestionar Actividades</h1>

<h2><html:link page="/Usuario/registrar_actividad.do">Registrar una actividad</html:link></h2>

<h2>Lista de actividades registradas</h2>
<logic:iterate id="act" name="lista">
	<bean:write name="act" property="apellido" />,
	<bean:write name="act" property="nombre"/>. 
	<bean:write name="act" property="value"/>
    <html:form action="/Usuario/gestionar_actividades">
        <html:hidden name="act" property="id_act" />
        <html:submit value="Detalle" property="detalle" />
    </html:form>
    <br />
</logic:iterate>

