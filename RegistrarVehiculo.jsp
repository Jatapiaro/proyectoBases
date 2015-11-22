<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/estilos.css">
	<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
	<title>Registro de Vehiculo</title>
</head>
<body>
 

    <c:choose>
    	<c:when test="${sessionScope.usuario != null &&sessionScope.rol == true}">

	<div class="contenedor-formulario">
		<div class="wrap">
			<form action="RegistrarVehiculo.do" class="formulario" name="formulario_registro" method="post">
				<div>
					<div class="input-group">
						<input type="text" id="placas" name="placasVehiculo">
						<label class="label" for="placas">Placas:</label>
					</div>
					<div class="input-group">
						<input type="text" id="costo" name="costoVehiculo">
						<label class="label" for="costo">Costo por uso:</label>
					</div>
					<div class="input-group">
						<input type="text" id="capacidad" name="capacidadVehiculo">
						<label class="label" for="pass">Capacidad(Kilogramos):</label>
					</div>

					<input type="submit" id="btn-submit" value="Registrar Veh&iacute;culo">
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