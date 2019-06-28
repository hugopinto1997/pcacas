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
<title>Pelicula</title>
</head>
<body style="background-color:#f6f6f6f6;">
<div class="container" style="width: 100%; background-size: 100% ; background-image: url('${p.image}');">
  <div class="jumbotron" style=" background-color:#00000070;">
    <h1 style="background-color:#00000000; color:#ffffff; font-weight:bold;">${p.name }</h1>      
    <p style="background-color:#00000000; color:#ffffff; font-weight:bold;">A continuacion se muestran las funciones disponibles</p>
  </div>    
</div>
<div style="color:#fff; position:absolute; right:0; top:0; margin:40px;">
<p>Desea cerrar sesión?</p>
 <form  name="back" action="${pageContext.request.contextPath}/Ret4" method="post">
             <INPUT TYPE="hidden" NAME="id" value=${u.idUser}> 				
		 <button class="btn btn-primary btn-md" 
		 	style="z-index:500; position:relative; top:0; right:0; width: 100%;" id="nuevaSuc" type="submit">Cerrar Sesión</button>
		 	</form>
</div>
<div class="main container">
<br>
<h1>Trailer</h1>
	${p.video }
	<br>
		<br>
		<br>
	<h1>Filtrar búsqueda</h1>
	<br>
	
 <form  name="back" action="${pageContext.request.contextPath}/agregarreservafilter" method="post">
   <INPUT TYPE="hidden" NAME="iduser" value=${u.idUser}>
   <INPUT TYPE="hidden" NAME="idmovie" value=${p.idMovie}> 				
    				
 
  <div style="display:flex;">
 	<div style="flex: 33%; margin-left:10px; margin-right:10px;">
  <select name="tipo" id="tipo" class="browser-default custom-select" style="width:100%; color: #fff; background: #424ABC; font-size: 20px; height: 50px; border-color: #000; border-width: 2px;">
 	   	   <option value="Todas">Todas</option> 
 	   <option value="2D DOB">2D DOB</option> 
 	   <option value="2D SUB">2D SUB</option>                
 	   <option value="3D DOB">3D DOB</option>                
 	   <option value="3D SUB">3D SUB</option>                
               
</select>
	</div>
 	<div style="flex:33%; margin-left:10px; margin-right:10px;">
 	<select id="fec" name="fec" class="browser-default custom-select" style="width:100%; color: #fff; background: #424ABC; font-size: 20px; height: 50px; border-color: #000; border-width: 2px;">
 	  <option selected value="Todas">Todas</option>  
 	  <c:forEach items="${f}" var="f" >
 	   	   <c:if test="${f == '2019-06-28' }">
 	   	   <option selected value="${f }">${f}</option>  
 	   	  </c:if>
 	   	    <c:if test="${f != '2019-06-28' }">
 	   	   <option value="${f }">${f}</option>  
 	   	  </c:if>
 	   	                
 	  </c:forEach>       
</select>
 	</div>
 	<div style="flex:33%; margin-left:10px; margin-right:10px;">
 	 <button class="btn btn-danger btn-lg" 
		 	style="z-index:500; position:relative; top:0; right:0; width: 100%;" id="nuevofilter" type="submit">Buscar</button>
 	 	</div>
 	 </div>
 	
 	</form>
 	<br>
 	<br>
 	
<table border="1" class="table main container">
   <tr>
           <th style="font-weight: bold; font-size:24px;">Tipo de función</th>
           <th style="font-weight:bold; font-size:24px;">Fecha</th>
           <th style="font-weight:bold; font-size:24px;">Hora</th>
           <th style="font-weight:bold; font-size:24px;">Comprar entradas</th>
           
           
           
       </tr>
       
        <c:forEach items="${s}" var="s">
         <tr>
           <th>${s.showType}</th>
          <th>${s.showDate}</th>
           <th>${s.newHour}</th>  
           <th>
           <form  name="back" action="${pageContext.request.contextPath}/comprar" method="post">
             <INPUT TYPE="hidden" NAME="idshowcase" value=${s.idShowcase}> 
             <INPUT TYPE="hidden" NAME="iduser" value=${u.idUser}> 	
             <INPUT TYPE="hidden" NAME="idmovie" value=${p.idMovie}> 				
             			
              				
             				
		 <button class="btn btn-primary btn-md" 
		 	style="z-index:500; position:relative; top:0; right:0; width: 100%;" id="nuevaSuc" type="submit">Comprar</button>
		 	</form>
           
           </th>       
                
         
          
         
           
       </tr>
       </c:forEach>
       </table>

</div> 
</body>
</html>