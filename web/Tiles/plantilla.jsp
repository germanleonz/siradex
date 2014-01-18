<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE>
<html lang="es">
	<head>
		<meta charset="UTF-8">
		<title class="titulos">
			<tiles:getAsString name="titulo"/>
		</title>
		<!--CSS-->
		<link rel="stylesheet" type="text/css" href="<html:rewrite page="/css/style_plantilla.css"/>"/>
		<!--Javascript-->
		<script type="text/javascript" src="<html:rewrite page="/javascript/jquery-1.8.3.js"/>"></script>
		<script type="text/javascript" src="<html:rewrite page="/javascript/jquery-ui-1.9.2.custom.js"/>"></script>
	</head>
	<body>
	<center>
		<div id="borde">
		<tiles:get name="header"/>
			<div id="contenido">
				<aside id="asideLeft" class="section">
					<div class="region">
						<tiles:get name="leftColumn"/>
					</div>
				</aside>
				<div class="asideContent">
					<tiles:get name="body"/>
				</div>
				<aside id="asideRight" class="section">
					<div class="region">
						<tiles:get name="rightColumn"/>
					</div>
				</aside>
			</div>
			<tiles:get name="footer"/>
		</div>
	</center>
</body>
</html>
