<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/estilos.css">
	<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
	<title>Registro de Chofer</title>
</head>
<body>
 

    <c:choose>
    	<c:when test="${sessionScope.usuario != null &&sessionScope.rol == true}">

	<div class="contenedor-formulario">
		<div class="wrap">
			<form action="RegistrarChofer.do" class="formulario" name="formulario_registro" method="post">
				<div>
					<div class="input-group">
						<input type="text" id="nombre" name="nombreChofer">
						<label class="label" for="nombre">Nombre del ch&oacutefer:</label>
					</div>

					<div class="input-group">
						<input type="text" id="username" name="usernameChofer">
						<label class="label" for="username">Username:</label>
					</div>

					<div class="input-group">
						<input type="password" id="password" name="passwordChofer">
						<label class="label" for="password">Password:</label>
					</div>

					<div class="input-group">
						<input type="text" id="telefono" name="telefonoChofer">
						<label class="label" for="telefono">Tel&eacutefono del ch&oacutefer:</label>
					</div>
					<div class="input-group">
						<input type="text" id="salario" name="salarioChofer">
						<label class="label" for="salario">Salario:</label>
					</div>

					<div class="input-group radio">

						<input type="radio" name="esAdmin" id="adminS" value="True">
						<label for="adminS">Si</label>

						<input type="radio" name="esAdmin" id="adminN" value="False">
						<label for="adminN">No</label>
						
					</div>

					<input type="submit" id="btn-submit" value="Registrar Chofer">
				</div>
			</form>
		</div>
	</div>

	<script src="js/formulario.js"></script>

<a href="Index.jsp">Men&uacute</a>
		</c:when>
		<c:otherwise>
			<c:redirect url="Login.html"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
</html>