<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/estilos.css">
	<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
	<title>Formularios</title>
</head>
<body>
	<div class="contenedor-formulario">
		<div class="wrap">
			<form action="" class="formulario" name="formulario_registro" method="get">
				<div>
					<div class="input-group" align="center">
					<label class= "label" for="listaClientes" >Seleccione un cliente:</label>
						<select id = "listaClientes" >
						   <option val = ""></option>
						   <option val = "1">Cliente1</option>
						   <option val = "2">Cliente2</option>
						   <option val = "3">Cliente3</option>
						   <option val = "4">Cliente4</option>
             			</select>
             		</div>	
             		<div class="input-group" align="center">
					<label class= "label" for="listaChoferes" >Seleccione un chofer:</label>
						<select id = "listaChoferes" >
						   <option val = ""></option>
						   <option val = "1">Chofer1</option>
						   <option val = "2">Chofer2</option>
						   <option val = "3">Chofer3</option>
						   <option val = "4">Chofer4</option>
             			</select>
					<div class="input-group">
						<label class="label" for="fechaHoraRecoleccion">Fecha y hora de recolección:</label>
						<br>
						<br>
						<input type="datetime-local" id="fechaHoraRecoleccion" name="fechaHoraRecoleccion">

					</div>
					<div class="input-group">
						<input type="text" id="direccionRecoleccion" name="direccionRecoleccion">
						<label class="label" for="direccionRecoleccion">Dirección de recolección:</label>
					</div>
					<div class="input-group">

						<label class="label" for="fechaHoraEntrega">Fecha y hora de entrega:</label>
						<br>
						<br>
						<input type="datetime-local" id="fechaHoraEntrega" name="fechaHoraEntrega">


					</div>
					<div class="input-group">
						<input type="text" name="direccionEntrega" id="direccionEntrega">
						<label class="label" for="direccionEntrega">Dirección de entrega:</label>
					</div>

					<div class="input-group radio">
						<input type="radio" name="zona" id="norte" value="norte">
						<label for="norte">Norte</label>
						<input type="radio" name="zona" id="sur" value="sur">
						<label for="sur">Sur</label>
						<input type="radio" name="zona" id="oriente" value="oriente">
						<label for="oriente">Oriente</label>
						<input type="radio" name="zona" id="poniente" value="poniente">
						<label for="poniente">Poniente</label>
						<input type="radio" name="zona" id="foraneo" value="foraneo">
						<label for="foraneo">Foráneo</label>
					</div>
					<div class="input-group">
						<input type="text" id="km" name="km">
						<label class="label" for="km">Kilometros:</label>
					</div>
						
					<input type="submit" id="btn-submit" value="Enviar">
				</div>
			</form>
		</div>
	</div>

	<script src="js/formulario.js"></script>
</body>
</html>
