<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/estilos3.css">
	<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
	<title>Modificar Cargamento</title>
</head>
<body>
    <c:choose>
    	<c:when test="${sessionScope.usuario != null}">
    			<div class="contenedor-formulario">
		<div class="wrap">

			<form action="ActualizarCargamento.do" class="formulario" name="formulario_registro" method="post">

			<input type="hidden" value="${cargamento.cargamentoID}" name="cargamentoID">

			<input type="hidden" value="${cargamento.fleteID}" name="fleteID">

				<div>
					<div div class="input-group">
						<input type="text" id="tipo" name="tipoCargamento" value="${cargamento.tipoCargamento}">
						<label class="label" for="tipo">Tipo:</label>
					</div>	
					<div class="input-group">
						<input type="text" id="PesoMaterial" name="pesoCargamento" value="${cargamento.pesoCargamento}">
						<label class="label" for="PesomMaterial">Peso del cargamento:</label>
					</div>

					<div class="input-group radio">
					<div style= "color:#303F9F">
					Tratar con delicadeza
					</div>

						<c:choose>

						<c:when test="${cargamento.delicadoCargamento==true}">

						<input type="radio" name="delicadoCargamento" id="adminS" value="True" checked="checked">
						<label for="adminS">Si</label>

						<input type="radio" name="delicadoCargamento" id="adminN" value="False">
						<label for="adminN">No</label>

						</c:when>

						<c:otherwise>

						<input type="radio" name="delicadoCargamento" id="adminS" value="True">
						<label for="adminS">Si</label>

						<input type="radio" name="delicadoCargamento" id="adminN" value="False" checked="checked">
						<label for="adminN">No</label>

						</c:otherwise>

						</c:choose>
						
					</div>

					<input type="hidden" value="${fechaHoraRecoleccion}" name="fechaHoraRecoleccion">

					<input type="submit" id="btn-submit" value="Modificar Cargamento">
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