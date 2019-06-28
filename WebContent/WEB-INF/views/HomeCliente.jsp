<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="resources/css/formas.css">
			<!-- vinculo a bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<title>Sucursales</title>
</head>
<body style="background-color:#f6f6f6f6;">

<div class="container" style="width: 100%; background-size: 100% 100%; background-repeat: no-repeat;">
  <div class="jumbotron" style=" background-color:#e30228;">
    <h1 style="background-color:#00000000; color:#ffffff; font-weight:bold;">Cartelera</h1>      
    <p style="background-color:#00000000; color:#ffffff; font-weight:bold;">A continuación se muestran todas las peliculas disponibles</p>
  </div>    
</div>
<div style="color:#fff; position:absolute; right:0; top:0; margin:40px;">
<p>Desea cerrar sesión?</p>
 <form  name="back" action="${pageContext.request.contextPath}/Ret4" method="post">
             <INPUT TYPE="hidden" NAME="id" value=${user.idUser}> 				
		 <button class="btn btn-primary btn-md" 
		 	style="z-index:500; position:relative; top:0; right:0; width: 100%;" id="nuevaSuc" type="submit">Cerrar Sesión</button>
		 	</form>
</div>
<div class="main container">
	  <c:forEach items="${p}" var="p">
	<div style="display: flex; background-color:#060547; border-radius:10px; padding-top:2px; padding-left:25px; margin-left:150px; margin-right:150px; margin-top:10px;
	 height:440px;">
		<div style="flex: 40%;">
		 <img src="${p.image }" style="border-radius:5px; width:100%; margin-top:20px; height:400px;" alt="Flowers in Chania">
		</div>
		<div style="flex: 60%; padding-top:10px; padding-right:10px;">
		<h1 style="padding-left:30px; font-weight:bold; color:#ffffff;">${p.name }</h1>
		<h3 style="padding-left:30px; color:#ffffff90;"> ${p.length } min</h3>
		<form action="${pageContext.request.contextPath}/addreserva" method="POST">
		 	 <INPUT TYPE="hidden" NAME="iduser" value=${user.idUser}> 				
			 <INPUT TYPE="hidden" NAME="idmovie" value=${p.idMovie}> 				
		 	  				 				
		 <center><button class="btn btn-danger btn-lg" 
		 	style="width: 80%;" id="nuevaSuc" type="submit">Agregar Reserva</button></center>
		 	</form>
		</div>
	</div>
	
	</c:forEach>

</div>
		 
</body>
</html>