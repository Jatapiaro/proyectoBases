<html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/estilos2.css">
	<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
	<title>Ver Vehiculos</title>
	<style type="text/css">
	table, td, th{

		font-family: "Roboto";
		border: none;
		border-collapse: separate;
    	border-spacing: 10px;

	}
	td, th{
		padding: 5px;
	

	}
	th{
		background-color: #303F9F;
		color: #fff;
	}
	</style>
</head>
<body>
    <c:choose>
    	<c:when test="${sessionScope.usuario != null &&sessionScope.rol == true}">
	<center>
	<div class="contenedor-formulario">
		<div class="wrap">
			<div class="formulario" name="formulario_registro">
			<h2 style="color:#303F9F">Lista de Vehiculos</h2>
			<br>
			<br>
			<h3 style="color:#${coloreado}">${mensaje}</h3>
				<div>
					<div class="input-group">
					</div>
					
						<table >
							<thead>
								<th> Placas</th>
								<th> Costo por uso</th>
								<th> Capacidad</th>
							</thead>

							<c:forEach items="${ListaDeVehiculos}" var="vehiculo">
							<tr>
								<td style= "color:#303F9F">${vehiculo.placasVehiculo}</td>
								<td style= "color:#303F9F">$${vehiculo.costoVehiculo}"</td>
								<td style= "color:#303F9F">${vehiculo.capacidadVehiculo}kg</td>

								<form action="ObtenerVehiculo.do" method="post">
								<input type="hidden" value="${vehiculo.placasVehiculo}" name="vehiculoID">
								<td align='center' style= "color:#303F9F"><input type="submit" id="btn-submit" value="Editar" style="width:100%"></td>
								</form>

								<form action="EliminarVehiculo.do" method="post">
								<input type="hidden" value="${vehiculo.placasVehiculo}" name="vehiculoID">
								<td align='center' style= "color:#303F9F"><input type="submit" id="btn-submit2" value="Borrar" style="width:100%"></td>
								</form>
							</tr>

							</c:forEach>
						</table>
				</div>
			</form>
		</div>
	</div>

	<script src="js/formulario.js"></script>
		</c:when>
		<c:otherwise>
			<c:redirect url="Login.html"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
</html>