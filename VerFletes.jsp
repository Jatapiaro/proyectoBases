<html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<title>Deslpiega fletes</title>
</head>
<body>
    <c:choose>
    	<c:when test="${sessionScope.usuario != null}">
			<center>
				<h1><strong>Ver fletes</strong></h1>

				<c:forEach items="${ListaDeFletes}" var="flete">
					<table>
					<tr>
					<center>
					<table>
						<tr>
						<form action="RedireccionarCargamento.do" method="post">
						<input type="hidden" value="${flete.fleteID}" name="theID">
						<td>Nº Flete: </td><td><c:out value="${flete.fleteID}"/></td>
						<td>Para el cliente: </td><td><c:out value="${flete.cliente.nombreCliente}"/></td>
						<td><input type="submit" value="Añadir Cargamento"></td>
						</form>
						</tr>

						<tr>
						<form action="RegistarCargamento.html" method="post">

						<input type="hidden" value="${flete.fleteID}" name="theID">

						<td>Chofer encargado: </td><td><c:out value="${flete.chofer.nombreChofer}"/></td>
						<td>Vehiculo designado: </td><td><c:out value="${flete.vehiculoID}"/></td>
						<td><input type="submit" value="Añadir Reparto"></td>
						</form>
						</tr>

						<tr>
						<form action="ConfirmarRecoleccion.do" method="post">
						<input type="hidden" value="${flete.fleteID}" name="theID">
						<td>Fecha y hora de recoleccion: </td><td><c:out value="${flete.fechaHoraRecoleccion}"/></td>
						<td>Dirección de recolección: </td><td><c:out value="${flete.direccionRecoleccion}"/></td>

						<td>Maniobra al recolectar</td>
						<td>
						Si<input type="radio" name="maniobraRecoleccion" value="True"/>
						No<input type="radio" name="maniobraRecoleccion" value="False"/>
						</td>

						<td><input type="submit" value="Recoleccion Completada"></td>
						</form>
						</tr>

						<tr>
						<form action="ConfirmarEntrega.do" method="post">
						<input type="hidden" value="${flete.fleteID}" name="theID">
						<td>Fecha y hora de entrega: </td><td><c:out value="${flete.fechaHoraEntrega}"/></td>
						<td>Dirección de entrega: </td><td><c:out value="${flete.direccionEntrega}"/></td>

						<td>Maniobra al entregar</td>
						<td>
						Si<input type="radio" name="maniobraEntrega" value="True"/>
						No<input type="radio" name="maniobraEntrega" value="False"/>
						</td>

						<form action="RegistarCargamento.html" method="post">
						<td><input type="submit" value="Entrega Completada"></td>
						</form>

					</tr>
				    </center>
				    <br>
				    <br>
				    <br>
					</table>
					<td><input type="submit" value="Eliminar Flete"></td>
					<td><input type="submit" value="Modificar flete"></td>
					</tr>

					</table>
				</c:forEach>

			</center>
			<a href="Index.jsp">Menú Principal</a>
		</c:when>
		<c:otherwise>
			<c:redirect url="Login.html"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
</html>