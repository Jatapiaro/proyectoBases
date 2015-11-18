<html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<title>Deslpiega Clientes</title>
</head>
<body>
    <c:choose>
    	<c:when test="${sessionScope.usuario != null}">
			<center>
				<h1><strong>Ver Clientes</strong></h1>
				<h2>${mensaje}</h2>
					<table>
					<tr>
					<center>
					<table>
					<c:forEach items="${ListaDeClientes}" var="cliente">
						<tr>
						<form action="EliminarCliente.do" method="post">
						<input type="hidden" value="${cliente.clienteID}" name="clienteID">

						<td>Cliente: </td><td><c:out value="${cliente.nombreCliente}"/></td>
						<td>Telefono: </td><td><c:out value="${cliente.telefonoCliente}"/></td>
						<td>Contacto o representante: </td><td><c:out value="${cliente.contactoCliente}"/></td>
						<td><input type="submit" value="Algo"></td>
						</form>
						</tr>
						</c:forEach>
					</table>
				

			</center>
			<a href="Index.jsp">Menú Principal</a>
		</c:when>
		<c:otherwise>
			<c:redirect url="Login.html"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
</html>