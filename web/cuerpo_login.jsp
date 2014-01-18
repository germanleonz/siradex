<%-- 
   Document   : cuerpo_login
   Created on : Oct 25, 2012, 2:28:00 AM
   Author     : germanleonz
--%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<h1>Bienvenido al Sistema de Registro de Actividades de Extensión</h1>
<html:form action="/login">
       <table id="tabla_login" border="0">
               <tbody>
                       <p>Para iniciar sesión, llene los siguientes campos:</p>
                       <tr>
                               <td><bean:message key="label.login.usbid"/></td>
                               <td><html:text property="usbid"/></td>
                               <td><html:errors property="usbid"/> </td>
                       </tr>

                       <tr>
                               <td><bean:message key="label.login.contrasena"/></td>
                               <td><html:password property="contrasena"/></td>
                               <td><html:errors property="contrasena"/></td>
                       </tr>
                       <tr>
                               <td></td>
                               <td><html:submit value="Iniciar Sesión"/></td> 
                       </tr>
               </tbody>
       </table>
</html:form>