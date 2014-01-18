<%-- 
    Document   : cuerpo_registrar_actividad
    Created on : Nov 27, 2012, 11:38:37 AM
    Author     : germanleonz
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="infosis.siradex.clases.CampoTipoAct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

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

<h1>Registrar Actividad</h1>


    <p> Elija un tipo de actividad: </p>

<ul>

<!--Listamos los tipos de actividad leidos de la base de datos-->
    <html:form action="/Usuario/registrar_actividad">
    <li>
	<html:select property="tipo">
		<html:options collection="listatipos" property="id_tipo_act" labelProperty="nombre_tipo_act"/>
	</html:select>
	<html:submit value="Confirmar" />
    </li>
    </html:form>

</ul>
<%
	if (request.getAttribute("listacampos") != null) {
%>
        <html:form action="/Usuario/registrar_actividad" method="post" enctype="multipart/form-data">
            <table>
                <html:hidden property="id_ta" value='<%=(String) request.getAttribute("id_ta")%>' />
	<%
		ArrayList<CampoTipoAct> listacampos = (ArrayList) request.getAttribute("listacampos");
		for (CampoTipoAct campo : listacampos) {
	%>
	<br />
                <tr><td><%=campo.getNombre_campo()%></td>
	<%
		if (campo.getTipo_campo().equals("TEXTO")) {
	%>
                    <td>
                        <html:hidden property="id_cta" value='<%=Integer.toString(campo.getId_cta())%>' />
	<html:text property="valor" value="" />
                    </td>
	<%                    } else if (campo.getTipo_campo().equals("NUMERICO")) {
	%>
                    <td>
                        <html:hidden property="id_cta" value='<%=Integer.toString(campo.getId_cta())%>' />
	<html:text property="valor" value=""/>
                    </td>
	<%                    } else if (campo.getTipo_campo().equals("LISTA")) {
	%>
                    <td>
                        <html:hidden property="id_cta" value='<%=Integer.toString(campo.getId_cta())%>' />
	<html:text property="valor" value="" />
                    </td>
	<%                    } else if (campo.getTipo_campo().equals("ARCHIVO")) {
	%>
                    <td>
                        <html:hidden property="id_cta_file" value='<%=Integer.toString(campo.getId_cta())%>' />
                        <html:file property="file" size="50" />
                    </td>
	<%                    } else if (campo.getTipo_campo().equals("FECHA")) {
	%>
                    <td>
                        <html:hidden property="id_cta" value='<%=Integer.toString(campo.getId_cta())%>' />
	<span id="fecha_input"> <html:text property="valor" value="" /></span>
                    </td>
                    <%                        }%>
                </tr>
                <%
		}
	%>
            </table>
	<br />
	<html:submit value="Registar Actividad" />
</html:form>
<%
	}
%>