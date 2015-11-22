<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>	
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/estilos.css">
	<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
	<title>Registro de Fletes</title>
</head>
<body>
    <c:choose>
    	<c:when test="${sessionScope.usuario != null}">
     			<center>
	<div class="contenedor-formulario">

		<div class="wrap">
			<form action="RegistrarFlete.do" class="formulario" name="formulario_registro" method="post">
				<div>

				<h1>Registro de Flete</h1>
					<div class="input-group" align="center">
					<label class= "label" for="listaClientes" >Seleccione un cliente:</label>

						<select id = "listaClientes" name="elCliente">
							<c:forEach items="${ListaDeClientes}" var="cliente">
								<option value="${cliente.clienteID}">${cliente.nombreCliente}</option>
							</c:forEach>
             			</select>
             		</div>	
             		<div class="input-group" align="center">
					<label class= "label" for="listaChoferes" >Seleccione un chofer:</label>
						<select id = "listaChoferes" name="elChofer">

							<c:forEach items="${ListaDeChoferes}" var="chofer">
								<option value="${chofer.usernameChofer}">${chofer.nombreChofer}</option>
							</c:forEach>

             			</select>
					<div class="input-group">
						<label class="label" for="fechaHoraRecoleccion">Fecha y hora de recolecci&oacuten:</label>
						<br>
						<br>
						<input type="datetime-local" id="fechaHoraRecoleccion" name="fechaHoraRecoleccion">

					</div>
					<div class="input-group">
						<input type="text" id="direccionRecoleccion" name="direccionRecoleccion">
						<label class="label" for="direccionRecoleccion">Direcci&oacuten de recolecci&oacuten:</label>
					</div>
					<div class="input-group">

						<label class="label" for="fechaHoraEntrega">Fecha y hora de entrega:</label>
						<br>
						<br>
						<input type="datetime-local" id="fechaHoraEntrega" name="fechaHoraEntrega">


					</div>
					<div class="input-group">
						<input type="text" name="direccionEntrega" id="direccionEntrega">
						<label class="label" for="direccionEntrega">Direcci&oacuten de entrega:</label>
					</div>

					<div class="input-group radio">
						<input type="radio" name="zona" id="norte" value="Norte">
						<label for="norte">Norte</label>
						<input type="radio" name="zona" id="sur" value="Sur">
						<label for="sur">Sur</label>
						<input type="radio" name="zona" id="oriente" value="Oriente">
						<label for="oriente">Oriente</label>
						<input type="radio" name="zona" id="poniente" value="Poniente">
						<label for="poniente">Poniente</label>
						<input type="radio" name="zona" id="foraneo" value="Foraneo">
						<label for="foraneo">Foráneo</label>
					</div>

					<div class="input-group">
						<input type="text" id="km" name="kilometros">
						<label class="label" for="km">Kilometros:</label>
					</div>
						
					<input type="submit" id="btn-submit" value="Registrar Flete">
				</div>
			</form>
		</div>
	</div>

	<script src="js/formulario.js"></script>					
				</center>
				<a href="Index.jsp"></a>
		</c:when>
		<c:otherwise>
			<c:redirect url="Login.html"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
</html>