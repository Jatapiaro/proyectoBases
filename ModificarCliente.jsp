<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/estilos3.css">
	<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
	<title>Modificar Cliente</title>
</head>
<body>
 

    <c:choose>
    	<c:when test="${sessionScope.usuario != null}">
    			<div class="contenedor-formulario">
		<div class="wrap">
			<form action="modificarCliente.do" class="formulario" name="formulario_registro" method="post">
				<div>

					<div class="input-group">
						<input type="text" id="nombre" name="nombreCliente" value="${cliente.nombreCliente}">
						<label class="label" for="nombre">Nombre de la empresa:</label>
					</div>

					<div class="input-group">
						<input type="text" id="contacto" name="contactoCliente" value="${cliente.contactoCliente}">
						<label class="label" for="contacto">Representante o contacto del cliente</label>
					</div>

					<div class="input-group">
						<input type="text" id="telefono" name="telefonoCliente" value="${cliente.nombreCliente}">
						<label class="label" for="telefono">Tel&eacutefono del cliente/representante:</label>
					</div>

					<div class="input-group">
						<input type="text" id="deuda" name="deudaCliente" value="${cliente.deudaCliente}">
						<label class="label" for="deuda">Deuda del Cliente:</label>
					</div>

					<input type="hidden" value="${cliente.clienteID}" name="clienteID">

						
					<input type="submit" id="btn-submit" value="Modificar Cliente">
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