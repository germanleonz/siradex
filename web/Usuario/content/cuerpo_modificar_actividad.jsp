<%-- 
    Document   : cuerpo_modificar_actividad
    Created on : Nov 30, 2012, 5:18:40 AM
    Author     : germanleonz
--%>



<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<link rel="stylesheet" type="text/css" href="<html:rewrite page="/css/jquery-ui-1.9.2.custom.css"/>"/>

<script type="text/javascript">
	$(function() {		
		$("#fecha_input input").datepicker({
			changeMonth: true,
			changeYear: true
		});

		$( "#fecha_input input" ).datepicker(
        "option", "dateFormat", "dd-mm-yy" 
	);
	
		$( "#fecha_input input" ).datepicker({
			dayNamesMin: [ "Dom", "Lun", "Mar", "Mie", "Juev", "Vier", "Sab" ] 
		});		
	
		var dayNamesMin = $( "#fecha_input input" ).datepicker( "option", "dayNames" );
		$( "#fecha_input input" ).datepicker( 
		"option", "dayNamesMin", [ "Dom", "Lun", "Mar", "Mie", "Juev", "Vier", "Sab" ] 
	);

		$( "#fecha_input input" ).datepicker( "option", "yearRange", "1970:2012" );
	})	
</script>

<html:form action="/Usuario/modificar_actividad" method="post" enctype="multipart/form-data">
	<table>
                <% boolean x = false;%>
                <logic:iterate id="act" name="lista">
			<% if (x == false) {%>
			<tr>
				<bean:write name="act" property="apellido" />,
				<bean:write name="act" property="nombre"/>.
			</tr>
			<br />
			<% }
			    x = true;%>
			<tr><td>
					<bean:write name="act" property="nombre_campo" />:
				</td>
				<td>
					<logic:equal name="act" property="tipo_campo" value="ARCHIVO">
						<html:hidden property="id_valor" name="act" />
						<html:hidden property="tipo_campo" name="act" />
						<html:file property="file" size="50" />
					</logic:equal>
					<logic:notEqual name="act" property="tipo_campo" value="ARCHIVO">
						<logic:equal name="act" property="tipo_campo" value="FECHA">
							<html:hidden property="tipo_campo" name="act" />
							<html:hidden property="id_valor" name="act" />
							<span id="fecha_input">
							<html:text  property="value" name="act" />
							</span>
						</logic:equal>
						<logic:notEqual name="act" property="tipo_campo" value="FECHA">
						<html:hidden property="tipo_campo" name="act" />
						<html:hidden property="id_valor" name="act" />
						<html:text  property="value" name="act" />
						</logic:notEqual>
					</logic:notEqual>
				</td>
			</tr>
			<br />
                </logic:iterate>
	</table>
	<html:submit value="Modificar" property="modificando" />
</html:form>
