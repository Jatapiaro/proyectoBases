<html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/estilos2.css">
	<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
	<title>Ver Clientes</title>
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
			<h2 style="color:#303F9F">Lista de Clientes</h2>
			<br>
			<br>
			<h3 style="color:#${coloreado}">${mensaje}</h3>
				<div>
					<div class="input-group">
					</div>
					
						<table >
							<thead>
								<th> Cliente</th>
								<th> N&uacutemero</th>
								<th> Contacto</th>
								<th> Adeudo</th>
							</thead>

							<c:forEach items="${ListaDeClientes}" var="cliente">
							<tr>
								<td style= "color:#303F9F">${cliente.nombreCliente}</td>
								<td style= "color:#303F9F">${cliente.telefonoCliente}</td>
								<td style= "color:#303F9F">${cliente.contactoCliente}</td>
								<td style="color:#303F9F">${cliente.deudaCliente}</td>
								<td align='center' style= "color:#303F9F">

								<form action="ObtenerCliente.do"method="post">
								<input type="hidden" value="${cliente.clienteID}" name="clienteID">
								<input type="submit" id="btn-submit" value="Editar" style="width:100%"></td>
								</form>

								<td align='center' style= "color:#303F9F">
								<form action="EliminarCliente.do" method="post">
								<input type="hidden" value="${cliente.clienteID}" name="clienteID">
								<input type="submit" id="btn-submit2" value="Borrar" style="width:100%">
								</form>
								</td>

							</tr>
							</c:forEach>
				</div>
			</form>
		</div>
	</div>
	</td>
	</table>
	</center>
	<script src="js/formulario.js"></script>
	<a href="Index.jsp">Men&uacute</a>
		</c:when>
		<c:otherwise>
			<c:redirect url="Login.html"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
</html>