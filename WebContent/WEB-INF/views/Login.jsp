<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="resources/css/formas.css">
			<!-- vinculo a bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- se vincula al hoja de estilo para definir el aspecto del formulario de login-->  
</head>
<body bgcolor="#00000" style="background-color:#240463;">
	<div id="Contenedor">
		 <div class="Icon">
                    <!--Icono de usuario-->
                   <span class="glyphicon glyphicon-user"></span>
                 </div>
<div class="ContentForm">
<form:form class="modal-content animate" action="${pageContext.request.contextPath}/Login" method="post" modelAttribute="loginDTO">
    
		 		<div class="input-group input-group-lg">
				  <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-envelope"></i></span>
				  <form:input class="form-control" type="text" placeholder="Enter user" name="user" path="user"/>
				</div>
				      <form:errors path="user" cssStyle="color:#E81505;"></form:errors><br>
				
				<br>
				<div class="input-group input-group-lg">
				  <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
				<form:input class="form-control" type="password" name="clave" path="clave" placeholder="Enter Password"/>
      			<form:errors path="clave" cssStyle="color:#E81505;"></form:errors><br>
        
				</div>
				
				<br>
				<center>
				<button class="btn btn-lg btn-primary btn-block btn-signin" id="IngresoLog" type="submit">Entrar</button>				
		 		</center>
		 	</form:form>
		 		
		 </div>	
		 </div>		 		 
</body>
</html>