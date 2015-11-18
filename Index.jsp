<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
	<title>MenuTransportes</title>
</head>
<body>


	<c:choose>
			<c:when test="${sessionScope.usuario != null}">

				<div class="Banner">

					<center>
						<img src="Rizo.jpg" style="width:1000px;height:228px;">
					</center>

				</div>
				
				<div class="Opciones">
					<table>
						<tr>

							<td>
								<div class= "header">
									<h1>Transportes Rizo</h1>
								</div>
							</td>

							<td>
								<div class = "opcion">
									<span class= "O1" style= "vertical-align:middle;"> <A HREF= "TraeClientesChoferes.do" style="text-decoration:none" > &nbsp;&nbsp; Registrar Flete &nbsp; &nbsp; </span>
								</div>
							</td>

							<td>
								<div class = "opcion">
									<span class= "O7" style= "vertical-align:middle;"> <A HREF= "RegistrarCliente.do" style="text-decoration:none" > &nbsp;&nbsp; Ver Clientes &nbsp; &nbsp; </span>
								</div>
							</td>


							<td>
								<div class = "opcion">
									<span class= "O2" style= "vertical-align:middle;"> <A HREF= "RegistroClientes.jsp" style="text-decoration:none" > &nbsp;&nbsp; Registrar Cliente &nbsp; &nbsp; </span>
								</div>
							</td>

							<td>
								<div class = "opcion">
									<span class= "O3" style= "vertical-align:middle;"> <A HREF= "RegistroVehiculo.html" style="text-decoration:none" > &nbsp;&nbsp; Registar Vehículo     &nbsp; &nbsp; </span>
								</div>
							</td>

							<td>
								<div class= "opcion">
									<span class="O4" style= "vertical-align:middle;"> <A HREF= "RegistroChofer.html" style="text-decoration:none" > &nbsp;&nbsp; Registrar Chofer &nbsp;&nbsp; </span>
								</div>
							</td>

							<td>
								<div class= "opcion">
									<span class="O5" style= "vertical-align:middle;"> <A HREF= "RegistrarFlete.do" style="text-decoration:none" > &nbsp;&nbsp; Ver Fletes &nbsp;&nbsp; </span>
								</div>
							</td>

						</tr>
					</table>
				</div>
			</c:when>
			<c:otherwise>
				<c:redirect url="Login.html"></c:redirect>
			</c:otherwise>
	</c:choose>

</body>
</html>