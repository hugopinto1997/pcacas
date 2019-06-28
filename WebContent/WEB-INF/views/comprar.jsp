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
<title>Comprar Entradas</title>

<script>


function validarFormulario(){
	var nasientos = document.getElementById('nasientos').value;
    var pisto = document.getElementById('pisto').value;
    var check = document.getElementById('check').value;

	if(nasientos>15 && ${u.balance}<pisto){
		 Swal.fire('No puede comprar mas de 15 asientos por transaccion y no tiene saldo suficiente')
		return false;
		}

    if(check == 2 && pisto>${u.balance} && ${sxc.aSeats}-nasientos<0){
		 Swal.fire('Asientos y dinero insuficientes')
			return false;
		}
	
	if(${sxc.aSeats}-nasientos<0){
		 Swal.fire('No hay suficientes asientos! :(')
		return false;
		}

	
	if(nasientos>15){
		 Swal.fire('No puede comprar mas de 15 asientos por transaccion')
		return false;
		}

	if(check == 2 && pisto==0){
		 Swal.fire('El dinero es requerido')
			return false;
		}

	if(check == 2 && pisto==0 && ${sxc.aSeats}-nasientos<0){
		 Swal.fire('Asientos insuficientes y el dinero no puede ir vacio')
			return false;
		}

	

	

	if(pisto>${u.balance}){
		 Swal.fire('Saldo insuficiente!')
			return false;
		}

	if(nasientos==0){
		 Swal.fire('Numero de asientos no puede ir vacio')
			return false;
		}

	

    return true;
}



</script>














</head>
<body style="background-color:#f6f6f6f6;">
<div class="container" style="width: 100%; background-size: 100% ; background-image: url('${p.image}');">
  <div class="jumbotron" style=" background-color:#00000070;">
    <h1 style="background-color:#00000000; color:#ffffff; font-weight:bold;">Entradas para ${p.name }</h1>      
    <p style="background-color:#00000000; color:#ffffff; font-weight:bold;">A continuación se muestra la información de la función</p>
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

<div class="main container" color:#fff; style="width: 100%; padding-left:50px; padding-right:50px; background-color:#072557; ">
<center><h1 style="color:#fff;">Información de usuario</h1></center>
		<h1 style="color:#fff;">Nombre: ${u.fname }  ${u.lname }</h1>
	<h1 style="color:	#fff;">Saldo: $${u.balance }</h1>
	<br>
</div>
	<br>
		<br>
		<br>

<h1>Función en la ${sxc.cinema.cinema }</h1>
<h1>Número de asientos disponibles: ${sxc.aSeats } asientos</h1>
<form action="${pageContext.request.contextPath}/factura" method="post" onsubmit="return validarFormulario()">
             <br><br> 
              <INPUT TYPE="hidden" NAME="idshowcase" id="idshowcase" value=${sxc.show.idShowcase}> 
             <INPUT TYPE="hidden" NAME="iduser" id="iduser" value=${u.idUser}> 	
             <INPUT TYPE="hidden" NAME="idmovie" id="idmovie" value=${p.idMovie}> 
             <div class="input-group input-group-lg">
				  <span class="input-group-addon" id="sizing-addon1"># de asientos</span>
				  <input type="number" name="nasientos" id="nasientos" style="width:25%;" class="form-control" placeholder="Número de asientos" id="asientos" aria-describedby="sizing-addon1" />
				
				</div>
			
				<div style="display:flex;">
				<div style="flex:10%;">
				<input type="checkbox" style="  zoom: 2;
  transform: scale(1);
  -ms-transform: scale(1);
  -webkit-transform: scale(1);
  -o-transform: scale(1);
  -moz-transform: scale(1);
  transform-origin: 0 0;
  -ms-transform-origin: 0 0;
  -webkit-transform-origin: 0 0;
  -o-transform-origin: 0 0;
  -moz-transform-origin: 0 0;
  -webkit-transform-origin: 0 0; margin-left:75px; margin-top:10px;" name="check" id="check" value="1" onchange="javascript:showContent()">  
				</div>
				<div style="flex:90%;">
				<h3 style="padding-left:20px;">        Utilizar saldo de la cuenta?</h3><br>
				</div>
				</div>
              
           			<div id="content" style="display: none;" class="input-group input-group-lg">
				  <input type="number" id="pisto" name="pisto" style="width:25%; margin-left:150px;" class="form-control" placeholder="Número de asientos" id="asientos" aria-describedby="sizing-addon1" />
				<br><br>
 </div>
 <br><br>
		<center> <button class="btn btn-primary btn-md" 
		 	style="width: 25%;" id="nuevaSuc" type="submit">Proseguir al pago</button>
		 	</center>
		 	</form>
		 	<br><br>


</div> 

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
<script type="text/javascript">
    function showContent() {
        element = document.getElementById("content");
        check = document.getElementById("check");
        if (check.checked) {
            element.style.display='block';
            document.getElementById("check").value = 2;
        }
        else {
            element.style.display='none';
            document.getElementById("check").value = 1;
            
        }
    }
</script>
</body>
</html>