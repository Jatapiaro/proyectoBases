<html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/estilos2.css">
	<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
	<title>Ver Choferes</title>
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
			<h2 style="color:#303F9F">Lista de Choferes</h2>
			<br>
			<br>
			<h3 style="color:#${coloreado}">${mensaje}</h3>
				<div>
					<div class="input-group">
					</div>
					
						<table >
							<thead>
								<th> Nombre</th>
								<th> N&uacutemero</th>
								<th>Salario</th>
							</thead>

							<c:forEach items="${ListaDeChoferes}" var="chofer">
							<tr>
								<td style= "color:#303F9F">${chofer.nombreChofer}</td>
								<td style= "color:#303F9F">${chofer.telefonoChofer}</td>
								<td style= "color:#303F9F">${chofer.salarioChofer}</td>

								<td align='center' style= "color:#303F9F">
								<form action="ObtenerChofer.do"method="post">
								<input type="hidden" value="${chofer.usernameChofer}" name="choferID">
								<input type="submit" id="btn-submit" value="Editar" style="width:100%"></td>
								</form>
								</td>

								<td align='center' style= "color:#303F9F">
								<form action="EliminarChofer.do" method="post">
								<input type="hidden" value="${chofer.usernameChofer}" name="choferID">
								<input type="submit" id="btn-submit2" value="Borrar" style="width:100%">
								</form>
								</td>
							</tr>
							</c:forEach>
				</div>
			</form>
		</div>
	</div>
	</table>
	</div>
	</div>
	</div>
	</div>
	</center>
	<a href="Index.jsp">Men&uacute</a>
	<script src="js/formulario.js"></script>
		</c:when>
		<c:otherwise>
			<c:redirect url="Login.html"></c:redirect>
		</c:otherwise>
	</c:choose>

</body>
</html>